1. 오라클 각 DataType 에 대해 상세히 설명하세요
--문자
고정길이
char  1바이트
nchar  한문자당 2바이트  (유니코드)
가변길이
varchar2
nvarchar2

LONG 2GB
--숫자
number(p,s) -> s 소수점 자리수, p 전체 자리수
--날짜 타입
DATE 
TIMESTAMP

2.  emp 테이블에서 [년도별] [월별] 입사사원수 출력.( PIVOT() 함수 사용 )

    [실행결과]
    1982	1	0	0	0	0	0	0	0	0	0	0	0
    1980	0	0	0	0	0	0	0	0	0	0	0	1
    1981	0	2	0	1	1	1	0	0	2	0	1	2
        
    
SELECT EXTRACT(MONTH FROM hiredate) hiredate_month FROM emp

SELECT *
FROM (SELECT EXTRACT(YEAR FROM hiredate) hiredate_year, EXTRACT(MONTH FROM hiredate) hiredate_month FROM emp)
PIVOT( COUNT(*)FOR hiredate_month IN(1,2,3,4,5,6,7,8,9,10,11,12));
  
    
    SELECT TO_CHAR( hiredate,'yyyy')년도별, TO_CHAR( hiredate,'MM') hire_month FROM emp ;
    
  
        SELECT *
    FROM ( SELECT TO_CHAR( hiredate,'yyyy')년도별, TO_CHAR( hiredate,'MM') hire_month FROM emp )
    PIVOT(  COUNT(hire_month) FOR hire_month IN (01,02,03,04,05,06,07,08,09,10,11,12) );
2-2.   emp 테이블에서 각 JOB별 입사년도별 1월~ 12월 입사인원수 출력.  ( PIVOT() 함수 사용 ) 
    [실행결과]
    ANALYST		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1980	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1981	0	0	0	0	0	0	0	0	0	0	0	1
    CLERK		1982	1	0	0	0	0	0	0	0	0	0	0	0
    MANAGER		1981	0	0	0	1	1	1	0	0	0	0	0	0
    PRESIDENT	1981	0	0	0	0	0	0	0	0	0	0	1	0
    SALESMAN	1981	0	2	0	0	0	0	0	0       
    
 SELECT *
FROM (SELECT job, EXTRACT(YEAR FROM hiredate) hiredate_year, EXTRACT(MONTH FROM hiredate) hiredate_month FROM emp)
PIVOT( COUNT(*)FOR hiredate_month IN(1,2,3,4,5,6,7,8,9,10,11,12));   
    
    
    SELECT *
    FROM ( SELECT JOB, TO_CHAR( hiredate,'yyyy')년도별, TO_CHAR( hiredate,'MM') hire_month FROM emp )
    PIVOT(  COUNT(hire_month) FOR hire_month IN (01,02,03,04,05,06,07,08,09,10,11,12) )
    ORDER BY job;
    
3. emp테이블에서 입사일자가 오래된 순으로 3명 출력 ( TOP 3 )
    [실행결과]
    1	7369	SMITH	CLERK	    7902	80/12/17	800		    20
    2	7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
    3	7521	WARD	SALESMAN	7698	81/02/22	1250	500	30   
    

  [a.TOP-N : RoWNUM];
    SELECT *
    FROM (
    SELECT RoWNUM seq, emp.*
    FROM emp
    ORDER BY hiredate ASC
    ) WHERE seq<=3;
    
    [b.RANK()];
    SELECT *
    FROM (SELECT emp.*
           ,RANK() OVER (ORDER BY hiredate ASC) seq
    FROM emp
    )
    WHERE  seq<=3;
    
4. SMS 인증번호  임의의  6자리 숫자 출력 ( dbms_random  패키지 사용 )

--LTRIM(), RTRIM() , TRIM()
SELECT SUBSTR ( LTRIM (LTRIM( dbms_random.value ,'0.') ,'0'),0,6) A
    ,TRUNC( dbms_random.value(100000,1000000)) B -- 100000<=  <999999
FROM dual;

4-2. 임의의 대소문자 5글자 출력( dbms_random  패키지 사용 )

SELECT dbms_random.string('A',5)
FROM dual;

