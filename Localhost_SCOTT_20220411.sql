1. EMP 테이블의 사원수를 조회하는 쿼리 작성.
  집계함수 / 그룹함수 / 복수행함수
  COUNT(), SUM(), AVG()]
  MAX(), MIN()
  STDDEV() 표준편차, VARIANCE()분산
    
SELECT COUNT(*)  --NULL값 포함해서 12
     --,COUNT(COMM) --NULL값 제외해서 4
     --,SUM( sal+NVL(comm,0))totalpay
     --,SUM(sal+NVL(comm,0) )/COUNT(*) avg_pay
     --,AVG( sal+NVL(comm,0) ) avg_pay2
     ,MAX( sal+NVL(comm,0)) max_pay
     ,MIN(sal+NVL(comm,0)) min_pay
FROM emp;
--12
  --**주의할 점 ) NULL 값을 제외한 ***
--문제) emp테이블에서 최고급여액을 받는 사원의 정보?

SELECT *
FROM emp
WHERE sal+NVL(comm,0)=( SELECT MAX (sal+NVL(comm,0)) FROM emp );

SELECT *
FROM emp
WHERE sal+NVL(comm,0)=( SELECT MIN(sal+NVL(comm,0)) FROM emp );

--문제 emp테이블에서 최고, 최저 급여를 받는 사원의 정보
방법1)
SELECT *
FROM emp
WHERE sal+NVL(comm,0)=( SELECT MIN(sal+NVL(comm,0)) FROM emp )
      OR sal+NVL(comm,0)=( SELECT MAX(sal+NVL(comm,0)) FROM emp );
방법2)
SELECT *
FROM emp
WHERE sal+NVL(comm,0)=( SELECT MAX (sal+NVL(comm,0)) FROM emp )
UNION
SELECT *
FROM emp
WHERE sal+NVL(comm,0)=( SELECT MIN(sal+NVL(comm,0)) FROM emp );

방법3)
SELECT *
FROM emp
WHERE sal+NVL(comm,0) 
  IN(  ( SELECT MAX (sal+NVL(comm,0)) FROM emp )
           , (SELECT MIN(sal+NVL(comm,0))FROM emp));

--같이 쓸때는 FROM emp 필요, 아니면 오류난다.

--최고 급여
SELECT *
FROM emp
WHERE sal+NVL(comm,0) >= ALL(SELECT sal+NVL(comm,0) FROM emp);

--최저급여
SELECT *
FROM emp
WHERE sal+NVL(comm,0) <= ALL(SELECT sal+NVL(comm,0) FROM emp);

--WHERE 조건절의 서브쿼리의 결과가 존재한다면 TRUE 반환 --12명 나옴
SELECT *
FROM emp
WHERE EXISTS(SELECT DISTINCT mgr FROM emp WHERE mgr IS NOT NULL);
WHERE EXISTS (SELECT deptno FROM dept);

2. 현재 시스템의   날짜를 출력하는 쿼리 작성
SELECT SYSDATE
      ,CURRENT_DATE  --초까지
      ,CURRENT_TIMESTAMP --나노초까지
FROM dual;
--22/04/11

3. SQL 집합 연산자의 종류와 설명을 하세요
SUM 합계
AVG 평균
COUNT 갯수

4. 함수 설명
  ㄱ. 반올림 함수를 선언형식을 적고 설명하세요 
  SELECT ROUND(값, 반올림할 위치) 위치값 +1한 값에서 반올림 됨.
  FROM dual;
  ㄴ. 절삭(내림) 함수를 선언형식을 적고 설명하세요.    
  TRUNC -- 값, 위치   
  FLOOR -- 소수 첫째자리내림, 무조건 정수값
  ㄷ. 절상(올림) 함수를 선언형식을 적고 설명하세요.    
  CEIL --위치 지정 안됨.
  
5. 게시판에서 총 게시글 수가 : 65 개 이고  한 페이지에 : 15개의 게시글 출력할 때
    총 페이지 수를 계산하는 쿼리 작성.
