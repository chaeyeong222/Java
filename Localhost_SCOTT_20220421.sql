논리적모델링
         
         5) 정규화(Normal Form)종류
           ㄱ. 제1정규화(1NF) : 
                    릴레이션에 속한 모든 속성의 도메인(컬럼값)이 
                    원자 값(atomic value=중복X)으로만 구성되어 있으면 제1정규형에 속한다.
                    반복되는 속성을 제거한 뒤 기본 테이블의 기본키를 추가해 새로운 테이블을 생성한다.
           ㄴ. 제2정규화(2NF) : 
              - 부분함수적 종속성 제거해서 완전 함수 종속
              - 모든 컬럼(속성)이 복합키 전체에 종속적이어야 한다.
              
              -함수적 종속성
                dept     X(deptno) Y(dname)
                          결정자      종속자
               Y는 X에 함수적 종속이다
               X->Y
              -완전 함수적 종속성
              -부분 함수적 종속성
                조건) 복합키(X+Y)에 전체적으로 의존하지 않는 속성
                
               예) 학과등록 테이블
                 PK -> [학번 + 과정코드 ]복합키
                  
                 학번  과정코드  평가코드  과정명  과정기간
                 100   A001        A    JAVA    1개월
                 100   A002        F    ASP     3개월
                 101   A001        A    JAVA    1개월
                 101   A003        C      C#    1개월
                 102   A001        A    JAVA    1개월
                  =>과정명과 과정기간은 복합키에 종속적이지 않고, 과정코드 속성에 부분함수적 종속성이 있다.
                  =>과정명, 과정기간 속성 제거( 부분함수적 종속성 제거) -> 제2정규화 -> 새로운 테이블 생성
                  
                 결과)
                  PK -> [학번 + 과정코드 ]복합키
                 학번  과정코드  평가코드  
                 100   A001        A   
                 100   A002        F  
                 101   A001        A    
                 101   A003        C   
                 102   A001        A   
                  
                  PK
                 과정코드   과정명  과정기간
                  A001     JAVA      1개월
                  A002     ASP       3개월
                  A001     JAVA      1개월
                  A003      C#       1개월
                  A001     JAVA      1개월
                  
              -이행 함수적 종속성
              
           ㄷ. 제3정규화(3NF) : 
              이행 함수적 종속성 제거
               X    ->  Y
               결정자  종속자
               Y   -> Z (Z가 일반칼럼인Y에 종속적일경우 제거)
               
               예.
               사원테이블
               PK
               empno(x) ename(y)  deptno(z)  dname(k)
               7369      홍길동       10       영업부
               
               X -> Y
               X -> Z
               z -> k (이행적 함수 종속)
               
               xyz만 사원테이블에 두고 zk는 부서테이블을 새로 생성해서 둔다
               
               
           ㄹ. BCNF :(보이스/코드 정규형[ Boyce/Codd Normal Form ])
             - 릴레이션 R이 제3정규화를 만족하고, 모든 결정자가 후보키 여야한다는 것.
             -제3정규화를 만족하는 대부분의 릴레이션(테이블)은 BCNF도 만족한다.
             
             [X+Y] 복합키
             
             Z->Y 복합키 중의 한 속성이 일반키에 종속..
             
           ㅁ. 제4정규화(4NF) : 
           ㅂ. 제5정규화(5NF) :       
     
 역정규화 : 관계 다 끊고 비식별화 관계로 설정 -> fk너무 많아서        
 제1정규화 : 중복된 데이터 제거
 제2정규화 : 부분함수적 종속성 제거
 제3정규화 : 이행적함수종속성 제거
 --------------------------------------------------------------
 [물리적 모델링]
  - 논리적 모델링 : 관계 스키마 + 정규화
  - 좀 더 효율적으로 구현하기 위한 작업과 함께 개발하려는 DBMS의 특성에 맞게 
    실제 데이터베이스 내의 개체들을 정의하는 단계
  - 데이터 사용량 분석, 업무 프로세스 분석을 통해서 보다 효율적인 데이터베이스가 되도록
    인덱스 사용, 역정규화를 수행
  --------------------------------------------------------------
  --뷰 VIEW
FROM 테이블 명 또는 뷰명
FROM             user_tables;