5. 게시글을 저장하는 테이블 생성
   ㄱ.   테이블명 : tbl_test
   ㄴ.   컬럼               자료형  크기    널허용여부    고유키
         글번호    seq   NUMBER(3)     NOT NULL PRIMARY KEY     
         작성자    writer   VARCHAR2     NOT NULL
         비밀번호 passwd      VARCHAR2    NOT NULL
         글제목    title       VARCHAR2    NOT NULL
         글내용    content  VARCHAR2
         작성일    regdate   디폴트 - SYSDATE
    ㄷ.  글번호, 작성자, 비밀번호, 글 제목은 필수 입력 사항으로 지정
    ㄹ.  글번호가  기본키( PK )로 지정
    ㅁ.  작성일은 현재 시스템의 날짜로 자동 설정
    
    
    CREATE TABLE tbl_test (
                    seq       NUMBER      NOT NULL   CONSTRAINTS  PK_tbltest_seq  PRIMARY KEY  
                   ,writer  VARCHAR2(20)  NOT NULL
                   ,passwd  VARCHAR2(20)  NOT NULL
                   ,title VARCHAR2(100)   NOT NULL
                   ,content  LONG  
                   ,regdate   DATE   DEFAULT SYSDATE
    );
    --Table TBL_TEST이(가) 생성되었습니다.
  
5-2. 조회수    read   컬럼을 추가 ( 기본값 0 으로  설정 ) 

ALTER TABLE tbl_test
    ADD read number DEFAULT 0;
    --Table TBL_TEST이(가) 변경되었습니다.
  --컬럼 한 개만 추가할 때는 () 생략 가능  
  
  DESC tbl_test;
5-3. 글내용    content 컬럼의 자료형을 clob 로 수정 (LONG -> CLOB)

ALTER TABLE tbl_test
  MODIFY (content clob);
--Table TBL_TEST이(가) 변경되었습니다.
5-4. 테이블 구조 확인

DESC tbl_test;

5-5. 글제목     title 을   subject로 수정 

SELECT title subject FROM tbl_test; --별칭으로 사용가능

ALTER TABLE tbl_test
   RENAME COLUMN title TO subject; 
   
--Table TBL_TEST이(가) 변경되었습니다.
5-6.  tbl_test  -> tbl_board 테이블명 변경 

RENAME tbl_test TO tbl_board;

DESC tbl_board;
--테이블 이름이 변경되었습니다.

이름      널?       유형            
------- -------- ------------- 
SEQ     NOT NULL NUMBER        
WRITER  NOT NULL VARCHAR2(20)  
PASSWD  NOT NULL VARCHAR2(20)  
SUBJECT NOT NULL VARCHAR2(100) 
CONTENT          CLOB          
REGDATE          DATE          
READ             NUMBER    


5-7. CRUD  ( insert, select, update, delete ) 
   ㄱ. 임의의 게시글 5개를 추가 insert 
   INSERT INTO tbl_board ( seq,writer, passwd, subject, content, regdate, read)
        VALUES ( 1,'admin','1234','test1', 'test -1',SYSDATE,0);
   --1 행 이(가) 삽입되었습니다.
    INSERT INTO tbl_board ( seq,writer, passwd, subject, content)
        VALUES ( 2,'hong','1234','hong1', 'hong -1');
   --디폴트옵션 있으니까 regdate, read 생략가능
   
   --글내용 content 필수입력 x
    INSERT INTO tbl_board ( seq,writer, passwd, subject)
        VALUES ( 3,'kenik','1234','kenik 1');
   
   COMMIT;
   ㄴ. 게시글 조회 select
   SELECT *
   FROM tbl_board; 
   
   ㄷ. 3번 게시글의 글 제목, 내용 수정 update
     (게시글 삭제, 수정 할때는 검색한 후!)
   SELECT seq, subject, content
   FROM tbl_board
   WHERE seq=3;
   
   UPDATE tbl_board
   SET subject = '[e]' || subject, content='[e]'||NVL(content,'내용 무')
   WHERE seq=3;
   
   COMMIT;
   
   ㄹ. 4번 게시글 삭제 delete
   
   DELETE FROM tbl_board
   WHERE seq=4;
   --0개 행 이(가) 삭제되었습니다. 4번행이 없으니까..
   
5-8. tbl_board 테이블 삭제  
                         
DROP TABLE tbl_board PURGE;  --완전 삭제( 휴지통 거치지 않고)
--Table TBL_BOARD이(가) 삭제되었습니다.

