
--문제 ) emp 테이블에서 comm 이 null 인 모든 사원 정보를 출력하는 쿼리 하세요
SELECT *
FROM emp
WHERE comm IS NULL;
-------------------------------------------------
--1. 용어정리
--  ㄱ. Data        정보
--  ㄴ. DataBase  정보의 집합
--  ㄷ. DBMS      데이터베이스 관리 시스템, 소프트웨어   오라클
             DBMS 중에 하나 오라클, MySQL, MS SQL
--  ㄹ. DBA         데이터베이스 관리자    (SYS),  SYSTEM,
                                      계정생성,,
                                      SCOTT -> scott.sql 검색-> emp, dept, salgrade, bonus 테이블 생성
                                    GRANT 권한 to user
--  ㅁ. 롤(ROLE)   ?
        권한 부여, 제거..
          [제거할 때]
            REVOKE 롤이름
	        FROM 사용자명 또는 롤이름 또는 PUBLIC;
            
            다수 사용자 <= 부여, 제거.... => 다양한 권한privilege  효율적 관리(권한 부여, 제거)
            신입사원역할(role)에 권한 50개 부여
            CREATE USER  계정명 
            ALTER USER 계정명 IDENTIFIED BY NEW비밀번호 
                                         ACCOUNT UNLOCK;
             DROP USER CASCADE;
            
            
            CREATE TABLE 테이블명
            DROP TABLE
            
            CREATE ROLE  롤명
            DROP ROLE
            a에게 신입사원역할을 부여하면 권한 50개 부여됨.
            GRANT 
            
           1. 롤 생성 ⇒ 2. 롤에 권한 부여 ⇒ 3. 사용자에게 롤 부여

   select * 
   from role_sys_privs
   where role='RESOURCE';
 
-- 롤 안에 있는 권한들을 확인할 때,
CREATE SEQUENCE
CREATE TRIGGER
CREATE CLUSTER
CREATE PROCEDURE
CREATE TYPE
CREATE OPERATOR
CREATE TABLE
CREATE INDEXTYPE

   문제 1) SCOTT 계정이 소유하고 있는 롤을 확인하고
       2) CREATE 롤 제거
       3) CREATE 롤 부여

   
   1)
   SELECT * 
   FROM user_role_privs;   -- 사용자에게 부여된 시스템 권한?
   
SCOTT	CONNECT	NO	YES	NO
SCOTT	RESOURCE	NO	YES	NO

   FROM role _sys_privs;   --롤에 부여된 시스템 권한?
   2)
   REVOKE CONNECT FROM scott;
   3)
   GRANT CONNECT TO scott;
 -- 2,3은 sys 에서 실행해야한다.  
 -- + admin 옵션은 생성, 제거할 수 있는 역할
            
--  ㅂ. SID( 전역 데이터베이스 이름 ) XE => 네트워크를 통해 사용자가 오라클 서버와의 연결을 담당하는 관리프로그램
--       설치된 오라클 DB의 고유한 이름
--       오라클 무료 버전을 설치하면 자동으로 SID => XE
                    
--  ㅅ. 데이터 모델  
--         컴퓨터에 데이터를 저장하는 방식을 정의해놓은 개념 모델
--         관계형 데이터 모델
--  ㅇ. 스키마(Schema)     -> 계정만들면 그 계정이 사용할 수 있는 객체들이 만들어지는 데, 그것을 스키마라 한다.
         ㄱ. DB에서 어떤 목적을 위하여 필요한 여러 개로 구성된 테이블들의 집합을
         ㄴ. DATABASE SCHEMA (db 스키마)
             - scott 계정 생성 -> 모든 object 생성모음 -> 스키마
             - 특정 user와 관련된 object의 모듬
               - emp 테이블 생성
                 FROM 스키마.테이블
                 FROM scott.emp;
                 
        ㄷ. 용어정리
           인스턴스instance : 오라클 서버 -> 시작 startup -> 종료 shutdown
           세션 session  : 사용자 로그인 -> 로그아웃
           스키마 schema : 특정 user와 관련된 object의 모듬
