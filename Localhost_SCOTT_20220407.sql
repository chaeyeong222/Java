1. subquery 에 대해 설명하세요 ?  
  ㄱ. 하나의 SQL 문장의 절에 부속된 또 다른 select 문장,
       두 번의 질의를 수행해야 얻을 수 있는 결과를 한 번의 질의로 해결
  ㄴ.  >, >=, < , <=     + 오른쪽 (서브쿼리)
          IN SOME ANY
  ㄷ. 질의가 미지정된 값을 근거로 할 때 유용
  ㄹ. subquery는 mainquery의 조건으로 사용
     WHERE 조건절 안에 (서브쿼리) 
  ㅁ. subquery의 결과는 main outer query에 의해 사용된다
  ㅂ. subquery의 실행 순서는 subquery를 먼저 실행하고, 그 결과를 mainquery에 전달하여 실행
  ㅅ. WHERE, HAVING, INSERT문장의 INTO절,UPDATE문장의 SET절, SELECT /DELETE문장 FROM 절 에서 사용가능
  ㅇ. 서브쿼리는 ORDER BY 절을 포함할 수 없다. INLINE VIEW 에서는 사용가능(예외)
  ㅈ.
2. Inline View 에 대해 설명하세요 ?
   FROM 절 뒤에 사용되는 서브쿼리
   FROM 테이블 명, 뷰명
         (서브쿼리) 마치 테이블 처럼 사용된다.
         
3. WITH 절에 대해 설명하세요 ? 
   ㄱ. 사용될 서브쿼리 블록을 미리 선언하여 반복사용
   ㄴ. 형식     -> WITH 절 안에 WITH 절 사용 불가
    WITH 쿼리이름1 AS (SELECT 문 서브쿼리),
         쿼리이름2 AS (SELECT 문 서브쿼리),
         쿼리이름3 AS (SELECT 문 서브쿼리)
         ;
    ㄷ. 하나의 with절에 여러 개의 query block 사용이 가능하다.
    ㄹ. 서브쿼리 사용하면 성능 저하된다.(단점) 코딩은 간결, 쉬워짐.(장점)
    
4. 자료 사전( Data Dictionary ) 란 ?  user_   all_   dba_   V$  뷰
5. ROLE 이란 ?   권한을 모아놓은 것, 권한부여제거를 편리하게 하기위해 사용
        ㄱ. 롤생성 -> 권한 부여 롤-> 롤 계정에 권한 부여
        
6. 스키마( Schema ) 란 ?
7. LIKE 연산자에 대해서 설명하세요 ? 
   WHERE 컬럼명 LIKE '와일드카드 %, _(패턴)'   ESCAPE
   
8. REGEXP_LIKE() 함수에 대해서 설명하세요 ? 
  LIKE 연산자 차이점: 정규표현식을 사용
  
  REGEXP_LIKE(컬럼명, '정규표현식', 파라미터 i)
  
9. 어제까지 배운 Oracle 함수를 적고 설명하세요 .
   ㄱ. NVL()   NVL2()
   ㄴ. SUBSTR(문자열, POSITION, LENGTH)
   ㄷ. 
   ㄹ.
   ㅁ.
   ㅂ.CONCAT
   ㅅ.MOD() 나머지 구하는 함수
   등등
10. insa 테이블에서 사원들이 속한 부서명을 중복되지 않게 아래와 같이
    정렬해서 출력하세요.
   SELECT 절 키워드, AS 별칭, ALL, DISTINCT중복제거
SELECT DISTINCT BUSEO  --,name, ssn  : 3개의 칼럼이 모두 같아야 중복
FROM insa
ORDER BY buseo ASC;
    
    [출력결과]
BUSEO          
---------------
개발부
기획부
영업부
인사부
자재부
총무부
홍보부
11. insa 테이블에서 70년대생 남자사원만 아래와 같이 주민등록번호로 정렬해서 출력하세요.
키워드는 대문자 권장, 테이블명, 컬럼명은 소문자 권장