SELECT CEIL( 65/15) "페이지수"
FROM dual;
6. emp 테이블에서 사원들의 평균 급여보다 많은 급여를 받으면 1
                                     적은 급여를 받으면 -1
                                     같으면           0 
  을 출력하는 쿼리 작성.
SELECT t.ename, t.pay, t.avg_pay
   ,SIGN( t.pay-t.avg_pay   ) 
FROM (SELECT ename 
         , sal+NVL(comm,0) pay
         --, AVG( sal+NVL(comm,0) )
         ,( SELECT FLOOR (AVG( sal+NVL(comm,0) )) FROM emp) avg_pay
     FROM emp
) t;

7. insa테이블에서 80년대( 80년~89년생 )에 출생한 사원들만 조회하는 쿼리를 작성
  ㄱ. LIKE 사용
  WHERE ssn LIKE '8%'
  ㄴ. REGEXP_LIKE 사용
  WHERE REGEXP_LIKE (ssn,'^8')
  ㄷ. BETWEEN ~ AND 사용   
  WHERE SUBSTR(ssn,0,2)  BETWEEN 80 AND 89
  
8. insa 테이블에서 주민등록번호를 123456-1******  형식으로 출력하세요 . ( LPAD, RPAD 함수 사용  )
[실행결과]
홍길동	770423-1022432	770423-1******
이순신	800423-1544236	800423-1******
이순애	770922-2312547	770922-2******
SELECT name, ssn
           ,RPAD(  SUBSTR( ssn, 0,8) ,14,'*')
FROM insa;