--  ㅈ. R+DBMS          관계형 데이터베이스

--2. 설치된 [오라클을 삭제]하는 절차를 [검색]해서 상세히 적으세요.  ***
  ㄱ. 작업관리자 - 서비스 탭에서 Oracle 붙어져있는 서비스 들 중 실행중인것은 모두 우클릭 - 중지    
  ㄴ. uninstall.exe  / 프로그램 추가 및 삭제 -> 제거
  ㄷ. 탐색기 - 오라클 폴더 (oraclxe) 삭제
  ㄹ. 레지스트리편집기 regedit.exe -> 오라클 관련 레지스트리 삭제

--3. SYS 계정으로 접속하여 모든 사용자 정보를 조회하는 쿼리(SQL)을 작성하세요.
SELECT *
FROM dba_tables; --SCOTT이 사용 불가, SYS 에서만 가능
FROM all_tables ; -- SCOTT 계정이 소유하고 있는 테이블 + 권한을 부여받아서 사용할 수 있는 테이블 정보

FROM user_tables; -- SCOTT 계정이 소유하고 있는 테이블 정보 VIEW
FROM all_users; 
FROM dba_users;  
FROM user_users;


--4. SCOTT 계정 + 소유 객체(테이블)  를 삭제하는  쿼리(SQL)을 작성하세요.  
    ㄱ. 계정 생성             CREATE USER scott IDENTIFIED 비밀번호;
    ㄴ. 계정 수정              ALTER USER scott IDENTIFIED BY 비밀번호;
    ㄷ. 계정 삭제            DROP USER scott CASCADE;

--5. 위의 4번에 의해서
--    SCOTT 계정이 삭제되었으면 SCOTT 계정을 tiger 비밀번호로 생성하는 쿼리(SQL)을 작성하세요. 
         CREATE USER scott IDENTIFIED tiger; 

--6. 오라클이 제공하는 기본적인 롤(role)의 종류를 적으시고,
     
--6-2.   SCOTT 계정에게 권한을 부여하는 쿼리(SQL)을 작성하세요. 
  GRANT CONNECT, RESOURCE, UNILMITED TABLESPACE TO scott ;

--7-1. SCOTT 계정에게  scott.sql 파일을 찾아서 emp, dept, bonus, salgrade 테이블을 생성 및 데이터 추가한 과정을 작성하세요.
CREATE TABLE DEPT
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	DNAME VARCHAR2(14) ,
	LOC VARCHAR2(13) ) ;
DROP TABLE EMP;
CREATE TABLE EMP
       (EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MGR NUMBER(4),
	HIREDATE DATE,
	SAL NUMBER(7,2),
	COMM NUMBER(7,2),
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT);
INSERT INTO DEPT VALUES
	(10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES
	(30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES
	(40,'OPERATIONS','BOSTON');
INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-JUL-87')-85,3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-JUL-87')-51,1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);
DROP TABLE BONUS;
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10)	,
	JOB VARCHAR2(9)  ,
	SAL NUMBER,
	COMM NUMBER
	) ;
DROP TABLE SALGRADE;
CREATE TABLE SALGRADE
      ( GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER );
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;

--7-2. 각 테이블에 어떤 정보를 저장하는지 컬럼에 대해 정보( 컬럼명, 자료형 )를 설명하세요.
--  ㄱ. emp      EMPNO, 문자열/ JOB,문자열 / MGR,숫자형/HIREDATE ,날짜/SAL,숫자형/COMM,숫자형/DEPTNO, 숫자형
--  ㄴ. dept      부서번호,2자리숫자자료형 / 부서명,14바이트크기 문자열 자료형/ 지역명, 13바이트 문자열자료형
--  ㄷ. bonus     ENAME, 10바이트 문자열 자료형/ JOB, 9바이트문자열자료형/SAL 숫자형/COMM 숫자형 
--  ㄹ. salgrade   등급,숫자형/ LOSAL, 숫자형/ HISAL, 숫자형

DESC emp;