6-1. 오늘의 날짜와 요일 출력 
 [실행결과]
오늘날짜  숫자요일  한자리요일       요일
-------- ---        ------   ------------
22/04/15  6             금      금요일      

SELECT SYSDATE
      ,TO_CHAR(SYSDATE,'D') 숫자요일
      ,TO_CHAR(SYSDATE,'DY') 한자리요일
      ,TO_CHAR(SYSDATE,'DAY') 요일
FROM dual;

6-2. 이번 달의 마지막 날과 날짜만 출력 
 [실행결과]
오늘날짜  이번달마지막날짜                  마지막날짜(일)
-------- -------- -- ---------------------------------
22/04/15 22/04/30 30                                30

SELECT SYSDATE 오늘날짜
      ,LAST_DAY(SYSDATE)  이번달마지막날짜  
      ,TO_CHAR(LAST_DAY(SYSDATE) , 'DD')  
FROM dual;

6-3.
 [실행결과]
오늘날짜    월의주차 년의주차 년의 주차
--------    -       --      --
22/04/15    3       15      15


SELECT SYSDATE 오늘날짜
      ,TO_CHAR(SYSDATE,'W') 
      ,TO_CHAR(SYSDATE,'IW') --월요일을 주의 시작으로 본다
      ,TO_CHAR(SYSDATE,'WW') --매년 1일을 주의 시작으로 본다
FROM dual;
[년 주차]
IW: 월요일-일요일 ( 요일을 기준) 
WW: 1일 -7일( 일을 기준)  2022.1.1~ 2022.1.7
    1/2/3/      4
IW     13      14
WW     13   (2~)  14

SELECT TO_CHAR( TO_DATE('2022.4.4'),'IW')
      ,TO_CHAR( TO_DATE('2022.4.4'),'WW')
FROM dual;
-------------------------------------------
[테이블 생성하는 방법]
? 테이블을 만드는 가장 단순하면서도 일반적인 명령 형식으로 만드는 방법
? Extend table 생성

【형식】
CREATE TABLE table
( 컬럼1  	데이터타입,
  컬럼2  	데이터타입,...)
STORAGE    (INITIAL  	크기
	    NEXT	크기
	    MINEXTENTS	크기
	    MAXEXTENTS	크기
	    PCTINCREASE	n);
   캐싱 테이블은 빈번하게 사용되는 테이블 데이터를 데이터버퍼 캐시영역에 상주시켜 
   검색시 성능을 향상시킴.

? Subquery를 이용한 table 생성

? External table 생성
 -DB 외부에 저장된 data source를 조작하기 위한 접근 방법의 하나로 읽기 전용 테이블
 
? NESTED TABLE 생성
 - 테이블 속의 어느 컬럼이 또 다른 테이블 형식을 가진다.
? Partitioned Tables & Indexes 생성
-------------------------------------------
--[ Subquery를 이용한 table 생성]
1. 이미 존재하는 테이블 있고 
2. select - subquery를 이용하여 
3. 새로운 테이블을 생성 + 데이터 입력insert
4. 【형식】
	CREATE TABLE 테이블명 [컬럼명 (,컬럼명),...]
	AS subquery;
? 다른 테이블에 존재하는 특정 컬럼과 행을 이용한 테이블을 생성하고 싶을 때 사용
? Subquery의 결과값으로 table이 생성됨
? 컬럼명을 명시할 경우 subquery의 컬럼수와 테이블의 컬럼수를 같게 해야 한다.
? 컬럼을 명시하지 않을 경우, 컬럼명은 subquery의 컬럼명과 같게 된다.
? subquery를 이용해 테이블을 생성할 때 
  CREATE TABLE 테이블명 뒤에 컬럼명을 명시해 주는 것이 좋다.
5. 예시.
  ㄱ. emp 테이블에서 10번 부서원 검색 ->> empno, ename, hiredate, sal+NVL(comm,0) pay 새로운 테이블 생성

CREATE TABLE tbl_emp10 -- (no, name, ibsadate, pay) --[컬럼명, 컬럼명 , 컬럼명, 컬럼명]
AS (
   SELECT empno, ename, hiredate, sal+NVL(comm,0) pay
   FROM emp
   WHERE deptno=10
);
--Table TBL_EMP10이(가) 생성되었습니다.

