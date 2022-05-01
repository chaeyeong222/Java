-- SCOTT 계정 접속 --  
-- ***** PL/SQL *****
-- 1. 익명 프로시저
-- 2. 저장 프로시저( 대표적 )

-- 예) 부서테이블에 부서번호를 파라미터로 받아서 부서 삭제 : up_delDept
--     저장 프로시저를 실행 : execute 문 , 익명프로시저 실행, 또 다른 저장 프로시저 
 
-- 예) DEPT 테이블에 새로운 부서를 추가하는 저장 프로시저 생성  up_incdept

-- 1) 
SELECT *
FROM dept;
--2-1) 시퀀스 확인
SELECT *
FROM user_sequences;
--2-2) seq_dept 시퀀스 삭제
DROP SEQUENCE seq_dept;
--2-3) 시퀀스 생성  seq_dept
CREATE SEQUENCE seq_dept
INCREMENT BY 10
START WITH 50
MAXVALUE 90
NOCACHE;

-- 3)
INSERT INTO dept ( deptno, dname, loc  ) VALUES ( seq_dept.nextval, '???', '???' )
COMMIT;

-- 3-2) 저장 프로시저 생성
CREATE OR REPLACE PROCEDURE up_insDept
(
    pdname   dept.dname%TYPE := null
    , ploc   dept.loc%TYPE DEFAULT null
)
IS
BEGIN
   INSERT INTO dept ( deptno, dname, loc  ) VALUES ( seq_dept.nextval, pdname, ploc );
   -- COMMIT;  
--EXCEPTION
   -- ROLLBACK;
END;

-- Procedure UP_INSDEPT이(가) 컴파일되었습니다.

BEGIN
   -- UP_INSDEPT( pdname=>'QC', ploc=>'SEOUL' );
   -- UP_INSDEPT( 'QC', 'SEOUL' );
   -- UP_INSDEPT( ploc=>'SEOUL', pdname=>'QC' );
    UP_INSDEPT( pdname => 'QC' );
END;

--PL/SQL 프로시저가 성공적으로 완료되었습니다.
ROLLBACK;
SELECT * FROM dept;
COMMIT;

-- 예) DEPT 테이블에서 부서정보를 수정하는 저장 프로시저 

EXEC up_updDept( 60, 'QC', 'SEOUL' ); -- 부서명, 지역명 수정
EXEC up_updDept( 60, pdname => 'XX'  );  -- 부서명 수정
EXEC up_updDept( 60, ploc => 'YY' ); -- 지역명 수정


CREATE OR REPLACE PROCEDURE up_updDept
(
      pdeptno  IN dept.deptno%TYPE
    , pdname   IN dept.dname%TYPE := null
    , ploc     IN dept.loc%TYPE DEFAULT null
)
IS
  vdname  dept.dname%TYPE;  -- 수정할 원래 레코드의 부서명
  vloc    dept.loc%TYPE;   -- 지역명
BEGIN
   IF  pdname IS NULL OR ploc IS NULL  THEN
      SELECT dname, loc INTO vdname, vloc
      FROM dept
      WHERE deptno = pdeptno;
   END IF;

   UPDATE dept
   SET    dname = CASE 
                        WHEN pdname IS NULL THEN  vdname
                        ELSE pdname
                  END
          ,  loc = NVL( ploc, vloc  )
   WHERE deptno = pdeptno;
    
   -- COMMIT;  
--EXCEPTION
   -- ROLLBACK;
END;
-- Procedure UP_UPDDEPT이(가) 컴파일되었습니다.


-- 예) 모든 부서 정보를 조회하는 저장 프로시저
-- ( 명시적 커서를 사용한 예제 )
CREATE OR REPLACE PROCEDURE up_selDept
IS
   CURSOR vcurdept IS (  SELECT * FROM dept );
   vrowdept dept%ROWTYPE;
