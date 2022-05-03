

PL/SQL 
익명 프로시저
저장 프로시저
저장 함수
 [ 트리거 ] 
 
1. 트리거 사전적의미: 방아쇠 - 자동으로 총알이 날아감
2. 어떤 작업 전(before) 또는 후(after)에 트리거에 정의한 로직을 실행하는 PL/SQL의 한종류
3. 대상(테이블)에 미리 트리거를 지정하면 
    어떤 이벤트(DML)가 발생할 때 자동으로 지정된 트리거가 작동(활동)하도록한 객체를 트리거라고 한다
4. 예) 
    입고테이블
    코드 이름 날짜 갯수
    101 LG냉장고 2022.4.27 10
    
    재고테이블 (자동으로 재고수량을 수정하는 트리거)
    LG냉장고 120+10=130  update문 실행
    
    
5. 트리거 키워드 (예약어)

ㄱ. 작업 전에 자동처리되는 트리거 : BEFORE
ㄴ. 작업 후에 자동처리되는 트리거 : AFTER
ㄷ. FOR EACH ROW : 행마다 처리되는 트리거 (행 트리거)
ㄹ. REFERENCING 영향 받는 행의 값 참조
ㅁ. : OLD 참조되기 전 열(컬럼)의 값
ㅂ. : NEW 참조한 후 열(컬럼)의 값



6. 트리거 형식

【형식】 
	CREATE [OR REPLACE] TRIGGER 트리거명 [BEFORE ? AFTER]
	  trigger_event ON 테이블명
	  [FOR EACH ROW [WHEN TRIGGER 조건]]  --트리거가 발생되는 갯수
	DECLARE
	  선언문
	BEGIN
	  PL/SQL 코드
    EXCEPTION
      예외처리부분
	END;





7. 트리거 확인
SELECT *
FROM user_triggers;
FROM user_sequences
FROM user_constraints;
FROM user_tables;



8. 트리거 생성, 삭제, 활성화/비활성화


9. 트리거 테스트
CREATE TABLE tbl_trigger1(
   id NUMBER PRIMARY KEY
   , name VARCHAR2(20)
);
-- Table TBL_TRIGGER1이(가) 생성되었습니다.

CREATE TABLE tbl_trigger2(
  memo VARCHAR2(100) --로그내용
  , ilja DATE DEFAULT SYSDATE
);
--Table TBL_TRIGGER2이(가) 생성되었습니다.





9-2. tbl_trigger1 테이블에 한 레코드(행)을 insert
     대상(tbl_trigger1 테이블)에 DML이 발생하면 tbl_trigger2 테이블에
     자동으로 로그를 기록하는 트리거 생성



10. 트리거 선언

CREATE OR REPLACE TRIGGER ut_exam01 AFTER 
INSERT OR UPDATE OR DELETE ON tbl_trigger1 
--FOR EACH ROW 행트리거
--DECLARE 
BEGIN 
    IF INSERTING THEN
    INSERT INTO tbl_trigger2 (memo) VALUES ('tbl_trigger1 테이블 추가됨');
    ELSIF UPDATING THEN
    INSERT INTO tbl_trigger2 (memo) VALUES ('tbl_trigger1 테이블 수정됨');
    ELSIF DELETING THEN
    INSERT INTO tbl_trigger2 (memo) VALUES ('tbl_trigger1 테이블 삭제됨');
    END IF;
--EXCEPTION
END;



--저장 프로시저는 커밋해야하지만
--트리거는 자동으로 커밋, 롤백된다


SELECT * FROM tbl_trigger1;
SELECT * FROM tbl_trigger2;

INSERT INTO tbl_trigger1 VALUES (1, 'admin');
commit;

--AFTER 트리거는 제약조건에 걸리면 작동하지 않는다
INSERT INTO tbl_trigger1 VALUES (2, 'hong');
commit;


rollback;

--dml (update)
UPDATE tbl_trigger1
SET name = 'kim'
WHERE id=2;


--dml (DELETE)
DELETE FROM tbl_trigger1
WHERE id=2;



---
문제) tbl_trigger1 테이블에 근무시간X, 주말(토,일)X에는 INSERT, UPDATE, DELETE 
하면 에러 발생

--삽입되기 전에 트리거가 발생이 되어서 근무/주말인 체크 후에 삽입 결정
INSERT INTO tbl_trigger1 VALUES (2, 'hong');

--before 트리거 생성

CREATE OR REPLACE TRIGGER ut_exam02 BEFORE 
INSERT OR UPDATE OR DELETE ON tbl_trigger1 
--FOR EACH ROW 행트리거
--DECLARE 
BEGIN 
    IF NOT (TO_CHAR (SYSDATE, 'HH24') BETWEEN 12 AND 18) OR TO_CHAR(SYSDATE, 'DY') IN ('토', '일') THEN
        --강제로 에러발생시키면 I,U,D (DML)문도 취소
        RAISE_APPLICATION_ERROR(-20000, '지금은 근무 시간 외 또는 주말이기에 작업이 안됩니다');
   
    END IF;