SELECT name
       -- ,ssn
        , CONCAT( SUBSTR(ssn,0,8),'******') RRN
FROM insa
WHERE REGEXP_LIKE(ssn,'^7.{5}-[13579]')  -. 알파벳대소,숫자,모든 문자의미
--WHERE REGEXP_LIKE(ssn,'^7[0-9][0-9][0-9][0-9][0-9]-[13579]')
--WHERE REGEXP_LIKE(ssn,'^7[0-9][0-9][0-9][0-9][0-9]-1[0-9][0-9][0-9][0-9][0-9][0-9]')
--WHERE REGEXP_LIKE( ssn, '^7')AND MOD( SUBSTR(ssn, -7,1),2) =1
--WHERE ssn LIKE '7%';
--WHERE SUBSTR(ssn,0,1) = '7';
ORDER BY SSN ASC;
NAME                 RRN           
-------------------- --------------
문길수               721217-1******
김인수               731211-1******
김종서               751010-1******
허경운               760105-1******
정한국               760909-1******
최석규               770129-1******
지재환               771115-1******
홍길동               771212-1******
산마루               780505-1******
장인철               780506-1******
박문수               780710-1******
이상헌               781010-1******
김정훈               790304-1******
박세열               790509-1******
이기상               790604-1******

15개 행이 선택되었습니다. 

12. insa 테이블에서 70년대 12월생 모든 사원 아래와 같이 주민등록번호로 정렬해서 출력하세요.
SELECT NAME, SSN
FROM insa
--WHERE ssn LIKE '7_12%'
WHERE REGEXP_LIKE (ssn,'^7\d12')
ORDER BY ssn;

NAME                 SSN           
-------------------- --------------
문길수               721217-1951357
김인수               731211-1214576
홍길동               771212-1022432

13. LIKE 연산자의 ESCAPE 에 대해서 설명하세요. 
  1) wildcard를 일반 문자처럼 쓰고 싶은 경우에는 ESCAPE 옵션을 사용
    ㄱ. dept 테이블 조회
     SELECT *
     FROM dept;
    ㄴ. dept 테이블 구조 확인
    DESC dept;
    
    이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)      --필수 입력사항   2자리 숫자
