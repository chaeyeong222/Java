1. PIVOT() 함수의 형식을 적으세요.

SELECT *
FROM (피벗대상 서브쿼리)
PIVOT( 그룹함수(집계컬럼) FOR 피벗칼럼 IN (피벗칼럼값 AS별칭))


2. emp 테이블의   각 JOB별 사원수 (피봇)

    CLERK   SALESMAN  PRESIDENT    MANAGER    ANALYST
---------- ---------- ---------- ---------- ----------
         3          4          1          3          1
         
         1) 피벗대상 서브쿼리
           SELECT job FROM emp
         2) IN (목록)
           SELECT DISTINCT job
           FROM emp;
           
SELECT *
FROM ( SELECT job FROM emp)
PIVOT ( COUNT(job) FOR job IN ('CLERK', 'SALESMAN','PRESIDENT','MANAGER','ANALYST'  ));


3. emp 테이블에서  [JOB별로] 각 월별 입사한 사원의 수를 조회 
  ㄱ. COUNT(), DECODE() 사용

JOB         COUNT(*)         1월         2월         3월         4월         5월         6월         7월         8월         9월        10월        11월        12월
--------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
CLERK              3          1          0          0          0          0          0          0          0          0          0          0          2
SALESMAN           4          0          2          0          0          0          0          0          0          2          0          0          0
PRESIDENT          1          0          0          0          0          0          0          0          0          0          0          1          0
MANAGER            3          0          0          0          1          1          1          0          0          0          0          0          0
ANALYST            1          0          0          0          0          0          0          0          0          0          0          0          1
;
SELECT job, COUNT(*)
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '01',' ')) "1월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '02',' '))"2월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '03',' '))"3월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '04',' '))"4월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '05',' '))"5월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '06',' '))"6월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '07',' '))"7월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '08',' '))"8월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '09',' '))"9월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '10',' '))"10월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '11',' '))"11월"
        ,COUNT (DECODE( TO_CHAR( hiredate, 'MM'), '12',' '))"12월"
        --EXTRACT( MONTH FROM hiredate)
FROM emp
GROUP BY job;

TO_CHAR  은 문자형태 '01'
EXTRACT 는 숫자형태 1


  ㄴ. GROUP BY 절 사용

         월        인원수
---------- ----------
         1          1
         2          2
         4          1
         5          1
         6          1
         9          2
        11          1
        12          3

8개 행이 선택되었습니다. 

SELECT TO_CHAR( hiredate, 'MM') 월, COUNT(*)인원수
FROM emp
GROUP BY TO_CHAR( hiredate, 'MM')
ORDER BY 월;
  
  ㄷ. PIVOT() 사용
  
JOB               1월          2          3          4          5          6          7          8          9         10         11         12
--------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ---------- ----------
CLERK              1          0          0          0          0          0          0          0          0          0          0          2
SALESMAN           0          2          0          0          0          0          0          0          2          0          0          0
PRESIDENT          0          0          0          0          0          0          0          0          0          0          1          0
MANAGER            0          0          0          1          1          1          0          0          0          0          0          0
ANALYST            0          0          0          0          0          0          0          0          0          0          0          1


SELECT *
FROM ( SELECT job, EXTRACT( MONTH FROM hiredate) hire_month FROM emp) 
PIVOT(  COUNT(*)  FOR hire_month IN(1,2,3,4,5,6,7,8,9,10,11,12));

SELECT JOB, EXTRACT( MONTH FROM hiredate) hire_month 
FROM emp;



4. emp 테이블에서 각 부서별 급여 많이 받는 사원 2명씩 출력
  실행결과)
       SEQ      EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- ---------- --------- ---------- -------- ---------- ---------- ----------
         1       7839 KING       PRESIDENT            81/11/17       5000                    10
         2       7782 CLARK      MANAGER         7839 81/06/09       2450                    10
         1       7902 FORD       ANALYST         7566 81/12/03       3000                    20
         2       7566 JONES      MANAGER         7839 81/04/02       2975                    20
         1       7698 BLAKE      MANAGER         7839 81/05/01       2850                    30
         2       7654 MARTIN     SALESMAN        7698 81/09/28       1250       1400         30
   ; 
 1. RANK 순위 함수
 2. TOP-N 방식