8-2. emp 테이블에서 30번 부서만 PAY를 계산 후 막대그래프를 아래와 같이 그리는 쿼리 작성
   ( 필요한 부분은 결과 분석하세요~    PAY가 100 단위당 # 한개 , 반올림처리 )
   
SELECT deptno, ename
        ,sal + NVL(comm,0) pay
        , ROUND(sal + NVL(comm,0),-2)/100
        ,RPAD( ' ', ROUND(sal + NVL(comm,0),-2)/100+1, '#')
FROM emp
WHERE deptno = 30;
   
[실행결과]
DEPTNO ENAME PAY BAR_LENGTH      
---------- ---------- ---------- ----------
30	BLAKE	2850	29	 #############################
30	MARTIN	2650	27	 ###########################
30	ALLEN	1900	19	 ###################
30	WARD	1750	18	 ##################
30	TURNER	1500	15	 ###############
30	JAMES	950	    10	 ##########

8-3. insa 테이블에서  주민번호를 아래와 같이 '-' 문자를 제거해서 출력
[실행결과]
NAME    SSN             SSN_2
홍길동	770423-1022432	7704231022432
이순신	800423-1544236	8004231544236
이순애	770922-2312547	7709222312547

SELECT ssn
       ,REPLACE(ssn, '-','')
       ,INSTR(ssn, '-')
       ,SUBSTR(ssn, 0,6) || SUBSTR(ssn, -7)
FROM insa;

9. emp 테이블에서 각 사원의 근무일수, 근무 개월수, 근무 년수를 출력하세요.

날짜 - 날짜 = 일수
날짜 + 숫자 = 일(숫자)이 더해진 날짜
날짜 - 숫자 = 일이 빼진 날짜
날짜 +- 숫자/24 = 시간이 +- 된 날짜

-- 근무일수 / 365 = 근무년수 + 윤년계산

SELECT empno, ename, hiredate
     , CEIL ( ABS( hiredate - SYSDATE)) 근무일수
FROM emp;

--MONTHS_BETWEEN() : 날짜 사이의 개월수 리턴하는 함수
SELECT ROUND (ABS(MONTHS_BETWEEN(hiredate, SYSDATE)),2) 근무개월수
       ,ROUND(ABS(MONTHS_BETWEEN(hiredate, SYSDATE))/12 ,2) 근무년수
FROM emp;


10. 개강일로부터 오늘날짜까지의 수업일수 ?  --토/일/공휴일 포함
( 개강일 : 2022.2.15 )

--ORA-00932: inconsistent datatypes: expected CHAR got DATE
-- 자료형 다름 '2022~'을 문자열로 인식해서 오류난 것
SELECT '2022.02.15'- SYSDATE
FROM dual;

/*TO_DATE 함수는
CHAR, VARCHAR2, NCHAR, NVARCHAR2 데이터타입을
DATE 데이터타입으로 변환한다*/

--올바른 것
SELECT  TO_DATE( '2022.02.15')- SYSDATE
      -- ORA-01843: not a valid month
      --,TO_DATE( '02/15/2022')- SYSDATE
      ,TO_DATE( '02/15/2022', 'MM/DD/YYYY')- SYSDATE
FROM dual;




10-2.  오늘부터 수료일까지 남은 일수 ?  
( 수료일 : 2022.7.29 ) 

SELECT  CEIL (TO_DATE( '2022.07.29')- SYSDATE)
FROM dual;

10-3. emp 테이블에서 각 사원의 입사일을 기준으로 100일 후 날짜, 10일전 날짜, 1시간 후 날짜, 3개월 전 날짜 출력

SMITH	80/12/17	81/03/27	80/12/07	80/12/17	81/03/17	80/09/17
ALLEN	81/02/20	81/05/31	81/02/10	81/02/20	81/05/20	80/11/20
WARD	81/02/22	81/06/02	81/02/12	81/02/22	81/05/22	80/11/22

SELECT ename, hiredate
       ,hiredate + 100
       ,hiredate -10
       ,hiredate +1/24
       ,ADD_MONTHS(hiredate, 3) "3개월후"
       ,ADD_MONTHS(hiredate, -3) "3개월전"
FROM emp;

MONTHS_BETWEEN () 개월차

SELECT t.f, t.s
       ,MONTHS_BETWEEN(t.f, t.s)
FROM ( SELECT TO_DATE ('03-01-2022', 'MM-DD-YYYY')   F
         ,TO_DATE ('02-01-2022', 'MM-DD-YYYY')  S
      FROM dual
      )t;

--ADD_MONTHS()
SELECT ADD_MONTHS(TO_DATE ('02-01-2022', 'MM-DD-YYYY'), 1)
       ,ADD_MONTHS(TO_DATE ('02-28-2022', 'MM-DD-YYYY'),1)  --3.31
       ,ADD_MONTHS(TO_DATE ('02-27-2022', 'MM-DD-YYYY'),1)   --3.27
FROM dual;

--LAST_DAY() 는 특정 날짜가 속한 달의 가장 마지막 날짜를 반환

SELECT LAST_DAY(SYSDATE)
   --       일 만 얻어오고 싶다?
       ,TO_CHAR( LAST_DAY(SYSDATE), 'DD')
       ,EXTRACT( DAY FROM LAST_DAY(SYSDATE))
FROM dual;

--다음주 금요일 휴강?
--명시된 요일이 돌아오는 가장 최근 날짜
-- 일1 월2 화3 ...
SELECT SYSDATE 
        ,TO_CHAR(SYSDATE,'D') 
        ,TO_CHAR(SYSDATE,'DY') 
        ,TO_CHAR(SYSDATE,'DAY') 
        ,NEXT_DAY( SYSDATE , '금요일')
        ,NEXT_DAY( SYSDATE , '월요일')
FROM dual;

11. function 설명
 ㄱ. ASCII()
 ㄴ. CHR()
 ㄷ. GREATEST()
 ㄹ. LEAST()
 ㅁ. UPPER()
 ㅂ. LOWER()
 ㅅ. LENGTH()
 ㅇ. SUBSTR()
 ㅈ. INSTR()
 
 SELECT ASCII('가'), ASCII('A')
      ,CHR(15380608), CHR(65)
      ,GREATEST(1,2,3,4,5), LEAST(1,2,3,4,5)
 FROM dual;
 
12. 
SELECT TRUNC( SYSDATE, 'YEAR' ) --22/01/01 
      , TRUNC( SYSDATE, 'MONTH' )     -- 22/04/01
      , TRUNC( SYSDATE  )     --22/04/11
    FROM dual;
    위의 쿼리의 결과를 적으세요 . 
    
문제) 이번달 몇 일 남았나?
SELECT SYSDATE
      ,LAST_DAY(SYSDATE)
      ,LAST_DAY(SYSDATE) -SYSDATE 