BEGIN
   OPEN vcurdept;
   
   LOOP
     FETCH vcurdept INTO vrowdept;
     EXIT WHEN vcurdept%NOTFOUND;
     DBMS_OUTPUT.PUT_LINE( vrowdept.deptno || ' / ' ||
                             vrowdept.dname || ' / ' ||  vrowdept.loc);
   END LOOP;
   
   CLOSE vcurdept;
--EXCEPTION
END;

-- ( 암시적 커서를 사용한 예제 )
CREATE OR REPLACE PROCEDURE up_selDept
IS  
BEGIN
    FOR vrowdept  IN (  SELECT * FROM dept )
    LOOP
       DBMS_OUTPUT.PUT_LINE( vrowdept.deptno || ' / ' ||
                             vrowdept.dname || ' / ' ||  vrowdept.loc);
    END LOOP;  
--EXCEPTION
END;

-- Procedure UP_SELDEPT이(가) 컴파일되었습니다.
EXECUTE up_selDept;


-- 9:59 수업 시작~
-- 예) 저장 프로시저의 파라미터의 MODE ( IN/ [OUT] 출력용 /INOUT )에 대해서 살펴보자.
--    insa테이블의 사원번호를 입력용파라미터로 입력을 하면
--    그 사원의 주민번호 앞자리 6자리를 출력용파라미터 출력하는 저장 프로시저.

CREATE OR REPLACE PROCEDURE up_rrn6Insa
(
    pnum IN insa.num%TYPE
    , prrn6 OUT VARCHAR2  -- 크기 X
)
IS
  vssn insa.ssn%TYPE;
BEGIN
  SELECT ssn INTO vssn
  FROM insa
  WHERE num = pnum;
  
  prrn6 := SUBSTR( vssn, 0, 6 );
  
--EXCEPTION
END;

-- Procedure UP_RRN6INSA이(가) 컴파일되었습니다.

-- [처음으로]  출력용 파라미터를 가진 저장 프로시저를 테스트 
DECLARE
  vssn6 VARCHAR2(6);
BEGIN
   UP_RRN6INSA( 1001,  vssn6 );
   DBMS_OUTPUT.PUT_LINE( 'vssn6 : ' || vssn6 );
END;

-------------------------------------------------------------------------------------
SELECT *
FROM tbl_score;


문제 1)tbl_score 테이블에 새로운 학생의 성적 정보를 저장하는 프로시저 : up_insScore
    p :   num, kor, eng, mat   입력하지 않으면 0 처리
    총점, 평균, 등급 까지는 처리가 되도록 .. 

CREATE OR REPLACE PROCEDURE up_insScore
(
    pnum tbl_score.num%TYPE
    , pname tbl_score.name%TYPE 
    , pkor tbl_score.kor%TYPE  DEFAULT 0
    , peng tbl_score.eng%TYPE  DEFAULT 0 
    , pmat tbl_score.mat%TYPE  DEFAULT 0
)
IS 
  vtot tbl_score.tot%TYPE;
  vavg tbl_score.avg%TYPE;
  vgrade tbl_score.grade%TYPE;
BEGIN
   
   vtot := pkor + peng + pmat;
   vavg :=  TRUNC( vtot / 3 , 2 );
   vgrade := CASE
               WHEN vavg >= 90 THEN 'A'
               WHEN vavg >= 80 THEN 'B'
               WHEN vavg >= 70 THEN 'C'
               WHEN vavg >= 60 THEN 'D'
               ELSE 'F'
             END;

  INSERT INTO tbl_score (num, name, kor, eng, mat, tot, avg, grade ) 
  VALUES ( pnum, pname, pkor, peng, pmat, vtot, vavg, vgrade ) ;
  
  -- 저장 프로시저 안에서 또 다른 저장프로시저를 호출...
  up_rankScore;
  
--EXCEPTION
END;

EXEC up_insScore(1100, '테이블', 89,45,77);