--8. SCOTT 계정이 소유하고 잇는 모든 테이블을 조회하는 쿼리(SQL)을 작성하세요.
SELECT *
FROM user_users;



--9. SQL*Plus 를 사용하여 SYS로 접속하여 접속한 사용자 확인하고, 모든 사용자 정보를 조회하고
--   종료하는 명령문을 작성하세요.  
-- 어떻게 로그인 하는지 뜸
 --   sqlplus /?


--10. 관계형 데이터 모델의 핵심 구성 요소
   ㄱ.  개체 (테이블)
   ㄴ.  속성 (컬럼)
   ㄷ.  관계 

--11. Oracle SQL Developer 에서 쿼리(SQL)을 실행하는 방법을 모두 적으세요.
 /*
   ㄱ.  커서를 두고 ctrl + enter
   ㄴ.  실행하고자 하는 코딩 드래그 한 후 ctrl + enter
   ㄷ. 블럭잡고 f5
*/
--12. 오라클 주석처리 방법  3가지를 적으세요.
  /*
    ㄱ. --
    ㄴ. rem
*/
--13. 자료 사전( Data [Dictionary] ) 이란? 
  메타데이터(META DATA) == DATA Dictionary 의 정보
   ㄱ. Data Dictionary = 테이블 + 뷰view 의 집합
   ㄴ. 데이터베이스의 정보를 제공하는 역할 
      ex. scott 소유하고 있는 테이블 정보
       FROM user_users; //Data Dictionary 뷰
    ㄷ. DB 생성시 sys 계정 생성 -> SYS 스키마 생성 내부에 자료 사전 생성
    
    
    FROM user_tables; // 자료사전 = 뷰 정보
      dba_
      all_
      user_
      v$   DB의 성능분석/ 통계 정보 제공하는 뷰
--14. SQL 이란 ?

     서버 <-> 클라이언트   
        사용 언어 -> 구조화 된 질의 언어

--15. SQL의 종류에 대해 상세히 적으세요.
    ㄱ.  데이터 검색 DQL  ->   SELECT
    ㄴ.  데이터 정의 DDL -> CREATE, ALTER, DROP
    ㄷ.  데이터 조작 DML -> INSERT, UPDATE, DELETE  + 반드시 commit, rollback
    ㄹ.  권한부여, 제거 DCL -> GRANT, REVOKE
    ㅁ.  트랜젝션 처리 TCL -> COMMIT, ROLLBACK, SAVEPOINT

--16. select 문의 7 개의 절과 처리 순서에 대해서 적으세요.

WITH         1
SELECT    6   
FROM  2
WHERE   3
GROUP BY  4
HAVING    5
ORDER BY  7

--17. emp 테이블의 테이블 구조(컬럼정보)를 확인하는  쿼리를 작성하세요.

DESC emp;
   
--18. employees 테이블에서  아래와 같이 출력되도록 쿼리 작성하세요. 

SELECT FIRST_NAME, LAST_NAME, concat(FIRST_NAME, LAST_NAME) AS NAME
FROM employees;
   
FIRST_NAME          LAST_NAME                   NAME                                           
-------------------- ------------------------- ---------------------------------------------- 
Samuel               McCain                    Samuel McCain                                  
Allan                McEwen                    Allan McEwen                                   
Irene                Mikkilineni               Irene Mikkilineni                              
Kevin                Mourgos                   Kevin Mourgos                                  
Julia                Nayer                     Julia Nayer     

--19. 아래 뷰(View)에 대한 설명을 적으세요.
--  ㄱ. dba_tables                
--  ㄴ. all_tables                
--  ㄷ. user_tables  == tabs     

--20. HR 계정의 생성 시기와 [잠금상태]를 확인하는 쿼리를 작성하세요.

SELECT username, account_status 
FROM dba_users    -- SYS 가서 사용
WHERE username = 'HR' ;   -> 검색할 때 대소문자 구분함
FROM all_users;  -- HR 43   14/05/29
 
--21. emp 테이블에서 잡,  사원번호, 이름, 입사일자를 조회하는 쿼리를 작성하세요.

SELECT job, empno, ename, hiredate
FROM emp;

