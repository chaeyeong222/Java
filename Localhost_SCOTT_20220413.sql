
SELECT *
FROM salgrade;

1	700	   1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999

1. emp , salgrade 테이블을 사용해서 아래와 같이 출력.

SELECT ename, sal
      , (CASE 
       WHEN sal+NVL(comm,0) BETWEEN 700 AND 1200 THEN 1
       WHEN sal+NVL(comm,0) BETWEEN 1201 AND 1400 THEN 2
       WHEN sal+NVL(comm,0) BETWEEN 1401 AND 2000 THEN 3
       WHEN sal+NVL(comm,0) BETWEEN 2001 AND 3000 THEN 4
       ELSE 5
       END)  grade
FROM emp;

1-2. emp , salgrade 테이블을 사용해서 아래와 같이 출력. [JOIN] 사용

SELECT e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND HISAL;


ename   sal    grade
---------------------
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

1-3.  위의 결과에서 등급(grade)가 1등급인 사원만 조회하는 쿼리 작성
SELECT t.empno, t.ename, t.sal, t.grade
FROM (SELECT e.empno, e.ename, e.sal, s.grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND HISAL
)t
WHERE t.grade =1;

SELECT *
FROM (
SELECT *
FROM emp, salgrade
WHERE sal BETWEEN losal AND HISAL
)
WHERE GRADE=1;

결과)
     EMPNO ENAME             SAL      GRADE
---------- ---------- ---------- ----------
      7369 SMITH             800          1
      7900 JAMES             950          1  
      

2. emp 에서 최고급여를 받는 사원의 정보 출력

dept : dname
emp : ename, pay

--조인 안하면
SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp);

--조인 사용
ORA-00918: column ambiguously defined 
그냥 deptno 쓰면 오류남. dept와 emp 모두 존재하기때문
SELECT d.dname,d.deptno, ename, sal+NVL(comm,0) pay
FROM emp e JOIN dept d ON d.deptno= e.deptno --부모/자식테이블
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp);


SELECT d.dname, ename, sal+NVL(comm,0) max_pay
FROM emp e, dept d
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp)
       AND d.deptno =e.deptno;

DNAME          ENAME             PAY
-------------- ---------- ----------
ACCOUNTING     KING             5000

2-2. emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력 join

dept : dname, deptno
emp : deptno, ename, sal+NVL(comm,0) pay
-------------
SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp
GROUP BY deptno;
--ORA-00979: not a GROUP BY expression
------------
SELECT deptno,MAX(  sal+NVL(comm,0)) dept_max_pay
FROM emp
GROUP BY deptno;
30	2850
20	3000
10	5000
----------
--상관 서브 쿼리 main query -sub query
SELECT dname, d.deptno, ename,sal+NVL(comm,0) pay
FROM emp e, dept d
WHERE sal+NVL(comm,0) =(SELECT MAX(sal+NVL(comm,0) ) FROM emp WHERE deptno= e.deptno)
   AND e.deptno=d.deptno;
-- WHERE sal+NVL(comm,0) = (deptno 해당 부서의 최고 급여액) ;


/*내가 한 코딩 -조인조건 빼먹지 말기
SELECT d.dname, ename, sal+NVL(comm,0) max_pay
FROM emp e, dept d
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno=e.deptno)
;
*/

--다른 코딩 - 순위함수 이용

SELECT *
FROM ( SELECT deptno, ename, sal+NVL(comm,0) pay
    ,RANK()OVER(PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC) pay_rank
From emp
)t
WHERE t.pay_rank =1;

--부서명 같이 출력 dname 출력 위해서 join 해야함 -안에서 조인
SELECT *
FROM ( SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
    ,RANK()OVER(PARTITION BY d.deptno ORDER BY sal+NVL(comm,0) DESC) pay_rank
From emp e JOIN dept d ON e.deptno = d.deptno
)t
WHERE t.pay_rank =1;