SELECT *
FROM(SELECT rank() over(partition by deptno order by sal desc) seq 
      , empno, ename, job, NVL(mgr,0) hiredate, sal, NVL(comm,0), deptno
FROM emp)t
WHERE t.seq <=2;

----
문제) EMP 테이블에서 GRADE 등급별 사원수 조회 GRADE -> SALGRADE 테이블;

SELECT *
FROM salgrade;

1	700	    1200
2	1201	1400
3	1401	2000
4	2001	3000
5	3001	9999

--1) COUNT 와 DECODE 함수 이용
/*
SELECT ename, COUNT( ( sal BETWEEN LOSAL AND HISAL) grade))
FROM emp e, dept d ;
GROUP BY grade
*/
SELECT ename, sal, losal || '~' || hisal grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;

----
SELECT COUNT(*)
   , COUNT(DECODE(grade,1,'o')) "1등급"
   , COUNT(DECODE(grade,1,'o')) "2등급"
   , COUNT(DECODE(grade,1,'o')) "3등급"
   , COUNT(DECODE(grade,1,'o')) "4등급"
   , COUNT(DECODE(grade,1,'o')) "5등급"
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal;


--2) GROUP BY 절 사용

SELECT grade||'등급' 등급 , COUNT(*)
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
GROUP BY grade
ORDER BY grade ASC;

--3) PIVOT 사용

SELECT *
FROM ( 
       SELECT deptno, grade 
       FROM emp e , salgrade s 
       WHERE sal BETWEEN s.losal AND s.hisal)
PIVOT( COUNT(*) FOR grade IN(1,2,3,4,5));

--deptno 추가하면 부서별 등급 확인할 수 있다.

--문제) emp 테이블에서 년도별 입사 사원수

1. COUNT, DECODE 함수
SELECT COUNT ( DECODE ( TO_CHAR( hiredate, 'YYYY'),1980,'O' ) ) "1980년"
        ,COUNT ( DECODE ( TO_CHAR( hiredate, 'YYYY'),1981,'O' ) )"1981년"
        ,COUNT ( DECODE ( TO_CHAR( hiredate, 'YYYY'),1982,'O' ) )"1982년"
FROM emp;

2. GROUP BY 절

SELECT TO_CHAR( hiredate, 'YYYY'), COUNT(*)
FROM emp
GROUP BY TO_CHAR( hiredate, 'YYYY')
ORDER BY TO_CHAR( hiredate, 'YYYY');

3. PIVOT 

SELECT *
FROM ( 
       SELECT EXTRACT( YEAR FROM hiredate) hire_year
       FROM emp) 
PIVOT( COUNT(*) FOR hire_year IN(1980,1981,1982) );

--마지막 피벗 문제)
-- 프로젝트 진행 중 질문
1. 테이블 생성 : TBL_PIVOT
   컬럼 : no(번호), name, jumsu

CREATE TABLE TBL_PIVOT(
    no NUMBER NOT NULL PRIMARY KEY --필수 입력(고유한 키)
    , name VARCHAR2(20) NOT NULL
    , jumsu NUMBER(3)
);
--Table TBL_PIVOT이(가) 생성되었습니다.

2. 학생의 성적 정보 추가 (INSERT)

INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 1,'박예린','90'); --KOR
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 2,'박예린','89'); --ENG
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 3,'박예린','99'); --MAT

3. 문제점: 국어, 영어, 수학 과목의 점수 저장 -> 과목별 점수 저장해야하는데 잘못 만듦
  
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 4,'안시은','56'); --KOR
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 5,'안시은','45'); --ENG
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 6,'안시은','12'); --MAT

INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 7,'김민','99'); --KOR
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 8,'김민','85'); --ENG
INSERT INTO TBL_PIVOT (no, name, jumsu) VALUES( 9,'김민','100'); --MAT

