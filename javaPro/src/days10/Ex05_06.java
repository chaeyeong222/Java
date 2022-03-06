package days10;

import java.util.Date;

public class Ex05_06 {

	public static void main(String[] args) {
		// 현재 시스템의 년도를 얻어오는 코딩.
		// java 날짜, 시간을 다루는 기능이 구현된 클래스 : Date, Calendar 클래스
		//JDK 1.8 새로 추가된 클래스 		LocalDate. 	LocaldateTime 등등
		
		//import java.util.Date;
		//getYear() 메서드는 사용되지않는다, 폐기할 것임.
		Date d = new Date();
		int now = d.getYear() +1900 ;
		System.out.println("올해년도: "+now);

	}

}