--- 밖에서 조인
--[방법1]
SELECT t.deptno, d.dname, t.ename, t.pay, t.pay_rank
FROM ( SELECT deptno, ename, sal+NVL(comm,0) pay
    ,RANK()OVER(PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC) pay_rank
From emp 
)t JOIN dept d ON t.deptno=d.deptno
WHERE t.pay_rank =1;
--[방법2]
SELECT t.deptno, d.dname, t.ename, t.pay, t.pay_rank
FROM ( SELECT deptno, ename, sal+NVL(comm,0) pay
    ,RANK()OVER(PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC) pay_rank
From emp 
)t, dept d
WHERE t.pay_rank =1 AND t.deptno=d.deptno;

    DEPTNO DNAME          ENAME             PAY
---------- -------------- ---------- ----------
        10 ACCOUNTING     KING             5000
        20 RESEARCH       FORD             3000
        30 SALES          BLAKE            2850
        
        
? 3. emp 에서 각 사원의 급여가 전체급여의 몇 %가 되는 지 조회.
--       ( %   소수점 3자리에서 반올림하세요 )
--            무조건 소수점 2자리까지는 출력.. 7.00%,  3.50%     

SELECT SUM( sal+ NVL(comm,0) ) totalpay
FROM emp;

SELECT t.*
    ,TO_CHAR ( ROUND( PAY/TOTALPAY*100, 2) , '9,999.00') || '%' 비율
FROM ( SELECT ename, sal+ NVL(comm,0) pay
     ,(SELECT SUM( sal+ NVL(comm,0)) FROM emp)  totalpay
FROM emp)t;

/*내가 한 코딩
SELECT t.ename, t. pay
        , SUM(sal+NVL(comm,0)) total_pay
        
FROM(SELECT ename, sal+NVL(comm,0) pay
      ,PERCENT_RANK() OVER(ORDER BY sal+NVL(comm,0)) "비율"
FROM emp
)t;
*/
ENAME             PAY   TOTALPAY 비율     
---------- ---------- ---------- -------
SMITH             800      27125   2.95%
ALLEN            1900      27125   7.00%
WARD             1750      27125   6.45%
JONES            2975      27125  10.97%
MARTIN           2650      27125   9.77%
BLAKE            2850      27125  10.51%
CLARK            2450      27125   9.03%
KING             5000      27125  18.43%
TURNER           1500      27125   5.53%
JAMES             950      27125   3.50%
FORD             3000      27125  11.06%
MILLER           1300      27125   4.79%

12개 행이 선택되었습니다. 

? 4. emp 에서 가장 빨리 입사한 사원 과 가장 늦게(최근) 입사한 사원의 차이 일수 ? 
--[방법1]
SELECT MAX(hiredate),MIN(hiredate) 
     ,MAX(hiredate)-MIN(hiredate)
FROM emp;

ORDER BY hiredate DESC;
--[방법2] FIRST_VALUE , LAST_VALUE
SELECT ename, hiredate
  ,FIRST_VALUE(hiredate) OVER (ORDER BY hiredate DESC) A --현재행까지의 처음 값
 -- ,LAST_VALUE(hiredate) OVER (ORDER BY hiredate DESC) --현재행까지의 마지막 값
 ,FIRST_VALUE(hiredate) OVER (ORDER BY hiredate ASC) B
 ,FIRST_VALUE(ename) OVER (ORDER BY hiredate DESC)c
 ,FIRST_VALUE(ename) OVER (ORDER BY hiredate ASC) d
FROM emp;


5. insa 에서 사원들의 만나이 계산해서 출력
  ( 만나이 = 올해년도 - 출생년도          - 1( 생일이지나지 않으면) )
;

SELECT t.name, t.ssn
    , CASE 
      WHEN t.ischeck = -1 THEN t.birth_year - t.now_year -1
      ELSE t.birth_year - t.now_year
FROM (
SELECT name, ssn
    , TO_CHAR( SYSDATE ,'YYYY') now_year
    ,SUBSTR(ssn, 0,2)
    , CASE
      WHEN  SUBSTR( ssn, -7,1) IN (1,2,5,6) THEN 1900 + SUBSTR(ssn, 0,2)
      WHEN  SUBSTR( ssn, -7,1) IN (3,4,7,8)THEN 2000 + SUBSTR(ssn, 0,2)
      ELSE 1800 + SUBSTR(ssn, 0,2)
      END birth_year   
    , SIGN (TRUNC( SYSDATE) - TO_DATE (SUBSTR( ssn, 3,4),'MMDD')) ischeck
FROM insa
)t;

