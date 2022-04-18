TO_CHAR 숫자 날짜 -> 문자로

1.  TO_CHAR( ,  'format') 함수에서 'format'에 사용되는 기호를 적으세요.
  ㄱ. 년도 : Y, [YY], YYY, [YYYY], SYYYY, I, IY,IYY, IYYY, IYYYY, YEAR, SYEAR, RR, RRRR
  ㄴ. 월 : MONTH, [MM], MON
  ㄷ. 월의 일 : [DD]
      주의 일 : D
      년의 일 : DDD
  ㄹ. 요일 : day
  ㅁ. 월의 주차 : W
      년의 주차 : WW ,IW
  ㅂ. 시간/24시간 : HH/HH24   , HH12
  ㅅ. 분 : MI
  ㅇ. 초 : SS
  ㅈ. 자정에서 지난 초 : SSSSS  ms
  ㅊ. 오전/오후 : AM/PM
   
  TS : 시간만을 간략하게 나타내는 것
  DS , DL : 년도를 간략하게 나타내는 것
  
2. 본인의 생일로부터 오늘까지 살아온 일수, 개월수, 년수를 출력하세요..
SELECT  CEIL (SYSDATE - TO_DATE ('1998.07.03')) "살아온 일 수"
       ,  (MONTHS_BETWEEN(TO_DATE ('1998.07.03'),SYSDATE)) "개월 수" 
       ,ABS (MONTHS_BETWEEN(TO_DATE ('1998.07.03'),SYSDATE))/12 "년수"
FROM dual;

3. emp  에서  comm 이 null 사원수 ?? 

SELECT  --COUNT (COMM) NULL 값을제외한 집계
        COUNT (*)
FROM emp
WHERE comm IS NULL;

SELECT COUNT (DECODE (comm, null, 'O'))
FROM emp;

SELECT COUNT (CASE 
       WHEN comm IS NULL THEN 'O'
       ELSE null
       END )
FROM emp;

4. 
  4-1. 이번 달이 몇 일까지 있는 확인.
  SELECT LAST_DAY(SYSDATE)
          ,TO_DATE( LAST_DAY(SYSDATE),'DD')
         -- ,EXTRACT( DATE FROM LAST_DAY(SYSDATE)  )
  FROM dual;
  --22/04/30
  4-2. 오늘이 년중 몇 째 주, 월중 몇 째주인지 확인. 
SELECT TO_CHAR(SYSDATE, 'WW')  --년
         ,TO_CHAR(SYSDATE, 'IW')--년
         ,TO_CHAR(SYSDATE, 'W') --월
FROM dual;


5. emp 에서  pay 를 NVL(), NVL2(), COALESCE()함수를 사용해서 출력하세요.

SELECT sal+NVL(comm,0)
      , sal+ NVL2(comm,comm, 0)
      , NVL2( comm, sal+comm, sal)
      , sal+ COALESCE(comm,0)
      , COALESCE (sal+comm,sal,0)
FROM emp;


5-2. emp테이블에서 mgr이 null 인 경우 -1 로 출력하는 쿼리 작성
      ㄱ. nvl()    
      ㄴ. nvl2() 
      ㄷ. COALESCE()
      
SELECT e.*
    ,NVL(MGR,-1)
    ,NVL2(MGR,MGR,-1)
    ,COALESCE( MGR, -1)
 FROM emp e
 WHERE MGR IS NULL;
    
      
6. insa 에서  이름,주민번호, 성별( 남자/여자 ), 성별( 남자/여자 ) 출력 쿼리 작성-
    ㄱ. DECODE()
    
    SELECT name, ssn
            ,DECODE( MOD(SUBSTR(ssn, -7,1),2),1,'남자','여자') 
    FROM insa;
    
    ㄴ. CASE 함수
    SELECT name, ssn
           ,CASE MOD(SUBSTR(ssn, -7,1),2)
           WHEN 1 THEN '남자'
           ELSE '여자'
           END gender
           ,CASE
           WHEN  MOD(SUBSTR(ssn, -7,1),2)=1 THEN '남자'
           ELSE '여자'
           END gender
    FROM insa;