DNAME           VARCHAR2(14)                   14바이트 문자열
LOC             VARCHAR2(13)                   13바이트 문자열

    ㄷ. 새로운 부서를 추가 DML - INSERT문 + COMMIT, ROLLBACK 트렌젝션 쿼리
    INSERT INTO dept (deptno, dname, loc) VALUES (100, 'QC100%T','SEOUL');
    
    오류 보고 -
    ORA-01438: value larger than specified precision allowed for this column
    precision: 정밀도 P
    scale : s
    
    INSERT INTO dept (deptno, dname, loc) VALUES (40, 'QC100%T','SEOUL');
    오류 보고 -
    ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
               유일성   제약조건                      위배
               PK ==Primary Key
    INSERT INTO dept (deptno, dname, loc) VALUES (50, 'QC100%T','SEOUL');
    1 행 이(가) 삽입되었습니다.
    COMMIT;
    커밋 완료.
    
    ㄹ. 
    SELECT * 
    FROM dept;
    
    ㅁ. 데이터 수정  : DML - UPDATE문 + COMMIT, ROLLBACK
    
    30번 부서의 부서명을 SALES ->SA%LES 로 수정
      [형식]
      UPDATE 테이블명 
      SET   수정할 칼럼=수정할값, 수정할 칼럼=수정할값,수정할 칼럼=수정할값...
      [WHERE 조건식]
      
      UPDATE dept
      SET  dname = 'SA%LES'
      WHERE deptno = 30;   --WHERE 조건절이 없으면 모든 행(레코드) 수정
      COMMIT;
    ㅂ. 확인
    SELECT *
    FROM dept;
    
    --CreateLeadUpdateDelete
    ㅅ. 40부서 삭제 : DML - DELETE 문 +COMMIT         / TRUNCATE문 /
      40	OPERATIONS	BOSTON
      [형식]
      DELETE (FROM) 테이블명   --모든 행 삭제됨.WHERE 조건 없으면
      WHERE 조건식;  -- 보통 삭제할때 primary key로 삭제(중복안되므로)
      
      DELETE FROM dept
      WHERE deptno = 40;
      
      ROLLBACK;
      오라클 세션(SESSION) = 사용자 로그인 ~ 로그아웃
      오라클 인스턴스 INSTANCE =??
      
      형식)
    INSERT INTO 테이블명 (컬럼명...) VALUES (컬럼값...) 
    COMMIT;
      
   o. 문제) dept 테이블에서 부서명dname에 '%'문자를 포함하는 부서정보 출력(조회)
   ㄱ. LIKE 연산자 사용
   SELECT *
   FROM dept
   --'%와일드카드    %한문자       %와일드카드'
   --             와일드카드 제외
   WHERE dname LIKE '%\%%' ESCAPE '\';
   
   문제) 50번부서 삭제, 30번부서명 'SALES'로 수정
   DELETE FROM dept
   WHERE deptno = 50;
   --1 행 이(가) 삭제되었습니다.
   
   UPDATE dept
   --SET dname = 'SALES'
   set dname = REPLACE(dname, '%', '')   
   WHERE deptno =30;
   --1 행 이(가) 업데이트되었습니다.
   COMMIT;
   
   -- JAVA "SA%LES" -> "SALES"      "SA%LES".replace("%","")
   -- ORACLE : REPLACE('SA%LES','%','')
   --SELECT deptno, dname, loc, REPLACE('SA%LES','%','')
   --SELECT dept.*, REPLACE('SA%LES','%','')
   SELECT d.*, REPLACE('SA%LES','%','')
   FROM dept d
   WHERE dname LIKE '%\%%' ESCAPE '\';
   
   --오류: FROM keyword not found where expected
   
   문제) dept 테이블에서 부서명에 'r'문자열을 포함하면 부서번호를 1증가시키는 쿼리
   UPDATE dept
   SET deptno = deptno+1
   WHERE REGEXP_LIKE(dname, 'r', 'i');
   
      
   --integrity constraint (SCOTT.FK_DEPTNO)violated-child record found
   --    무결성     제약조건    위배된다   자식 레코드(행) 찾았다.
   
   SELECT *
   FROM dept;
   
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON

   parent           deptno(참조)        child
   dept 테이블                          emp 테이블
   부모테이블의 부서번호                 자식테이블의 부서번호(외래키,FK) 컬럼

 
    
14. emp 테이블에서
    pay(sal+comm)  1000 이상~ 3000 이하 받는  
    30부서원을 제외한 모든 사원들만 
    ename을 기준으로 오름차순 정렬해서 조회하는 쿼리를 작성하세요.  
    ㄱ. with 절 사용  
--WITH 쿼리이름 AS (서브쿼리)
WITH temp AS(
SELECT deptno, ename,   sal+NVL(comm,0) pay
FROM emp
--WHERE deptno !=30   여기에 써도 됨
)
SELECT t.*
FROM temp t
WHERE t.pay BETWEEN 1000 AND 3000  AND t.deptno !=30;

    ㄴ. inline view 사용
SELECT t.*
FROM (
    SELECT deptno, ename,   sal+NVL(comm,0) pay
    FROM emp
    WHERE deptno !=30
) t
WHERE t.pay BETWEEN 1000 AND 3000;


    ㄷ. 일반 쿼리 사용.
SELECT deptno, ename,   sal+NVL(comm,0) pay
FROM emp
WHERE (sal+NVL(comm,0)BETWEEN 1000 AND 3000 )AND deptno !=30
ORDER BY ename ASC;

    DEPTNO ENAME             PAY
