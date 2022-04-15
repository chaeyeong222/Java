1. 오류 메시지에 대해서 설명하세요 .
 ㄱ. ORA-01438: value larger than specified precision allowed for this column 
 칼럼이 정한 값을 초과한 값
 dname varchar2(14) 14byte  '아름다운부서' 18byte
 ㄴ. ORA-00001: unique constraint (SCOTT.PK_DEPT) violated      
 INSERT deptno =30  고유키 중복
 ㄷ. ORA-00923: FROM keyword not found where expected 
 from 절 앞 뒤에 구문 잘못됨
 
 ㄹ. ORA-02292: integrity constraint (SCOTT.FK_DEPTNO) violated - child record found 자식 클래스에서 찾을 수 없음
 dept - 10,20,30,40  (pk)  부모테이블
 emp 60 부서에 사원추가   -> pk를 emp에서 참조하고 있음 자식테이블
 부모테이블의 pk를 자식테이블의 fk로 참조한다. (관계)
   -> fk 에 위배된다       
 
2. RR과  YY의 차이점에 대해서 설명하세요 .
현재시스템의 2000년도 /21세기
RR 50-99  1900년대  0-49 2000년대
YY 2000년대
yy는 시스템 날짜 기준 세기
rr은 시스템 날짜에서 50년을 기준으로 가까운 세기

3. JAVA :  5 % 2  코딩을 오라클로 나머지 구해서 출력하는 쿼리를 작성하세요.
SELECT MOD(5,2)
FROM dual;

4. dept 테이블을 사용해서 각 DML문의 형식을 적고, 쿼리 작성하고 실행하세요. 

INSERT INTO 테이블명 VALUES
UPDATE 테이블명
SET 컬럼명 =컬럼값
[WHERE = 조건절]
DELETE FROM 테이블명
[WHERE = 조건절]
 ㄱ. 새로운 부서를 추가(insert)하는 쿼리 작성 및 확인 
 DESC dept;
 
    1) (  50, QC, SEOUL )
    INSERT INTO dept ( deptno, dname, loc) VALUES (50, 'QC', 'SEOUL' );
    1 행 이(가) 삽입되었습니다.
    2) (  60, T100%, SEOUL )
    INSERT INTO dept ( deptno, dname, loc) VALUES (60, 'T100%', 'SEOUL' );
     1 행 이(가) 삽입되었습니다.
    3) (  70, T100T, BUSAN )
    INSERT INTO dept ( deptno, dname, loc) VALUES (70, 'T100T', 'BUSAN' );
     1 행 이(가) 삽입되었습니다.
 ㄴ. 60번 부서의 부서명,  지역명을 수정 
     ( 원래 부서명 뒤에 'X' 문자열 추가해서 수정, 지역명은 DAEGU 로 수정 ) 
     UPDATE dept 
     SET dname = dname || 'X',loc = 'DAEGU'
     WHERE deptno = 60;
 ㄷ. LIKE 연산자를 사용해서 부서명에 '%' 문자가 포함된 부서 정보 조회하는 쿼리 작성
 
 SELECT *
 FROM dept
 WHERE  dname LIKE '%\%%' ESCAPE '\';
 
 ㄹ. REGEXP_LIKE() 함수를 사용해서 부서명에 '%' 문자가 포함된 부서 정보 조회하는 쿼리 작성
 SELECT *
 FROM dept
 WHERE REGEXP_LIKE(dname, '%');
 
 ㅁ. 부서번호 50, 60, 70번 부서 삭제
 DELETE FROM dept
 WHERE deptno >=50;
 WHERE deptno IN (50,60,70);
 WHERE deptno BETWEEN 50 AND 70;
 
 
5. 한글 한 문자와 알파벳 한 문자가 몇 바이트인지 출력하는 쿼리 작성
SELECT VSIZE('가')
FROM dual;

SELECT VSIZE('A')
FROM dual;

6. insa 테이블에서 남자는 'X', 여자는 'O' 로 성별(gender) 출력하는 쿼리 작성