1. 테이블(방)을 보기 위한 창문 :뷰 VIEW
2. 뷰의 의미는 하나의 select 문과 같다
   select deptno, ename
   from emp
   where deptno=10;
3. 뷰를 통해 insert, update, delete 가 가능하지만 대부분은 select 를 위해 사용
4. 뷰는 가상테이블이다
5. 뷰는 한개 이상의 테이블 -> 뷰 생성
         또 다른 뷰      -> 뷰생성
6. 목적 : 일부만 접근할 수 있도록 제한하기 위한 기법, 보안성+편리성
7. 뷰 생성한다는 의미 : 데이터 딕셔너리(자료사전) 테이블에 뷰에 대한 정의만 저장되고
                     디스크에 저장공간이 할당되지 않는다
    예. user_Tables 뷰-> 정의 -> 자료사전
8. 뷰를 사용해서 DML + 제약조건 설정도 가능하다
9. 뷰의 종류
   ㄱ. 심플뷰 simple view   - 1개 테이블 연동
   ㄴ. 복합뷰 complex view  - 여러개 테이블 연동
10. 뷰 형식
【형식】
	CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름
		[(alias[,alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];

여기서 각각의 옵션의 의미는 다음과 같다.
옵션 설 명 
OR REPLACE 같은 이름의 뷰가 있을 경우 무시하고 다시 생성 
FORCE 기본 테이블의 유무에 상관없이 뷰를 생성 
NOFORCE 기본 테이블이 있을 때만 뷰를 생성 
ALIAS 기본 테이블의 컬럼이름과 다르게 지정한 뷰의 컬럼명 부여 
WITH CHECK OPTION 뷰에 의해 access될 수 있는 행(row)만이 삽입, 수정 가능 
WITH READ ONLY -- DML 작업을 제한(단지 읽는 것만 가능) 

   가정) 우리가 빈번히 판매량을 확인하는 쿼리 수행
   SELECT b.b_id, title, price, g.g_id, g_name, p_date, p_su
   FROM book b JOIN danga d ON b.b_id =d.b_id
               JOIN panmai p ON p.b_id =b.b_id
               JOIN gogaek g ON g.g_id =p.g_id;
   
--뷰 생성
--panView 가 없으면 생성하고 있으면 수정한다.
--오류 보고 -
--ORA-01031: insufficient privileges 권한이 없어서 뷰 생성 불가. scott 계정이 view 생성권한x
--scott계정생성 -> 로그인x -> 권한 부여
CREATE OR REPLACE VIEW panView 
         (bookid, booktitle, bookdanga, gogaekid, gogaekname, pdate, p_su) 
AS 
   SELECT b.b_id, title, price, g.g_id, g_name, p_date , p_su
   FROM book b JOIN danga d ON b.b_id =d.b_id
               JOIN panmai p ON p.b_id =b.b_id
               JOIN gogaek g ON g.g_id =p.g_id;
   
 -- View PANVIEW이(가) 생성되었습니다.
 --생성된 뷰 사용
 SELECT *
 FROM PANVIEW;
 --View PANVIEW이(가) 생성되었습니다.
 
 --권한 확인
 SELECT *
 FROM user_sys_privs;
 
 DESC PANVIEW;
 이름         널?       유형            
---------- -------- ------------- 
BOOKID     NOT NULL VARCHAR2(10)  
BOOKTITLE  NOT NULL VARCHAR2(100) 
BOOKDANGA  NOT NULL NUMBER(7)     
GOGAEKID   NOT NULL NUMBER(5)     
GOGAEKNAME NOT NULL VARCHAR2(20)  
PDATE               DATE    
 --뷰 소스 확인 
 SELECT *
 FROM user_views
 WHERE view_name = 'PANVIEW';
 
 --뷰를사용해서 전체판매금액 가져오기
 SELECT sum(p_su * bookdanga) 전체판매금액
 FROM panview;
--문제) 뷰 생성 gogaekView
--년도, 월, 고객코드, 고객명, 판매금액합(년도, 월 별) 출력하기
 panmai - p_date
 gogaek - g_id, g_name, 
 danga - price,
 
    
  CREATE OR REPLACE VIEW gogaekView
     AS 
        SELECT TO_CHAR(p_date, 'YYYY')year,TO_CHAR(p_date, 'MM')month
                ,g.g_id, g_name, SUM(p_su * price)amt
        FROM panmai p JOIN danga d ON p.b_id=d.b_id
                      JOIN gogaek g ON p.g_id=g.g_id
        GROUP BY TO_CHAR(p_date, 'YYYY'),TO_CHAR(p_date, 'MM'),g_name,g.g_id
        ORDER BY TO_CHAR(p_date, 'YYYY'),TO_CHAR(p_date, 'MM');
 어떤 뷰 있는 지 확인
 SELECT *
 FROM user_views;
 
 -- [뷰를 사용해서 DML 작업]
 
 
 CREATE TABLE testa(
  aid        number primary key
  , name    varchar2(20) not null
  , tel    varchar2(20) not null
  , memo   varchar2(100)
);       
 