7. emp 에서 평균PAY 보다 같거나 큰 사원들만의 급여합을 출력.
SELECT SUM( sal+NVL(comm,0))/COUNT( *) avg_pay 
       ,AVG( sal+NVL(comm,0)) avg_pay   
FROM emp; 
--2260.416666666666666666666666666666666667

SELECT SUM( sal+NVL(comm,0)) total_pay
FROM emp
WHERE sal+NVL(comm,0) 
     >= ( SELECT AVG( sal+NVL(comm,0)) FROM emp);
--18925 

--WHERE sal+NVL(comm,0) > = 2260.416666666666666666666666666666666667;
SELECT --t.ename, t.pay, t.avg_pay
   -- ,SIGN( t.pay - t.avg_pay) 
    SUM ( DECODE (SIGN( t.pay - t.avg_pay) , -1, null, t.pay) )TOTAL_PAY
    ,  SUM ( 
    CASE SIGN( t.pay - t.avg_pay)
    WHEN -1 THEN null
    ELSE t.pay
    END
    )
FROM (
SELECT ename, sal+NVL(comm,0)pay
      , (SELECT AVG( sal+NVL(comm,0)) FROM emp ) AVG_PAY
FROM emp
)t;

8. emp 에서  사원이 존재하는 부서의 부서번호만 출력

SELECT DISTINCT deptno
FROM emp;
8-2. emp 에서  사원이 존재하지 않는 부서의 부서번호만 출력

SELECT deptno
FROM dept
MINUS
SELECT DISTINCT deptno
FROM emp;


9. 함수 설명
    9-1. NULLIF() 함수 설명  -> 
    9-2. COALESCE() 함수 설명  -> null 이 아닌 값을 반환
    9-3. DECODE() 함수 설명  -> 
    9-4. LAST_DAY() 함수 설명 -> 마지막 날 알려줌
    9-5. ADD_MONTHS() 함수 설명  -> 개월수 더해줌
    9-6. MONTHS_BETWEEN() 함수 설명  -> 두 날짜 사이의 개월 수 알려줌
    9-7. NEXT_DAY() 함수 설명  -> 돌아오는 가장 최근의 날 알려줌
    9-8. EXTRACT() 함수 설명  ->

10. emp 테이블의 ename, pay , 최대pay값 5000을 100%로 계산해서
   각 사원의 pay를 백분률로 계산해서 10% 당 별하나(*)로 처리해서 출력
   ( 소숫점 첫 째 자리에서 반올림해서 출력 )

SELECT -- ename, sal+NVL(comm,0) pay,
    MAX( sal+NVL(comm,0)) max_pay
    ,MIN ( sal+NVL(comm,0))
FROM emp;

SELECT t.*
      , t.pay*100/t.max_pay ||'%' "percent"
      , ROUND (( t.pay*100/t.max_pay )/10) START_COUNT
      , RPAD( ' ', ROUND (( t.pay*100/t.max_pay )/10)+1,'*')
FROM (
SELECT ename, sal+NVL(comm,0) pay
      , (SELECT MAX( sal+NVL(comm,0)) FROM emp ) max_pay
FROM emp
)t;



11. 아래 코딩을  DECODE()를 사용해서 표현하세요.
    ㄱ. [자바]
        if( A == B ){
           return X;
        }
           -> DECODE ( A,B,X)
    
    ㄴ. [자바]
        if( A==B){
           return S;
        }else if( A == C){
           return T;
        }else{
           return U;
        }
       -> DECODE ( A,B,S,C,T,U)
    ㄷ.  [자바]
        if( A==B){
           return XXX;
        }else{
           return YYY;
        }
        -> DECODE ( A,B,XXX,YYY)
        
12. insa테이블에서 1001, 1002 사원의 주민번호의 월/일 만 10월10일로 수정하는 쿼리를 작성 

SELECT name,ssn,
         REPLACE( ssn, TO_CHAR(SUBSTR(ssn, 3,4)), '1010')
FROM insa
WHERE num = 1001 OR num = 1002;