6. 테이블의 구조 확인
DESC tbl_emp10;

이름       널? 유형           
-------- -- ------------ 
EMPNO       NUMBER(4)      emp 테이블 자료형
ENAME       VARCHAR2(10)   emp 테이블 자료형
HIREDATE    DATE           emp 테이블 자료형
PAY         NUMBER         시스템이 자료형 설정(알아서)

7. 원래테이블은 그대로 두고, 복사해서 테이블 사용하고 싶을 때 사용
CREATE TABLE tbl_empcopy
AS (
        SELECT * FROM emp 
    );
--Table TBL_EMPCOPY이(가) 생성되었습니다.
-- emp 테이블의 구조+ 12명의 사원데이터 그대로 복사 -> 새로운 테이블 생성
DESC tbl_empcopy;

8. 제약조건은 복사되지 않는다 (NOT NULL 제약조건은 예외)
  ㄱ. EMP 제약조건
  SELECT *
  FROM user_constraints
  WHERE table_name = UPPER( 'emp');
  
제약조건
소유자    제약조건 이름      제약조건 타입
OWNER   CONSTRINT_NAME
SCOTT	PK_EMP	             P     PK
SCOTT	FK_DEPTNO	         R     FK
  
  FROM tabs;
  FROM user_tables;
    
    ㄴ. tbl_empcopy 제약조건
    
  SELECT *
  FROM user_constraints
  WHERE table_name =  'tbl_empcopy';
  
9. 테이블 삭제
DROP TABLE tbl_emp10 PURGE;
DROP TABLE tbl_empcopy PURGE;

10. 테이블은 기존 테이블로부터 서브쿼리를 사용해서 생성 + 데이터는 필요x
-----------------방법1)-----------------
CREATE TABLE tbl_emp_copy
AS (
  SELECT *
  FROM emp
);
 1) 생성하고 나서
 DELETE FROM tbl_emp_copy;
 COMMIT;
 2) DELETE 에서 WHERE 조건 절 빼고 지우면 모든 데이터 삭제됨.
SELECT *
FROM tbl_emp_copy;
--오라클 11G XE 는 PURGE 안붙여도 자동으로 완전 삭제됨.
-----------------방법2)-----------------
--항상 거짓인 값을 넣어주면 데이터 제외하고 테이블 생성됨 - 구조만 복사.
CREATE TABLE tbl_emp_copy
AS (
  SELECT *
  FROM emp
  WHERE 1=0 
);

DROP TABLE tbl_emp_copy;
-------------------------------------------
1. tbl_member 테이블 있는지 확인

SELECT *
FROM user_tables
WHERE REGEXP_LIKE( table_name,'member','i');

2. tbl_member 테이블 삭제
DROP TABLE tbl_member;

3. 테이블 생성

rrn 주민등록번호를 컬럼으로 추가      => 추출속성
     -> 나이, 생일, 성별 추출 가능 -> 나이 생일 대신 주민번호 사용

CREATE TABLE tbl_member
 (
    id varchar2(10) NOT NULL CONSTRAINTS PK_TABLEMEMBER_ID PRIMARY KEY         --고유키PK =중복x = (유일성unique+ NN(not null))
    ,name varchar2(20) NOT NULL
      ,age  NUMBER(3)
      ,birth DATE
    ,regdate DATE DEFAULT SYSDATE --가입일 
    ,point NUMBER DEFAULT 100  --포인트
 );
-- Table TBL_MEMBER이(가) 생성되었습니다.

SELECT *
FROM user_constraints
WHERE table_name = 'TBL_MEMBER';

PK   P
NN   C
FK   R

--제약조건 명 지정하지 않으면 자동으로 SYS~~
멤버추가
오류 보고 -
ORA-01830: date format picture ends before converting entire input string
 -- '1991/03/04' 형식으로 넣던가 fmt으로 알려줘야함
INSERT INTO TBL_MEMBER (id, name, age, birth, regdate, point)
     VALUES ('admin','관리자',32,TO_DATE( '03/04/1991','MM/DD/YYYY'),SYSDATE, 100);

오류 보고 -
ORA-00001: unique constraint (SCOTT.PK_TABLEMEMBER_ID) violated
 PK 고유키는 중복 안된다 