/*  
  SELECT t.name, t.ssn
        , CASE t.ischeck
        WHEN -1 THEN t.b_day_year - t.n_year
        ELSE t.b_day_year - t.n_year
  FROM(
       SELECT  name, ssn
       , SUBSTR(ssn, 0,2)
       , TO_CHAR(SYSDATE,'YYYY') n_year
       , CASE 
        WHEN SUBSTR(ssn,8,1) In (1,2,5,6)  THEN 1900 + SUBSTR(ssn, 0,2)
        WHEN SUBSTR(ssn,8,1) In (3,4,7,8)  THEN 2000 + SUBSTR(ssn, 0,2)
        ELSE 1800+ SUBSTR(ssn, 0,2)
        END b_day_year
        , SIGN( TRUNC(SYSDATE) - TO_DATE(SUBSTR(ssn,3,4),'MMDD') ) ischeck
    FROM insa
    )t;
*/
  
6. insa 테이블에서 아래와 같이 결과가 나오게 ..
     [총사원수]      [남자사원수]      [여자사원수] [남사원들의 총급여합]  [여사원들의 총급여합] [남자-max(급여)] [여자-max(급여)]
---------- ---------- ---------- ---------- ---------- ---------- ----------
        60                31              29           51961200                41430400                  2650000          2550000
      SELECT COUNT(*) 총사원수
          ,COUNT (DECODE ( MOD( SUBSTR(ssn,-7,1),2), 1,'남자'))  남자사원수
          , COUNT ( CASE MOD(  SUBSTR(ssn,-7,1),2)
          WHEN 0 THEN 'o'
          ELSE null
          END) 여자사원수
          , SUM( DECODE ( MOD( SUBSTR(ssn,-7,1),2), 1,basicpay)) "남사원 총급여합"
          , SUM( DECODE ( MOD( SUBSTR(ssn,-7,1),2), 0,basicpay)) "여사원 총급여합"
          , MAX( DECODE ( MOD( SUBSTR(ssn,-7,1),2), 1,basicpay)) "남사원 최고급여"
          , MAX( DECODE ( MOD( SUBSTR(ssn,-7,1),2), 0,basicpay)) "여사원 최고급여"
      FROM insa;
          
7. TOP-N 방식으로 풀기 ( ROWNUM 의사 컬럼 사용: 행에 순번 매겨줌)  ROWID :행에 고유한 아이디를 붙여줌
   emp 에서 최고급여를 받는 사원의 정보 출력  
  
    DEPTNO ENAME             PAY   PAY_RANK
---------- ---------- ---------- ----------
        10 KING             5000          1
/* 형식
SELECT ROWNUM
FROM (
        ORDER BY
)
WHERE ROWNUM = 1;
*/

SELECT T.*, ROWNUM PAY_RANK
FROM (
       SELECT deptno, ename, sal+NVL(comm,0) pay
       FROM emp
        ORDER BY pay DESC
)T
WHERE ROWNUM = 1;
        
8-1.순위(RANK) 함수 사용해서 풀기 
   emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력
   
    DEPTNO ENAME             PAY DEPTNO_RANK
---------- ---------- ---------- -----------
        10 KING             5000           1
        20 FORD             3000           1
        30 BLAKE            2850           1

ㄴ.  + emp 조인
SELECT t.deptno, e.ename, e.sal
FROM (
SELECT deptno, MAX(SAL) maxpay
FROM emp
GROUP BY deptno
) t, emp e
WHERE t.deptno = e.deptno  AND t.maxpay = e.sal;

ㄱ. 순위매기는 함수  -> 다시 보기
SELECT *
FROM ( SELECT d.deptno, dname, ename, sal+NVL(comm,0) pay
    ,RANK()OVER(PARTITION BY d.deptno ORDER BY sal+NVL(comm,0) DESC) pay_rank
From emp e JOIN dept d ON e.deptno = d.deptno
)t
WHERE pay_rank =1; 



SELECT deptno, ename, sal+NVL(comm,0) pay
       , ROWNUM 
FROM emp
WHERE sal+NVL(comm,0) = (SELECT MAX( sal+NVL(comm,0)) FROM emp)


8-2. 상관()서브쿼리를 사용해서 풀기 
   emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력 
   
