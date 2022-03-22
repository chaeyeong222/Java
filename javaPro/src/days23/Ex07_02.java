package days23;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Ex07_02 {

	public static void main(String[] args) {
		//개강2022.02.15으로부터 100일후?
		//LocalDate 클래스 + 시스템 now() | of()
		//calendar-> add (날짜+1) 
		//LocalDate 날짜수정메서드?    with(),  plus(), minus()
		
		LocalDate openday = LocalDate.of(2022, 2, 15);
		//d.plus(Period.ofDays(100)); 방법1 Period.ofDays 사용
		//LocalDate afterday = openday.plusDays(100); //방법1 PlusDays 사용
		//System.out.println(afterday); //2022-05-26
		//LocalDate resultday = openday.plus(100, ChronoUnit.DAYS); //방법3 ChronoUnit.DAYS 사용
		//System.out.println(resultday); //2022-05-26
		//날짜만 20일로 수정
		//LocalDate result = openday.withDayOfMonth(20); 2020.2.20
		//LocalDate result = openday.withYear(2020);   2020.2.15
		LocalDate result= openday.with(ChronoField.YEAR,2020); //위의 코딩과 같은 결과
		

	}

}