4. 조회
SELECT *
FROM TBL_PIVOT;

1	박예린	90
2	박예린	89
3	박예린	99
4	안시은	56
5	안시은	45
6	안시은	12
7	김민	    99
8	김민	    85
9	김민	    100

4. 결과물이 이렇게 나오길 원함
피벗 사용해서
번호 이름   국어 영어 수학
1   박예린  90  89  99
2   안시은  56  45  12
3    김민   99  85  100

1. 피벗 대상 서브쿼리
SELECT TRUNC( (no-1)/3)+1 no, name, jumsu 
    ,DECODE ( MOD(no,3),1,'국어',2,'영어','수학') 과목
FROM TBL_PIVOT;

IN (목록) '국어','영어','수학';

SELECT *
FROM (
        SELECT TRUNC( (no-1)/3)+1 no, name, jumsu 
            ,DECODE ( MOD(no,3),1,'국어',2,'영어','수학') subject
        FROM TBL_PIVOT
)
PIVOT( SUM(jumsu) FOR subject IN ('국어','영어','수학'))
ORDER BY no ASC;

--NO  1/2/3  1
--NO 4/5/6   2
--NO 7/8/9   3

SELECT no
    , (no-1)
    , TRUNC( (no-1)/3)+1 no
FROM TBL_PIVOT;

/* 내가한거
SELECT *
FROM ( SELECT no, name, jumsu 
    ,DECODE ( MOD(no,3),1,'국어',2,'영어','수학') 과목
FROM TBL_PIVOT   )
PIVOT( COUNT(*) FOR 과목 IN ('국어','영어','수학');

SELECT DECODE( MOD(no,3),1,'O') 국어
        ,DECODE( MOD(no,3),2,'O') 영어
       , DECODE( MOD(no,3),0,'O') 수학
FROM TBL_PIVOT;
WHERE MOD(no,3)=1;

SELECT DECODE ( MOD(tp.no,3),1,'국어',2,'영어','수학') 과목, t.name, t.jumsu
FROM ( 
SELECT name, jumsu --COUNT(*)
FROM TBL_PIVOT
)t, TBL_PIVOT tp
GROUP BY MOD(no,3);
*/
-----------
JAVA  : 난수 (임의의 수)   0.0 <=Math.random() <1.0
ORACLE : dbms_random 패키지(package)  != 자바의 패키지 개념과는 다름

PL/SQL = 확장된 SQL + PL(절차적 언어)
SELECT    dbms_random.value
    ,dbms_random.value(0, 100)   --0<= 실수 <100
    ,floor(dbms_random.value(0, 45)) + 1 lotto
    ,dbms_random.string('U', 5) --UPPER 대문자 5개
    ,dbms_random.string('L', 5) --LOWER 소문자 5개
    ,dbms_random.string('A', 5) -- 알파벳 대소문자 5개
    ,dbms_random.string('x', 5) -- 대문자+숫자5개
    ,dbms_random.string('P', 5) --대문자 + 특수문자
FROM dual;

-----
문제 150<= 정수 <=200  

SELECT dbms_random.value(0,50)
      , TRUNC (dbms_random.value *51) +150
      , TRUNC ( dbms_random.value(0,51))+150
      , TRUNC (dbms_random.value(150,201))
FROM dual;

SELECT CEIL( dbms_random.value(0,50))+150
FROM dual;
------
오라클 자료형
숫자(정수,실수) - NUMBER
날짜          - DATE(초 날짜시간) ,TIMESTAMP( 나노세컨드ns + 타임존)
문자열        - VARCHAR2  

문자자료형 char/ nchar
         varchar2 / nvarchar2
         [var]
         [n]
