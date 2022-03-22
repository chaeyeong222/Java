package days23;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Ex07 {

	public static void main(String[] args) {
		//LocalDate d = new (X);
		//LocalDate d = LocalDate.getinstance() (X);
		//객체생성 - now(), of() 메서드 사용!
		
		LocalDate d = LocalDate.now(); //현재 시스템의 날짜 객체 생성
		System.out.println(d); //2022-03-22

		//년도
		System.out.println(ChronoField.YEAR);
		int year = d.getYear();  //getXXX();
		System.out.println(year); //2022
		
		year = d.get(ChronoField.YEAR);
		System.out.println(year); //2022
		//월
		int month =d.getMonthValue();
		System.out.println(month); //3
		Month m = d.getMonth();
		System.out.println(m);      //MARCH
		
		month = d.get(ChronoField.MONTH_OF_YEAR);
		System.out.println(month);  //3
		//일
		int date = d.getDayOfMonth();
		System.out.println(date);  //22
		
		date =d.get(ChronoField.DAY_OF_MONTH);
		System.out.println(date);    //22
		
		//요일  1월2화3수4목5금6토  7일
		//DayOfWeek day = d.getDayOfWeek();
		//System.out.println(day);   //TUESDAY
		int dayOfWeek = d.getDayOfWeek().getValue(); //TUESDAY
		int day2=d.get(ChronoField.DAY_OF_WEEK);
		System.out.println(day2);  //2(화)
		
		//2022.3.27.일
		//Date dt=new Date(2022-1900,3-1,27);
		LocalDate dt=LocalDate.of(2022,3,27); //3대신 Month.MARCH 가능
		System.out.println(dt.getDayOfWeek().getValue()); //7 일요일
				
	}

}