INSERT INTO TBL_MEMBER VALUES ('hong','홍길동',22,'2001.01.01',SYSDATE, 100);
--테이블 순서와 똑같으므로 생략
 
오류 보고 -
SQL 오류: ORA-00947: not enough values :
디폴트 준 값들은 생략했는데 왜 오류-> 디폴드값 생략하려면 칼럼명 넣어줘야함.
 INSERT INTO TBL_MEMBER (id, name, age, birth) VALUES ('park','박지순',25,'1998.5.9');

--null허용하는 칼럼은 null로 채워도 됨.
 INSERT INTO TBL_MEMBER( name, birth, id, age) VALUES ('이진수', null, 'kenik',25);

COMMIT;                
SELECT *
FROM tbl_member;
                
 -------서브쿼리 사용해서 insert할 수 있다
형식 )
INSERT INTO 테이블명(서브쿼리);

----------------
1. tbl_emp10 테이블 유무 확인  -> 삭제
2. emp 테이블을 구조복사o, 데이터x -> tbl_emp10 테이블 생성
CREATE TABLE tbl_emp1  --칼럼명
AS (
   SELECT *
   FROM emp
   WHERE 1=10
   );
   
SELECT *
FROM tbl_emp;

3.emp 테이블의 10번 부서원들을 select 해서 tbl_emp10 테이블에 추가

INSERT INTO tbl_emp10
   (
   SELECT *
   FROM emp
   WHERE deptno=10   
   );
    
    commit;
    DROP TABLE tbl_emp10;
    
--[MULTITABLE INSERT문] 다중테이블에 INSERT문
--4가지 종류
--    조건유무             전부
--ㄱ. unconditional insert all 
--ㄴ. conditional insert all 
--ㄷ. conditional first insert 
--ㄹ. pivoting insert 

--하나의 INSERT 문에 

--ㄱ. unconditional insert all 
--  조건에 상관없이 기술되어진 여러개의 테이블에 데이터를 입력한다
? 서브쿼리로부터 한번에 하나의 행을 반환받아 각각 insert 절을 수행한다.
? into 절과 values 절에 기술한 컬럼의 개수와 데이터 타입은 동일해야 한다
 형식 
 INSERT ALL
      INTO 테이블1 VALUES (컬럼값..)
      INTO 테이블2 VALUES (컬럼값..)
      INTO 테이블3 VALUES (컬럼값..)
      :
      서브쿼리 ;  SELECT(10개)

CREATE TABLE dept_10 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_20 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_30 AS SELECT * FROM dept WHERE 1=0;
CREATE TABLE dept_40 AS SELECT * FROM dept WHERE 1=0;

SELECT * FROM dept_10; DELETE FROM dept_10;
SELECT * FROM dept_20; DELETE FROM dept_20;
SELECT * FROM dept_30; DELETE FROM dept_30;
SELECT * FROM dept_40; DELETE FROM dept_40;

INSERT ALL
    INTO dept_10 VALUES (deptno, dname, loc)
    INTO dept_20 VALUES (deptno, dname, loc)
    INTO dept_30 VALUES (deptno, dname, loc)
    INTO dept_40 VALUES (deptno, dname, loc)
SELECT deptno, dname, loc
FROM dept;
--16개 행 이(가) 삽입되었습니다.
COMMIT;
DROP TABLE dept_10;
DROP TABLE dept_20;
DROP TABLE dept_30;
DROP TABLE dept_40;

-ㄴ. conditional insert all 

문제) emp 테이블에 한번에 집어넣기

-- emp테이블의 구조만 복사해서 테이블 생성
CREATE TABLE emp_10 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_20 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_30 AS SELECT * FROM emp WHERE 1=0;
CREATE TABLE emp_40 AS SELECT * FROM emp WHERE 1=0;

【형식】
	INSERT ALL
	WHEN 조건절1 THEN
	  INTO [테이블1] VALUES (컬럼1,컬럼2,...)
	WHEN 조건절2 THEN
	  INTO [테이블2] VALUES (컬럼1,컬럼2,...)
	........
	ELSE
	  INTO [테이블3] VALUES (컬럼1,컬럼2,...)
	Subquery;

? subquery로부터 한번에 하나씩 행을 리턴받아 WHEN...THEN절에서 체크한 후,
   조건에 맞는 절에 기술된 테이블에 insert 절을 수행한다.