1. CHAR
 ㄱ. 고정 길이 문자 자료형
     char(10)
     'abc'
     10 byte = ['a']['b']['c'][][][][][][][]
 ㄴ. 1byte ~ 2000 byte 알파벳 1문자 = 1byte, 한글 1문자 = 3byte  
 SELECT VSIZE('A'), VSIZE('가')
 FROM dual;
 ㄷ. 형식
    CHAR(SIZE [BYTE|CHAR])
    
    char(3) == char(3 byte)
    char(3 char) == 3문자(알파벳, 한글)
    char == char(1) == char (1 byte)
 ㄹ.테스트
 
 CREATE TABLE tbl_char(
   aa char
   ,bb char(3)
   ,cc char(3 char)
 );
 --Table TBL_CHAR이(가) 생성되었습니다.
SELECT *
FROM tbl_char;

INSERT INTO tbl_char (aa, bb, cc ) VALUES ( 'a','kbs','kbs' );
--1 행 이(가) 삽입되었습니다.
COMMIT;     --커밋 완료.
INSERT INTO tbl_char VALUES ( '가','kbs','kbs' );
--ORA-12899: value too large for column "SCOTT"."TBL_CHAR"."AA" (actual: 3, maximum: 1)
-- 크기보다 큰 값이라 에러남

INSERT INTO tbl_char VALUES ( 'b','k','케비에' );
COMMIT;

2. NCHAR == N+CHAR == U[N]ICODE + CHAR
 ㄱ. 유니코드(unicode) 모든 언어의 1문자를 2바이트로 처리
 ㄴ. 형식
  NCHAR[(SIZE)]
 ㄷ. [고정길이] 2000바이트
 
  nchar == nchar(1) 1문자
  nchar(5)          5문자
  
 CREATE TABLE tbl_nchar(
   aa char
   ,bb char(3 char)
   ,cc nchar(3)
 );
--Table TBL_NCHAR이(가) 생성되었습니다.

INSERT INTO tbl_nchar VALUES ('a', '홍길X', '홍길동');
--1 행 이(가) 삽입되었습니다.
COMMIT;

SELECT *
FROM tbl_nchar;

3. VARCHAR2 = VAR + CHAR
    ㄱ. 가변길이, 최대 4000 바이트
    ㄴ. 형식
      VARCHAR2(size [byte|char]) 의 시노님 VARCHAR 
    ㄷ. 
      char = char(1 byte)
      varchar2 == varchar2(4000 byte)
      varchar2(10) == varchar2( 10 byte)
      varchar2(10 char)
    ㄹ. 고정길이/가변길이 차이점 설명
      char(10) == char(10 byte)
      varchar2(10) == varchar2( 10 byte)
      
      'kbs' 저장
      char [k][b][s]['']['']['']['']['']['']['']
      varchar2 [k][b][s]  --빈 공간은 버림
      
      ㅁ. 어떤 경우에 고정길이/가변길이 사용하는가?
      
      char / nchar 고정길이 : 누구나 같은 값을 가질 경우
                     ex. 주민번호 14자리 문자열, 우편번호
      varchar2 /nvarchar2 가변길이 : ex.게시글 제목

4. NVARCHAR2
 ㄱ. N(유니코드) + VAR(가변길이)
 ㄴ. 최대 4000바이트
 ㄷ. NVARCHAR2[(size)]
 ㄹ. nvarchar2 == nvarchar2 (4000)
 
5. LONG 가변길이의 문자 자료형 - 2GB
6. NUMBER[(P,S)]
  ㄱ.숫자 ( 정수, 실수)
  ㄴ. precision 정확도  - 값의 전체자릿수   1~38
     scale     규모    - 소수점 이하 자릿수 -84~127
     
     NUMBER(P) 정수
     NUMBER(P,S) 실수
  ㄷ. NUMBER == NUMBER(38,127)
  ㄹ. 테스트
CREATE TABLE tbl_number(
   kor NUMBER(3) --(-999)~(999)  원하는 것 0 <= <=100
   ,eng NUMBER(3)
   ,mat NUMBER(3)
   ,tot NUMBER(3)
   ,avgs NUMBER(5,2)
);
--Table TBL_NUMBER이(가) 생성되었습니다.
--                                                91 값으로 들어가짐 오류x
INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90.89, 85, 100 );
COMMIT;

INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90, 85, 101 );
INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90, 85, -1 );

--ORA-01438: value larger than specified precision allowed for this column
INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90, 85, 1000 );

INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90, 85, -999 );

--오류
INSERT INTO tbl_number ( kor, eng, mat) VALUES ( 90, 85, -1001);


SELECT *
FROM tbl_number;

모든 학생의 국영수 점수를 0~100 사이의 수로 수정
UPDATE tbl_number
SET kor = TRUNC( dbms_random.value(0,101))
    ,eng = TRUNC( dbms_random.value(0,101))
    ,mat = TRUNC( dbms_random.value(0,101))
    ; 
    
UPDATE tbl_number
SET tot = kor+eng+mat
    ,avgs = (kor+eng+mat)/3
    ;     
 
 COMMIT;   
 
 -- avgs 컬럼 NUMBER(5,2)  100.00
 
 UPDATE tbl_number
 SET avgs = 999.87123; 
 SET avgs = 89.12945678;  -- scale 2, 소수점 3번째 자리에서 반올림.
 SET avgs = 89.12345678; -- 오류안남 
 SET avgs = 100.00;
 SET avgs = 99999;  --오류 (크기 안맞음)
 SET avgs = 999;
 SET avgs = 89.23;
 
NUMBER(4,5)처럼 scale이 precision보다 크면, 이는 첫자리에 0이 놓이게 된다.
NUMBER(p) == NUMBER(p,0)

123.89 NUMBER( 6,-2) 100
 
 7. FLOAT(P)  == 내부적NUMBER 
 8. DATE
    - 세기, 년, 월, 일, 시, 분, 초를 저장하는 자료형
    --------
학생정보를 저장하는 테이블 : tbl_student
컬럼 : 
학번 NUMBER(7) -9999999~ 9999999 
이름 CHAR, NCHAR  고정길이 X
       , VARCHAR2, NVARCHAR2 가변길이  
    VARCHAR2 (size BYTE|CHAR)
    VARCHAR2 ( 20)
국어 NUMBER(3) -999~999
영어 NUMBER(3)
수학 NUMBER(3)
총점 NUMBER(3)
평균 NUMBER(5,2)
등수 NUMBER(3)
생일 DATE
주민번호 CHAR(14)
기타 VARCHAR2 -- 2GB 고정길이 문자

9. TIMESTAMP(n) DATE의 확장된 자료형으로 나노초까지, n: 초 밑의 자리수
  TIMESTAMP == TIMESTAMP(6)

10. 
INTERVAL YEAR[(n)] TO MONTH n=2  년과 월을 사용하여 날짜값의 기간을 저장 
INTERVAL DAY[(n1)] TO SECOND[(n2)] 

11. RAW()       2000 BYTE
    LONG RAW()  2GB
    
    이미지 파일 -> 테이블의 어떤 컬럼
    test.gif   img RAW/LONG RAW
    010101
    2진데이터
12. 2GB 이상의 2진 데이터를 저장할때는 BFILE 자료형 사용
     BFILE -> B(binary 2진데이터) + FILE(외부 파일 형식으로 저장)
     
13. LOB (Large OBject)
 ㄱ. B + LOB = BLOB 2GB이상의 2진데이터 저장
 ㄴ. C + LOB = CLOB 2GB이상의 텍스트 데이터 저장
 ㄷ. NC + LOB = NCLOB 2GB이상의 유니코드 형태의 텍스트 데이터 저장
 
 텍스트 (LONG) 이미지, 이진데이터( LONG RAW) +2GB 이상(대용량) LOB 자료형 필요
 
14. ROWID 의사 컬럼 --행을 구별할 수 있는 고유한 값
SELECT ROWID, dept.*
FROM dept;

ROWID
--------
AAAE5cAAEAAAAFMAAA	10	ACCOUNTING	NEW YORK
AAAE5cAAEAAAAFMAAB	20	RESEARCH	DALLAS
AAAE5cAAEAAAAFMAAC	30	SALES	CHICAGO
AAAE5cAAEAAAAFMAAD	40	OPERATIONS	BOSTON

