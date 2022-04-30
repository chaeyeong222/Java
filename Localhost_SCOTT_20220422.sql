--------------------------------------------------------
--  파일이 생성됨 - 금요일-4월-22-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table T_SAMPLE
--------------------------------------------------------

  CREATE TABLE "SCOTT"."T_SAMPLE" 
   (   "S_ID" NUMBER, 
   "S_NAME" VARCHAR2(20 BYTE), 
   "S_ODATE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "SCOTT"."T_SAMPLE"."S_ID" IS '샘플ID';
   COMMENT ON COLUMN "SCOTT"."T_SAMPLE"."S_NAME" IS '샘플명';
   COMMENT ON COLUMN "SCOTT"."T_SAMPLE"."S_ODATE" IS '구입일';
   COMMENT ON TABLE "SCOTT"."T_SAMPLE"  IS '샘플';
REM INSERTING into SCOTT.T_SAMPLE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_T_SAMPLE
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCOTT"."PK_T_SAMPLE" ON "SCOTT"."T_SAMPLE" ("S_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table T_SAMPLE
--------------------------------------------------------

  ALTER TABLE "SCOTT"."T_SAMPLE" ADD CONSTRAINT "PK_T_SAMPLE" PRIMARY KEY ("S_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "SCOTT"."T_SAMPLE" MODIFY ("S_ID" NOT NULL ENABLE);
  
  SELECT * FROM t_sample;
  ---------------------------------------------------------
  T_MEMBER 회원
  T_POLL 설문
  T_POLLSUB 설문항목
  T_VOTER 투표
  -----------------------------------
  회원
  1. 회원 가입/탈퇴/수정
CREATE SEQUENCE seq_member
INCREMENT BY 1
START WITH 1
MAXVALUE 9999
NOCACHE;
  
  
 INSERT INTO T_MEMBER ( MemberSeq, MemberID, MemberPasswd, MemberName,MemberPhone, MemberAddress  )
VALUES  (seq_member.nextval, 'admin','1234','관리자','010-1111-1111','서울 강남구');
   INSERT INTO T_MEMBER ( MemberSeq, MemberID, MemberPasswd, MemberName,MemberPhone, MemberAddress  )
VALUES  (seq_member.nextval, 'hong','1234','홍길동','010-2222-2222','경기도 남양주');
 INSERT INTO T_MEMBER ( MemberSeq, MemberID, MemberPasswd, MemberName,MemberPhone, MemberAddress  )
VALUES  (seq_member.nextval, 'kim','1234','김기수','010-3333-3333','서울 양천구');
  
  SELECT *
  FROM t_member;
  
  2. 설문등록(작성)/ 수정/ 삭제
CREATE SEQUENCE seq_poll;
--Sequence SEQ_POLL이(가) 생성되었습니다.
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )  
  VALUES (seq_poll.nextval, '좋아하는 여배우?'
           ,TO_DATE('2022-03-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,TO_DATE('2022-03-15 18:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,5
           ,0
           ,TO_DATE('2022-02-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,1
           );
INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )  
  VALUES (seq_poll.nextval, '좋아하는 과목?'
           ,TO_DATE('2022-04-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,TO_DATE('2022-05-01 18:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,4
           ,0
           ,TO_DATE('2022-04-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,1
           );
 INSERT INTO T_POLL (PollSeq,Question,SDate, EDAte , ItemCount,PollTotal, RegDate, MemberSEQ )  
  VALUES (seq_poll.nextval, '5월5일 휴강 찬반?'
           ,TO_DATE('2022-05-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,TO_DATE('2022-05-04 18:00:00', 'YYYY-MM-DD HH24:MI:SS')
           ,2
           ,0
           ,SYSDATE
           ,1
           );          
 COMMIT; 
 
 SELECT * FROM t_poll;
 
 --세부항목 추가 쿼리 작성
 CREATE SEQUENCE seq_pollsub;
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'배슬기',0,1 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'김옥빈',0,1 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'아이유',0,1 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'김선아',0,1 );

INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'수학',0,2 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'국어',0,2 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'영어',0,2 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'사회',0,2 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'과학',0,2 );

INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'찬성',0,3 );
INSERT INTO T_PollSub (PollSubSeq , Answer , ACount , PollSeq  )  
VALUES  (seq_pollsub.nextval,'반대',0,3 );

COMMIT;

SELECT * FROM t_pollsub;
  3. 설문 목록 페이지 = 쿼리
--번호/ 질문/ 작성자/ 시작일/종료일/항목수/참여자수/상태

SELECT pollseq, question, membername, sDate, edate
  , itemcount, polltotal
  , CASE
      WHEN SYSDATE > edate  THEN '종료'
      WHEN SYSDATE BETWEEN sdate AND edate  THEN '진행중'
      ELSE '시작전'
    END   state
FROM t_poll p JOIN t_member m ON p.memberseq = m.memberseq;

  4. 설문 투표/ 수정. 취소
CREATE SEQUENCE seq_vector;
--1
INSERT INTO t_voter (VectorSeq , UserName,RegDate, PollSeq,PollSubSeq, MemberSeq)   
  VALUES (seq_vector.nextval, '홍길동', SYSDATE,1,3 ,2);
--2
UPDATE t_poll
SET polltotal = polltotal+1
WHERE pollseq = 1;
--3
UPDATE t_pollsub
SET acount = acount +1
WHERE pollsubseq =3;

--1
INSERT INTO t_voter (VectorSeq , UserName,RegDate, PollSeq,PollSubSeq, MemberSeq)   
  VALUES (seq_vector.nextval, '김기수', SYSDATE,1,3 ,2);
--2
UPDATE t_poll
SET polltotal = polltotal+1
WHERE pollseq = 1;
--3
UPDATE t_pollsub
SET acount = acount +1
WHERE pollsubseq =3;

--1
INSERT INTO t_voter (VectorSeq , UserName,RegDate, PollSeq,PollSubSeq, MemberSeq)   
  VALUES (seq_vector.nextval, '관리자', SYSDATE,1,2 ,2);
--2
UPDATE t_poll
SET polltotal = polltotal+1
WHERE pollseq = 1;
--3
UPDATE t_pollsub
SET acount = acount +1
WHERE pollsubseq =2;


SELECT * FROM t_voter;
SELECT * FROM t_poll;
SELECT * FROM t_pollsub;
COMMIT;
  5. 설문투표 결과보기
 --1
 SELECT COUNT(*)
 FROM t_voter
 WHERE pollseq =1;
  --1-2.참여자수
SELECT polltotal
FROM t_poll
WHERE pollseq =1;

----
SELECT question, answer
    ,RPAD(' ',v+1,'#') ||acount || '(' || v||')'
FROM (
SELECT question, answer, acount, polltotal
       , ROUND( acount/polltotal *100)v
FROM t_pollsub s JOIN t_poll p ON s.pollseq = p.pollseq
WHERE p.pollseq=1
)t;
  
  ---선언, 실행, 예외 블럭
DECLARE
  vname varchar2(20);
  vage number(3) :=20;
BEGIN
  vname := '홍길동';
  vage :=20;
  
  DBMS_OUTPUT.PUT_LINE(vname || ','||vage);
--EXCEPTION
  --예외처리
END;
------------------
문제) 10번 부서원 중에 급여을 가장 많이 받는 사원의 정보를 출력하는 익명프로시저 만들기
 empno, deptno, ename, job, mgr, hiredate, pay(sal+comm)
 
 SELECT empno,deptno, ename,job, mgr, hiredate,pay
 FROM (
         SELECT empno, e.deptno, ename, job, mgr, hiredate, sal+NVL(comm,0)pay
            ,rank() over (order by sal+NVL(comm,0)DESC) r
 FROM emp e JOIN dept d ON e.deptno= d.deptno
 WHERE d.deptno=10
 )t
 WHERE t.r=1;
 -----------------
 SELECT empno, deptno, ename, job, mgr, hiredate, sal+NVL(comm,0)pay
 FROM emp
 WHERE deptno=10 AND sal+NVL(comm,0) = (
 SELECT MAX(sal+NVL(comm,0) )maxpay
 FROM emp
  WHERE deptno=10
 );
 -----------------
 
DECLARE
  vname varchar2(20);
  vage number(3) :=20;
BEGIN
  vname := '홍길동';
  vage :=20;
  
  DBMS_OUTPUT.PUT_LINE(vname || ','||vage);
--EXCEPTION
  --예외처리
END;
 
 
 -----
 DECLARE
   vempno NUMBER(4);
   vdeptno NUMBER(2);
   vename emp.ename%TYPE; --타입형 변수
   vjob emp.job%TYPE;
   vmgr emp.mgr%TYPE;
   vhiredate emp.hiredate%TYPE;
   vpay NUMBER;
 BEGIN
    SELECT empno, deptno, ename, job, mgr, hiredate, sal+NVL(comm,0)pay
       INTO vempno, vdeptno, vename, vjob, vmgr, vhiredate, vpay
 FROM emp
 WHERE deptno=10 AND sal+NVL(comm,0) = (
                                     SELECT MAX(sal+NVL(comm,0) )maxpay
                                     FROM emp
                                      WHERE deptno=10);
 DBMS_OUTPUT.PUT_LINE( vempno  || ', ' || vename  || ', ' ||  vjob  || ', ' || vmgr  || ', ' ||  vhiredate  );        
 --EXCEPTION
 END;
 
 -------------------
  DECLARE
   vempno NUMBER(4);
   vdeptno NUMBER(2);
   vename emp.ename%TYPE; --타입형 변수
   vjob emp.job%TYPE;
   vmgr emp.mgr%TYPE;
   vhiredate emp.hiredate%TYPE;
   vpay NUMBER;
   
   vmax_pay NUMBER;
 BEGIN
 --1
 SELECT MAX(sal+NVL(comm,0) )INTO vmax_pay
 FROM emp
 WHERE deptno=10;
 --2
    SELECT empno, deptno, ename, job, mgr, hiredate, sal+NVL(comm,0)pay
       INTO vempno, vdeptno, vename, vjob, vmgr, vhiredate, vpay
 FROM emp
 WHERE deptno=10 AND sal+NVL(comm,0) = vmax_pay;
 DBMS_OUTPUT.PUT_LINE( vempno  || ', ' || vename  || ', ' ||  vjob  || ', ' || vmgr  || ', ' ||  vhiredate  );        
 --EXCEPTION
 END;
 -----------------------
-- emp테이블 한 행(레코드) 전체 저장할 변수 선언
   DECLARE
   vemprow emp%ROWTYPE;
   vpay NUMBER;
   vmax_pay NUMBER;
 BEGIN
 --1
 SELECT MAX(sal+NVL(comm,0) )INTO vmax_pay
 FROM emp
 WHERE deptno=10;
 --2
    SELECT empno, deptno, ename, job, mgr, hiredate, sal+NVL(comm,0)pay
       INTO vemprow.empno, vemprow.deptno, vemprow.ename, vemprow.job, vemprow.mgr, vemprow.hiredate, vpay
 FROM emp
 WHERE deptno=10 AND sal+NVL(comm,0) = vmax_pay;
 DBMS_OUTPUT.PUT_LINE( vemprow.empno  || ', ' || vemprow.ename  || ', ' ||  vemprow.job  || ', ' || vemprow.mgr  || ', ' ||  vemprow.hiredate  );        
 --EXCEPTION
 END;
 
 ------------------------
 --오류 보고: exact fetch returns more than requested number of rows
 -- 요청된 행보다 더 많은 행이 반환된다.
 --처리결과가 여러개의 행을 반환할 경우에는 반드시 커서cursor를 사용해야 한다.
 
 DECLARE
  vename emp.ename%TYPE;
  vjob emp.job%TYPE;
 BEGIN
     SELECT ename, job --12명사원 ==12row(행)
       INTO vename, vjob
     FROM emp;
     --WHERE empno=7369;
     DBMS_OUTPUT.PUT_LINE(vename ||','||vjob);
 --EXCEPTION
 END;
 ----------------------
 --PL/SQL제어문~
-- JAVA
  if(조건식) {
  }
  
--  PLSQL
      IF(조건식) THEN
      IF 조건식 THEN  
      END IF;
  
--  JAVA
  if문
 -- PLSQL 
      IF(조건식) THEN
      --
      ELSE
      --
      END IF;
 -- 자바
 if() else if()~

 --PLSQL
     IF (조건식) THEN
     ELSIF(조건식)THEN
     ELSE
     END IF;
  -------------문제) 변수를 하나 선언해서 정수를 입력받아서 짝수/홀수 출력
  
  DECLARE
    vnum NUMBER := 0;
    vresult VARCHAR2(20);
  BEGIN
    vnum  :=         :bindNumber; --바인딩변수
    IF MOD((vnum),2)=0 THEN 
       vresult := '짝수';
    ELSE
       vresult := '홀수';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(vresult);
  --EXCEPTION
  END;
  
  ---------------
  --국어점수 입력받아 수우미양가 출력하는 익명프로시저 작성하기
  
  DECLARE
    vkor NUMBER(3) := 0; 
    vgrade VARCHAR2(3);
  BEGIN
     vkor :=  :bindKor;
     
     IF vkor >=90 THEN
        vgrade := '수';
     ELSIF vkor >=80 THEN
         vgrade := '우';
     ELSIF vkor >=70 THEN
        vgrade := '미';
     ELSIF vkor >=60 THEN
        vgrade := '양';
     ELSE 
         vgrade := '가';
     END IF;
     
     DBMS_OUTPUT.PUT_LINE(vgrade);
  --EXCEPTION
  END;
  --------------------
    DECLARE
    vkor NUMBER(3) := 0; 
    vgrade VARCHAR2(3);
  BEGIN
     vkor :=  :bindKor;
     
     vkor := TRUNC(vkor/10);
     
    CASE vkor
      WHEN 10 THEN vgrade :='수';
      WHEN 9 THEN vgrade :='수';
      WHEN 8 THEN vgrade :='우';
      WHEN 7 THEN vgrade :='미';
      WHEN 6 THEN vgrade :='양';
      ELSE vgrade :='가';
      END CASE;
     
     DBMS_OUTPUT.PUT_LINE(vgrade);
  --EXCEPTION
  END;
  
  ----PL/SQL FOR문
  