CREATE TABLE testb(
   bid  number primary key
   , aid  number constraint fk_testb_aid references testa(aid) on delete cascade
   , score number(3)
); 

INSERT INTO testa (aid, NAME, tel) VALUES (1, 'a', '1');
INSERT INTO testa (aid, name, tel) VALUES (2, 'b', '2');
INSERT INTO testa (aid, name, tel) VALUES (3, 'c', '3');
INSERT INTO testa (aid, name, tel) VALUES (4, 'd', '4');

INSERT INTO testb (bid, aid, score) VALUES (1, 1, 80);
INSERT INTO testb (bid, aid, score) VALUES (2, 2, 70);
INSERT INTO testb (bid, aid, score) VALUES (3, 3, 90);
INSERT INTO testb (bid, aid, score) VALUES (4, 4, 100);

SELECT * FROM testa;
1	a	1	
2	b	2	
3	c	3	
4	d	4	

SELECT * FROM testb;
1	1	80
2	2	70
3	3	90
4	4	100
----- 심플뷰
CREATE OR REPLACE VIEW aView
AS
 SELECT aid, name, memo --tel 컬럼x
 FROM testa;
 --View AVIEW이(가) 생성되었습니다.
 
 SELECT * 
 FROM aView;
 --aView (심플)뷰를 사용해서 insert 작업
 INSERT INTO aView(aid, name, memo) VALUES (5,'f',null);
 --오류 보고 -
--ORA-01400: cannot insert NULL into ("SCOTT"."TESTA"."TEL")
--tel에 자동으로 null 들어가지므로 오류난다

CREATE OR REPLACE VIEW aView
AS
 SELECT aid, name, tel
 FROM testa;
 --View AVIEW이(가) 생성되었습니다.
  INSERT INTO aView(aid, name, tel) VALUES (5,'f','5');
  --1 행 이(가) 삽입되었습니다.
commit;

select *
from testa;

1	a	1	
2	b	2	
3	c	3	
4	d	4	
5	f	5	 --insert됨..

--복합뷰 abView
CREATE OR REPLACE VIEW abView
AS
  SELECT a.aid, name, tel, bid, score
  FROM testa a JOIN testb b ON a.aid=b.aid;
  WITH READ ONLY; --SELECT만 하겠다,INSERT, UPDATE, DELETE불가능
-----
SELECT *
FROM abView;

INSERT INTO abView( aid, name, tel, bid, score) VALUES ( 10,'X','5',20,70);
--오류남, 하나의 INSERT 문으로 동시에 두 테이블에 INSERT할 수 없다.

--수정 1테이블만 수정
UPDATE abView
SET score = 99
where bid=1;
rollback;
--한 테이블만 삭제도 가능
DELETE FROM abView
WHERE aid=1;
rollback;

--뷰삭제
DROP VIEW abview;
DROP VIEW panview;
-----------모든 뷰 삭제함------
WITH CHECK OPTION 뷰에 의해 access될 수 있는 행(row)만이 삽입, 수정 가능 
-----------
CREATE OR REPLACE VIEW bView
AS
 SELECT bid, aid, score
 FROM testb
 WHERE score >=90;
bid aid score
3	3	90
4	4	100
 
 
 SELECT *
 FROM bView;

--수정 bid=3, score =70
UPDATE bView
SET SCORE=70
WHERE bid=3;
rollback;

--bView + with check option
CREATE OR REPLACE VIEW bView
AS
 SELECT bid, aid, score
 FROM testb
 WHERE score >=90