------------------------------------
COUNT 함수
------------------------------------
쿼리한 행의 수를 반환한다.
COUNT(컬럼명) 함수는 NULL이 아닌 행의 수를 출력하고 COUNT(*) 함수는 NULL을 포함한 행의 수를 출력한다.

【형식】
	COUNT([* ? DISTINCT ? ALL] 컬럼명) [ [OVER] (analytic 절)]
------------------------------------
--COUNT(*) OVER( ORDER BY basicpay ASC):  질의한 행의 누적된 결과값을 반환한다.
SELECT name, basicpay
        ,COUNT(*) OVER( ORDER BY basicpay ASC)
FROM insa;

나윤균	840000	1
홍길남	875000	2
정한국	880000	6
심심해	880000	6
이성길	880000	6
유영희	880000	6
임수봉	890000	7
이남신	892000	8
김신애	900000	9
김말숙	920000	10
;

SELECT buseo, name, basicpay
        ,COUNT(*) OVER(PARTITION BY buseo ORDER BY basicpay ASC)
FROM insa;
------------------------------------
 SUM() 함수 : 누적된 합
------------------------------------
【형식】
	SUM ([DISTINCT ? ALL] expr)
               [OVER (analytic_clause)]

SELECT DISTINCT buseo
        --, name
        , SUM(basicpay) OVER (ORDER BY buseo) PS
FROM insa
ORDER BY PS ASC;

------------------------------------
 AVG() 함수 : 누적된 평균
------------------------------------

【형식】
	AVG( [DISTINCT ? ALL] 컬럼명)
	   [ [OVER] (analytic 절)]

SELECT buseo, city, basicpay
        , AVG(basicpay) OVER (PARTITION BY ORDER BY city) PS
          "지역평균 급여차"
FROM insa;

------------------------------------
테이블 생성, 수정,삭제...
------------------------------------
테이블 table 생성 :tbl_member
컬럼    컬럼명        자료형                   크기         널 허용     고유키
아이디    id      문자 /가변길이     varchar2  10          NOT NULL     PK
이름     name     문자/가변길이      varchar2  20          NOT NULL
나이     age      숫자/정수           number  3           
전화번호  tel      문자열 /고정길이     char    13 [ 3-4-4] NOT NULL
생일     birth    날짜/고정길이        date               
기타     etc      문자              varchar2  200       


【간단한 테이블 생성 형식】
    CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
      ( 
        열이름  데이터타입 [DEFAULT 표현식] [제약조건] 
       [,열이름  데이터타입 [DEFAULT 표현식] [제약조건] ] 
       [,...]  
      ); 

GLOBAL TEMPORARY : 임시테이블 생성 

 CREATE TABLE scott.tbl_member
      ( 
        id  varchar2(10) NOT NULL PRIMARY KEY
        ,name  varchar2(20) NOT NULL 
        ,age number(3)
        ,tel char(13) NOT NULL 
        ,birth date
        ,etc varchar2 (200)
      );
--Table SCOTT.TBL_MEMBER이(가) 생성되었습니다.

SELECT *
FROM tabs
WHERE table_name LIKE '%MEMBER%';

DROP TABLE tbl_member;
--Table TBL_MEMBER이(가) 삭제되었습니다.
 CREATE TABLE scott.tbl_member
      ( 
        id  varchar2(10) NOT NULL PRIMARY KEY
        ,name  varchar2(20) NOT NULL 
        ,age number(3)
        ,birth date
     );

--테이블 생성
 
 DESC tbl_member;
 
 이름    널?       유형           
----- -------- ------------ 
ID    NOT NULL VARCHAR2(10) 
NAME  NOT NULL VARCHAR2(20) 
AGE            NUMBER(3)    
BIRTH          DATE    

------------------------------------
1. 기존 tbl_member 테이블에    새로운 ( 전화번호, 기타 컬럼 추가)