9.  emp테이블에서 각 부서의 사원수, 부서총급여합, 부서평균을 아래와 같이 출력하는 쿼리 작성.
결과)
    DEPTNO       부서원수       총급여합    	     평균
---------- ---------- 		---------- 	----------
        10          3      	 8750    	2916.67
        20          3     	  6775    	2258.33
        30          6     	 11600    	1933.33      
 ;
 
SELECT deptno, COUNT(*)  "부서원수"  
       , SUM(sal+NVL(comm,0)) "총급여합"
       , ROUND ( AVG(sal+NVL(comm,0)),2)  "평균"
FROM emp
GROUP BY deptno
ORDER BY deptno;
         
10-1.  emp 테이블에서 30번인 부서의 최고, 최저 SAL을 출력하는 쿼리 작성.
결과)
  MIN(SAL)   MAX(SAL)
---------- ----------
       950       2850
[방법1]
 SELECT MIN ( sal+NVL(comm,0)) "MIN(SAL)"
       , MAX(sal+NVL(comm,0)) "MAX(SAL)"
 FROM emp
 WHERE deptno =30;
       
[방법2] HAVING 절 :GROUP BY 의 조건절
SELECT deptno
       , MAX(sal+NVL(comm,0)),  MIN( sal+NVL(comm,0))
FROM emp
GROUP BY deptno
HAVING deptno =30; 

10-2.  emp 테이블에서 30번인 부서의 최고, 최저 SAL를 받는 사원의 정보 출력하는 쿼리 작성.

결과)
     EMPNO ENAME      HIREDATE        SAL
---------- ---------- -------- ----------
      7698 BLAKE      81/05/01       2850
      7900 JAMES      81/12/03        950  
      
[방법1]
 SELECT MAX( sal),MIN( sal)
 FROM emp
 WHERE deptno =30;

/*
SELECT empno, ename, hiredate, sal
 FROM emp
 WHERE deptno =30 AND sal IN ( SELECT MAX( sal),MIN( sal)  FROM emp
 WHERE deptno =30) ;
--ORA-00913: too many values
두개 한번에는 안됨. 따로따로 서브쿼리 넣어주기. 
*/
[방법2]
SELECT empno, ename, hiredate, sal
 FROM emp
 WHERE deptno =30 AND sal IN ( 
                       (SELECT MAX( sal) FROM emp  WHERE deptno =30 ) 
                       ,(SELECT MIN( sal) FROM emp  WHERE deptno =30 )
                        );
[방법3]UNION ALL 가능
[방법4]
SELECT empno, ename, hiredate, sal
FROM ( SELECT MAX( sal) maxsal ,MIN( sal) minsal  
    FROM emp
    WHERE deptno =30
  )t, emp e
WHERE e.deptno=30 AND t.maxsal=e.sal OR t.minsal=e.sal;

11.  insa 테이블에서 
[실행결과]
부서명     총사원수 부서사원수 성별  성별사원수  부/전%   부성/전%   성/부%
개발부	    60	    14	      F	    8	    23.3%	  13.3%	    57.1%
개발부	    60	    14	      M	    6	    23.3%	  10%	    42.9%
기획부	    60	    7	      F	    3	    11.7%	5%	4       2.9%
기획부	    60	    7	      M	    4	    11.7%	6.7%	    57.1%
영업부	    60	    16	      F	    8	    26.7%	13.3%	    50%
영업부	    60	    16	      M	    8	    26.7%	13.3%	    50%
인사부	    60	    4	      M	    4	    6.7%	6.7%	    100%
자재부	    60	    6	      F	    4	    10%	    6.7%	    66.7%
자재부	    60	    6	      M	    2	    10%	    3.3%	    33.3%
총무부	    60	    7	      F	    3	    11.7%	5%	        42.9%
총무부	    60	    7	      M 	4	    11.7%	6.7%	    57.1%
홍보부	    60	    6	      F	    3	    10%	    5%	        50%
홍보부	    60	    6	      M	    3	    10%	    5%	        50%             
;
WITH temp AS 
(
        SELECT t.buseo
               ,(SELECT COUNT(*) FROM insa ) 총사원수
               ,(SELECT COUNT(*) FROM insa WHERE buseo =t.buseo) 부서사원수 --상관서브쿼리
               , gender
               , COUNT (*) "성별사원수"
        FROM (                                                  --인라인뷰
            SELECT buseo, name, ssn
                     , DECODE ( MOD ( SUBSTR(ssn, -7,1),2),1,'M','F') gender
            FROM insa
        )t
        GROUP BY buseo, gender
        ORDER BY buseo, gender
)
SELECT temp.*
     , ROUND( 부서사원수/총사원수*100,2)||'%' "부/전%"
     , ROUND( 성별사원수/총사원수*100,2)||'%' "부성/전%"
     , ROUND( 성별사원수/부서사원수*100,2)||'%' "성/부%"
