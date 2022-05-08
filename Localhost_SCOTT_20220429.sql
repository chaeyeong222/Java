ㄱ. 트랜잭션(Transaction)이란?
    일의 처리가 완료되지 않은 중간 과정을 취소하여 일의 시작 전 단계로 되돌리는 기능
    결과가 도출되기까지의 중간 단계에서 문제가 발생하였을 경우 
    모든 중간 과정을 무효화하여 작업의 처음 시작 전 단계로 되돌리는 것
ㄴ. 모든 일의 완료를 알리는 commit과 일의 취소를 알리는 rollback이 쓰인다.
ㄷ. DML문을 실행하면 해당 트랜젝션에 의해 발생한 데이터가 
    다른 사용자에 의해 변경이 발생하지 않도록 LOCK(잠김현상)을 발생한다. 
    이 lock은 commit 또는 rollback 문이 실행되면 해제된다.
ㄹ. 트랜젝션 처리가 필요한 곳. ex. 계좌이체작업
    백경환 -> 김지민 100만원 이체
    
    1. 백경환 통장에서 update 100만원 차감하는 dml
    2. 김지민 통장에서 update 100만원 증가하는 dml
    
    1+2 -> 모두 완료 commit, 하나라도 실패하면 rollback;

   ex. 트랜젝션 처리 필요 + 트리거 생성(입고 추가되면 자동 재고도 추가)
    입고테이블        insert 15
    
    재고테이블        update 15

ㅁ. 트랜젝션 테스트 
--A user 원격으로 scott 계정에 접속

SELECT *
FROM emp;

7369	SMITH	CLERK	7902	80/12/17	800		20
1) SMITH	CLERK -> MANAGER 수정
UPDATE emp
SET job = 'MANAGER'
WHERE ename = 'SMITH';
--1 행 이(가) 업데이트되었습니다.
--DML문 실행하면 잠금 lock
--commit, rollback 전이니까 잠금해제x
commit;

2) SMITH	 MANAGER -> CLERK 수정
UPDATE emp
SET job = 'CLERK'
WHERE ename = 'SMITH';
--1 행 이(가) 업데이트되었습니다.
--commit, rollback 전이니까 잠금해제x
commit;

INSERT/UPDATE/DELETE DML문 수행 커/롤 잠금해제X

--DEAD LOCK(데드락)
--백경환 - 책상수리 중 드라이버X

--A 망치O+ 못X UPDATE 실행중
DML 사용하면 자동으로 트랜젝션 걸린다LOCK -> 커밋, 롤백 잠금해제
DDL/DCL 실행하면 트랜젝션 해제
-----------------------
--SELECT DQL문에 사용할 수 있는 절 : FOR UPDATE OF 문
SELECT *
FROM EMP
FOR UPDATE OR JOB NOWAIT;
DQL + 트랜젝션(LOCK)
--COMMIT; ROLLBACK;
---------------------------------
TCL문 - COMMIT, ROLLBACK,SAVEPOINT

COMMIT;

SELECT *
FROM DEPT;

1.삭제
SAVEPOINT sp_dept_delete;
DELETE FROM DEPT WHERE DEPTNO =50; --잠금 


2.추가
SAVEPOINT sp_dept_insert;
INSERT INTO DEPT VALUES(60,'AA','YY'); --잠금


3. 수정
SAVEPOINT sp_dept_update;
UPDATE DEPT
SET LOC = 'SEOUL' 
WHERE DEPTNO = 40;  --잠금


ROLLBACK; --모든작업 취소, 잠금해제

--삭제는 남겨두고 2개만 롤백하려면?
rollback to savepoint sp_dept_insert;
----------------------------------------------
--*****동적 sql *****
1. 동적sql? 컴파일 시에 sql문장이 확정되지 않는 경우

SELECT *
FROM 게시판테이블
if 제목검색 then
WHERE 제목 like '길동';
elsif 제목 + 내용 then
where 제목 like '길동' or 내용 like '길동';
end if;
--where 조건절 엄청 많을때
2. where 조건절, select 컬럼.. 항목이 동적으로 변하는 경우 사용
select ??
from 
where ? and ? or ??..

3. pl/sql 에서 DDL 문을 실행하는 경우
CREATE/ ALTER/ DROP + TRUNCATE

4. PL/SQL에서 ALTER SESSION /SYSTEM 명령어를 실행하는 경우 DBA X

5. 동적쿼리를사용하는 방법
  1) 원시동적쿼리 (native dynamic sql : nds)******
  2) DBMS_SQL패키지 사용 (복잡해서 사용X)
  
  exec(ute) 저장프로시저명(파라미터..);