ALTER TABLE tbl_member
        ADD ( 
         tel char(13) NOT NULL 
        ,etc varchar2(200)
        );
--Table TBL_MEMBER이(가) 변경되었습니다.

DESC tbl_member;

2. ETC   VARCHAR2(200) 컬럼의 자료형 수정 (크기 200->255)

ALTER TABLE tbl_member
      MODIFY (etc VARCHAR2(255) );
      
      --Table TBL_MEMBER이(가) 변경되었습니다.
DESC tbl_member;

      이름    널?       유형            
----- -------- ------------- 
ID    NOT NULL VARCHAR2(10)  
NAME  NOT NULL VARCHAR2(20)  
AGE            NUMBER(3)     
BIRTH          DATE          
TEL   NOT NULL CHAR(13)      
ETC            VARCHAR2(255) 
------------------------------------
【형식】
        ALTER TABLE 테이블명
        MODIFY (컬럼명 datatype [DEFAULT 값]
               [,컬럼명 datatype]...);

? 데이터의 type, [size]***, default 값을 변경할 수 있다.
? 변경 대상 컬럼에 데이터가 없거나 null 값만 존재할 경우에는 size를 줄일 수 있다.
? 데이터 타입의 변경은 CHAR와 VARCHAR2 상호간의 변경만 가능하다.
? ***컬럼 크기의 변경은 저장된 데이터의 크기보다 같거나 클 경우에만 가능하다.
? NOT NULL 컬럼인 경우에는 size의 확대만 가능하다.
? 컬럼의 기본값 변경은 그 이후에 삽입INSERT되는 행부터 영향을 준다.
? 컬럼이름의 [직접적인 변경]은 불가능하다.
? 컬럼이름의 변경은 서브쿼리를 통한 테이블 생성시 alias를 이용하여 변경이 가능하다.
? alter table ... modify를 이용하여 제약조건 constraint을 수정할 수 없다.

------------------------------------
ALTER TABLE 테이블 수정 DDL문
  1) 새로운 컬럼 추가 ... add
    【형식】컬럼추가
        ALTER TABLE 테이블명
        ADD (컬럼명 datatype [DEFAULT 값]
            [,컬럼명 datatype]...);
? *** 한번의 add 명령으로 여러 개의 컬럼 추가가 가능하고, 하나의 컬럼만 추가하는 경우에는 괄호를 생략해도 된다.
? *** 추가된 컬럼은 테이블의 마지막 부분에 생성되며 사용자가 컬럼의 위치를 지정할 수 없다
? 추가된 컬럼에도 기본 값을 지정할 수 있다.
? 기존 데이터가 존재하면 추가된 컬럼 값은 NULL로 입력 되고, 새로 입력되는 데이터에 대해서만 기본 값이 적용된다.

  2) 기존 컬럼을 수정 
  3) 기존 컬럼을 삭제
  4) 제약조건 추가
  5) 제약조건 삭제

------------------------------------

3. etc 컬럼명을 bigo 컬럼명으로 수정
  ㄱ. 별칭alias으로 수정
SELECT etc bigo FROM tbl_member;
  ㄴ. 필드명을 수정
ALTER TABLE tbl_member
RENAME COLUMN etc TO bigo;
--Table TBL_MEMBER이(가) 변경되었습니다.
------------------------------------

4. bigo 컬럼 삭제
        ALTER TABLE tbl_member
        DROP COLUMN bigo;

DESC tbl_member;
------------------------------------

【형식】
        ALTER TABLE 테이블명
        DROP COLUMN 컬럼명; 

? 컬럼을 삭제하면 해당 컬럼에 저장된 데이터도 함께 삭제된다.
? 한번에 하나의 컬럼만 삭제할 수 있다.
? 삭제 후 테이블에는 적어도 하나의 컬럼은 존재해야 한다.
? DDL문으로 삭제된 컬럼은 복구할 수 없다.

------------------------------------
5. tbl_member 테이블 이름을 수정 ( tbl_customer )

RENAME tbl_member TO tbl_customer;