--22.  emp 테이블에서  아래와 같은 조회 결과가 나오도록 쿼리를 작성하세요.
    (  sal + comm = pay  )
SELECT EMPNO, ENAME, SAL,
            -- NVL( COMM,0), sal+nvl(comm,0) pay
            NVL(COMM,COMM,0) COMM, SAL+NVL2(COMM , COMM, 0)PAY
            --CONCAT(SAL, COMM) AS PAY
FROM emp
WHERE ENAME = 'MILLER';
    
     EMPNO ENAME             SAL       COMM        PAY
---------- ---------- ---------- ---------- ----------
      7369 SMITH             800          0        800
      7499 ALLEN            1600        300       1900
      7521 WARD             1250        500       1750
      7566 JONES            2975          0       2975
      7654 MARTIN           1250       1400       2650
      7698 BLAKE            2850          0       2850
      7782 CLARK            2450          0       2450
      7839 KING             5000          0       5000
      7844 TURNER           1500          0       1500
      7900 JAMES             950          0        950
      7902 FORD             3000          0       3000

     EMPNO ENAME             SAL       COMM        PAY
---------- ---------- ---------- ---------- ----------
      7934 MILLER           1300          0       1300

	12개 행이 선택되었습니다.  

--23.  emp테이블에서
--    각 부서별로 오름차순 1차 정렬하고 급여(PAY)별로 2차 내림차순 정렬해서 조회하는 쿼리를 작성하세요.   
SELECT deptno, ename, sal+ NVL(comm, 0) pay
FROM emp 
ORDER BY deptno ASC, pay DESC;
--ORDER BY deptno ASC, NVL(comm, 0)DESC;

--24. 계정을 생성하는 쿼리 형식에 대해 적으세요.
     
--25. 생성된 계정의 비밀번호 , 잠금을 해제하는 쿼리 형식에 대해서 적으세요.
 
ALTER USER 계정명 INDICATED BY 비밀번호
                                ACCOUNT UNLOCK;
  
--26. DB에 로그인할 수 있는 권한을 부여하는 쿼리 형식에 대해서 적으세요.
    
--27. 특정포트( 1521 Port )를 방화벽 해제하는 방법에 대해서 상세히 과정을 적으세요.

--28. SQL*PLUS 툴을 사용해서 
--   ㄱ. SYS로 로그인하는 방법(형식)을 적으세요   
--   ㄴ. SCOTT로 로그인하는 방법(형식)을 적으세요   

--29. SQL의 작성방법 
   
--30. 아래 에러 메시지의 의미를 적으세요.
  ㄱ. ORA-00942: table or view does not exist   --  >FROM 테이블 명 -- 오타, 접근권한X 
                                        
  ㄴ. ORA-00904: "SCOTT": invalid identifier  -- 식별자  - 없는 이름, 오타
  ㄷ. ORA-00936: missing expression           --표현식(수식) 잘못된 경우
  ㄹ. ORA-00933: SQL command not properly ended  --구문 끝이 없음 
  
  SQL? 구조화 된 질의 언어
  PL/SQL = SQL + ( 절차적 언어문법 확장)
    절차적 언어 문법
    if
    for
    제어문
    변수

   [sql 작성 방법]
   1. 대소문자를 구별X
    select *
   from emp;
   
   Select *
   From emp;
   
   SELECT *
   FROM EMP;
   
   WHERE username = 'hr';
   WHERE username = 'HR';
   
   2) sqlplus
   SQL> select
      2  *
      3  from
      4  emp
      5  ;
  
   3)  
   SELECT     empno,    ename  ,    deptno 
   FROM emp;
   
   4) 절 별로 라인 구분
   5) 키워드 대문자, 그외 문자( 테이블명, 컬럼명 등등 ) 소문자 - 권장.
   6) 탭, 공백 사용 -  권장
   

-- 31. emp 테이블에서 부서번호가 10번이고, 잡이 CLERK  인 사원의 정보를 조회하는 쿼리 작성.

SELECT *
FROM emp
WHERE dep = 10 AND job='CLERK';