? VALUES 절에 지정한 DEFAULT 값을 사용할 수 있다. 
  만약 default값이 지정되어 있지 않다면, NULL 값이 삽입된다.
  
  INSERT ALL
    WHEN deptno=10 THEN
     INTO emp_10 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
      WHEN deptno=20 THEN  
     INTO emp_20 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
      WHEN deptno=30 THEN
     INTO emp_30 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
      WHEN deptno=40 THEN
     INTO emp_40 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
  SELECT * FROM emp;
  
SELECT * FROM dept_10;
SELECT * FROM dept_20; 
SELECT * FROM dept_30;
SELECT * FROM dept_40;

emp10 레코드 모두 삭제
DROP TABLE emp_10 ; --테이블 완전 삭제

DELETE FROM emp_10; --모든 레코드(데이터) 삭제
COMMIT;

TRUNCATE TABLE emp_10; -- 모든 레코드(데이터) 삭제 + 자동 커밋/롤백X
-- WHERE 조건절 없이 DELETE 하는 것과 동일 단, 자동커밋
--Table EMP_10이(가) 잘렸습니다.
TRUNCATE TABLE emp_20; 
TRUNCATE TABLE emp_30; 
TRUNCATE TABLE emp_40; 

--ㄷ. conditional first insert  

【형식】
INSERT FIRST
WHEN 조건절1 THEN
  INTO [테이블1] VALUES (컬럼1,컬럼2,...)
WHEN 조건절2 THEN
  INTO [테이블2] VALUES (컬럼1,컬럼2,...)
........
ELSE
  INTO [테이블3] VALUES (컬럼1,컬럼2,...)
Sub-Query;

? conditional INSERT FIRST는 조건절을 기술하여 조건에 맞는 값들을 원하는 테이블에 삽입할 수 있다.
? 여러 개의 WHEN...THEN절을 사용하여 여러 조건 사용이 가능하다. 단, 첫 번째 WHEN 절에서 조건을 만족한다면, INTO 절을 수행한 후 다음의 WHEN 절들은 더 이상 수행하지 않는다.
? subquery로부터 한 번에 하나씩 행을 리턴 받아 when...then절에서 조건을 체크한 후 조건에 맞는 절에 기술된 테이블에 insert를 수행한다.
? 조건을 기술한 when 절들을 만족하는 행이 없을 경우 else절을 사용하여 into 절을 수행할 수 있다. else절이 없을 경우 리턴 딘 그행에 대해서는 아무런 작업도 발생하지 않는다.

---
SELECT *
FROM emp
WHERE deptno =10;

--7782	CLARK	MANAGER	7839	81/06/09	2450		10
--7839	KING	PRESIDENT		81/11/17	5000		10
--7934	MILLER	CLERK	7782	82/01/23	1300		10

SELECT *
FROM emp
WHERE job ='CLERK';

--7369	SMITH	CLERK	7902	80/12/17	800		20
--7900	JAMES	CLERK	7698	81/12/03	950		30
--7934	MILLER	CLERK	7782	82/01/23	1300		10

MILLER 는 부서10, 직업 CLERK