FROM dual;

--오라클 형변환 함수
TO_NUMBER() : 문자 -> 숫자 형변환
TO_DATE()
TO_CHAR()

SELECT '10' --왼쪽정렬
        ,10   --오른쪽정렬
        ,TO_NUMBER('10')
        ,'10'+10
FROM dual;

SELECT *
FROM insa
WHERE SUBSTR(ssn, -7,1)=1 ; -- '1' 암시적 형변환

SELECT TO_DATE( '2022.02.15')
       ,TO_DATE( '02.15.2022','MM.DD.YYYY')
       ,TO_DATE('2022','YYYY') 
       --2022/04/01  --년도만 있는 문자열을 TO_CHAR로 날짜변환하면 그 달의 1일 날짜로 들어감.
       ,TO_DATE('2022.03','YYYY.MM') --1일로 설정
       ,TO_DATE('20','DD') --2022/4/20
FROM dual;
    
SELECT SYSDATE 
--       ,TO_CHAR(SYSDATE, 'YYYY') --날짜에서 문자열 '2022'년도만 가져옴
--       ,TO_CHAR(SYSDATE, 'MM')
--       ,TO_CHAR(SYSDATE, 'DD')
--       ,TO_CHAR(SYSDATE, 'HH')
--       ,TO_CHAR(SYSDATE, 'HH24')
--       ,TO_CHAR(SYSDATE, 'SS')
--       ,TO_CHAR(SYSDATE, 'D')
--       ,TO_CHAR(SYSDATE, 'DY')
--       ,TO_CHAR(SYSDATE, 'DAY'
         ,TO_CHAR(SYSDATE, 'CC')  --21세기
         ,TO_CHAR(SYSDATE, 'Q') --2(분기)
         ,TO_CHAR(SYSDATE, 'WW')--년 중에 몇번째 주
         ,TO_CHAR(SYSDATE, 'IW')   --1년 중 몇번째 주
         ,TO_CHAR(SYSDATE, 'W') --월 중에 몇번째 주
FROM dual;

--SYSDATE를 TO_CHAR 사용해서 '2022년 4월 11일 오후 12:40:12'로 출력
-- . 와 / 외에 다른 문자 넣고 싶다면 " 쌍따옴표 넣는다
SELECT TO_CHAR(SYSDATE, 'YYYY"년 "MM"월 "DD"일 "TS')
FROM dual;

------------숫자를 문자로
SELECT 1234567
 --3자리마다 콤마 찍은 문자열로 변환
 , TO_CHAR(1234567 ,'9,999,999') --###### 뜨면 자리 부족
 , TO_CHAR(1234567 ,'L9,999,999.99') --대문자 L 붙이면 통화기호
 , TO_CHAR(12,'0009')  --0012 빈자리는 0으로 채움
FROM dual;

--
SELECT ename, TO_CHAR(  sal+NVL(comm,0) , 'L9,999') pay
FROM emp;

SELECT name, TO_CHAR( basicpay + sudang, 'L9,999,999') pay
FROM insa;

--EMP 테이블에서 각 사원의 입사일짜를 기준으로 10년5개월20일째 되는 날은?

SELECT ename, hiredate
        ,ADD_MONTHS( hiredate + 20, 10*12 + 5) 
FROM emp;

--문자열 '2021년 12월 23일' 문자열을 날짜형으로 변환
ORA-01821: date format not recognized
SELECT TO_DATE( '2021년 12월 23일', 'YYYY"년" MM"월 "DD"일"')
FROM dual;

--INSA 테이블에서 SSN 주민번호를 통해서 생일 가져오기 + 오늘기준으로 생일 지났다면 -1, 오늘이면 0, 안지났으면 1
SELECT name, ssn
         ,TO_CHAR( TO_DATE( SUBSTR(ssn,3,4) ,'MMDD' ),'YY/MM/DD HH24:MI:SS' ) BIRTHDAY   --년도가 현재시스템 년도로 들어감 2022
         , TO_CHAR ( TRUNC(SYSDATE) , 'YY/MM/DD HH24:MI:SS')
         , SIGN( TO_DATE( SUBSTR(ssn,3,4) ,'MMDD'  )- TRUNC(SYSDATE) )
FROM insa;

-- COALESCE() 값을 순차적으로 체크해서 NULL 이 아닌 값을 반환하는 함수

[형식]
 COALESCE( expr[,expr,expr,expr,..])
 
SELECT ename, sal, comm
       , sal + NVL(comm,0) pay
       , sal + NVL2(comm, comm, 0) pay
       , sal + COALESCE(comm,0)
       , COALESCE (sal+comm, sal,0) pay
       ,COALESCE ( sal, commpay)
FROM emp;

--*****DECODE() 함수 **
--1. 프로그램 언어(자바)의 IF 문
--   3. IF( == 조건식) 같다(=) 비교연산자 만 사용 가능 
--2. FROM 절에서는 사용 불가 **
--4. DECODE() 함수의 확장함수가 CASE() 함수. 
--5. PL/SQL에서 사용할 목적으로 만든 오라클 함수.
-- 자바 
int x = 10;
if( x= 11) {
  return c;
}
--> DECODE(x,11,c);  --  x=11이면 c리턴


if(x = 10) {
  return a;
}else { 
  return b;
}
--> DECODE(x,10,a,b); --  x=10이면 a리턴 아니면 b리턴


if(x = 1) {
   return a;
}else if (x= 10) {
  return b;
} else if (x= 15) {
  return c;
} else {
    return d;  
}
--> DECODE(x,1,a,10,b,15,c,d);

--문제 )insa 테이블에서 ssn 주민등록번호 생일 얻어와서
      생일 지났으면 (지남) , 오늘이면 (오늘임) , 안지났으면 (안지남)