FROM temp;

--GROUP BY /HAVING 절
12. insa테이블에서 여자인원수가 5명 이상인 부서만 출력.  
SELECT *
FROM(
    SELECT buseo,COUNT(*) 여자사원수
    FROM insa
    WHERE MOD(SUBSTR(ssn,-7,1),2)=0
    GROUP BY buseo
)t
WHERE  여자사원수 >=5 ;

13. insa 테이블에서 급여(pay= basicpay+sudang)가 상위 15%에 해당되는 사원들 정보 출력 
  (급여순위 9등까지 출력)
SELECT COUNT(*) FROM insa; --60명 
SELECT 60 * 0.15   --9명
FROM dual;

SELECT *
FROM (
    SELECT buseo, name, basicpay+sudang pay
           ,RANK() OVER (ORDER BY basicpay+sudang DESC) pay_rank
    FROM insa
)
WHERE pay_rank <= (SELECT COUNT(*) FROM insa) *0.15;
--WHERE pay_rank <= 9;


14. emp 테이블에서 sal의 전체사원에서의 등수 , 부서내에서의 등수를 출력하는 쿼리 작성

--RANK 함수 사용
SELECT deptno, ename, sal
    ,RANK() OVER ( ORDER BY sal DESC) 전체등수
    , RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) 부서등수
FROM emp
ORDER BY deptno;

--상관 서브 쿼리

SELECT deptno, ename, sal
    ,(SELECT COUNT(*)+1 FROM emp WHERE sal > e.sal ) 전교등수
    ,(SELECT COUNT(*)+1 FROM emp WHERE sal > e.sal AND deptno=e.deptno) 부서내등수
FROM emp e
ORDER BY deptno ASC, 부서내등수 ASC;

---------------------------
앞 뒤에 있는 특정 문자 제거
SELECT '***ADMIN***'
      --  , REPLACE ( '***ADMIN***','*','')
      --  , TRIM( '특정문자' FROM 문자열 ) -> 특정문자 말고 공백도 가능
      ,TRIM ( '*' FROM '***ADMIN***')
FROM dual;

------------
TO_DATE / TO_CHAR( 숫자/날짜, 'fmt' [,nls param]   )

nls param = nls parameter (매개변수, 인자)
--nls?
1. National Language Support
2. 3가지 종류 분류 (우선순위)
   SESSION  >  CLIENT  >  SERVER

SELECT ename, sal, TO_CHAR(hiredate, 'YY/MON/DAY', 'NLS_DATE_LANGUAGE =JAPANESE')
FROM emp;
------------
-- GROUP BY 절,  HAVING 절
SELECT 
   COUNT(*) --전체사원수
   , COUNT( DECODE ( deptno,10, 'o')) --10번 부서 사원수
   , COUNT( DECODE ( deptno,20, 'o')) --20번 부서 사원수
   , COUNT( DECODE ( deptno,30, 'o')) --30번 부서 사원수
   , COUNT( DECODE ( deptno,40, 'o')) --40번 부서 사원수
FROM emp;

--부서별 인원 수 파악 (40번부서 출력 X) OUTER JOIN
-- ORA-00904: "DEPTNO": invalid identifier
SELECT 0 deptno, COUNT(*) 
FROM emp
UNION ALL
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
ORDER BY deptno ASC;

--문제) emp 테이블에서 
     1) 20번, 40번 부서는 제외시키고
     2) 그 외 부서의 사원수를 계산
     3) 그 사원수가 4명이상인 부서정보를 조회
     (조건 : 부서번호, 부서명, 사원수)
 ;
 
