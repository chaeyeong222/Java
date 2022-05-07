[PL/SQL의 패키지]
1. 관계되는 타입, 프로그램 객체, 서브프로그램(procedure, function)을 논리적으로 묶어 놓은 것은 의미
2.패키지는 ㄱ. specification  ㄴ. body 부분으로 구성
3.오라클에서 기본적으로 제공하는 패키지가 있으며, 간단히 이를 이용하면 편리하다
4.specification 부분은 type, constant, variable, exception, cursor, subprogram(저장프로시저, 저장함수) 이 선언된다. 
5. body 부분은 cursor, sub program 따위가 존재한다.
6. 호출할 때 '패키지_이름.프로시저_이름' 형식의 참조를 이용해야 한다.
----------------------------------------------------------------
1)specification 부분  
CREATE OR REPLACE PACKAGE logon_pkg 
AS 
    PROCEDURE up_idCheck 
    (
        pempno IN emp.empno%TYPE --ID
        , pempnoCheck OUT NUMBER --0(사용가능)   1(사용불가능)
    );
    procedure up_logon
    (
        pempno in emp.empno%type --id
        , pename in emp.ename%type --비밀번호 대신에 사용 
        , plogonCheck out number --로그인가능하면 0 1(id 존재x) -1 (id존재하지만 비번 틀림) 
    );
    FUNCTION uf_age
    (
      prrn VARCHAR2
    )
    RETURN NUMBER ;
END logon_pkg;

--Package LOGON_PKG이(가) 컴파일되었습니다.
2)body 부분
CREATE OR REPLACE PACKAGE BODY logon_pkg
AS
    PROCEDURE up_idCheck
    (
        pempno IN emp.empno%TYPE --ID
        , pempnoCheck OUT NUMBER --0(사용가능)   1(사용불가능)
    )
    IS
    BEGIN
        SELECT COUNT(*) INTO pempnoCheck
        FROM emp
        WHERE empno=pempno;
    --EXCEPTION
    END up_idCheck;
    procedure up_logon
    (
        pempno in emp.empno%type --id
        , pename in emp.ename%type --비밀번호 대신에 사용 
        , plogonCheck out number --로그인가능하면 0 1(id 존재x) -1 (id존재하지만 비번 틀림) 
    ) 
    is 
    vename emp.ename%type;
    begin
        select count(*) into  plogonCheck --id 존재하지 않으면 0
        from emp 
        where empno=empno;
        --id가 존재하면, 비밀번호가 맞는지 체크  
        if plogonCheck = 1 then 
            select ename into vename
            from emp
            where empno=pempno;
    
            --id존재, 비빌번호 일치 
            if vename=pename then
           plogonCheck := 0; --로그인성공 
            else  --id 존재, 비밀번호x 
            plogonCheck:= -1; --로그인 실패 
            end if;
    else 
        plogonCheck := 1;
        end if; 
    end up_logon;
    FUNCTION uf_age
    (
      prrn VARCHAR2
    )
    RETURN NUMBER 
    IS
       vischeck number(1);
       vt_year  number(4);
       vb_year  number(4);
       vage     number(3);
    BEGIN
       vischeck :=  SIGN(  TRUNC( SYSDATE ) -  TO_DATE(  SUBSTR( prrn, 3,4), 'MMDD') );
       vt_year  := TO_CHAR( SYSDATE  , 'YYYY');
       vb_year  := CASE  
                     WHEN SUBSTR( prrn, 8, 1 ) IN (1,2,5,6) THEN '1900' + SUBSTR( prrn, 1,2)
                     WHEN SUBSTR( prrn, 8, 1 ) IN (3,4,7,8) THEN '2000' + SUBSTR( prrn, 1,2)
                     ELSE                                       '1800'  + SUBSTR( prrn, 1,2)
                 END;
       vage     :=  CASE  VISCHECK
                    WHEN -1 THEN  --  깮 씪  븞吏  궃寃 
                     vt_year - vb_year-1
                    ELSE   -- 0, 1
                     vt_year - vb_year
                END  ;        
       RETURN vage;         
    --EXCEPTION
    END;
END logon_pkg;

--Package LOGON_PKG이(가) 컴파일되었습니다.
--------------------------------


SELECT NAME, ssn
   , LOGON_PKG.uf_age(ssn) age
FROM insa;

DECLARE 
 vempnoCheck NUMBER;
BEGIN
  LOGON_PKG.up_idcheck(7369,  vempnoCheck );
  DBMS_OUTPUT.PUT_LINE(vempnoCheck);
END;
------------------------------------
커서cursor + 파라미터를 이용하는 방법
---------------------
CREATE OR REPLACE PROCEDURE up_selDeptEmp
(
pdeptno dept.deptno%type
)
IS 
   vename emp.ename%type;
   vsal emp.sal%type;
   
    CURSOR cemplist(    cdeptno dept.deptno%type )IS 
    ( 
                    SELECT ename, sal
                    FROM emp
                    WHERE deptno = cdeptno );
BEGIN
 OPEN cemplist(pdeptno);
 LOOP 
    FETCH cemplist INTO vename, vsal;
    EXIT WHEN cemplist%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vename|| ','||vsal);
 END LOOP;
 CLOSE cemplist;
END;

--Procedure UP_SELDEPTEMP이(가) 컴파일되었습니다.

EXEC UP_SELDEPTEMP(30);
---------------------------------------------
*****SYS_REFCURSOR 타입(오라클 9i 이전 : REF CURSORS )
      SYS 참조 커서