---------- ---------- ----------
        10 MILLER           1300
        10 CLARK            2450
        20 JONES            2975
        20 FORD             3000

15. insa테이블에서 ssn 컬럼을 통해서 year, month, date, gender 출력

  SSN          YEAR MONTH DATE GENDER  
---------- ------ ---- ----- -----
771212-1022432	77	12	12	1
801007-1544236	80	10	07	1
770922-2312547	77	09	22	2
790304-1788896	79	03	04	1
811112-1566789	81	11	12	1
:
60개 행이 선택되었습니다. 

SELECT ssn
       ,SUBSTR(ssn, 0 ,2 ) year
       ,SUBSTR(ssn, 3 ,2 ) month
       ,SUBSTR(ssn, 5 ,2 ) "DATE"  --쌍따옴표 주면 ㄱㅊ
       --,SUBSTR(ssn, 5 ,2 ) date   -> date미리 사용되고 있는 예약어라서 오류: 날짜자료형
    ,SUBSTR(ssn, 8 ,1 ) gender
FROM insa;
--00923. 00000 -  "FROM keyword not found where expected"

16. emp 테이블에서 입사년도 컬럼에서 년,월,일 찾아서 출력
    ㄱ. 년도 찾을 때는 TO_CHAR() 함수 사용
    ㄴ. 월 찾을 때는 SUBSTR() 함수 사용
    ㄷ. 일 찾을 때는 EXTRACT() 함수 사용
    
ENAME      HIREDATE YEAR MONTH DATE
---------- -------- ---- -- --
SMITH      80/12/17 1980 12 17
ALLEN      81/02/20 1981 02 20
WARD       81/02/22 1981 02 22
JONES      81/04/02 1981 04 02
MARTIN     81/09/28 1981 09 28
BLAKE      81/05/01 1981 05 01
CLARK      81/06/09 1981 06 09
KING       81/11/17 1981 11 17
TURNER     81/09/08 1981 09 08
JAMES      81/12/03 1981 12 03
FORD       81/12/03 1981 12 03
MILLER     82/01/23 1982 01 23

12개 행이 선택되었습니다. 
-- JAVA : Date, Calendar, LocalDate, LocalDateTime
-- ORACLE : DATE, TIMESTAMP
-- TO_CHAR(날짜칼럼, '형식FORMATT', ,[NLS PARAM])

SELECT ename, hiredate
          ,TO_CHAR(hiredate, ) year
FROM emp;

--RR 과 YY기호의 차이점
      '97/01/12'    '03/12/21'
RR    1997/01/12      2003/12/21
YY    2097/01/12     2003/12/21
        2000년대(SYSDATE)

문제) 현재 시스템의 날짜/시간 정보를 얻어오는 코딩
--JAVA : Date d =  new Date();   d.toLocalString();
--       Calendar c = Calendar.getInstance();    c.toString();
--Oracle : SYSDATE 함수


--2000년대 21세기
SELECT  SYSDATE,hiredate
            , TO_CHAR(hiredate, 'yyyy') year
            , SUBSTR(hiredate, 4,2) month
            , EXTRACT(DAY FROM hiredate ) "DATE"
FROM emp;   --4개의 행 레코드



17. emp 테이블에서 직속상사(mgr)가 없는  사원의 정보를 조회하는 쿼리 작성.
SELECT empno, ename, NVL(mgr,0)
FROM emp
WHERE mgr IS NULL;

     EMPNO ENAME             MGR
---------- ---------- ----------
      7839 KING                0
      
18. 모든 롤( ROLE ) 확인
19. RESOUCE 롤의 모든 권한 확인
20. scott 계정이 부여받은 롤 확인

21. YY와 RR의 차이점에 대해서 설명하세요 . 