SELECT d.deptno, dname, t.cnt
 FROM (
     SELECT deptno, COUNT(*) cnt
     FROM emp
     WHERE deptno NOT IN (20,40)
     GROUP BY deptno
     )t JOIN dept d ON d.deptno = t.deptno
WHERE cnt >=4;
     
--그룹화 집계 + 조건 (having)
--ORA-00918: column ambiguously defined
/* 집계함수 외에는 모두 group by 절에 들어가야 한다.
SELECT d.deptno, dname, COUNT(*)
FROM emp e JOIN dept d ON e.deptno =d.deptno
WHERE deptno NOT IN (20,40)
GROUP BY deptno
HAVING COUNT(*) >=4;
*/
SELECT d.deptno, dname, COUNT(*)
FROM emp e JOIN dept d ON e.deptno =d.deptno
WHERE d.deptno NOT IN (20,40)
GROUP BY d.deptno, dname
HAVING COUNT(*) >=4;


----
문제) insa 테이블에서 
     각 부서별로 과장 ?, 대리?, 사원? 등등 직급별 사원수를 출력
     
SELECT buseo, name, jikwi
FROM insa
WHERE buseo = '개발부'
ORDER BY JIKWI;

-------(1차) 부서별로 그룹, (2차)부서 안에서 직급별 그룹
SELECT buseo, jikwi, COUNT(*) 직급사원수
FROM insa
GROUP BY buseo, jikwi
ORDER BY buseo ASC, jikwi ASC;

--문제 ) insa 테이블에서 남자사원들만 부서별로 사원수를 구해서 6명이상인 부서만 출력
   --     (부서명, 남자사원수)
--- WHERE/ GROUP BY/ HAVING 절 구분해서 사용

SELECT 부서명, 남자사원수
FROM insa
WHERE 남자사원만
GROUP BY 부서별
HAVING 남자사원수 >=6; 

--ORA-00904: "남자사원수": invalid identifier 처리순서에 따라 HAVING 절남자사원수 인식못함
SELECT buseo, COUNT(*) 남자사원수
FROM insa
WHERE MOD( SUBSTR(ssn, 8,1),2) =1
GROUP BY buseo
HAVING COUNT(*) >=6; 

-- GROUP BY 절 에서 ROLLUP, CUBE 조건
 -- ROLLUP은 GROUP BY 절의 그룹 족너에 따라 전체 행을 그룹화하고
 --  각 그룹에 대해 부분합을 구하는 연산자이다
   
   문제 )insa 테이블에서 남자사원수, 여자사원수를 출력(조회) -group by 절 사용
   
   SELECT DECODE ( MOD( SUBSTR(ssn, 8,1),2),1,'남자','여자') GENDER
          ,COUNT(*)
   FROM insa
   GROUP BY MOD( SUBSTR(ssn, 8,1),2)
   UNION ALL
   SELECT '총사원수', COUNT(*)   FROM insa;
   
   
GENDER COUNT(*)
---    --- 
남자	   31
여자	   29
총사원수  60

-- ROLL UP 연산자 사용 위와 같은 처리
그룹화 한 부분합을 따로 구해서 합집합 할 필요 없이 RULLUP 연산자에 의해서 부분합 출력
   SELECT DECODE(  MOD( SUBSTR(ssn, 8,1),2),1,'남자',0,'여자','총사원수') GENDER
          ,COUNT(*)
   FROM insa
   GROUP BY ROLLUP ( MOD( SUBSTR(ssn, 8,1),2));

-------------
  SELECT DECODE(  MOD( SUBSTR(ssn, 8,1),2),1,'남자',0,'여자','총사원수') GENDER
          ,COUNT(*)
   FROM insa
   GROUP BY CUBE ( MOD( SUBSTR(ssn, 8,1),2));

--문제 )   insa 테이블에서 
          각 부서별로 1차그룹화, 각 직위별 2차그룹화 COUNT(), SUM(), AVG()
    SELECT buseo, jikwi, COUNT(*) 사원수
    FROM insa
    GROUP BY buseo , jikwi
--    ORDER BY buseo, jikwi
    UNION ALL
    SELECT buseo, ' ', COUNT(*)
    FROM insa
    GROUP BY buseo
    UNION ALL
    SELECT '','',COUNT(*)
    FROM insa;
    
    ORDER BY buseo ASC ;
