package days22;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02_02 {

	public static void main(String[] args) {
		// 현재 시스템의 날짜, 시간 -> d 객체
		//[문제] 달력그리기-> 2010년 5월1일이 무슨 요일?
		
		//방법1
	/*	Date d= new Date(2010-1900, 5-1, 1);
		System.out.println(d.getDay());   //6토요일
	*/
		//방법2
		
		Date d = new Date(); //시스템의날짜, 시간
		//d.getXXX() 년,월, 일,시분초요일
		//d.setXXX() setter -> 필드설정
		d.setYear(2010-1900);
		d.setMonth(5-1);
		d.setDate(1);
		System.out.println(d.getDay());  
        
		//[문제]마지막 날짜 28.29.30.31
		System.out.println(d);
		int month = d.getMonth();
		d.setMonth(month+1);
		System.out.println(d);
		int date = d.getDate();
		d.setDate(date-1);
		System.out.println(d);
		System.out.println(d.getDate());
		//달의 첫 날짜로 간 다음에 1을 빼서 그 전달의 마지막 날짜 가져옴.
		
		//[문제] 890212 주민등록번호-> 오늘 기준 생일이 지났는지 여부
		String rrn =   "890212";
	      // 오늘 날짜
		
	      Date today = new Date();
	      // 시간/분/초 절삭
	      today.setHours(0);    // 12            ***
	      today.setMinutes(0); // 50
	      today.setSeconds(0);
	      
	      int b_month =  Integer.parseInt( rrn.substring(2, 4) ) -1;
	      int b_date = Integer.parseInt( rrn.substring(4, 6) ) ;
	      Date birthday = new Date( today.getYear(), b_month, b_date);
	      
	      System.out.println(  birthday.after(today) );   // false
	      System.out.println(  birthday.before(today) );   // true
	      System.out.println(  birthday.equals(today) );   // false      
	      
	      System.out.println( birthday.compareTo(today) );  // -1(안지남)  0(오늘이생일)   1(지남)
		
	}

}