22. emp 테이블에서 사원이름에   'la' 문자열을 포함하는 사원 정보 출력
   ㄱ. LIKE 사용
   WHERE ename LIKE '%' || UPPER('la') || '$'
   WHERE ename LIKE  UPPER('%la%')
   ㄴ. REGEXP_LIKE() 사용
   WHERE REGEXP_LIKE (ename, 'la',i)
   
    DEPTNO ENAME     
---------- ----------
        30 BLAKE     
        10 CLARK    

23. hr 계정으로 접속
    employees 테이블에서 first_name, last_name 이름 속에 'ev' 문자열 포함하는 사원 정보 출력
    
FIRST_NAME           LAST_NAME         NAME                NAME                                                                                                                                                                                    
-------------------- ------------- ------------- ----------------------
Kevin                Feeney          Kevin Feeney        K[ev]in Feeney                                                                                                                                                                          
Steven               King            Steven King         St[ev]en King                                                                                                                                                                           
Steven               Markle          Steven Markle       St[ev]en Markle                                                                                                                                                                         
Kevin                Mourgos         Kevin Mourgos       K[ev]in Mourgos                                                                                                                                                                         
 


 --확인 --
 
 SELECT *
 FROM dept;
--부서추가   50, 아름다운 부서, 서울
INSERT INTO dept (deptno, dname, loc) VALUES ( 50, '아름다운 부서', '서울');

--오류 보고 -
ORA-12899: value too large for column "SCOTT"."DEPT"."DNAME" (actual: 19, maximum: 14)
INSERT INTO dept (deptno, dname, loc) VALUES ( 50, '아름다운부서', '서울');

DESC dept;
DNAME           VARCHAR2(14)   -- 14바이트 문자열 한글 4문자까지만 가능 
한글 6문자 =18바이트
한글 1문자 = 3바이트

--VSIZE() 함수  몇 바이튼지 확인하는 함수
SELECT VSIZE('아')  --3바이트
        ,VSIZE('아름다운부서')  --18바이트
        ,VSIZE('A')   --1바이트
FROM dual;


--문제) dept 테이블 40,50,60,70 부서 삭제    -> PL/SQL
   DELETE FROM dept    WHERE deptno = 40;
   DELETE FROM dept    WHERE deptno = 50;
   DELETE FROM dept    WHERE deptno = 60;
   DELETE FROM dept    WHERE deptno = 70;
   
   --
   DELETE FROM dept 
   WHERE deptno = 40 OR deptno = 50 OR deptno = 60 OR deptno = 70;
   --
   DELETE FROM dept
   WHERE deptn IN (40,50,60,70);
   --
   DELETE FROM dept
   WHERE deptno BETWEEN 40 AND 70;
   
   --문제) insa 테이블에서 연락처(tel)가 없는 사원은 '연락처등록안됨'출력하는 쿼리
SELECT num, name, tel
        ,NVL(tel,'연락처등록안됨')
FROM insa
WHERE tel IS NULL;

   --문제) insa 테이블에서 num, name, tel 컬럼 출력할 때 연락처(tel)없는 사람은 x
                                                              있는 사람은 o
          조건) 개발부만                      
SELECT num, name 
     ,NVL2(tel,'O','X') tel
FROM insa
WHERE buseo LIKE '%개발%';

--[오라클 연산자]

--[오라클 함수]

--[오라클 자료형]
1. 비교연산자   where 절에서 사용    숫자, 날짜, 문자    true, false, null
           > >= < <= != ^= <>
SELECT 3>5
FROM dept;
  --LOB는 비교 연산자를 사용할 수 없지만, PL/SQL에서는 CLOB 데이터를 비교할 수 있다
  -- ANY, SOME, ALL  SQL 연산자

2. 논리연산자 : WHERE 절에서 사용, AND , OR, NOT 연산자  true, false, null
3. SQL 연산자 : [NOT] IN (list)
           [NOT] BETWEEN  a AND b
           [NOT] LIKE 
           IS [NOT] NULL
  ANY, SOME, ALL  SQL 연산자 + 비교연산자
  [NOT] EXISTS          SQL 연산자      WHERE   (서브쿼리  존재하면 TRUE)
   == [NOT] IN