---------------------------------------
--커서를 매개변수로 받아서 출력하는 저장프로시저
CREATE OR REPLACE PROCEDURE up_selInsa
( pcursor SYS_REFCURSOR)
is
  vname insa.name%type;
  vcity insa.city%type;
  vbasicpay insa.basicpay%type;
begin
   LOOP
    FETCH pcursor INTO vname, vcity, vbasicpay;
    EXIT WHEN pcursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vname ||','||vcity ||','||vbasicpay);
   END LOOP;
end;

--Procedure UP_SELINSA이(가) 컴파일되었습니다.
--위의 프로시저를 테스트
CREATE OR REPLACE PROCEDURE up_test_selInsa
is
  vcursor SYS_REFCURSOR; --커서 변수 선언
begin

  OPEN vcursor FOR SELECT name, city, basicpay FROM insa;
  UP_SELINSA(vcursor); --반복문 돌면서 fetch 하는 작업
  close vcursor;
end;

--Procedure UP_TEST_SELINSA이(가) 컴파일되었습니다.

exec up_test_selInsa;
---------------------------
CREATE OR REPLACE PROCEDURE up_selInsa
(
 pcursor OUT SYS_REFCURSOR --출력용 매개변수 커서 사용이유?
)
IS
BEGIN
  OPEN pcursor FOR SELECT name, city, basicpay FROM insa;
END;
--Procedure UP_SELINSA이(가) 컴파일되었습니다.
 --JDBC = JAVA + ORACLE
---------------------------------
pl/sql 예외처리 exception
1. pl/sql 블럭 내에서 에러를 처리하는 블럭: exception 블럭(절)
예)
CREATE OR REPLACE PROCEDURE up_exception01
(psal emp.sal%type)
IS
 vename emp.ename%type;
BEGIN
  SELECT ename INTO vename
  FROM emp
  WHERE sal = psal;
  
  DBMS_OUTPUT.PUT_LINE(psal || '=>'|| vename);
EXCEPTION
  WHEN NO_DATA_FOUND THEN   --미리 정의된 예외
     RAISE_APPLICATION_ERROR(-20002,'>QUERY DATA NOT FOUND<');
  WHEN TOO_MANY_ROWS THEN 
     RAISE_APPLICATION_ERROR(-20003,'>QUERY TOO MANY ROWS FOUND<');
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20004,'>QUERY OTHERS EXCEPTION FOUND<');
END;

--Procedure UP_EXCEPTION01이(가) 컴파일되었습니다.
------------------------
SELECT ename, sal
FROM emp;

EXEC UP_EXCEPTION01(1250);
EXEC UP_EXCEPTION01(800);

------------------------------
--미리 정의되지 않은 예외 어떻게 처리?
INSERT INTO dept VALUES (40,'QC','SEOUL');
--ORA-00001: unique constraint (SCOTT.PK_DEPT) violated (40번부서이미존재)
DUP_VAL_ON_INDEX ORA-00001 이미 입력되어 있는 컬럼 값을 다시 입력하려는 경우에 발생

--------------
INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (9999, 'adnin','CLERK',9000, SYSDATE, 950,NULL, 90);
--미리정의된 7가지 예외에 없는 예외 처리  EX. ORA-02291
--ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
-------------------
CREATE OR REPLACE PROCEDURE up_insEmp
(
pempno emp.empno%type,
pename emp.ename%type,
pjob emp.job%type,
pmgr emp.mgr%type,
phiredate emp.hiredate%type,
psal emp.sal%type,
pcomm emp.comm%type,
pdeptno emp.deptno%type
)
IS
   ve_invalid_deptno EXCEPTION;
   --예외 객체 지정(매핑)할 때 PRAGMA EXCEPTION 절 사용
   PRAGMA EXCEPTION_INIT(ve_invalid_deptno, -02291);
BEGIN
  INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
    VALUES (pempno, pename, pjob, pmgr, phiredate, psal, pcomm, pdeptno);
    COMMIT;
EXCEPTION
    WHEN ve_invalid_deptno THEN
       RAISE_APPLICATION_ERROR(-20999,'>QUERY DEPTNO FK NOT FOUND<');
    WHEN OTHERS THEN
       RAISE_APPLICATION_ERROR(-20004,'>QUERY OTHERS EXCEPTION FOUND<');

END;

--Procedure UP_INSEMP이(가) 컴파일되었습니다.

EXEC up_insEmp(9999, 'adnin','CLERK',9000, SYSDATE, 950,NULL, 90);

----------------------------
--사용자가 정의하는 예외처리 방법
SELECT *
FROM tbl_score;

CREATE OR REPLACE PROCEDURE up_exception02
(
   psal IN emp.sal%type
)
IS
   vempcount NUMBER;
   
   ve_no_emp_returned EXCEPTION;
BEGIN
   SELECT COUNT(*) INTO vempcount
   FROM emp
   WHERE sal BETWEEN  (psal-100) AND (psal+100) ;
   
   IF  vempcount = 0 THEN
      -- 강제 예외 발생         throw  new MyScoreException();
      RAISE ve_no_emp_returned;
   ELSE
      DBMS_OUTPUT.PUT_LINE('>처리 결과 : ' || vempcount );
   END IF;
EXCEPTION
   WHEN ve_no_emp_returned THEN
      RAISE_APPLICATION_ERROR(-20011, '> QUERY EMP COUNT = 0 .... <');
   WHEN OTHERS THEN
     RAISE_APPLICATION_ERROR(-20004, '> QUERY OTHERS EXCEPTION FOUND <');
END;


EXEC UP_EXCEPTION02( 500 );






