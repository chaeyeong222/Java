-- [ SCOTT 접속된 스크립트 파일]
-- 데이터 정의 언어 DDL   - CREATE, ALTER, DROP

-- 사용자 생성하는 쿼리
CREATE USER admin IDENTIFIED BY 123$;
--오류 보고 -
--ORA-00911: invalid character
--00911. 00000 -  "invalid character"
--*Cause:    The identifier name started with an ASCII character other than a
--           letter or a number. After the first character of the identifier
--           name, ASCII characters are allowed including "$", "#" and "_".
--           Identifiers enclosed in double quotation marks may contain any
--           character other than a double quotation. Alternate quotation
--           marks (q'#...#') cannot use spaces, tabs, or carriage returns as
--           delimiters. For all other contexts, consult the SQL Language
--           Reference Manual.
--           SCOTT 새로운 사용자 계정 생성하면 
--오류 보고 -
--ORA-01031: insufficient privileges   권한이 충분하지 않아서 계정을 생성할 수 없다. 
--01031. 00000 -  "insufficient privileges"
--*Cause:    An attempt was made to perform a database operation without
--           the necessary privileges.
-----------------
rem scott 접속한 스크립트 파일   //rem == -- (주석처리)
--------------------------
1. 테이블 생성
CREATE TABLE
  ㄱ. scott.sql 스크립트 찾아서
2. scott 계정이 소유하고 있는 테이블 조회
SELECT *
FROM tabs;
---소유하고 있는 테이블 없다--

3. DEPT 테이블 생성
CREATE TABLE DEPT  
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,   --부서번호 컬럼
	 DNAME VARCHAR2(14) ,  --부서명 컬럼
	 LOC VARCHAR2(13)      --지역명 컬럼
     ) ; 
     
    -- 오라클 자료형 NUMBER(2) 2자리 숫자자료형, varchar2(14) 14바이트 크기의 문자열 자료형 
    -- Table DEPT이(가) 생성되었습니다.
    
SELECT * 
FROM dept;
FROM 테이블명;
FROM 스키마.테이블명;

4. 어떤 테이블의구조 확인( 조회)
DESC dept;
DESC 테이블명;

이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 

SCOTT 계정을 생성하면 SCOTT 계정명과 동일한 스키마 schema 생성

5. dept 테이블 - 부서정보 추가
                     -- 부서번호   '부서명'    '지역명'
                     -- 오라클에서 '문자열'  또는 '날짜형'
INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');
COMMIT;

7. 4개의 행 추가 확인 
SELECT * 
FROM dept;

8. EMP(사원) 테이블 생성
CREATE TABLE EMP
(
-- 사원들을 구별할 수 있는 고유한 키로 사번EMPNO 컬럼을 설정
    EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,  --사원번호 PRIMARY KEY(PK) ==고유키
	ENAME VARCHAR2(10), -- 사원명
	JOB VARCHAR2(9),   -- 잡
	MGR NUMBER(4),     -- 직속상사의 사원번호
	HIREDATE DATE,     -- 입사일자
	SAL NUMBER(7,2),    -- 급여
	COMM NUMBER(7,2),    --커미션
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT  --부서번호, 부서테이블dept 의 부서번호deptno 참조
    );
    
    -- Table EMP이(가) 생성되었습니다.
10. 사원 emp 테이블 조회
SELECT *
FROM emp;

11.사원등록
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
COMMIT;

11. 12명 사원등록 조회
SELECT * 
FROM emp;

12. 보너스 테이블 생성 
CREATE TABLE BONUS
	(
	ENAME VARCHAR2(10)	,
	JOB VARCHAR2(9)  ,
	SAL NUMBER,
	COMM NUMBER
	) ;
--급여등급 테이블
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

13. scott 이 소유한 테이블 확인
SELECT * 
FROM tabs;

SELECT *
FROM salgrade;

-- scott.sql파일로 샘플로 사용할 테이블 4개 생성 + 데이터 추가