SELECT * 
FROM tbl_score;
COMMIT;
ROLLBACK;
   
문제 2) tbl_score 테이블에 새로운 학생의 성적 정보를 수정하는 프로시저 : up_updScore     
   p  : num,   kor, eng, mat  입력하지 않으면  수정 전의 점수로 처리
     총점, 평균, 등급 까지는 처리가 되도록 .. 


CREATE OR REPLACE PROCEDURE up_updScore
(
    pnum tbl_score.num%TYPE 
    , pkor tbl_score.kor%TYPE := NULL  
    , peng tbl_score.eng%TYPE := NULL   
    , pmat tbl_score.mat%TYPE := NULL
)
IS 
  vkor tbl_score.kor%TYPE   ;
  veng tbl_score.eng%TYPE   ;
  vmat tbl_score.mat%TYPE   ;
  
  vtot tbl_score.tot%TYPE;
  vavg tbl_score.avg%TYPE;
  vgrade tbl_score.grade%TYPE;
BEGIN
   SELECT kor, eng, mat INTO vkor, veng, vmat
   FrOM tbl_score
   WHERE num = pnum;

     IF pkor IS NOT NULL THEN  vkor := pkor; END IF;
     veng := NVL(peng, veng); 
     vmat := NVL(pmat, vmat); 
   
   vtot := vkor + veng + vmat;
   vavg :=  TRUNC( vtot / 3 , 2 );
   vgrade := CASE
               WHEN vavg >= 90 THEN 'A'
               WHEN vavg >= 80 THEN 'B'
               WHEN vavg >= 70 THEN 'C'
               WHEN vavg >= 60 THEN 'D'
               ELSE 'F'
             END;

  UPDATE tbl_score  
  SET   
      kor=vkor, eng =  veng, mat = vmat
      , tot = vtot
      , avg = vavg
      , grade = vgrade
  WHERE num = pnum;
  
  up_rankScore;
--EXCEPTION
END;

EXEC up_updScore ( 1100, 95,67,88);

SELECT * FROM tbl_score;
COMMIT;

문제 3)      tbl_score 테이블에  삭제하는 프로시저 : up_delScore
  p  : num  

CREATE OR REPLACE PROCEDURE up_delScore 
(
   pnum tbl_Score.num%TYPE
)
IS  
BEGIN    
  DELETE FROM  tbl_score
  WHERE num = pnum;
  
  up_rankScore;
  
--EXCEPTION
END;  

EXEC up_delScore(1100);

SELECT * FRom tbl_score;
COMMIT;
  
문제 4)   tbl_score 테이블에  모든 학생 정보를 조회하는 프로시저 : up_selScore

CREATE OR REPLACE PROCEDURE up_selScore
IS
   CURSOR vcurScroe IS (  SELECT * FROM tbl_score );
   vrowscore tbl_score%ROWTYPE;
BEGIN
   OPEN vcurScroe;
   
   LOOP
     FETCH vcurScroe INTO vrowscore;
     EXIT WHEN vcurScroe%NOTFOUND;
     DBMS_OUTPUT.PUT_LINE( vrowscore.num || ' / ' ||
                             vrowscore.name || ' / ' ||  vrowscore.tot|| ' / ' ||
                             vrowscore.avg || ' / ' ||  vrowscore.grade|| ' / ' ||
                             vrowscore.rank
                             );
   END LOOP;
   
   CLOSE vcurScroe;
--EXCEPTION
END;

EXEC up_selscore;

문제 5) 등수를 처리하는 프로시저  : up_rankScore

CREATE OR REPLACE PROCEDURE up_rankScore 
IS 
  vrank tbl_score.rank%TYPE;
BEGIN
    
  UPDATE tbl_score t  
  SET   rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > t.tot  ) ;
  
--EXCEPTION
END;

EXEC  up_rankScore;

UPDATE tbl_score
SET rank = 1;
COMMIT;
SELECT * FROM tbl_score;