방법1)
SELECT t.*
     ,REPLACE( REPLACE(t.gender, '1','X'),'2','O') gender
FROM (--인라인 뷰
    SELECT name, ssn
          ,SUBSTR(ssn,8,1)GENDER
    FROM insa
)t;

방법2) NULL 관련된 함수  NVL2()  NUL() 
  NULLIF(?,?) 같으면 NULL 반환 다르면 앞의 값 반환

SELECT name,ssn
      , SUBSTR(ssn, -7,1) gender
      , MOD(SUBSTR(ssn,-7,1),2) gender  --0 여자,1남자
      ,NVL2( NULLIF( MOD(SUBSTR(ssn, -7,1),2) ,1),'O','X') gender
FROM insa;

WITH temp AS (
    SELECT name, ssn
          ,REPLACE ( SUBSTR(ssn,8,1), NULL)
    FROM insa
    WHERE SUBSTR(ssn,8,1) = 1
)
SELECT name, ssn
      ,NVL2(SUBSTR(ssn,8,1),'x','o')
FROM insa;

결과값
숫자 왼쪽 정렬 -> 문자열 '1'
숫자 오른쪽 정렬 -> 숫자 1

      ,NVL(REPLACE(SUBSTR(ssn,8,1),1,null)
FROM insa

    NAME                 SSN            GENDER
    -------------------- -------------- ------
    홍길동               771212-1022432    X
    이순신               801007-1544236    X
    이순애               770922-2312547    O
    김정훈               790304-1788896    X
    한석봉               811112-1566789    X

7. insa 테이블에서 2000년 이후 입사자 정보 조회하는 쿼리 작성
SELECT name, ibsadate
FROM insa
WHERE TO_CHAR(ibsadate,'YYYY')>=2000     --'2000' >=2000
WHERE ibsadate >='2000.01.01'
WHERE EXTRACT(YEAR FROM ibsadate) >=2000 ;

    NAME                 IBSADATE
    -------------------- --------
    이미성               00/04/07
    심심해               00/05/05
    권영미               00/06/04
    유관순               00/07/07
    
8-1. Oracle의 날짜를 나타내는 자료형 2가지를 적으세요.
   ㄱ. DATE
   ㄴ. TIMESTAMP
   
8-2. 현재 시스템의 날짜/시간 정보를 출력하는 쿼리를 작성하세요.

--SYSDATE 함수 : 현재 시스템의 날짜, 시간 분 초 반환
--CURRENT _DATE : 현재 SESSION의 날짜 정보를 일/월/년 24시:분:초 형식으로 반환
--         반환되는 DATE 데이터타입은 GREGORIAN CALENDAR이다
--CURRENT_TIMESTAMP : 

--오라클 - 인스턴스 : DB 서버 시작시점 부터 서버 종료 시점까지
--오라클 - 세션 : 현재 사용자가 로그인 한 순간부터 로그아웃 한 순간까지

SELECT SYSDATE, CURRENT_DATE, CURRENT_TIMESTAMP
FROM dual;

22/04/08   ,  22/04/08   ,22/04/08 10:50:05.000000000 ASIA/SEOUL
9. HR 계정으로 접속해서 
   SELECT * FROM scott.dept;
   위의 쿼리를 실행하면 ORA-00942: table or view does not exist 오류가 발생한다.
   그래서
   HR 계정에서도 scott.dept 테이블을 SELECT할 수 있도록 권한부여 및 arirang 이란 이름으로 
   시노님( SYNONYM )을 생성해서
   HR 계정에서도 SELECT * FROM arirang 쿼리를 사용할 수 있도록 설정하고 테스트하는 
   모든 쿼리를 순서대로 작성하세요. 
   
  1) sys계정 접속해서
   CREATE PUBLIC SYNONYM arirang
   FOR scott.dept;
  2)
   scott 계정 접속해서
   GRANT SELECT ON dept TO HR;
  3) 
   hr계정 접속해서
   SELECT *
   FROM arirang;
   
   
   