----------
UPDATE insa
SET  ssn = SUBSTR(ssn, 0,2) || '1010' || SUBSTR(ssn,7)
WHERE num IN ( 1001,1002);

COMMIT;

--2개 행 이(가) 업데이트되었습니다.

--커밋 완료.
12-2. insa테이블에서 '2022.10.10'을 기준으로 아래와 같이 출력하는 쿼리 작성.  

SELECT name, ssn
     --     , TO_CHAR( TO_DATE('2022.10.10'), 'HH24:MI:SS')
     --     ,TO_CHAR(TO_DATE ( SUBSTR( ssn, 3,4) ,'MMDD'),'HH24:MI:SS')
          ,DECODE ( SIGN( TO_DATE('2022.10.10') - TO_DATE( SUBSTR( ssn, 3,4) ,'MMDD')   )
                       ,-1, '생일 전',0,'오늘 생일' ,1,'생일 후')
          , CASE SIGN( TO_DATE('2022.10.10') - TO_DATE( SUBSTR( ssn, 3,4) ,'MMDD'))
                WHEN 1 THEN '생일 후'
                WHEN -1 THEN '생일 전'
                ELSE '오늘 생일'
                END
FROM insa;


결과)
장인철	780506-1625148	생일 후
김영년	821011-2362514	생일 전
나윤균	810810-1552147	생일 후
김종서	751010-1122233	오늘 생일
유관순	801010-2987897	오늘 생일
정한국	760909-1333333	생일 후

12-3. insa테이블에서 '2022.10.10'기준으로 이 날이 생일인 사원수,지난 사원수, 안 지난 사원수를 출력하는 쿼리 작성. 


SELECT COUNT (*) "사원수" 
FROM insa
GROUP BY  DECODE ( SIGN( TO_DATE('2022.10.10') - TO_DATE( SUBSTR( ssn, 3,4) ,'MMDD')   )
                       ,-1, '생일 전',0,'오늘 생일' ,1,'생일 후') ;                       

----------방법1
SELECT  COUNT(DECODE ( S,0,'O' )) "오늘 생일인 사원수"
     ,COUNT(CASE WHEN S=1 THEN 'O' ELSE NULL END) "생일 전 사원 수" 
     , COUNT(CASE WHEN S=-1 THEN 'O' ELSE NULL END) "생일 후 사원 수" 
  -- t.name, t.ssn, t.s, DECODE ( S,0,'O' )
  , COUNT(*) "전체 사원 수"
     
FROM 
(
    SELECT name, ssn
          , TO_DATE( '2022.10.10')
          , TO_DATE(SUBSTR(ssn,3,4),'MMDD')
          , SIGN( TO_DATE( '2022.10.10') - TO_DATE(SUBSTR(ssn,3,4),'MMDD') ) S
    FROM insa
)t;

--    GROUP BY 절 사용
SELECT DECODE( t.S, -1,'생일 전',0,'오늘생일', 1,'생일 후'), COUNT(*)
FROM 
(
    SELECT name, ssn
          , SIGN( TO_DATE( '2022.10.10') - TO_DATE(SUBSTR(ssn,3,4),'MMDD') ) S
    FROM insa
)t
GROUP BY t.S;

결과)
오늘이 생일인 사원수 생일 안지난 사원수  생일 지난 사원수   전체사원수
----------- 	     ---------- 	 ----------    ------
7	                  44	           9	         60
          
13.  emp 테이블에서 10번 부서원들은  급여 15% 인상
                20번 부서원들은 급여 10% 인상
                30번 부서원들은 급여 5% 인상
                40번 부서원들은 급여 20% 인상
  하는 쿼리 작성.     

SELECT deptno, ename, sal + NVL(comm,0) pay
    ,DECODE( deptno, 10,15,20,10,30,5,40,20)||'%인상' "인상률"
    , (sal+ NVL( comm,0))*DECODE( deptno, 10,15,20,10,30,5,40,20)/100 "인상금액" 
     , CASE deptno
       WHEN 10 THEN (sal+ NVL( comm,0))*1.15
       WHEN 20 THEN (sal+ NVL( comm,0))*1.1
       WHEN 30 THEN (sal+ NVL( comm,0))*1.05
       WHEN 40 THEN (sal+ NVL( comm,0))*1.2
       END 인상된금액