14. DQL - [SELECT문]
 -- 3. 데이터를 가져오는 데 사용하는 문
 -- 2. 대상 : 하나 이상의 테이블 , 뷰
 -- 1. SELECT, SubQuery 를 이용해서
 
15. 소유자 , SELECT 권한을 부여받은 자.
16.【형식】
    [subquery_factoring_clause] subquery [for_update_clause];

【subquery 형식】
   {query_block ?
    subquery {UNION [ALL] ? INTERSECT ? MINUS }... ? (subquery)} 
   [order_by_clause] 

【query_block 형식】
   SELECT [hint] [DISTINCT ? UNIQUE ? ALL] select_list
   FROM {table_reference ? join_clause ? (join_clause)},...
     [where_clause] 
     [hierarchical_query_clause] 
     [group_by_clause]
     [HAVING condition]
     [model_clause]

【subquery factoring_clause형식】
   WITH {query AS (subquery),...}

17. ***** SELECT 문의 절( clause) 처리 순서 **** 암기하기
  각각의 절마다 줄바꿈 한다.
[  WITH 절     -- 1 ]
  SELECT 절   -- 6
  FROM 절     -- 2
[  WHERE 절    -- 3 ]
[  GROUP BY 절 -- 4  ]
[  HAVING 절   -- 5 ]
[  ORDER BY 절 -- 7  ]

18. SELECT절에서 사용할 수 있는 키워드(예약어) :DISTINCT, ALL, AS
19. 예제

  1) 모든 사원정보를 조회, 확인, 검색하는 SQL 쿼리(Query)작성하기
SELECT * -- 모든 칼럼을 조회
FROM emp; -- 테이블명 또는 뷰 대상

  2) 모든 사원정보를 조회하는 SQL 쿼리(Query)작성하기
   (조건 : 사원번호, 사원명, 입사일자  만 조회)
SELECT empno, ename, hiredate
FROM emp;
  3) 모든 사원 조회( 사원번호, 사원명, 입사일자, 급여, 커미션)
    조건1 ) 급여(sal) 많이 받는 사람 순으로 점렬해서 조회
            sal 내림차순descending 정렬
SELECT empno, ename, hiredate, sal, comm
FROM emp
ORDER BY sal DESC;
ORDER BY sal (ASC) ; --정렬기준, 기본정렬 : 오름차순

   4)  모든 사원 조회
   조건 1) 부서번호, 사원번호, 사원명, 입사일자
   조건 2) 입사일자 순으로 최근 입사한 사원 먼저 출력

SELECT deptno, empno, ename, hiredate
FROM emp
ORDER BY depto, hiredate;
-- 1차 정렬: deptno부서별로 1차 오름차순 정렬
-- 2차 정렬 : hiredate 입사일자 기준으로 내림차순 정렬
ORDER BY 1 ASC, 4 DESC;  -- 부서별로 오름차순 정렬
ORDER BY hiredate DESC;
ORDER BY hiredate ASC; --오래된 순 출력됨

   5) HR 계정으로 접속 
   
   -- 오라클에서 문자열 합치는 방법 2가지
       1. || 연산자 사용
       2. concat() 함수
SELECT ename || 'has $' || sal
FROM emp;

SELECT concat ( ename, ' has $', sal)
FROM emp;

   6) 사원번호, 사원명, 입사일자, SAL(급여), COMM 출력
     sal+ comm == pay
     이름 = 별칭
     AS 키워드는 SELECT에 칼럼의 별칭을 부여할 때 사용하는 예약어
SELECT empno AS "사원번호"
         , ename AS 사원명 --쌍따옴표생략 가능
         , hiredate 입사일자 --AS 생략 가능
         , sal , comm 
         ,sal+comm   AS "월급"
         ,NVL2( sal+comm , sal+comm , sal  ) AS PAY
         ,NVL2( comm , sal+comm , sal  )
         ,sal+ NVL(comm,0)
