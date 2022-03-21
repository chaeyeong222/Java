package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex03_03 {

	public static void main(String[] args) {


		int year = 2005;
		Calendar c = new GregorianCalendar(2005, 1-1, 1);
		for (int month = 0; month < 12; month++) {
			c.set(Calendar.MONTH, month);
			int lastDay = c.getActualMaximum(Calendar.DATE);
			System.out.printf("%d년%d월 -%d일\n", year, month+1,lastDay);
		}

	}

}