--가장 먼저 만족하는 절만 실행하고 나머지는 실행안함.
INSERT FIRST
    WHEN  deptno =10 THEN
    INTO emp_10 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    WHEN job='CLERK'  THEN
    INTO emp_20 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    ELSE
    INTO emp_40 VALUES (empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT * FROM emp;
-> 밀러는 부서가 10이라 10번에만 들어가고 점원조건은 무시되므로 20번에는 안들어감

DROP TABLE emp_10;
DROP TABLE emp_20;
DROP TABLE emp_30;
DROP TABLE emp_40;

--ㄹ. Pivoting insert 문

【형식】
INSERT ALL
WHEN 조건절1 THEN
  INTO [테이블1] VALUES (컬럼1,컬럼2,...)
  INTO [테이블1] VALUES (컬럼1,컬럼2,...)
  ..........
Sub-Query;

? 여러 개의 INTO 절을 사용할 수 있지만, INTO 절 뒤에 오는 테이블은 모두 동일하여야 한다.
? 주로 여러 곳의 시스템으로부터 데이터를 받아 작업하는 dataware house에 적합하다. 정규화 되지 않은 data source들이나 다른 format으로 저장된 data source들을 Oracle의 관계형 DB에서 사용하기에 적합한 형태로 변환한다.
? 정규화 되지 않은 데이터를 oracle이 제공하는 relational한 형태로 테이블을 변경하는 작업을 pivoting이라고 한다.

CREATE TABLE tbl_sales(
   employee_id       number(6),
   week_id            number(2),
   sales_mon          number(8,2),
   sales_tue          number(8,2),
   sales_wed          number(8,2),
   sales_thu          number(8,2),
   sales_fri          number(8,2)
   );

--Table TBL_SALES이(가) 생성되었습니다.

insert into tbl_sales values(1101,4,100,150,80,60,120);
insert into tbl_sales values(1102,5,300,300,230,120,150);

COMMIT;

SELECT *
FROM tbl_sales;

create table tbl_sales_data(
  employee_id        number(6),
  week_id            number(2),
  sales              number(8,2)
  );
--Table TBL_SALES_DATA이(가) 생성되었습니다.

insert all
   into tbl_sales_data values(employee_id, week_id, sales_mon)
   into tbl_sales_data values(employee_id, week_id, sales_tue)
   into tbl_sales_data values(employee_id, week_id, sales_wed)
   into tbl_sales_data values(employee_id, week_id, sales_thu)
   into tbl_sales_data values(employee_id, week_id, sales_fri)
   
   select employee_id, week_id, sales_mon, sales_tue, sales_wed,
          sales_thu, sales_fri
   from tbl_sales;

SELECT *
FROM tbl_sales_data;

--------------------
         이미 존재하는 테이블을 사용해서 새로운 테이블 생성
문제 ) insa 테이블의 num, name 컬럼만 복사해서 tbl_score 테이블 생성
     조건1) num <= 1005 자료(레코드)만 복사.
     
CREATE TABLE tbl_score  
  AS 
   SELECT num, name
   FROM insa
   WHERE num <=1005;
--Table TBL_SCORE이(가) 생성되었습니다.

--alter table + 추가는 add 수정은 modify
문제2) tbl_score 테이블에 kor, eng, mat, tot, avg, grade , rank 칼럼 추가
 (k, e, m 기본값 0 ,         grade 는 한문자(영어, 한글)
ALTER TABLE tbl_score 
   ADD( kor number(3) DEFAULT 0
       ,eng number(3) DEFAULT 0
       ,mat number(3) DEFAULT 0
       ,tot NUMBER(3)
       ,avg NUMBER(5,2)
       ,grade char(1 char) 
       ,rank NUMBER
       );
--Table TBL_SCORE이(가) 변경되었습니다.

DESC tbl_score;

이름    널?       유형           
----- -------- ------------ 
NUM   NOT NULL NUMBER(5)    
NAME  NOT NULL VARCHAR2(20) 
KOR            NUMBER(3)    
ENG            NUMBER(3)    
MAT            NUMBER(3)    
TOT            NUMBER(3)    
AVG            NUMBER(5,2)  
GRADE          CHAR(1 CHAR) 
RANK           NUMBER       

문제 ) 1001~1005 num, name
     kor, eng, mat 임의의 점수를 발생시켜서 수정
  
 UPDATE tbl_score
 SET  kor =  TRUNC( dbms_random.value(0,101))
     ,eng =   TRUNC( dbms_random.value(0,101))
     ,mat  =  TRUNC( dbms_random.value(0,101));
  COMMIT;
문제) tbl_score 테이블에 TOT, AVG 계산해서 수정 UPDATE

UPDATE tbl_score
SET  tot = kor+eng+mat
    , avg = (kor+eng+mat)/3;

평균 90이상 A
    80    B
    70    C
    60    D
          F
 --방법1
UPDATE tbl_score
SET grade = CASE
              WHEN avg >=90  THEN grade ='A'
              WHEN avg BETWEEN 80 AND 89  THEN 'B'
              WHEN avg BETWEEN 70 AND 79  THEN 'C'
              WHEN avg BETWEEN 60 AND 69  THEN 'D'
              ELSE 'F'
  --방법2 
UPDATE tbl_score
SET grade 
   = DECODE(TRUNC(avg/10),10,'A',9,'A',8,'B',7,'C',6,'D','F');
