package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex03_02 {

	public static void main(String[] args) {
		// Calendar 클래스 사용해서
		//2010.05.01 무슨 요일인지?
		
		/* 방법1
		Calendar c = new GregorianCalendar(2010, 5-1, 1);
		//1일 7토
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 7
*/
		//방법2
		Calendar c = Calendar.getInstance();
		//c.get(int field) 년,월,일시분초밀세요일..
		/*
		c.set(Calendar.YEAR, 2010); //년도
		c.set(Calendar.MONTH, 5-1); //월
		c.set(Calendar.DATE, 1);//일
		*/
		c.set(2010, 5-1, 1); //한번에 설정 가능
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		
		//p.530 예제 10-1
		
		int lastDay = c.getActualMaximum(Calendar.DATE);
		System.out.println(lastDay);
		
		
	}

}