10. emp 테이블에서 사원명(ename)에 'e'문자를 포함한 사원을 검색해서 아래와 같이 출력.

SELECT ename, REPLACE(ename, 'E','[E]') SEARCH_ENAME
FROM emp
WHERE ename LIKE UPPER('%e%');

SELECT ename
        ,REPLACE( ename, UPPER( :input ), '['|| UPPER(:input) || ']'  )SEARCH_NAME
FROM emp
WHERE REGEXP_LIKE(ename, :input, 'i');


   : 변수명 
   ㄱ. 바인드변수 bind variable
   ㄴ. 세션 session 이 유지되는 동안 사용 가능한 변수
   
    ENAME   SEARCH_ENAME
    --------------------
    ALLEN	ALL[E]N
    JONES	JON[E]S
    BLAKE	BLAK[E]
    TURNER	TURN[E]R
    JAMES	JAM[E]S
    MILLER	MILL[E]R

11.   UPDATE 문에 WHERE 조건절이 없는 경우는 어떻게 되나 ?  오류..?
11-2. DELETE 문에 WHERE 조건절이 없는 경우는 어떻게 되나 ? 전부삭제

12. DML( INSERT, UPDATE, DELETE ) 문 실행 후 반드시 무엇을 해 주어야 하나 ? 
commit 또는 rollback

13. insa 테이블에서 
   ㄱ. 출신지역(city)가 인천인 사원의 정보(name,city,buseo)를 조회하고
   ㄴ. 부서(buseo)가 개발부인 사원의 정보(name,city,buseo)를 조회해서
   두 결과물의 합집합(UNION)을 출력하는 쿼리를 작성하세요. 
   ( 조건 : SET(집합) 연산자 사용 )
   SELECT name, city, buseo
   FROM insa
   WHERE city = '인천'
   UNION
   SELECT name, city, buseo
   FROM insa
   WHERE buseo = '개발부';
   
   
   3 [6] 8 ==17명
   ----------------
   SELECT name, city, buseo
   FROM insa
   WHERE city = '인천'
   UNION ALL
   SELECT name, city, buseo
   FROM insa
   WHERE buseo = '개발부';

인천    인천 &개발    개발부    
3            6        8      U 17명
                            UA 23명
 UA -> 중복되더라도 두번 출력하겠다(차이점)
 
--------------
SELECT ename, sal   --,comm 칼럼 수 다르면 오류남 / 타입 달라도 오류   
FROM emp
UNION
SELECT name, basicpay
FROM insa;
----------------
  SELECT name, city, buseo
   FROM insa
   WHERE city = '인천'
   MINUS
   SELECT name, city, buseo
   FROM insa
   WHERE buseo = '개발부';

--차집합
--김신제	인천	기획부
--전용재	인천	영업부
--최석규	인천	홍보부

SELECT name, city, buseo
FROM insa
WHERE city = '인천' AND buseo != '개발부';

---------
SELECT name, city, buseo
FROM insa
WHERE city = '인천'
INTERSECT
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';
--교집합
SELECT name, city, buseo
FROM insa
WHERE city = '인천' AND buseo = '개발부';
---------
IS NAN
IS INFINITE
IS NULL --널이니?
-------------
--오라클 함수
1. 복잡한 쿼리문 -> 간단히 처리 (조작) -> 결과 반환
2. 함수의 기능
   ㄱ. 데이터 계산     루트 4=2  -> sqrt(4)
   ㄴ. 데이터 변경     UPPER('abc')
   ㄷ. 그룹의 결과를 출력     그룹함수 그룹함수(group function) = 집계함수 COUNT()
   ㄹ. 날짜 형식을 변경 TO_CHAR()
   ㅁ. 컬럼 데이터 타입 변경
       날짜형 -> 문자열, 문자열-> 날짜형 변경
       문자열 <-> 숫자형
   
   문제) insa 테이블에서 총 사원수 몇명?