COMMIT;

-문제) 등수 처리하는 UPDATE 문

SELECT num, tot,name
       ,RANK() OVER(ORDER BY tot DESC) rank
FROM tbl_score;
--
방법1
UPDATE tbl_score y
SET rank = (  SELECT r
              FROM (
                SELECT num, tot,name
                       ,RANK() OVER(ORDER BY tot DESC) r
                FROM tbl_score
                ) X
            WHERE X.NUM = Y.NUM
           );
           
  --5개 행 이(가) 업데이트되었습니다.
  ROLLBACK;
  --방법2
UPDATE tbl_score y
SET rank =
   ( SELECT COUNT(*)+1 FROM tbl_score  WHERE tot > y.tot);

SELECT *
FROM tbl_score;

COMMIT;

--문제 ) 모든 학생의 국어점수를 5점 증가, 

UPDATE tbl_score
SET kor = CASE 
           WHEN kor>=95   THEN 100
           ELSE kor+5
           END;
/*JAVA
if( kor>=95) kor =100;
else kor+=5
*/
--문제 ) 1001번 학생의 국영 점수를 1005번 학생의 국어, 영어 점수로 수정
--방법1
UPDATE tbl_score
SET kor = (SELECT kor FROM tbl_score WHERE num =1005)
   ,eng = (SELECT eng FROM tbl_score WHERE num =1005)
WHERE num =1001;

--방법2
UPDATE tbl_score
SET (kor, eng) = (SELECT kor, eng FROM tbl_score WHERE num= 1005)
WHERE num =1001;

COMMIT;

SELECT *
FROM tbl_score;
--문제  )tbl_score 테이블에서 여학생들만 영어점수 5점 증가

--tbl_score 에는 성별에 해당하는 칼럼 없음
-- insa 테이블에 있음
-- 조인까지 해야함

SELECT *
FROM tbl_score;

UPDATE tbl_score 
SET eng = eng+5
WHERE num = (SELECT ts.num
            FROM tbl_score ts,( SELECT num, DECODE (MOD( SUBSTR(ssn, -7,1),2),0,'여자') gender  
                               FROM insa)i
            WHERE ts.num = i.num AND gender IS NOT NULL) ;



SELECT ts.num
FROM tbl_score ts,( SELECT num, DECODE (MOD( SUBSTR(ssn, -7,1),2),0,'여자') gender
                FROM insa)i
WHERE ts.num = i.num AND gender IS NOT NULL;

SELECT t.gender
FROM ( SELECT num, DECODE (MOD( SUBSTR(ssn, -7,1),2),0,'여자') gender
FROM insa i)t

;

SELECT NUM
FROM insa i;
--------------------------------------------
-- 만년달력
SELECT   
          NVL( MIN(    DECODE( TO_CHAR(dates, 'D'), 1,TO_CHAR(dates, 'DD') )   ), ' ') 일
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 2,TO_CHAR(dates, 'DD') ) ), ' ') 월
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 3,TO_CHAR(dates, 'DD') ) ), ' ') 화
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 4,TO_CHAR(dates, 'DD') ) ), ' ') 수
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 5,TO_CHAR(dates, 'DD') ) ), ' ') 목
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 6,TO_CHAR(dates, 'DD') ) ), ' ') 금
         , NVL( MIN(  DECODE( TO_CHAR(dates, 'D'), 7,TO_CHAR(dates, 'DD') ) ), ' ') 토         
FROM (
        SELECT TO_DATE( :yyyymm, 'YYYYMM') + (LEVEL -1) dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT( DAY FROM LAST_DAY( TO_DATE( :yyyymm , 'YYYYMM') ) )
      ) t      
GROUP BY  DECODE( TO_CHAR(dates, 'D'), 1, TO_CHAR( dates, 'IW') +1,  TO_CHAR( dates, 'IW')   )  
ORDER BY  DECODE( TO_CHAR(dates, 'D'), 1, TO_CHAR( dates, 'IW') +1,  TO_CHAR( dates, 'IW')   );

---------------------------------------------------------------
분석 순서
입력: 202203
날짜: 22/03/01
날짜+2 = 날짜
SELECT TO_DATE( '202203', 'YYYYMM') + (LEVEL -1) dates
FROM dual;

--LEVEL
계층적 질의(hierarchical query)