--EXCEPTION
END;



SELECT SYSDATE
        , TO_CHAR (SYSDATE, 'HH24')
        , TO_CHAR (SYSDATE, 'DAY')
        , TO_CHAR (SYSDATE, 'DY')
FROM DUAL;














-------


create table tbl_trg1
(
    hak varchar2(10) primary key
  , name varchar2(20)
  , kor number(3)
  , eng number(3)
  , mat number(3)
);
-- Table TBL_TRG1이(가) 생성되었습니다.
create table tbl_trg2
(
  hak varchar2(10) primary key
  , tot number(3)
  , avg number(5,2)
  , constraint fk_test2_hak foreign key(hak)   references tbl_trg1(hak)
);
-- Table TBL_TRG2이(가) 생성되었습니다.

SELECT * FROM tbl_trG1; --학번 이름 국어 영어 수학
SELECT * FROM tbl_trg2; --학번 총점 평균



-- 예) 한 학생의 학,이,국,영,수 -> tbl_trg1 에 INSERT
--     자동으로
--     tbl_trg2 테이블에 tot,avg INSERT 되는 트리거 생성 -> 테스트
INSERT INTO tbl_trg1 ( hak, name, kor, eng, mat ) VALUES ( 1, 'hong', 90,78, 99 );

:new 키워드

--트리거
CREATE OR REPLACE TRIGGER ut_trg1DML AFTER 
INSERT ON tbl_trg1
FOR EACH ROW    --행트리거 :new:old 쓸수있다(문법)
DECLARE 
    vtot NUMBER(3);
    vavg NUMBER(5,2);
BEGIN
    vtot := :NEW.KOR + :NEW.ENG + :NEW.MAT;
    vavg := vtot/3;
    INSERT INTO tbl_trg2 (hak, tot, avg) VALUES (:NEW.hak, vtot, vavg);
--EXCEPTION
END;

--ORA-04082: NEW or OLD references not allowed in table level triggers
테이블레벨의 트리거에서 :new, :old 사용 못함

commit;


SELECT * FROM tbl_trG1;
SELECT * FROM tbl_trg2;

-- 학번이 1번인 사람의 성적을 수정(update) -> 자동으로 TBL_TRG2 테이블이 총점,평균 수정
UPDATE TBL_TRG1
SET kor = 87, eng = 67, mat = 100
WHERE hak = 1;

CREATE OR REPLACE TRIGGER ut_trg1DML AFTER 
INSERT OR UPDATE ON tbl_trg1
FOR EACH ROW    --행트리거 :new:old 쓸수있다(문법)
DECLARE 
    vtot NUMBER(3);
    vavg NUMBER(5,2);
BEGIN
    vtot := :NEW.KOR + :NEW.ENG + :NEW.MAT;
    vavg := vtot/3;
    
    if inserting then
    INSERT INTO tbl_trg2 (hak, tot, avg) VALUES (:NEW.hak, vtot, vavg);
    elsif updating then
    update tbl_trg2
    set tot=VTOT, avg=VAVG
    WHERE hak = :OLD.hak ; -- == new.hak
    end if;
--EXCEPTION
END;


COMMIT

create table tbl_trg1
(
    hak varchar2(10) primary key
  , name varchar2(20)
  , kor number(3)
  , eng number(3)
  , mat number(3)
);
-- Table TBL_TRG1이(가) 생성되었습니다.
create table tbl_trg2
(
  hak varchar2(10) primary key
  , tot number(3)
  , avg number(5,2)
  , constraint fk_test2_hak foreign key(hak)   references tbl_trg1(hak)
);

문제) TBL_TRG1 테이블에 학번1인 학생을 삭제를 하면 자동으로 TBL_TRG2 테이블의 학번 1학생도 삭제되는 트리거를
만들어서 테스트


DELETE FROM TBL_TRG1
WHERE HAK=1;

CREATE OR REPLACE TRIGGER ut_trg1DML AFTER 
INSERT OR UPDATE or delete ON tbl_trg1
FOR EACH ROW    --행트리거 :new:old 쓸수있다(문법)
DECLARE 
    vtot NUMBER(3);
    vavg NUMBER(5,2);
BEGIN
    vtot := :NEW.KOR + :NEW.ENG + :NEW.MAT;
    vavg := vtot/3;
    
    if inserting then
    INSERT INTO tbl_trg2 (hak, tot, avg) VALUES (:NEW.hak, vtot, vavg);
    
    elsif updating then
    update tbl_trg2
    set tot=VTOT, avg=VAVG
    WHERE hak = :OLD.hak ; -- == new.hak
    
    ELSIF deleting then
    delete tbl_trg2
    WHERE hak = :OLD.hak ;
    end if;
--EXCEPTION
END;



ROLLBACK;