FOR counter변수 IN [REVERSE] 시작값,, 끝값
LOOP
  //반복처리할 코딩
END LOOP;

FOR   IN 시작.. 끝
LOOP
END LOOP;

--------문제. 1-10 까지의 합
DECLARE
   vi NUMBER;
   vsum NUMBER := 0;
BEGIN
  FOR  vi IN 1..10
  LOOP
    vsum := vsum + vi;
    IF vi=10 THEN dbms_output.put(vi);
    ELSE dbms_output.put(vi || '+');
    END IF;
    
  END LOOP;
   dbms_output.put_line('=' || vsum);
--EXCEPTION
END;
--------------------
--조건맞으면 끝내고 아니면 무한루프
LOOP

   EXIT WHEN 조건 --break
END LOOP;
--------------------
--조건이 참일동안 루프 반복
WHILE (조건)
LOOP

END LOOP;
------------------
--1~10 까지 합을 출력
1) LOOP END LOOP;문

DECLARE
  vi NUMBER :=1;
  vsum NUMBER :=0;
BEGIN

   LOOP 
        EXIT WHEN (vi =11);
        dbms_output.put(vi || '+');
        vsum := vsum+vi;
        vi := vi+1;
   END LOOP;
         dbms_output.put_line('=' || vsum);
--EXCEPTION
END;