WITH CHECK OPTION CONSTRAINT ck_bview;
--View BVIEW이(가) 생성되었습니다.

update하려니까 오류남
오류 보고 -
ORA-01402: view WITH CHECK OPTION where-clause violation
--view를 90점 이상인 애만 가져오도록 설정해놨기 때문에
--70점으로 수정할 수는 없다=> view가 가져올 수 없기때문

INSERT INTO bView(bid,aid, score) VALUES (5,4,100);
--1 행 이(가) 삽입되었습니다.
INSERT INTO bView(bid,aid, score) VALUES (6,4,87);
--오류 보고 -
--ORA-01402: view WITH CHECK OPTION where-clause violation
--90점보다 작은 애는 삽입불가
ROLLBACK;
--뷰? 가상테이블, 실제테이블 보안성, 편리성 -> SELECT, 심플뷰, 복합뷰

--물리적뷰(MATERIALIZED VIEW)
--실제 물리적으로 데이터를 저장하고 있는 뷰

--[시퀀스 SEQUENCE]
기존의 테이블에 대해 기본키PK나 유니크 키UK를 사용하여 
부가하는 일종의 새로운 컬럼처럼 사용할 수 있는 
[일련번호를 매김]하기 위한 하나의 컬럼으로 구성된 테이블

INCREMENT BY 정수 시퀀스 번호를 정수만큼씩 증가(디폴트=1) 
START WITH 정수 시작값을 지정(디폴트=1) cycle 옵션을 사용한 경우 다시 값을 생성할 때 minvalue에 설정한 값부터 시작 
MAXVALUE 정수 증가할 수 있는 최대값 
NOMAXVALUE(default) 시퀀스의 최대값이 없음을 정의, 오름차순은 10^27까지 커질 수 있고, 내림차순으로 1까지 작아질 수 있음 
MINVALUE 정수 생성할 수 있는 최소값 
NOMINVALUE(default) 시퀀스의 최소값이 없음을 정의, 오름차순은 최소 1까지, 내림차순으로 -(10^26)까지 간다. 
CYCLE 최대 또는 최소값에 도달한 후 값을 다시 생성 
NOCYCLE(default) 최대 또는 최소값에 도달한 후 값을 다시 재시작할 수 없음 
CACHE 빠른 access를 위해 시퀀스의 값을 메모리에 저장(기본 20) 
NOCACHE 어떤 시퀀스값도 캐싱되지 않음 

---***** 의사컬럼을 이용한 시퀀스의 사용
CURRVAL이 참조되기 전에 NEXTVAL이 먼저 사용되어야 한다. 
이는 pseudo 컬럼의 CURRVAL의 값은 NEXTVAL 컬럼 값을 참조하기 때문이다.
그러므로 NEXTVAL 컬럼이 사용되지 않은 상태에서 CURRVAL을 사용하면 
아무런 값이 없기 때문에 error를 출력한다.

CREATE SEQUENCE seq01
  INCREMENT BY 1 --1씩증가
  START WITH 100 --100시작
  MAXVALUE 10000
  MINVALUE 1 
  CYCLE --10000까지 갔다가 다시 1로(회전) , NOCYCLE: 최댓값가면 끝
  CACHE 20; --미리 번호표뽑아서 자리만들어놓는 갯수(성능)
--Sequence SEQ01이(가) 생성되었습니다.

CREATE SEQUENCE seq02;
--Sequence SEQ02이(가) 생성되었습니다.
--시퀀스 확인
SELECT *
FROM user_sequences;
FROM user_views;
FROM user_constraints;
FROM user_tables;
--시퀀스 삭제

DROP SEQUENCE seq01;
DROP SEQUENCE seq02;
-------
--기존의 다른 테이블에 사용--
SELECT *
FROM dept;
--부서테이블에 새로운 부서를 추가
SELECT MAX(deptno)+10 FROM dept;

INSERT INTO dept (deptno, dname, loc) VALUES ((SELECT MAX(deptno)+10 FROM dept), 'QC','SEOUL');
rollback;

--시퀀스 seq_dept
CREATE SEQUENCE seq_dept
    INCREMENT BY 10
    START WITH 50
    MAXVALUE 90
    MINVALUE 10
    NOCYCLE
    NOCACHE;
--Sequence SEQ_DEPT이(가) 생성되었습니다.