--ORA-00933: SQL command not properly ended
--ORDER BY 절은 항상 맨 마지막에서만 쓸 수 있다


    SELECT buseo, jikwi, COUNT(*) 사원수
    FROM insa
    --GROUP BY ROLLUP ( buseo , jikwi)
    GROUP BY CUBE( buseo , jikwi)
    ORDER BY buseo , jikwi;
    
    GROUP BY N=2개 buseo, jikwi
    ROLLUP N+1 =3 (부서+직위 사원수, 부서사원수,  전체 사원수)
    CUBE 2*N=4  (부서+직위 사원수, 부서사원수, 직위사원수, 전체 사원수)

개발부	과장	2
개발부	대리	2
개발부	부장	1
개발부	사원	9
기획부	대리	3
기획부	부장	2
기획부	사원	2
영업부	과장	1
영업부	대리	5
영업부	부장	2
영업부	사원	8
인사부	과장	1
인사부	대리	1
인사부	사원	2
자재부	과장	1
자재부	부장	1
자재부	사원	4
총무부	과장	2
총무부	부장	1
총무부	사원	4
홍보부	과장	1
홍보부	대리	2
홍보부	사원	3

-----------------------
--문제 ) emp 테이블에서 JOB 별로 사원수 몇 명 조회
ㄱ. GROUP BY 절
SELECT job, COUNT(*)
FROM emp
GROUP BY job;

ㄴ. DECODE() 함수
SELECT COUNT ( DECODE ( JOB, 'CLERK','O')) CLERK
       ,COUNT ( DECODE ( JOB, 'SALESMAN','O'))  SALESMAN
       ,COUNT ( DECODE ( JOB, 'PRESIDENT','O') ) PRESIDENT
       ,COUNT ( DECODE ( JOB, 'MANAGER','O'))  MANAGER
       ,COUNT ( DECODE ( JOB, 'ANALYST','O') ) ANALYST
FROM emp;

** ㄷ. PIVOT (피벗) **
--  모니터 가로/세로 - 피벗 기능 
-- 축을 중심으로 회전시키다. 세로 -> 가로 (피벗)/ 가로-> 세로 (언피벗)

1)오라클 11g 부터 제공하는 함수
2) 행과 열을 뒤집는 함수
3) 형식
 SELECT * 
 FROM (피벗 대상 쿼리문)  -- 피벗대상 서브쿼리
 PIVOT (그룹함수(집계컬럼) FOR 피벗컬럼 IN(피벗컬럼 값 AS 별칭...))

SELECT *
FROM ( SELECT job FROM emp)
PIVOT (COUNT (job) FOR job IN ('CLERK', 'SALESMAN','PRESIDENT','MANAGER','ANALYST'  ))


SELECT job
FROM emp;

CLERK
SALESMAN
SALESMAN
MANAGER
SALESMAN
MANAGER
MANAGER
PRESIDENT


-- 문제) emp 테이블에서
       각 job 별 1월, 2월 입사한 사원수를 조회.
SELECT * 
  FROM (SELECT job , TO_CHAR(hiredate, 'FMMM') || '월' hire_month
         FROM emp
       )
   PIVOT(
         COUNT(*)
         FOR hire_month IN ('1월', '2월','3월','4월','5월','6월','12월')
        );

-- 문제) insa 테이블에서 성별로 사원수 조회
 
 1. GROUP BY 사용
SELECT COUNT(*)
FROM insa
GROUP BY MOD ( SUBSTR(ssn, 8,1),2 );

  2. DECODE() 사용
  SELECT DECODE ( MOD ( SUBSTR(ssn, 8,1),2 ),'1','남자')
       ,DECODE ( MOD ( SUBSTR(ssn, 8,1),2 ),'0','여자')
  FROM insa;
  
  3. PIVOT() 사용
 SELECT * 
 FROM (피벗 대상 쿼리문)  -- 피벗대상 서브쿼리
 PIVOT (그룹함수(집계컬럼) FOR 피벗컬럼 IN(피벗컬럼 값 AS 별칭...))
 
 SELECT *
 FROM ( SELECT  MOD(SUBSTR(ssn, 8,1),2) gender FROM insa)
 PIVOT ( COUNT(*) FOR gender IN( 1 AS "남자",0 AS "여자"));