SELECT name, ssn
      ,SIGN( TRUNC( SYSDATE ) -  TO_DATE( SUBSTR(ssn,3,4) ,'MMDD')  )
       -- -1 생일전, 1생일후 0오늘생일
    ,DECODE( SIGN( TRUNC( SYSDATE ) -  TO_DATE( SUBSTR(ssn,3,4) ,'MMDD'))
       ,-1,'생일전',1,'생일후','오늘생일')
FROM insa;

--문제 )insa 테이블에서 ssn 주민등록번호 가지고 성별출력
SELECT name, ssn
      ,MOD( SUBSTR(ssn,8,1),2)
      ,DECODE( MOD( SUBSTR(ssn,8,1),2),1,'남자','여자')
FROM insa;

-- (+) 남자사원수 여자사원수 구하면?
--방법1
SELECT '남자사원수' "성별", COUNT(*) "사원수"
FROM insa
WHERE  MOD ( SUBSTR( ssn, -7,1),2)=1
UNION
SELECT '여자사원수', COUNT(*) 
FROM insa
WHERE MOD ( SUBSTR( ssn, -7,1),2)=0
UNION
SELECT '총사원수', COUNT(*) 
FROM insa ;

--방법2
SELECT COUNT(*) 총사원수
        , COUNT(DECODE( MOD( SUBSTR(ssn,8,1),2),1,'남자')) 남자사원수
        , COUNT(DECODE( MOD( SUBSTR(ssn,8,1),2),0,'여자')) 여자사원수
FROM insa ;

--
SELECT ssn
        ,  MOD( SUBSTR(ssn,8,1),2) gender
FROM insa;

--문제  emp테이블에서 총사원수, 10번부서 사원 수...~ 30번부서 사원수

SELECT COUNT(*)
        ,COUNT(DECODE( deptno,10,'10번부서')) "10번부서"
        ,COUNT(DECODE( deptno,20,'20번부서')) "20번부서"
        ,COUNT(DECODE( deptno,30,'30번부서')) "30번부서"