-- 31-2. emp 테이블에서 잡이 CLERK 이고, 부서번호가 10번이 아닌 사원의 정보를 조회하는 쿼리 작성.

SELECT *
FROM emp
WHERE DEPTNO != 10 AND JOB='CLERK';


-- 32. 오라클의 null의 의미 와 null 처리 함수에 대해서 설명하세요 .
      ㄱ. null 의미?    아직 정의되지 않은 값
       ㄴ. null 처리 함수 2가지 종류와 형식을 적고 설명하세요 .
NVL2 (A,B,C) -> A 가 NULL이면 C로, NULL이 아니면 B로 대체된다.
NVL(  A, B) -> A가 NULL 이면 B로 대체된다


-- 33.  emp 테이블에서 부서번호가 30번이고, 커미션이 null인 사원의 정보를 조회하는 쿼리 작성.
  ( ㄱ.  deptno, ename, sal, comm,  pay 컬럼 출력,  pay= sal+comm )
  ( ㄴ. comm이 null 인 경우는 0으로 대체해서 처리 )
  ( ㄷ. pay 가 많은 순으로 정렬 )

SELECT deptno, ename, sal, comm,  sal + NVL(comm,0) pay
FROM emp
WHERE deptno = 30 AND comm is NULL ; 
ORDER BY pay DESC;

   [NOT] IN (list)
   [NOT] BETWEEN a AND b
   IS [NOT] NULL

 null
 1. 미확인된 값
 2. ''  0 다른 값
 3. null 유무 확인할때는 = 비교연산자 사용하지 않고
                    sql 연산자 중 is null, is not null 연산자 확인한다.

-- 34. insa 테이블에서 수도권 출신의 사원 정보를 모두 조회하는 쿼리 작성 ( 오름차순 정렬 )
  ㄱ. OR 연산자 사용해서 풀기 
  
SELECT *
FROM insa
WHERE city = '서울' OR city ='경기' OR city ='인천'
ORDER BY city ASC;

  ㄴ. IN ( LIST ) SQL 연산자 사용해서 풀기 