2) WHIL ELOOP END LOOP; 문

DECLARE
  vi NUMBER :=1;
  vsum NUMBER :=0;
BEGIN
   WHILE(vi <=10)
   LOOP 
        dbms_output.put(vi || '+');
        vsum := vsum+vi;
        vi := vi+1;
   END LOOP;
         dbms_output.put_line('=' || vsum);
--EXCEPTION
END;
-------------
문제 : 구구단 출력
--1) for 2 개
DECLARE
  --vi NUMBER(1) :=1;  --FOR문에 사용되는 반복변수는 선언하지 않아도 됨
  --vdan NUMBER(1) :=1;
BEGIN
   
   FOR vdan IN 2..9
   LOOP
       FOR  vi  IN 1..9
       LOOP
       dbms_output.put( vdan || '*' || vi ||'='|| RPAD(vdan*vi, 4,' ') );   
       END LOOP;
       DBMS_OUTPUT.PUT_LINE('');
    END LOOP;

--EXCEPTION
END;

2) while 2개

DECLARE
  vdan NUMBER(2):=2 ;
  vi NUMBER(2) := 1 ;
BEGIN
   WHILE (vdan <= 9)
   LOOP
      vi  := 1;  -- *****
      WHILE( vi <= 9)
      LOOP
          DBMS_OUTPUT.PUT( vdan || '*' || vi || '=' || RPAD( vdan*vi, 4, ' ' ) );
          vi := vi + 1;
      END LOOP;
      DBMS_OUTPUT.PUT_LINE('');
      
      vdan := vdan + 1;
   END LOOP; 
