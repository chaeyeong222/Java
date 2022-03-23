package days24;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Ex01 {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate openDay = LocalDate.of(2022, 2, 15);
		
		//기능, 매개변수, 리턴값 제대로 알기
		Period p = Period.between(openDay, today);
		System.out.println(p.getYears()); //0
		System.out.println(p.get(ChronoUnit.YEARS)); //0
		
		System.out.println(p.getMonths()); //1
		System.out.println(p.get(ChronoUnit.MONTHS)); //1
		
		System.out.println(p.getDays()); //8
		System.out.println(p.get(ChronoUnit.DAYS)); //8
		

	}

}