FROM emp;


          
14. emp 테이블에서 각 부서의 사원수를 조회하는 쿼리
SELECT COUNT( DECODE(deptno,10,'O' ) ) "10번 부서 사원수"
        ,COUNT( DECODE(deptno,20,'O' ) ) "20번 부서 사원수"
        ,COUNT( DECODE(deptno,30,'O' ) ) "30번 부서 사원수"
        ,COUNT( DECODE(deptno,40,'O' ) ) "40번 부서 사원수"
        ,COUNT(*) "총사원수"
FROM emp;

----GROUP BY 절 사용
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

15. emp, salgrade 두 테이블을 참조해서 아래 결과 출력 쿼리 작성.

SELECT *
FROM salgrade;

등급 LOSAL  HISAL
1	700	    1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999



SELECT ename, sal
     ,CASE
                   -- LOSAL     HISAL 칼럼
       WHEN sal BETWEEN 700 AND 1200  THEN 1
       WHEN sal BETWEEN 1201 AND 1400  THEN 2
       WHEN sal BETWEEN 1401 AND 2000  THEN 3
       WHEN sal BETWEEN 2001 AND 3000  THEN 4
       WHEN sal BETWEEN 3001 AND 9999  THEN 5
       END grade
FROM emp;

-- 조인 JOIN 사용  -> 중복되지 않으므로 별칭 안넣어도 됨.
SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.LOSAL AND s.HISAL;
--WHERE e.name = 'SMITH' AND e.sal BETWEEN s.LOSAL AND s.HISAL;



-- 문제 : deptno, [dname], empno, ename, hiredate, job 컬럼 출력
SELECT deptno, empno, ename, hiredate, job
FROM emp;

SELECT dname
FROM dept;
--dname 출력 불가 dept 에서 가져와야함.
-- 자식 - emp 테이블 : deptno(fk), empno, ename, hiredate, job
-- 부모 - dept 테이블 :  deptno(pk), dname
-- emp와 dept 테이블은 deptno 컬럼으로 참조되고 있다 (관계 맺어짐).
--[형식 ] FROM A JOIN B ON 조인조건;

SELECT deptno,dname, empno, ename, hiredate, job
FROM dept JOIN emp ON dept.deptno = emp.deptno;
--ORA-00918: column ambiguously defined 오류남.
--              칼럼이 모호하게 선언됨
SELECT dept.deptno,dname, empno, ename, hiredate, job
FROM dept JOIN emp ON dept.deptno = emp.deptno;

--별칭 줌
SELECT d.deptno,dname, empno, ename, hiredate, job
FROM dept d JOIN emp e ON d.deptno = e.deptno;
--JOIN ON 대신 , WHERE 써도 됨
SELECT d.deptno,dname, empno, ename, hiredate, job
FROM dept d, emp e 
WHERE d.deptno = e.deptno; --JOIN 관련된 조건식


ENAME   SAL     GRADE
----- ----- ---------
SMITH	800	    1
ALLEN	1900	3
WARD	1750	3
JONES	2975	4
MARTIN	2650	4
BLAKE	2850	4
CLARK	2450	4
KING	5000	5
TURNER	1500	3
JAMES	950	    1
FORD	3000	4
MILLER	1300	2


16. emp 테이블에서 급여를 가장 많이 받는 사원의 empno, ename, pay 를 출력.

SELECT MAX( sal+NVL(comm,0)) max_pay
FROM emp;

------
SELECT ename, empno, sal+NVL(comm,0)
FROM emp
WHERE sal+NVL(comm,0) >=  ALL(SELECT sal+NVL(comm,0) FROM emp);
WHERE sal+NVL(comm,0) = (SELECT MAX( sal+NVL(comm,0)) max_pay FROM emp);

비교연산자 + SOME,ANY, ALL      
EXISTS
----