INSERT INTO dept (deptno, dname, loc) VALUES ( seq_dept.nextval, 'QC','SEOUL'||seq_dept.currval);

SELECT * FROM dept;

SELECT seq_dept.currval --지금 번호표 몇번까지 뽑았니? 60
FROM dual;

DELETE FROM dept
WHERE deptno=50; --삭제하고나면 다시 50번부터 시작 못함. 번호표 뽑으면 끝.

rollback;
----------------------
PL/SQL = SQL확장 +PL ==  Procedural Language extensions to SQL을 의미
                                절차적인 언어문법(기능)
                                 ㄱ. 변수선언
                                 ㄴ. 제어문
                                 ㄷ. 예외처리
-- PL/SQL은 블럭 구조의 언어이다
[선언 기능 블럭]
[실행 기능 블럭]
[예외 처리 블럭]
 --PL/SQL 선언형식
 [DECLARE 블럭]   -- 선언  블럭
 BEGIN 블럭 -- 실행  블럭
 [EXCEPTION] -- 예외 처리  블럭
 END -- 블럭 끝
  --*블럭내에서는 CREATEST, LEAST, DECODE 사용 불가
---------
DECLARE
BEGIN
EXCEPTION
END;
--PL/SQL의 6가지 종류
  1. 익명 anonymous 프로시저 procedure
  2. 저장 store 프로시저
  3. 저장 함수 stored fuction
  4. 패키지 package             ex. dbms_random 패키지
  5. 트리거 trigger
  6. 객체타입 Object Type
  
 
DBMS_OUTPUT 패키지
put()또는 
put_line()  정의된 문자값을 화면에 출력하는 프로세서 
NEW_LINE() GET_LINE에 의해 읽힌 행의 다음 라인을 읽을 때 사용 
GET_LINE() 또는 
GET_LINES()  현재 라인의 문자값을 읽는 프로세서 
ENABLE  화면에 문자값을 출력하는 모드로 설정하며 문자값을 지정할 수 있는 버퍼크기를 정의함 
DISABLE  화면에 문자값을 출력하는 모드로 해제함 

  
  ------------
-- ㄱ.익명프로시저 anonymous procedure ***
--실행할때 반드시 선택(블록잡아서)한 후 실행.
DECLARE 
  -- 선언문 declaration : 변수, 상수 선언
  -- 변수명 자료형(크기);
  vename VARCHAR2(10);
  vsal NUMBER(7,2);
BEGIN
  -- 실행문 statements
  SELECT       ename, sal
          INTO vename, vsal
  FROM emp
  WHERE empno = 7369;
  
  --출력
  DBMS_OUTPUT.PUT_LINE(vename);
  DBMS_OUTPUT.PUT_LINE(vsal);
--EXCEPTION
  -- 예외처리문 try-catch
END; -- ) 괄호닫음
  
--오류 보고 -
--ORA-06550: line 18, column 1:
--PLS-00103: Encountered the symbol "END" when expecting one of the following:
  --예외처리하는 블럭 주석처리하니까 해결
--  PL/SQL 프로시저가 성공적으로 완료되었습니다.

DESC emp;

--예. 이름/나이 변수에 저장 출력
DECLARE
  vname VARCHAR2(20);
  vage NUMBER(3);
BEGIN
  vname := '홍길동';
  vage := 20;
  
  DBMS_OUTPUT.PUT_LINE( vname || ',' ||vage); 
--EXCEPTION
END;
--오류 보고 -
--ORA-06550: line 5, column 9:
--PLS-00103: Encountered the symbol "=" when expecting one of the following:
-- := . ( @ % ;

--30번 부서의 지역명loc 가져와서 10번 부서의 loc로 수정
SELECT loc
FROM dept
WHERE deptno=30;

UPDATE dept
SET loc='CHICAGO'
WHERE deptno=10;
----------
DECLARE
   -- vloc   VARCHAR2(13)
     vloc dept.loc%TYPE; --타입형변수,dept테이블 loc의 자료형과 동일하게 주겠음
     
    vdeptno
BEGIN
    SELECT loc INTO vloc
    FROM dept
    WHERE deptno=30;
    
    UPDATE dept
    SET loc='CHICAGO'
    WHERE deptno=10;
    
-- EXCEPTION
END;

SELECT * FROM dept;
DESC dept;