select ename into vename 변수저장
6. 동적쿼리 실행방법
  1) execute immediate 동적쿼리문
                       INTO 변수명, 변수명 문
                       using mode(in,out,inout)파라미터, 파라미터..문
7. 동적쿼리 생성(작성) -> 실행

DECLARE
  vdsql varchar2(1000);
  vdeptno emp.deptno%type;
  vempno emp.empno%type;
  vename emp.ename%type;
  vjob emp.job%type;
  
BEGIN
  --ㄱ. 동적쿼리 작성
 vdsql :=  'SELECT deptno, empno, ename, job ';
  vdsql :=   vdsql || 'FROM emp ';
  vdsql :=  vdsql ||  'WHERE empno = 7369 ' ;

   --ㄴ. 동적쿼리 실행
execute immediate vdsql
               into vdeptno, vempno, vename, vjob;
  dbms_output.put_line(vdeptno ||','|| vempno ||','|| vename ||','|| vjob);
--EXCEPTION
END;
----------------
저장프로시저만들기
CREATE OR REPLACE PROCEDURE up_DSELEMP
(
 pempno emp.empno%type
)
is
  vdsql varchar2(1000);
  vdeptno emp.deptno%type;
  vempno emp.empno%type;
  vename emp.ename%type;
  vjob emp.job%type;
  
BEGIN
  --ㄱ. 동적쿼리 작성
  vdsql := 'SELECT deptno, empno, ename, job';
  vdsql := vdsql || 'FROM emp';
  vdsql := vdsql || 'WHERE empno=7369';
   --ㄴ. 동적쿼리 실행
EXECUTE IMMEDIATE vdsql
               INTO vdeptno, vempno, vename, vjob
               USING pempno;
  dbms_output.put_line(vdeptno ||','|| vempno ||','|| vename ||','|| vjob);
--EXCEPTION
END;
--
--저장프로시저 사용해서 동적쿼리 작성 및 실행..(insert)
CREATE OR REPLACE PROCEDURE up_DSELEMP
(
 pdname dept.dname%type
  , ploc dept.loc%type
)
is
  vdsql varchar2(1000);
  vdeptno dept.deptno%type; --50

BEGIN
  --ㄱ. 동적쿼리 작성
  vdsql := 'INSERT INTO dept';
  vdsql := vdsql || 'VALUES (:deptno, :dname, :loc)';
   --ㄴ. 동적쿼리 실행
EXECUTE IMMEDIATE vdsql 
               USING vdeptno, pdname, ploc;

  --COMMIT;
--EXCEPTION
END;
--Procedure UP_DSELEMP이(가) 컴파일되었습니다.

SELECT * FROM DEPT;
EXEC up_DSELEMP('QC','SEOUL');

4.익명프로시저를 사용해서 동적쿼리 + DDL(CREATE문)
DECLARE
  vsql varchar2(1000);
  vtableName varchar2(20);
BEGIN
  vtableName := 'tbl_nds';
   vsql := 'CREATE TABLE ' || vtableName ;
   -- vsql := 'CREATE TABLE  :tableName ' ;
   vsql := vsql || ' ( ' ;
   vsql := vsql || '         id number primary key  ' ;
   vsql := vsql || '         , name varchar2(20)  ' ;
   vsql := vsql || ' ) ' ;

 
 DBMS_OUTPUT.PUT_LINE(vsql);
 
 EXECUTE IMMEDIATE vsql;
END;
------------
예5. [OPEN FOR문] 설명? 
[동적 SQL]의 실행결과가 여러개의 레코드(행) 반환하는 [SELECT문+커서]
CREATE OR REPLACE PROCEDURE up_nds02
(
  pdeptno dept.deptno%type
)
IS
  vsql varchar2(1000);
  vrow emp%ROWTYPE;
  vcursor SYS_REFCURSOR; -- 9i  REF CURSOR
BEGIN
   vsql := 'SELECT * ';
   vsql := vsql || 'FROM emp ';
   vsql := vsql || 'WHERE deptno = :deptno ';
   
   -- X EXECUTE IMMEDIATE 동적쿼리   
   -- OPEN FOR 문 사용한다. 
   OPEN  vcursor FOR vsql USING pdeptno;
   
   LOOP
      FETCH vcursor INTO vrow;
      EXIT WHEN vcursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE( vrow.empno || ', ' || vrow.ename );
   END LOOP;
   
   CLOSE vcursor;
END;

-- Procedure UP_NDS02이(가) 컴파일되었습니다.
EXEC UP_NDS02( 30 );
EXEC UP_NDS02( 10 );