SELECT sal+NVL(comm,0) FROM emp;
16-2. emp 테이블에서 각 부서별 급여를 가장 많이 받는 사원의 pay를 출력
--방법1)
SELECT 10, MAX (sal+NVL(comm,0))max_pay
        ,MIN (sal+NVL(comm,0))min_pay
FROM emp
WHERE deptno=10
UNION ALL
SELECT 20, MAX (sal+NVL(comm,0))max_pay
        ,MIN (sal+NVL(comm,0))min_pay
FROM emp
WHERE deptno=20
UNION ALL
SELECT 30, MAX (sal+NVL(comm,0))max_pay
        ,MIN (sal+NVL(comm,0))min_pay
FROM emp
WHERE deptno=30
UNION ALL
SELECT 40, MAX (sal+NVL(comm,0))max_pay
        ,MIN (sal+NVL(comm,0))min_pay
FROM emp
WHERE deptno=40;

--방법2 group by 절 사용
SELECT deptno ||'번 부서' 
        , MAX (sal+NVL(comm,0))max_pay
        ,MIN (sal+NVL(comm,0))min_pay
FROM emp
GROUP BY deptno;

--방법3 --좋은 코딩은 아님
 SELECT( SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=10)
       ,( SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=20)
       ,( SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=30)
       ,( SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=40)
FROM dual;


--ORA-00979: not a GROUP BY expression
--empno 때문에 오류남
SELECT --empno, 
       deptno, MAX( sal + NVL(comm,0)) max_pay
FROM emp
GROUP BY deptno;


---------
SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp
WHERE deptno =30 AND sal+NVL(comm,0)= 2850
OR deptno =20 AND sal+NVL(comm,0)= 3000
OR deptno =10 AND sal+NVL(comm,0)= 5000 ;

-----***
-- 상관관계 correlated 서브 쿼리
--main query 의 값 e.deptno 을 서브쿼리에서 사용한 후
--결과값을 다시 메인 쿼리에서 사용

SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp e
WHERE sal+NVL(comm,0) = ( SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=e.deptno );

--서브쿼리 언제 사용?



--각 부서별로 각 부서의 평균 급여보다 크면 사원정보를 출력하세요
(방법1)
SELECT deptno, ename, sal+ NVL(comm,0) pay
        , (SELECT AVG(sal+ NVL(comm,0)) FROM emp WHERE deptno = e.deptno) deptno_avg_pay
FROM emp e
WHERE sal+ NVL(comm,0) > (SELECT AVG(sal+ NVL(comm,0)) FROM emp WHERE deptno = e.deptno)
ORDER BY deptno;
--두개 같나? 같음 위에는 부서별 평균까지 구하는 쿼리 포함
(방법2)
SELECT deptno, ename, sal+ NVL(comm,0) pay
FROM emp e
WHERE sal+NVL(comm,0) 
    >= (SELECT AVG( sal+NVL(comm,0)) FROM emp WHERE deptno=e.deptno )
ORDER BY deptno;



--문제) insa 테이블에서 
  -- java days10.EX05_05
--(  만나이 =  올해 년도 - 생일년도 )   생일지난 여부에 따라 생일 안났으면 -1
--   세는 나이 =  올해년도 -생일년도 +1

--주민등록번호 -[성별] 1,2,5,6 -> 1900  3,4,7,8 ->2000  9,0 ->1800
SELECT t.name, t.ssn
       ,CASE t.isbCheck
       WHEN -1 THEN t.now_year - t.birth_year -1   --생일 안지나면
       ELSE         t.now_year - t.birth_year 
       END amerianAge
       ,t.now_year - t.birth_year + DECODE(t.isbCheck,-1,-1,0) amerianAge
       , t.now_year - t.birth_year + 1 countingAGE
FROM(
    SELECT name, ssn
        ,TO_CHAR( SYSDATE, 'YYYY') now_year  
        , CASE
        WHEN SUBSTR(ssn,-7,1) IN (1,2,5,6)  THEN 1900 + SUBSTR(ssn,0,2)
        WHEN SUBSTR(ssn,8,1) IN (3,4,7,8) THEN 2000 + SUBSTR(ssn,0,2)
        ELSE 1800+ SUBSTR(ssn,0,2)
        END birth_year
        , SIGN ( TRUNC( SYSDATE) - TO_DATE(SUBSTR(ssn, 3,4),'MMDD')) isbCheck
      
FROM insa)t;