--EXCEPTION
END;
---------------------
record 형 변수 설명

emp/ dept 조인
 deptno, dname, empno,ename
 
 SELECT d.deptno, dname, empno, ename,sal+NVL(comm,0) pay
 FROM emp e JOIN dept d ON e.deptno = d.deptno
 WHERE empno = 7369;
-------------------------------------
  1)
 DECLARE
    vdeptno dept.deptno%TYPE;
    vdname  dept.dname%TYPE;
    vempno  emp.empno%TYPE;
    vename emp.ename%TYPE;
    vpay NUMBER;
 BEGIN
         SELECT d.deptno, dname, empno, ename,sal+NVL(comm,0) pay
           INTO vdeptno, vdname, vempno, vename,vpay
         FROM emp e JOIN dept d ON e.deptno = d.deptno
         WHERE empno = 7369;  
         
         DBMS_OUTPUT.PUT_LINE(vdeptno ||','||vdname ||','||vempno||','||vename||','||vpay);
 --EXCEPTION
 END;
----------------------------------
 2) %ROWTYPW형 변수 선언
 
 DECLARE
 
   vdrow dept%ROWTYPE;
   verow emp%ROWTYPE;
    
    vpay NUMBER;
 BEGIN
         SELECT d.deptno, dname, empno, ename,sal+NVL(comm,0) pay
           INTO vdrow.deptno, vdrow.dname, verow.empno, verow.ename,vpay
         FROM emp e JOIN dept d ON e.deptno = d.deptno
         WHERE empno = 7369;  
         
         DBMS_OUTPUT.PUT_LINE(vdrow.deptno ||','||vdrow.dname ||','||verow.empno||','||verow.ename||','||vpay);
 --EXCEPTION
 END;
