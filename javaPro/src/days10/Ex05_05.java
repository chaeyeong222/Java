package days10;

import java.util.Date;

/**
 * @author 이채영
 * @date 2022. 3. 2. - 오후 3:05:31
 * @subject 주민등록번호 -> 성별, 생년월일,  [나이]
 * @content 
  /* 둘의 차이점?
		 *       System.out.printf("출력형식", 출력값...) 
		 *      -> void(리턴값)  기능 원하는 출력형식으로 출력하는 기능
		 *       String.format("출력형식",출력값...)          
		 *      -> String (리턴값)      원하는 출력형식으로 값을 String으로 만들어주는기능
		 */
 /*
public class Ex05_05 {

	/*public static void main(String[] args) {
		/* 만 나이 : 갓 태어난 아이는 0세 / 생일을 기준으로 1살씩 up
		 *         기준연도 - 출생연도 -> 생일 이후면 그대로/ 생일 이전이면 -1
		 * 세는 나이 : 태어난 아이 1세/ 새해 첫날을 기준으로 1살씩 up
		 *        기준연도 - 출생연도 +1
		 *       
		 *  2019.12.30 태어남 / 2019.12.31   2020.01.01   2020.12.29   2020.12.30  2021.01.01
		 *       만나이                   0 살                 0살                0살                1살              1살
		 *       세는나이                 1 살                 2살                2살                2살              3살
		 *        
		 */
		
	//	String rrn = Ex05_02.getRRN();
	    // 세는나이 = get세는Age(rrn);
		//System.out.println(세는나이);
		
/*		int 만나이 = get만Age(rrn);
		System.out.println(만나이);
		
	}

	/*private static int get만Age(String rrn) {
		//만나이 = 올해(2022) - 생일년도 +1
		//계산방법 1) 몫(나이) == 총 산일 수/365.25
		//계산방법 2) 올해 - 생일년도 (생일 지났으면: 그대로) (생일 안지났으면 -1)

        int age;
	/*	//방법1
		Date d = new Date();
		int now =  d.getYear() +1900 ;
		int yearBD = Integer.parseInt(Ex05_04.getBirth(rrn).substring(0,4)); //1999
		age = now -yearBD;
		
		int monthBD = Integer.parseInt(Ex05_04.getBirth(rrn).substring(6, 8));
		int dateBD = Integer.parseInt(Ex05_04.getBirth(rrn).substring(10, 12));
		int month = d.getMonth()+1; //1월이면 0, 12월이면 11을 반환해주는 함수임.
		int date = d.getDate();
		
		if(!(monthBD>=month && dateBD >=date)) age--;
		
		return age;
	}
     
      //방법2  
      int age;
      int birthMD = Integer.parseInt(rrn);
      int nowMD = Integer.parseInt(rrn);
      
      if(birthMD < nowMD) age--;
		
		return age;
     */
    // 방법3    
	//	true/false 생일날짜객체.before(현재날짜객체)
	//	d.after(d2)
	//	d.before(d)
		
		
	//	return age;
//	}

	/*
	
	private static int get세는Age(String rrn) {
		
		//세는 나이 = 올해(2022) - 출생연도 +1
		int age;
		
		Date d = new Date();
		int now =  d.getYear() +1900 ;
		int yearBD = Integer.parseInt(Ex05_04.getBirth(rrn).substring(0,4)); //1999
		age = now -yearBD +1 ;
		
		
		
		return age;*/
	//}//

//}
	