--문제) emp 테이블에서 pay를 많이 받는 3명 출력 (TOP-N 방식)
SELECT ROWNUM, t.*
FROM (
        SELECT deptno, ename, sal+ NVL(comm,0) pay
        FROM emp
        ORDER BY PAY DESC
)t
WHERE ROWNUM <=3;
WHERE ROWNUM <=1;
WHERE ROWNUM  BETWEEN 3 AND 5; -- 오류남 반드시 TOP1이 포함되어야 한다. 

--[순위를 매기는 함수]
1. DENSE_RANK()
 ㄱ. 그룹 내에서 차례로 된 행의 rank를 계산하여 NUMBER 데이터타입으로 순위를 반환
 ㄴ. 해당 값에 대한 우선순위를 결정(중복 순위 계산 안함) 
【Aggregate 형식】
      DENSE_RANK ( expr[,expr,...] ) WITHIN GROUP
        (ORDER BY expr [[DESC ? ASC] [NULLS {FIRST ? LAST} , expr,...] )
【Analytic 형식】
      DENSE_RANK ( ) OVER ([query_partion_clause] order_by_clause )

2. RANK()
ㄴ. 해당 값에 대한 우선순위를 결정(중복 순위 계산 함) 
문제) emp 테이블에서 pay를 많이 받는 3명 출력 ( DENSE_RANK방식)
WITH pay_rank_emp AS (
        SELECT ename, sal+NVL(comm,0) pay
              ,DENSE_RANK() OVER( ORDER BY sal+NVL(comm,0) DESC) seq
        FROM emp
)
SELECT e.*
FROM pay_rank_emp e
where e.seq BETWEEN 3 AND 5;
WHERE e.seq <=5;
WHERE e.seq =1;


-------
WITH pay_rank_emp AS (
        SELECT ename, sal pay
              ,DENSE_RANK() OVER( ORDER BY sal DESC) dr_seq
              ,RANK() OVER( ORDER BY sal DESC) r_seq
              ,ROW_NUMBER ()OVER( ORDER BY sal DESC)rn_seq
        FROM emp
)
SELECT e.*
FROM pay_rank_emp e;

-- ROWNUM --> 함수X, 의사칼럼 = 가짜칼럼
3. ROW_NUMBER() 함수

--문제 ) emp 테이블에서 각 부서별로 급여를 가장 많이 받는 사원 1명 출력

--1. 하나하나 가져와서 UNION ALL 연산자 사용(합집합)
SELECT MAX(sal) max_pay
FROM emp
WHERE deptno =20 
WHERE deptno =10 ;

--2. 상관 서브 쿼리 MQ <-> SQ
SELECT deptno, sal max_pay
FROM emp e
WHERE sal = (SELECT MAX(sal) FROM emp WHERE deptno =e.deptno);

--3. 순위 함수 사용
SELECT t.*
FROM (
SELECT deptno , sal pay
       -- , RANK( ) OVER( ORDER BY  sal DESC) seq  --전체순위
       -- , RANK( ) OVER( PARTITION BY deptno ORDER BY  sal DESC) seq
       -- , DENSE_RANK( ) OVER( PARTITION BY deptno ORDER BY  sal DESC) seq
        , ROW_NUMBER( ) OVER( PARTITION BY deptno ORDER BY  sal DESC) seq
FROM emp)t
WHERE t.seq <=2;

--12:100 = ?:20
--? = 240/100
--   = 2.4

--문제 emp 테이블에서 sal pay 가 상위 20%까지의 사원정보
SELECT t.*
FROM (
SELECT deptno ,ename,  sal pay
       ,RANK( ) OVER( ORDER BY sal DESC) r_seq
FROM emp)t
WHERE t.r_seq <= FLOOR( 2.4);

-- PERCENT_RANK()
【Analytic 형식】
       PERCENT_RANK() OVER ( 
                             [query_partition_clause]
                              order_by_clause
                            )
---

