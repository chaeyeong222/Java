package days23;

import java.time.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오후 4:30:01
 * @subject p.565 TemporalAdjusters 클래스
 * @content   s붙으면 클래스 s 없으면 인터페이스
 *                   다음주 금요일은 몇 일?
 *                   다가오는 셋째 주 금요일 몇 일?
 /*	LocalDate now = LocalDate.now();
		System.out.println(now); //2022-03-22
		//다가오는 금요일?
		LocalDate result = now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(result); //2022-03-25
		//지난주 금요일
		result = now.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		System.out.println(result); //2022-03-18
		*/
class DayAfterTomorrow implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {		
		return temporal.plus(2, ChronoUnit.DAYS);
	}
	
}

public class Ex11 {

	public static void main(String[] args) {
	
		LocalDate today = LocalDate.now();  // 2022.3.22
		LocalDate date = today.with(new DayAfterTomorrow());
		System.out.println( date );  // 이틀 후 ~ 
		
		
	} // main

} // class