FROM emp;
   ㄱ. 값+null => null
   ㄴ. 오라클 null 의 의미? 미확인된 값, 적용되지 않은 값
      예. 이름/ 몸무게
        홍길동 / 65.93
        김철수 / null  몸무게 측정x, 확인되지 않은 값
   ㄷ. comn 칼럼의 값이 null일 경우 처리
     결정) 0으로 처리하겠다.
   ㄹ. 오라클에서 null 처리하는 함수 : nvl2()
   
   【형식】
        NVL2(expr1, expr2, expr3)
       expr1  널이면   expr3
              널이 아니면 expr2
   【형식】
	NVL(expr1,expr2)
   널null을 0 또는 다른 값으로 변환하는 함수
   
SELECT comm
    , NVL(comm, 0)
    ,sal+NVL(comm,0) pay
FROM emp;

    7) emp 사원테이블에서 job출력
       조건1) 중복 배제 job
SELECT DISTINCT job
FROM emp;    
ORDER BY job ASC;

CLERK
SALESMAN
PRESIDENT
MANAGER
ANALYST

JOB의 종류를 파악하기 위해서 쿼리 작성
  
JOB(일)
CLERK
SALESMAN
SALESMAN
MANAGER
SALESMAN
MANAGER
MANAGER
PRESIDENT
SALESMAN
CLERK
ANALYST
CLERK

--중복X 모두 출력
SELECT ALL job
FROM emp;    
ORDER BY job ASC;

8) SCOTT 계정이 소유하는 모든 테이블 조회
   user_tables 와 tabs 같은 동의어
   
   오라클 "데이터사전"에 포함된 뷰(View) - user_tables 뷰 명
   
SELECT *
FROM user_tables;
FROM tabs;

FROM table명 또는 뷰명

9) emp사원 테이블에서 10번 부서사원 정보만 조회(확인, 검색)
   조건 1) 10번 부서원만 조회.
   조건 2) SAL+COMM급여 기준으로 오름차순 정렬
   조건 3) 부서번호, 사원명, PAY 출력

SELECT deptno, ename, sal+NVL(comm,0) pay
FROM emp
WHERE deptno = 10;
ORDER BY sal+NVL(comm,0) ASC;
--WHERE deptno == 10;  X 오류남 --오라클 같다 연산자 =

ORA-00936: missing expression
00936. 00000 -  "missing expression"
*Cause:    
*Action:
312행, 15열에서 오류 발생

CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

-- Table INSA이(가) 생성되었습니다.

INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부', 
   '부장', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부', 
   '사원', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부', 
   '부장', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부', 
   '대리', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부', 
   '사원', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부', 
   '과장', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부', 
   '대리', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',    
'사원', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부', 
   '사원', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부', 
   '부장', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부', 
   '사원', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부', 
   '사원', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부', 
   '대리', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부', 
   '사원', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부', 
   '사원', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부', 
   '과장', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부', 
   '사원', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부', 
   '사원', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부', 
   '과장', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부', 
   '사원', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부', 
   '사원', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부', 
   '대리', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부', 
   '부장', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부', 
   '대리', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부', 
   '사원', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부', 
   '과장', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부', 
   '사원', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부', 
   '사원', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부', 
   '과장', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부', 
   '부장', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부', 
   '사원', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부', 
   '사원', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부', 
   '사원', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부', 
   '사원', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부', 
   '과장', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부', 
   '대리', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부', 
   '대리', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부', 
   '대리', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부', 
   '과장', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부', 
   '사원', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부', 
   '사원', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부', 
   '사원', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부', 
   '사원', 960000 , 152000);         
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부', 
   '부장', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부', 
   '대리', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부', 
   '대리', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부', 
   '사원', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부', 
   '대리', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부', 
   '과장', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부', 
   '사원', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부', 
   '사원', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부', 
   '사원', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부', 
   '사원', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부', 
   '대리', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부', 
   '부장', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부', 
   '대리', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부', 
   '사원', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부', 
   '사원', 900000 , 102000);

COMMIT;
-----------------------
SELECT *
FROM insa;

--문제1) INSA 테이블에서 사원의 출신지역이 '서울'인 사원 정보 조회
 --     조건1) 사원번호, 이름, 입사일자, 출신지역
      
