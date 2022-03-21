package days22;

import java.util.Date; //sql아님 잘 구분하기 **

/**
 * @author 이채영
 * @date 2022. 3. 21. - 오전 11:30:22
 * @subject 교재 2권 p.528 - chapter10.날짜와 시간& 형식화formatting
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 1.JDK 1.0, 1.1
		 *   1) Date 클래스 - deprecated메서드
		 *   2) Calendar 클래스
		 *    -new 객체생성을 못하고
		 *    getinstance()메서드 통해서 객체(인스턴스)얻어와서 사용한다
		 *      ㄴ 태국buddihistCalendar 객체를 반환
		 *      ㄴ 그외 GregorianCalendar 객체를 반환
		 *      
		 * 2. JDK 1.8
		 *   java.time패키지 안에 여러 하위 패키지 및 다양한 클래스 추가
		 *
		 */

		Date d = new Date();
		
		int year = d.getYear()+1900;//취소선-폐기되는 메서드 is deprecated
		//System.out.println(year); //2022
		
		//KST 한국표준시
		System.out.println(d.toString()); //Mon Mar 21 11:43:30 KST 2022
		System.out.println(d);                 //Mon Mar 21 11:43:30 KST 2022
	     //Greenwich Mean Time=GMT=그리니치평균시간=세계표준시간
		System.out.println(d.toGMTString()); //21 Mar 2022 02:44:41 GMT

		System.out.println(d.getMonth()+1);//1월(0)-12월(11)
		System.out.println(d.getDate());
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
		//1970.1.1.00:00:00(GMT) 밀리세컨드 값을 만환하는 메서드 getTime()
		System.out.println(d.getTime()); //long형 
		
		//오늘날짜가 무슨 요일인지?
		//0일1월2화..6토
		System.out.println(d.getDay());
		System.out.println("일월화수목금토".charAt(d.getDay())+"요일");
	}//main

	// Date d => 2022년 3월 21일 12:17:25(월요일)  반환하는 메서드 구현( 선언 )

	public static String getLocalDate(Date d) {
		
		int year = d.getYear()+1900;
		int month = d.getMonth()+1;
		int date = d.getDate();
		int hour = d.getHours();
		int minute = d.getMinutes();
		int second = d.getSeconds();
		int dayOfWeek = d.getDay();

		 return String.format(
		            "%d년 %d월 %d일 %02d:%02d:%02d(%c요일)"
		            , year, month, date, hour, minute, second
		            ,  "일월화수목금토".charAt(  dayOfWeek  ));
		      

	}
	
}//class