SELECT COUNT(*) 총사원수
FROM insa;
    영업부 몇명?
SELECT COUNT(*) 총사원수
FROM insa
WHERE buseo; 

------------

문제)emp 테이블 에서 각 부서별 사원 수와 총 사원수를 파악
  10번 부서 : 3명
  20번 부서 : 4명 ...
    총 사원수 : 12명
    
SELECT COUNT(*)
FROM emp
WHERE deptno = 10
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno = 20
UNION ALL
SELECT COUNT(*)
FROM emp
WHERE deptno = 30
UNION ALL
SELECT COUNT(*)
FROM emp;
-------------
함수의 유형

ㄱ. 단일행 함수
SELECT ename, UPPER(ename), LOWER(ename)
FROM emp;
ㄴ. 복수행 함수 = 그룹함수

SELECT COUNT(*)
FROM emp;

4. 단일행 함수중에 '숫자함수'
SELECT SQRT(4)  --제곱근, 루트
         --,SIN(),COS(),TAN()
         ,LOG()
         ,LN() --자연로그값
         ,POWER(2,3) ---누승, 제곱
         ,MOD(5,2)-- 나머지
         ,ABS(100), ABS(-100) --절대값
FROM dual;
   ㄱ. ROUND(NUMBER  [, 위치]) : 특정 위치에서 반올림  
     -- 형식 ROUND( n [,INTEGER])
     ROUND(a,b)는 a를 소수점 이하 b+1 자리에서 반올림하여 b까지 출력한다
     b가 없으면(b=0) 소수점 첫번째 자리에서 반올림,
     b값이 음수이면 소수점 왼쪽 b자리에서 반올림한다
     
 SELECT 3.141592 PI
      ,ROUND(3.141592 )  --3
      ,ROUND(3.641592)  --4
      ,ROUND(3.141592, 2)  --  3.14  b=2   +1  -> 소수점 3번째 자리에서 반올림
      ,ROUND(123.141592, -2 ) --10의자리에서 반올림  -> 100 
 FROM dual;
 
 ㄴ. 문제 emp 테이블의 pay(sal+comm) 총급여합(27125)/총사원수(12) => 평균급여값
    조건) 소수점3자리에서 반올림
 SELECT *
 FROM emp;

SELECT COUNT(*) total_number
FROM emp;

-- SUM() 집계함수=그룹함수
SELECT SUM (sal + NVL(comm,0)) total_pay
FROM emp;

--2260.416666666666666666666666666666666667 
--2260.42
SELECT ROUND( (SELECT SUM (sal + NVL(comm,0)) FROM emp)/(SELECT COUNT(*) FROM emp),2) AVG_PAY
FROM dual;
 
 SELECT SUM(sal+NVL(comm, 0))
       ,COUNT(*)
       ,SUM((sal+NVL(comm, 0))/COUNT(*)
 FROM emp;
 
 SELECT count(*), sal+NVL(comm,0) as pay, ROUND((count(*)+ pay)/2),1)
 FROM emp;


FROM emp;

  ㄴ. TRUNC(n,m)  절삭 함수(내림) + 절삭할 특정위치    -> 정수값, 실수
      FLOOR()  절삭 함수(내림)  + 무조건 소수 첫째자리  -> 정수값
      
      TRUNC(n) == FLOOR(n) == TRUNC(n,0)

SELECT 123.141592
        ,FLOOR(123.141592) -- 123 소수점 첫번째 자리에서 절삭
         ,FLOOR(123.941592) -- 123 소수점 첫번째 자리에서 절삭
         ,TRUNC(123.141592)
         ,TRUNC(123.941592,0)
         ,TRUNC(123.941592,1)  -- 123.9 소수점 두번재 자리에서 절삭
         ,TRUNC(123.941592,-1)  -- 120 일의자리에서 절삭
FROM dual;

ㄷ. CEIL()  소수점 첫번째 자리에서 올림하는 함수, 특정위치에서 올림X

