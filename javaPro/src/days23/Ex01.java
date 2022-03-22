package days23;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex01 {
	public static void main(String[] args) {
		// [Date 클래스 사용 ]
		int year = 2010;
		int month = 5;
		
		// 1. 2010.5.1    무슨 요일 ?    1(일) ~ 7(토)
		int START_DAY_OF_WEEK = 0;
		Date sDay = new Date(year-1900,month-1,1);
		START_DAY_OF_WEEK = sDay.getDay();
		sDay.setDate(sDay.getDate()-START_DAY_OF_WEEK);
	
		// 달력 출력
		System.out.printf("\t%d년 %d월\n", year, month);
		System.out.printf("\t일\t월\t화\t수\t목\t금\t토\n");
		
		for (int i = 1; i <=42; i++) {			
			int date = sDay.getDate();
			System.out.printf(  month == sDay.getMonth() +1   ?  "\t(%d)"  : "\t%d", date);
			sDay.setDate(sDay.getDate()+1); // 다음 날짜
			if( i % 7 ==0 ) System.out.println();
		}
		

	} // main

} // class


	/*public static void main(String[] args) {
		int year = 2010;
		int month = 5;
		
		Date d = new Date();
		d.setYear(2010-1900);
		d.setMonth(5-1);
		d.setDate(1);
		int startday = d.getDay();
		System.out.println(startday);
		
		Date e = new Date();
		e.setYear(2010-1900);
		e.setMonth(5);
		int date = d.getDate();
		e.setDate(date-1);
		int endday = e.getDay();
		
		System.out.printf("\t%d년 %d월\n", year, month);
		System.out.printf("\t일\t월\t화\t수\t목\t금\t토\n");
		
		for (int i = 1; i < 42; i++) {
			
		}

	}

}*/
