package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex07_02 {

	public static void main(String[] args) {
		int year = 2010;
		int month = 5;
		
		//2010.5.1 무슨요일? 1일7토
		int START_DAY_OF_WEEK = 0;
		Calendar sDay = new GregorianCalendar(year,month-1,1);
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		//2010.05 마지막날짜?
		int END_DAY = 0;
		Calendar eDay = new GregorianCalendar(year,month,1);
		eDay.add(Calendar.DATE, -1);
		END_DAY = eDay.get(Calendar.DATE);
		
		//달력출력
		System.out.printf("\t%d년%d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토\n");
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {
			System.out.println("\t");
		}
		for (int i = 1; i < END_DAY; i++) {
			System.out.printf("%d\t",i);
			if((i+START_DAY_OF_WEEK-1)%7==0) System.out.println();
		}

	}

}
