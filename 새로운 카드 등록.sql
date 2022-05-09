카드등록 시 핀번호, 카드번호 중복체크

 CREATE OR REPLACE PROCEDURE regisnewcard
 (
  pcard_no IN starbuckscard.card_no%type
   ,ppin_no IN starbuckscard.pin_no%type
   --, pcard_name   starbuckscard.card_name%TYPE 
   --, pmember_id starbuckscard.member_id%type
 )
 IS
  vcardnoCheck NUMBER;
  vcardpinnoCheck NUMBER;
 BEGIN
            SELECT COUNT(*) INTO vcardnoCheck
            FROM starbuckscard
            WHERE card_no = pcard_no;
        
             SELECT COUNT(*) INTO vcardpinnoCheck
             FROM starbuckscard
             WHERE pin_no = ppin_no;  
    
        if vcardnoCheck =1 then     dbms_output.put_line('이미 등록 된 카드번호 입니다');
        else --카드번호 중복 아닐 시
          if (length(pcard_no) !=16) then --카드번호 잘못입력
            dbms_output.put_line('잘못된 카드번호 양식입니다');
          else  -- 카드번호 제대로 입력함, 핀번호 체크
             if(vcardpinnoCheck =1) then 
                 dbms_output.put_line('이미 등록 된 핀번호입니다');
             else  --새로운 핀번호 (양식체크)
               if (length(ppin_no) !=8 ) then
                dbms_output.put_line('잘못된 핀번호 양식입니다');
               else 
                dbms_output.put_line('카드 등록 완료');
                INSERT INTO starbuckscard ( card_no , pin_no ) VALUES ( pcard_no, ppin_no );
              --  INSERT INTO starbuckscard ( card_no, card_name, pin_no, member_id  ) VALUES ( pcard_no, pcard_name, ppin_no,  pmember_id );
          end if;
          end if;
          end if;
          end if;      
 END;
 
 
 exec regisnewcard ( 1244, 87445124 ); --카드번호 양식 잘못됨
 exec regisnewcard ( 1245774588746610, 87445124 ); --이미 등록된 카드번호
 exec regisnewcard ( 1154478488746610, 32767 ); -- 잘못된 핀번호 양식
 exec regisnewcard ( 1154478488746610, 32998767 );--이미 등록 된 핀번호
 exec regisnewcard ( 1154478488746610, 87445132 );
 --exec regisnewcard ( 1154478488746610, 'test카드', 87445132, 'chaeyoung' ); --카드 등록 완료