FROM emp;

--EMP 테이블에서 각 부서별 급여합 조회
SELECT SUM( sal+ NVL(comm,0)) total_pay
FROM emp
WHERE deptno =10;

SELECT SUM ( DECODE( deptno,10,sal +NVL(comm,0)) ) PAY_10
      ,SUM ( DECODE( deptno,20,sal +NVL(comm,0)) ) PAY_20
      ,SUM ( DECODE( deptno,30,sal +NVL(comm,0)) ) PAY_30
      ,SUM ( sal +NVL(comm,0))  TOTALPAY
FROM emp;

문제 )EMP 에서 각 사원들의 번호, 이름, 급여 출력, 
    10번 부서원이라면 15% 인상
    20번 부서원이라면 5% 인상
    나머지부서원은  10% 인상
    
SELECT empno,deptno, ename, sal+NVL(comm,0) pay
       ,DECODE( deptno, 10,'15%',20,'5%','10%')||'인상'  "인상율"
       , DECODE( deptno,10, (sal+NVL(comm,0))*1.15
                        ,20,(sal+NVL(comm,0))*1.05
                        ,(sal+NVL(comm,0))*1.1)  "인상금액"        
FROM emp;

문제) insa 테이블에서 각 사원이 소속된 부서의 갯수는 몇개?

SELECT COUNT (DISTINCT buseo)
FROM insa;

--CASE 함수
--같다 = 비교연산자만 사용할 수 있다
-- 산술, 비교, 관계 다양한 연산자를 사용할 수 있도록 확장됨
【형식】
	CASE 컬럼명|표현식 WHEN 조건1 THEN 결과1
			  [WHEN 조건2 THEN 결과2
                                ......
			   WHEN 조건n THEN 결과n
			  ELSE 결과4]
	END 별칭

문제 )EMP 에서 각 사원들의 번호, 이름, 급여 출력, 
    10번 부서원이라면 15% 인상
    20번 부서원이라면 5% 인상
    나머지부서원은  10% 인상
    
    SELECT deptno, empno, ename, sal+NVL(comm,0) pay
          ,CASE deptno
                 WHEN 10 THEN  (sal+NVL(comm,0))*1.15
                 WHEN 20 THEN  (sal+NVL(comm,0))*1.05
                 ELSE          (sal+NVL(comm,0)) *1.1
           END pay2
    FROM emp
    ORDER BY deptno ASC;
문제 )insa 테이블에서 ssn 주민등록번호 가지고 성별출력 case

SELECT name, ssn
    ,CASE MOD( SUBSTR(ssn, 8,1),2)
      WHEN 1 THEN '남자'
      ELSE '여자'
      END gender
    , CASE 
      WHEN MOD( SUBSTR(ssn, 8,1),2)=1 THEN '남자'
      ELSE '여자'
      END gender
    , CASE 
      WHEN SUBSTR(ssn, 8,1) IN (1,3,5,7,9) THEN '남자'
      ELSE '여자'
      END gender
FROM insa;

문제) SELECT 문 7개의 절 GROUP BY 
WITH
  SELECT
FROM
WHERE 
GROUP BY
HAVING
  ORDER BY
----------------------------
--인사테이블에서 남자/여자 사원수 출력

SELECT COUNT (DECODE ( MOD( SUBSTR(ssn, 8,1),2),1 ,'남자')) 남자사원수
     ,COUNT (DECODE ( MOD( SUBSTR(ssn, 8,1),2),0 ,'여자')) 여자사원수
FROM insa;

--GROUP BY 절 사용해서 수정

SELECT MOD( SUBSTR(ssn, 8,1),2), COUNT(*) "인원수"
FROM insa
GROUP BY MOD( SUBSTR(ssn, 8,1),2) ;

EMP테이블에서 각 부서의 사원수를 출력조회
--문제 ) 사원이 없는 부서는 출력/조회 불가.

SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
ORDER BY deptno;

select *
from emp;