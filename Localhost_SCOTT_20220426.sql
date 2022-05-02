--1)회원가입할때 id 중복체크하는 저장프로시저
--> emp테이블에서 empno(ID)로 가정해서 풀이
-- 출력용 파라미터 선언 0 사용가능 1 사용불가

CREATE OR REPLACE PROCEDURE up_idCheck
(
  pempno IN emp.empno%TYPE  --id
  , pemonoCheck OUT NUMBER --0 사용가능 1 사용불가
)
IS
BEGIN

   SELECT COUNT(*)INTO pemonoCheck --있으면 1 더해지고 아니면 0임
   FROM emp
   WHERE empno=pempno;      
--EXCEPTION
END;
--Procedure UP_IDCHECK이(가) 컴파일되었습니다.

DECLARE
 vempnoCheck NUMBER;
BEGIN
   UP_IDCHECK(7369, vempnoCheck);
   DBMS_OUTPUT.PUT_LINE(vempnoCheck);
END;

--문제2. 회원가입 한 후에 ID(empno)/PW(ename) 입력하고 로그인(인증)
--      로그인 성공, 실패(ID존재X, 비밀번호 X) 사유
/*
CREATE OR REPLACE PROCEDURE up_logon
(
  pempno IN emp.empno%TYPE  --id
  , pename IN emp.ename%TYPE --pw
  , plogonCheck OUT NUMBER --0 로그인성공 실패 - ( 1-id존재x, -1 id존재, 비번x)
)
IS
  vename emp.ename%TYPE;
BEGIN
   SELECT COUNT(*)INTO plogonCheck --있으면 1 더해지고 아니면 0임
   FROM emp
   WHERE empno=pempno;  
   
   IF plogonCheck !=0 THEN  --아이디 존재 (비번만 체크하면 됨)
     
      SELECT ename INTO vename
      FROM emp
      WHERE empno = pempno;
       
      IF vename = pename THEN --비밀번호까지 일치하면 로그인 성공
        plogonCheck := 0;
   ELSE
       plogonCheck := -1; --비밀번호 불일치 -1
   END IF;      --if문 안만나면 그냥 1로 체크된다
   ELSE
      plogonCheck := 1;
END IF;
--EXCEPTION
END;
*/
create or replace procedure up_idCheck
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
end;

--Procedure UP_LOGON이(가) 컴파일되었습니다.
---------------
DECLARE
 VlogonCheck NUMBER;
BEGIN
   UP_LOGON(7369, 'SMITCH', vlogonCheck)
   DBMS_OUTPUT.PUT_LINE(vempnoCheck);
END;
---------------------
--저장함수(stored function)
SELECT num, name, ssn, case mod(substr(ssn, -7,1),2)
                          when 1 then '남'
                          else '여'
                      end gender
FROM insa;
--ssn주민등록번호를 파라미터로 넘겨주면 남자/여자를 반환하는 저장 함수
--저장함수 (리턴값o)=  저장프로시저(리턴값x) 같지만 차이점: 리턴값 유무
CREATE OR REPLACE FUNCTION uf_idCheck
(
  
)
RETURN 리턴자료형
IS
BEGIN
     RETURN (리턴값);
     RETURN 리턴값;
--EXCEPTION
END;

--문제) 주민등록번호 입력받아서 성별받환하는 함수   uf_gender

CREATE OR REPLACE FUNCTION uf_gender
(
  prrn VARCHAR2
)
RETURN VARCHAR2   --남자/여자
IS
 vgender VARCHAR2(6) := '여자';
BEGIN

    IF MOD(SUBSTR(prrn, -7,1),2)=1 THEN
      vgender :='남자';
    END IF;

     RETURN vgender;
--EXCEPTION
END;

--Function UF_GENDER이(가) 컴파일되었습니다.

SELECT num, name, ssn, scott.uf_gender(ssn) gender
FROM insa;
-----------
--문제) uf_sum(10)
-- 1~10까지의 합을 반환하는 함수 + 테스트 코딩
CREATE OR REPLACE FUNCTION uf_sum
(
    pnum NUMBER
)
RETURN NUMBER
IS
    vsum NUMBER := 0;
BEGIN
    FOR vnum IN REVERSE 1 .. pnum
    LOOP
        --DBMS_OUTPUT.PUT_LINE( vnum );
        vsum := vsum + vnum;
    END LOOP;
    
    RETURN vsum;
--EXCEPTION
END;


SELECT uf_sum(10)
FROM dual;

-----
--문제) 주민등록번호 입력받아서 생년월일 (yyyy.mm.dd)로 반환하는 함수 uf_birth()
CREATE OR REPLACE FUNCTION uf_birth
(
  prrn NUMBER
)
RETURN VARCHAR2
IS
  vbirth VARCHAR2(10);
  vgender number(1);
  vcentry number(2);
  vrrn6 VARCHAR2(6);
BEGIN
   
   vrrn6 := SUBSTR(prrn, 0,6);
   vgender := SUBSTR(prrn, -7,1);
   vcentry := CASE 
             when vgender in (1,2,5,6) then 19
             when vgender in (3,4,7,8) then 20
             else 18
           END;
   vbirth := TO_CHAR (TO_DATE( CONCAT(vcentry , vrrn6)),'YYYY.MM.DD');
   RETURN vbirth;
--EXCEPTION
END;
--Function UF_BIRTH이(가) 컴파일되었습니다.

SELECT name, ssn
           , uf_birth(ssn)
FROM insa;


-- 문제) 주민등록번호 입력받아서 만나이 반환하는 함수 uf_age()

CREATE OR REPLACE FUNCTION uf_age
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
                WHEN -1 THEN  -- 생일 안지난것
                 vt_year - vb_year-1
                ELSE   -- 0, 1
                 vt_year - vb_year
            END  ;        
   RETURN vage;         
--EXCEPTION
END;
-- Function UF_AGE이(가) 컴파일되었습니다.
--
SELECT name, ssn, UF_AGE(ssn) age
FROM insa;

---------
--예제) 저장프로시저 mode: in out in out 입출력용 파라미터(매개변수)
-- 전화번호 8765-8956
--         8765 전화번호 앞자리만 출력

create or replace procedure up_tel
(
 pphone IN OUT VARCHAR2
)
IS
BEGIN
  pphone := SUBSTR(pphone, 0,4);
END;
--Procedure UP_TEL이(가) 컴파일되었습니다.

DECLARE
  vphone varchar2(9) := '8765-8956';
BEGIN
  up_tel(vphone);
  
  DBMS_OUTPUT.PUT_LINE(vphone);
END;



