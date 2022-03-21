package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex07 {

	public static void main(String[] args) {
		int year = 2022;
		int month = 3;
		
		//2010.5.1 무슨요일? 1일~7토
		int START_DAY_OF_WEEK = 0;
		Calendar sDay = new GregorianCalendar(year,month-1,1);
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		
		sDay.add(Calendar.DATE, -START_DAY_OF_WEEK+1);//2022.2.27 
		
		
		
		//달력출력
		System.out.printf("\t%d년%d월\n",year,month);
		System.out.println("\t일\t월\t화\t수\t목\t금\t토\n");
		for (int i = 1; i <= 42; i++) {
			int date = sDay.get(Calendar.DATE);
			System.out.printf(month==sDay.get(Calendar.MONTH)+1? "\t(%d)" : "\t%d",date);
			sDay.add(Calendar.DATE, 1); //다음날짜
			if(i%7==0) System.out.println();//개행
			
			
		}


	}

}