-------------------------------------------------
--3. 레코드형 변수
DECLARE
     --사용자 정의 자료형
     TYPE EmpDeptType IS RECORD
     (
     vdeptno dept.deptno%TYPE,
     vdname  dept.dname%TYPE,
     vempno  emp.empno%TYPE,
     vename emp.ename%TYPE,
     vpay NUMBER
     );
     vrow EmpDeptType; --RECORD형 변수 선언
 BEGIN
         SELECT d.deptno, dname, empno, ename,sal+NVL(comm,0) pay
           INTO vrow.vdeptno, vrow.vdname, vrow.vempno, vrow.vename, vrow.vpay
         FROM emp e JOIN dept d ON e.deptno = d.deptno
         WHERE empno = 7369;  
         
         DBMS_OUTPUT.PUT_LINE(vrow.vdeptno ||','||vrow.vdname ||','||vrow.vempno||','||vrow.vename||','||vrow.vpay);
 --EXCEPTION
 END;
-- Encountered the symbol "JOIN" when expecting one of the following:
------------
--커서?
1. PL/SQL 블럭 내에서 실행되는 SELECT 문을 의미
2.여러개의 레코드를 처리하기 위해서 커서 CURSOR 사용해야한다
3. 커서의 2가지 종류
   ㄱ. implicit cursor 묵시적(암시적, 자동) 커서
   
DECLARE 
   --vrow
BEGIN
   FOR vrow IN (SELECT empno, ename, job FROM emp)
   LOOP
     DBMS_OUTPUT.PUT_LINE( vrow.empno ||','|| vrow.ename ||','|| vrow.job);
   END LOOP;