SELECT *
FROM insa
WHERE city IN ( '서울', '경기', '인천); 

  
-- 35. insa 테이블에서 수도권 출신이 아닌 사원 정보를 모두 조회하는 쿼리 작성 ( 오름차순 정렬 )
  ㄱ. AND 연산자 사용해서 풀기  
SELECT *
FROM insa
WHERE  city != '서울' AND  city != '경기'  AND city != '인천';
  ㄴ. NOT IN ( LIST ) SQL 연산자 사용해서 풀기   
SELECT *
FROM insa
WHERE city NOT IN  ('서울','인천','경기);

  ㄷ. OR, NOT 논리 연산자 사용해서 풀기
SELECT *
FROM insa
WHERE NOT (city = '서울' OR city ='경기' OR city ='인천');   
       
-- 36. 오라클 비교 연산자를 적으세요.
  ㄱ. 같다   :   =
  ㄴ. 다르다  :   !=, ^=, <>
  
-- 37. emp 테이블에서 pay(sal+comm)가  1000 이상~ 2000 이하 받는 30부서원들만 조회하는 쿼리 작성
  조건 : ㄱ.  pay 기준으로 오름차순 정렬 --ename을 기준으로 오름차순 정렬해서 출력(조회)
           ㄴ. comm 이 null은 0으로 처리 ( nvl () )  
           
           sql 실행 순서
SELECT deptno, ename, sal+nvl(comm,0) pay
FROM emp
--WHERE pay BETWEEN 1000 AND 2000 AND  deptno = 30 --pay 인식 못해서 에러
WHERE sal+nvl(comm,0) BETWEEN 1000 AND 2000 AND  deptno = 30
ORDER BY pay ASC; 

ORA-00920: invalid relational operator
00920. 00000 -  "invalid relational operator"
*Cause:    
*Action:
453행, 23열에서 오류 발생

  방법2) 
SELECT deptno, ename, sal+nvl(comm,0) pay
FROM emp
WHERE deptno = 30;

30	ALLEN	1900
30	WARD	1750
30	MARTIN	2650
30	BLAKE	2850
30	TURNER	1500
30	JAMES	950

위의 결과물을 가지고 WITH 절 사용
WHERE pay BETWEEN 1000 AND 2000;

-------------------------------
WITH temp AS ( --서브쿼리
SELECT deptno, ename, sal +NVL(comm,0) pay
FROM emp
WHERE deptno = 30
)
SELECT t.*
FROM temp t  --테이블의 별칭
WHERE t.pay BETWEEN 1000 AND 2000;
---------------
--세번째방법    --인라인뷰 inline view
-- 인라인뷰 : from 절 안에 있는 서브쿼리를 인라인뷰라고 한다.
SELECT T.*
FROM (  
    SELECT deptno, ename, sal +NVL(comm,0) pay
    FROM emp
    WHERE deptno = 30
) t 
WHERE T.pay BETWEEN 1000 AND 2000;

-- 38. emp 테이블에서 1981년도에 입사한 사원들만 조회하는 쿼리 작성.

SELECT hiredate, ename
FROM emp
WHERE hiredate LIKE '81%'; 

SELECT hiredate, ename
FROM emp
WHERE hiredate BETWEEN '1981-01-01' AND '1981-12-31';

--oracle :    Date   + 날짜와 문자 앞에서 ' 홑따옴표 붙임
--java : 날짜형 date, calender, localdate, localtime, localdatetime
 
SELECT hiredate
          , substr(hiredate, 0,2) YY
          ,substr(hiredate, 1,2) YY_1
--    , substr(char, position, length)
--    , substr(char, position, [,length]) 문자열 끝까지 자르겠다.
FROM emp;

-- 오라클 날짜에서 년도를 얻어오는 방법?
TO_CHAR(날짜형) 함수는 날짜형 인자값을 내가 원하는 값(년도, 월, 일, 요일) 을 
                                        문자열로 반환하는 함수
  [ RR 와 YY 차이점 정독] TO_CHAR(datetime) 함수

SELECT hiredate, ename
--          ,TO_CHAR(hiredate, 'RR')
--          ,TO_CHAR(hiredate, 'YY')
           --두 함수의 차이점 -리턴타입 TO_CHAR '1981'  EXTRACT : 숫자 1981
          ,TO_CHAR(hiredate, 'YYYY')
          ,EXTRACT(YEAR FROM hiredate ) "YEAR"
--          ,TO_CHAR(hiredate, 'RRRR')
--          ,TO_CHAR(hiredate, 'YEAR')
--          ,TO_CHAR(hiredate, 'SYYYY')
FROM emp;

문제) insa 테이블에서 주민등록번호로부터 
     앞자리 6자리 출력,
     뒷자리 7자리 출력,
     년도 2자리 출력
     월 2자리 출력
     일 2자리 출력
     주민번호 마지막 검증 1자리 출력
DESC insa;
   --주민번호 뒷자리 *로 표시

SELECT name
        , substr(ssn, 0,8) || '*******' rrn
        , concat(substr(ssn, 0,8), '*******') RRN
--       ,substr(SSN, 1,6) RRN6
--       ,substr(SSN, 8)  RRN7
--       ,substr(SSN, 0,2) YY
--       ,substr(SSN, 3,2) MM
--       ,substr(SSN, 4,2) DD
--       ,substr(SSN, 14)  RRN14
--       ,substr(SSN, -1,1) RRN14   -- -붙으면 뒤에서부터 읽어옴.
FROM insa;

-- 39. emp 테이블에서 직속상사(mgr)가 없는  사원의 정보를 조회
SELECT empno, ename, mgr
FROM emp
WHERE MGR is null;


-- 40. emp테이블에서 각 부서별로 오름차순 1차 정렬하고 급여(PAY)별로 2차 내림차순 정렬해서 조회하는 쿼리 작성

SELECT *
FROM emp
ORDER BY ename ASC, PAY DESC;