SELECT CEIL(3.141592)  --4
      ,CEIL(3.941592)  --4
FROM dual;

    -ROUND(), CEIL(), FLOOR(), TRUNC()

문제) 게시판에서 
    총 게시글 수가 ; 652
    한 페이지에 출력할 게시글 수 : 15
    총 페이지 수?
    
SELECT CEIL(652/15)
FROM dual;

문제) 소수점 3자리에서 올림 , 10의 자리에서 절상
SELECT 1234.5678
      ,CEIL(1234.5678*100)/100
      ,CEIL(1234.5678/100)*100
FROM dual;

  ㄹ. SIGN(n)  숫자 값에 따라 양수라면 1,0이라면 0, 음수라면 -1 반환하는 함수
  
SELECT SIGN(100), SIGN(0), SIGN(-100)
from dual;

문제) emp테이블에 평균 급여보다 많이 받으면 1 적게받으면 -1 같으면 0출력 되도록 하기

SELECT ename, sal+NVL(comm,0)pay
       ,ROUND( AVG(sal+NVL(comm,0)),2) avg_pay
FROM emp;
--ORA-00937: not a single-group group function
-- 오류 단일그룹, 그룹함수 아님.
-- 복수함수와 일반칼럼은 함께 사용할 수 없다. ***

SELECT t.*
     , ABS( t.pay-t.avg_pay)
    ,NVL2(NULLIF( SIGN(t.pay - t.avg_pay),1),'적다','많다')
FROM (SELECT ename, sal+NVL(comm,0)pay
       ,(SELECT ROUND( AVG(sal+NVL(comm,0)),2) FROM emp) avg_pay
       FROM emp
      )t;

SELECT SUM(sal+NVL(comm,0))pay
       ,ROUND( AVG(sal+NVL(comm,0)),2) avg_pay
FROM emp;

SELECT AVG(sal+NVL(comm,0))
      ,ROUND( AVG(sal+NVL(comm,0)),2) avg_pay
FROM emp;
  
--------문자함수

SELECT 'Kbs'
      , UPPER('Kbs') --'KBS'
      , LOWER('Kbs') --'kbs'
      ,INITCAP('kbs')--'Kbs'
FROM dual;

SELECT job
    ,LENGTH(job) --문자열 길이를 가져오는 함수
    ,CONCAT (empno, ename)
FROM emp;

--INSTR  (string, substring [,position [ ,occurence]])
SELECT ename
          , INSTR(ename, 'I') --찾는 문자열 있는 위치
FROM emp;

SELECT
    INSTR('corporate floor','or')  --2
    ,INSTR('corporate floor','or',3)--5
    ,INSTR('corporate floor','or',3,2)--14
    ,INSTR('corporate floor','or',-3,2) --뒤에서 3번째부터 찾아라
FROM dual;

  문제) 전화번호 테이블
       테이블 명 TBL_TEL
       번호(순번) NUMBER
       전화번호   02)123-1234
                054)7223-2323
                031)9837-8933
 -- CREATE TABLE 테이블명              

SELECT *
FROM tbl_tel;

문제) 오라클 숫자, 문자 함수 사용해서
   번호,  전화번호의 지역번호만 출력, 중간 번호만 출력, 마지막 번호만 출력
   
   --지역번호 출력 위해 ) 의 위치 먼저 찾음
SELECT no ,tel
      ,INSTR(tel, ')')       ")위치"
      ,INSTR(tel, '-',-1)    "-위치"
      ,SUBSTR(tel, 0, INSTR(tel, ')')-1)
      ,SUBSTR(tel,INSTR(tel, ')')+1,    INSTR(tel, '-')-1  -INSTR(tel, ')'))
      ,SUBSTR(tel, INSTR(tel, '-')+1)
FROM tbl_tel;

----- RPAD, LPAD
[형식]
   RPAD(expr1, n[,expr2])
   
