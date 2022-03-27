package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex07 {

	public static void main(String[] args) {
		// [Calendar 클래스 사용 ]
		int year = 2022;
		int month = 3;
		
		// 1. 2010.5.1    무슨 요일 ?    1(일) ~ 7(토)
		int START_DAY_OF_WEEK = 0;
		Calendar sDay = new GregorianCalendar(year, month-1, 1);
		START_DAY_OF_WEEK =  sDay.get(Calendar.DAY_OF_WEEK);	
		
		// 2. 2010.5. ??  마지막날짜? 
		int END_DAY = 0; 
		Calendar eDay = new GregorianCalendar(year, month, 1);  // 2010.6.1
		eDay.add(Calendar.DATE, -1);
		END_DAY =  eDay.get(Calendar.DATE);
		
		
		// 달력 출력
		System.out.printf("\t%d년 %d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {//1위치 잡기 위해 공백잡는 for문
			System.out.print("\t");
		}
		for (int i = 1; i <= END_DAY; i++) {
			System.out.printf("%d\t", i);
			// 개행
			if( ( i + START_DAY_OF_WEEK -1) % 7 ==0)  System.out.println();
		}

	} // main

} // class