--41. Alias 별칭을 작성하는 3가지 방법을 적으세요.
   SELECT deptno, ename 
     , sal + comm   (ㄱ)  AS "별칭"
     , sal + comm   (ㄴ)  AS 별칭
     , sal + comm   (ㄷ)  별칭
    FROM emp;

--42. 오라클의 논리 연산자를 적으세요.
  ㄱ.   AND
  ㄴ.    OR
  ㄷ.   NOT

-- 43. 어제 배운 오라클의 SQL 연산자를 적으세요.
  ㄱ.   (NOT) IN ()
  ㄴ.  (NOT) BETWEEN A AND B (A,B값 포함, 항상 A<B)
  ㄷ. IS NULL, IS NOT NULL
  
  ㄹ. ANY, SOME, ALL  SQL 연산자는 WHERE 조건절의 서브쿼리를 사용할 때 쓰이는 연산자
  
  WITH temp AS
(
  서브쿼리
 )
  
  INLINE VIEW(인라인뷰)
  FROM(
  서브쿼리
  )
  WHERE      SOME , ANY, ALL(서브쿼리)
  
  ===========================
  
  --LIKE SQL연산자 설명
  문제) INSA 테이블에서 성이 김씨인 사원의 정보 조회
  
--  java - name.startwith("김"),endwith()

SELECT name
     --,SUBSTR(name,1,1)
     ,ibsadate
FROM insa
WHERE name LIKE '_김%';
WHERE name LIKE '_김_';
WHERE name LIKE '%김%'; --이름 속에 김 한 문자를 포함하고 있나?
WHERE name LIKE '김_'; --두 문자중 첫 문자가 김
WHERE name LIKE  '김%' ; --안와도 좋고 아무거나와도 됨 
--WHERE SUBSTR(name,1,1) = '김';

like 연산자 기호 : 와일드카드 ( %, _)

-- REGEXP_LIKE 함수 : 정규표현식을 사용하는 LIKE 함수

==============
문제 ) 김씨만 출력
SELECT name, ssn
FROM insa
WHERE REGEXP_LIKE (name, '^김' );    -^ : 로 시작,  $ :로 끝
where REGEXP_LIKE(name,'남$';

문제 ) 김씨 또는 이씨 사원 출력
1) like
SELECT name, ssn
FROM insa
WHERE name LIKE '김%' OR name LIKE '이%';

2)regexp_like
SELECT name, ssn
FROM insa
--WHERE REGEXP_LIKE( name ,'^[김이]');
WHERE REGEXP_LIKE( name ,'^(김|이)');

문제) emp 테이블에서 이름ename속에 la 문자열 포함하는 사원
1) like
SELECT ename
FROM emp
--WHERE ename LIKE '%LA%'; --소문자로 하면 검색 안됨
--JAVA 문자열을 대문자로 변환하는 메서드 TOUPPERCASE
--ORACLE                           UPPER()
WHERE ename LIKE '%' || UPPER('la') || '%';

2) regexp_like
SELECT ename
FROM emp
--WHERE REGEXP_LIKE (ename, '정규표현식');
--WHERE REGEXP_LIKE (ename, 'LA');
--WHERE REGEXP_LIKE (ename, UPPER('la'));
WHERE REGEXP_LIKE (ename, 'la', i);   --i 넣으면 대소문자 구분없음
--WHERE REGEXP_LIKE (ename, '[a-zA-Z]*LA[a-zA-Z]*');

문제) Ste로 시작하고 v나 ph에 en으로 끝나는 경우 -> '^Ste(v|ph)en$'


문제) 인사테이블에서 성이 김, 이씨 는 제외한 모든 사원정보
1) like
SELECT name, ssn

FROM insa
--[1]WHERE NOT( name LIKE '김%' OR name LIKE '이%');
WHERE name NOT LIKE '김%' AND name NOT LIKE '이%');
2)REGEXP_LIKE()
SELECT name, ssn
FROM insa
WHERE REGEXP_LIKE (name, '^[^김이]');
--WHERE NOT REGEXP_LIKE (name, '^[김이]');
--WHERE NOT REGEXP_LIKE (name, '^[김|이]');