4. null 연산자
   is null    is not null
   
5. 연결 연산자 concat
6. 산술 연산자  + - * /   나머지 구하는 !함수! mod()

의문점 :  dual ?
SELECT 5+3
       ,5-3
       ,5*3
       ,5/3
       ,MOD(5,3)
FROM dual;

SELECT  --5/0  오류 divisor is equal to zero
        --5.0/0
        MOD(5,0)     --5
        ,MOD(5.0,0)  --5
FROM dual;
  
***[dual]이란?***
1. SYS관리자 계정이 소유하고 있는 테이블( 오라클 표준 테이블)
2. 행 1 개, 컬럼1개인 DUMMY 테이블
DESC dual;
DUMMY 컬럼 VARCHAR2(1)
3. 일시적으로 날짜나 산술 연산할 때 사용함
--원래는 이렇게 써야하는데
SELECT SYSDATE, CURRENT_DATE --22/04/07   22/04/07
            ,CURRENT_TIMESTAMP --22/04/07 16:15:48.000000000 ASIA/SEOUL
FROM sys.dual;

4. 스키마.테이블명( sys.dual) -> PUBLIC 시노님 (SYNONYM) 설정했기 때문에
SELECT SYSDATE
FROM dual;
5. dual 테이블은 오라클 설치하면 자동으로 만들어지는 테이블이다
오라클함수 : 루트4==2==sqrt(4)

--SYNONYM 시노님 이란?
1. HR 접속해서 
SELECT * 
FROM emp;

2. public 생략하면 private 시노님
【형식】
	CREATE [PUBLIC] SYNONYM [schema.]synonym명
  	FOR [schema.]object명;
3. PUBLIC 시노님은 모든 사용자가 접근 가능하기 때문에 생성 및 삭제는 오직 DBA만이 할 수 있다.
4. 시노님 생성 순서

1) SYSTEM 권한으로 접속한다.
2) PUBLIC 옵션을 사용하여 시노님을 생성한다.
3) 생성된 시노님에 대해 객체 소유자로 접속한다.
4) 시노님에 권한을 부여한다.

 GRANT SELECT ON emp TO HR; 
 --Grant을(를) 성공했습니다.

5. 시노님 삭제
【형식】
	DROP [PUBLIC] SYNONYM synonym명;
 ------------------------
 6.
 --FLOOR() 함수와 ROUND() 함수의 차이점
 --MOD       :n2 - n1 * FLOOR(n2/n1)  절삭함수
 --REMAINDER :n2 - n1 * ROUND(n2/n1)  반올림함수
 
 SELECT MOD(5,2)   --  **얘만 씀
       ,REMAINDER(5,2)
 FROM dual;
 
7. SET 집합 연산자
  ㄱ.UNION 연산자 - 합집합

SELECT deptno, empno, ename, job
FROM emp
WHERE deptno = 20
UNION
SELECT deptno, empno, ename, job
FROM emp
WHERE job = 'MANAGER';

--결과 5명
10	7782	CLARK	MANAGER
20	7369	SMITH	CLERK
20	7566	JONES	MANAGER
20	7902	FORD	ANALYST
30	7698	BLAKE	MANAGER

SELECT deptno, empno, ename, job
FROM emp
WHERE deptno = 20;

--3명
20	7369	SMITH	CLERK
20	7566	JONES	MANAGER
20	7902	FORD	ANALYST

SELECT deptno, empno, ename, job
FROM emp
WHERE job = 'MANAGER';

--3명
20	7566	JONES	MANAGER
30	7698	BLAKE	MANAGER
10	7782	CLARK	MANAGER
  
  ㄴ.UNION ALL 연산자 - 합집합+ALL
  ㄷ.INTERSECT 연산자  - 교집합
  ㄹ.MINUS 연산자      -차집합
    