-- ORA-01722: invalid number    () 넣어서 먼저 처리되게끔 하면 오류 해결
SELECT ename, sal+NVL(comm,0) pay
          ,LPAD ('원' || (sal+NVL(comm,0)) ,10,'*') -- 10자리 확보하고 금액 찍음,남는자리에 *-
          ,RPAD (sal+NVL(comm,0) ,10,'*')
FROM emp;

문제) PAY 10자리에서 반올림하고 100으로 나눠서 나온 수 만큼 # 찍음.
SELECT ename, sal+NVL(comm,0) pay
      ,ROUND( (sal+NVL(comm,0))/100)  "#개수"
      ,RPAD(' ',ROUND( (sal+NVL(comm,0))/100)+1,'#')
FROM emp;

SMITH	800      ########
ALLEN	1900     ## (19개)
WARD	1750     ##(18개 - 반올림)
JONES	2975
MARTIN	2650
BLAKE	2850
CLARK	2450
KING	5000
TURNER	1500
JAMES	950
FORD	3000
MILLER	1300

문제) RPAD 이용해서 주민번호 뒷자리 * 표시
SELECT name, ssn
      , RPAD( SUBSTR(ssn,0,8) , 14, '*')
FROM insa;

--ASCII(char)   오라클 문자 자료형 : char

SELECT ename
      ,SUBSTR(ename, 0 ,1)
      ,ASCII( SUBSTR(ename, 0 ,1))
      , ASCII('가')  --3바이트
      ,CHR(65)   --문자코드값을 다시 문자로
      , CHR(15380608)
FROM emp;

------------- 
GREATEST(?,?,?)
LEAST(?,?,?)
 -- 비교할 개수 무관

SELECT
    GREATEST(500,10,200)
    ,LEAST(500,10,200)
    ,GREATEST('KBS','ABC','XYZ')
    ,LEAST('KBS','ABC','XYZ')
FROM dual;

-------날짜 함수
SELECT SYSDATE    -- 현재 시스템 
       ,CURRENT_DATE   --현재 세션
       ,CURRENT_TIMESTAMP
FROM dual;

  TRUNC(date) 날짜 내림 특정위치
   ROUND(date) 날짜 반올림 특정위치

--숫자 함수
   TRUNC(number) 내림 특정위치
   ROUND(number) 반올림 특정위치
   
   --,ROUND(date [,format]) formate 없으면 정오기준, 있으면 format기준
SELECT SYSDATE  --22/04/08
    ,ROUND(SYSDATE) --22/04/09 / 정오를 기준으로 날짜를 반올림하여 리턴한다.
    ,ROUND(SYSDATE,'DD') --15일 기준
    ,ROUND(SYSDATE,'MM')   --개월 기준
    ,ROUND(SYSDATE,'YY')
    ,ROUND(SYSDATE,'DAY')
FROM dual;

--TRUNC(date) 자주 사용
SELECT CURRENT_TIMESTAMP
    ,TRUNC( CURRENT_TIMESTAMP)
    ,SYSDATE
    ,TRUNC(SYSDATE)
FROM dual;
--어디에 씀?
-- 설문조사, 투표  22.3.1.9시~ 22.4.8.정오  ->시간체크


--날짜형 + 숫자  = 날짜형
--날짜형 - 숫자  = 날짜형
--날짜형 - 날짜  = 일 수( 숫자)
--날짜형 + 숫자/24 (시간)  = 날짜형

SELECT SYSDATE   --22/04/08
      ,SYSDATE +3  --22/04/11
      ,SYSDATE -3 --22/04/05
      
FROM dual;

--문제) EMP테이블에서 사원들의 근무일수 조회

SELECT ename, hiredate  --DATE 날짜 자료형
      ,SYSDATE  --DATE 날짜 자료형
      ,CEIL(ABS(hiredate-SYSDATE)) "근무일수"
  --지금부터 2시간 후에 만나자
      ,TO_CHAR(SYSDATE + 2/24
      ,'YYYY/MM/DD HH:MI:SS')
FROM emp;