SELECT num, name, ibsadate, city
FROM insa
WHERE city = '서울' ; --조건(출신지역 서울)

--문제2) INSA 테이블에서 사원의 출신지역이 '수도권'인 사원 정보 조회
 --     조건1) 사원번호, 이름, 입사일자, 출신지역
 --     수도권? 서울, 인천, 경기
 
 -- 오라클 문자열 연결 연산자 ||
 -- 오라클 또는 연산자 OR
SELECT num, name, ibsadate, city
FROM insa
--WHERE city = '서울' OR city ='경기' OR city ='인천' 
-- IN SQL 연산자
WHERE city  IN ('서울','경기','인천' )
WHERE NOT city IN ('서울')   !부정연산자
WHERE city NOT In('서울')    not in() sql연산자
ORDER BY city ASC;


--문제3) INSA 테이블에서 사원의 출신지역이 '서울'이 아닌 사원 정보 조회
 --     조건1) 사원번호, 이름, 입사일자, 출신지역
 -- 오라클 같지않다 연산자 !=    ^=   <>  다 가능
SELECT num, name, ibsadate, city
FROM insa
WHERE NOT city = '서울';

--문제4) INSA 테이블에서 사원의 출신지역이 '수도권'이 아닌 사원 정보 조회
 --     조건1) 사원번호, 이름, 입사일자, 출신지역
 --     수도권? 서울, 인천, 경기
 
SELECT num, name, ibsadate, city
FROM insa
WHERE Not city IN ('서울','인천','경기);
;
-- 문제 5) insa 테이블에서 기본급이 150만원 이상인 사원정보 출력
-- 조건 1) 이름, basicpay
-- 조건 2) 부서별 1차정렬, basicpay정렬 오름차순

SELECT name,buseo, basicPay
FROM insa
WHERE basicPay >=1500000
ORDER BY buseo ASC, basicpay ASC ;

-- 문제 6) insa 테이블에서 기본급이 150만원 이상, 250만원 이하인 사원정보 출력
-- 조건 1) 영업부 사원만 조회
-- 조건 2) basicpay정렬 오름차순

SELECT name, buseo, basicPay
FROM insa
--WHERE buseo = '영업부' AND (basicPay >=1500000 AND basicPay <=2500000)
WHERE buseo = '영업부' AND basicPay BETWEEN 1500000 AND 2500000

ORDER BY basicPay ASC;

-- 문제 7) insa 테이블에서 기본급이 150만원 미만, 250만원 초과인 사원정보 출력
-- 조건 1) 영업부 사원만 조회
-- 조건 2) basicpay정렬 오름차순

SELECT name, buseo, basicPay
FROM insa
--WHERE buseo = '영업부' AND (basicPay  < 1500000 OR basicPay > 2500000)
--WHERE buseo = '영업부' AND NOT (basicPay BETWEEN 1500000 AND 2500000)
WHERE buseo = '영업부' AND (basicPay NOT BETWEEN 1500000 AND 2500000)

-- 문제 8) insa 테이블에서 입사년도가 1998년도인 사원정보 출력
-- 조건 1) name, ibsadate
-- 입사일 출력 형식 '98/10/11'
--IBSADATE       DATE 오라클 자료형: 날짜형
--날짜 출력 1998-01-01  /  98/01/01    /   1998.1.1

-- JAVA 문자열 잘라서 반환하는 메서드  substring(f,e)
-- 오라클 날짜 년도 반환 메서드 
SELECT name, ibsadate
FROM insa
-- WHERE ibsadate BETWEEN '1998-01-01' AND '1998-12-31'
WHERE SUBSTR (ibsadate, 0, 2) ='98'
ORDER BY ibsadate;

SELECT ibsadate
            ,SUBSTR(ibsadate, 1,2)

--오라클 연산자
--오라클 자료형
--오라클 함수

--문제 ) emp 테이블에서 comm 이 null 인 모든 사원 정보를 출력하는 쿼리 하세요
SELECT *
FROM emp
WHERE comm = 'null';