--EXCEPTION
END;

ㄴ. explicit cursor 명시적 커서
  1) 커서선언
  2) 커서 open
  3) LOOP
     --처리 FETCH 가져오다
     EXIT WHEN 커서 읽을 것이 없을 때 까지 
     END LOOP;
  4) 커서 CLOSE
예. -> 여러개의 행 가져오기 때문에 커서 없어서 오류난다.
DECLARE
     vename emp.ename%TYPE;
     vsal emp.sal%TYPE;
     vhiredate emp.hiredate%TYPE;
BEGIN
  SELECT ename, sal, hiredate
     IN vename, vsal, vhiredate
  FROM emp
  WHERE deptno =30;

  DBMS_OUTPUT.PUT_LINE(vename||','||vsal||','||vhiredate);

--EXCEPTION
END;
---------------
커서 사용하기
--1. 커서 선언
DECLARE
     vename emp.ename%TYPE;
     vsal emp.sal%TYPE;
     vhiredate emp.hiredate%TYPE;
 CURSOR emp30_cursor IS  (
                    SELECT ename, sal, hiredate
                    FROM emp
                    WHERE deptno =30
                    );
BEGIN
  --2.OPEN
  --OPEN 커서명
  OPEN emp30_cursor;
  --3.LOOP ~ FETCH (반복적으로 가져오는 작업)
  LOOP
    FETCH emp30_cursor INTO vename, vsal, vhiredate;
    DBMS_OUTPUT.PUT_LINE(vename||','||vsal||','||vhiredate);
   --EXIT WHEN emp30_cursor%NOTFOUND;
   EXIT WHEN emp30_cursor%NOTFOUND OR emp30_cursor%ROWCOUNT >=3;
  END LOOP;
   --4. CLOSE
   --CLOSE 커서명
   CLOSE emp30_cursor;
--EXCEPTION
END;
-----------------------------------
--암시적 커서 사용 예제 분석
   
DECLARE 
   --vrow
   CURSOR emp_cursor is (SELECT empno, ename, job FROM emp);
BEGIN
   FOR vrow IN emp_cursor
   LOOP
     DBMS_OUTPUT.PUT_LINE( vrow.empno ||','|| vrow.ename ||','|| vrow.job);
   END LOOP;
--EXCEPTION
END;

------------------------------------
--WHERE CURRENT OF 절
--stored procedure 저장 프로시저 PL/SQL/6가지 종류 중 2번째
1. PL/SQL/ 6가지 종류 중에 가장 대표적인 구조
2. 개발자가 자주 실행해야하는 업무를 이 문법에 의해 미리 작성하고
   데이터 베이스 내에 저장해두었다가 필요할때마다 호출해서 사용할 수 있다
3. 저장 프로시저 선언 형식
CREATE OR REPLACE PROCEDURE 프로시저명
(             입력용/출력용/
  p파라미터 MODE(IN/OUT/INOUT) 자료형(크기설정x),
  p파라미터 MODE(IN/OUT/INOUT) 자료형,
  p파라미터 MODE(IN/OUT/INOUT) 자료형
)
IS
  --변수
BEGIN
  --실행
EXCEPTION
  --예외처리
END;
4. 저장 프로시저 사용하는 방법
  ㄱ. execute 문 실행
  ㄴ. 또 다른 저장 프로시저안에서 호출해서 실행
  ㄷ. 익명 프로시저 호출
5. 예  user procedure ==up
CREATE OR REPLACE PROCEDURE up_delDept
( --입력용 파라미터
  pdeptno IN NUMBER
)
 IS
 
 BEGIN
   DELETE FROM dept
   WHERE deptno= pdeptno;
   
 -- COMMIT; 처리해야 제대로 처리됨.
-- EXCEPTION
 END up_delDept;

SELECT * FROM dept;

1. 익명프로시저
--DECLARE
BEGIN
  up_delDept(40);
--EXCEPTION
END;
2.EXECUTE문 실행
EXECUTE up_delDept(40);


------------------
월 저장프로시저 저장함수
화 트리거 패키지
수 동적쿼리
목 암호화
금 트랜젝션