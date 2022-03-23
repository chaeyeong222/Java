package days24;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Ex01_02 {

	public static void main(String[] args) {
		LocalTime t1 = LocalTime.now();
		LocalTime t2 = LocalTime.of(12,34,56);
		
		//between()메서드 -static 메서드
		//until() 메서드 -인스턴스 메서드
		Duration d = Duration.between(t1, t2);
		//t1.until(t2, null);
		System.out.println(d.getSeconds());
		System.out.println(d.getNano());
		
		long hour = d.getSeconds()/60/60;
		long minute = (d.getSeconds()/hour*3600)/60;
		long second = (d.getSeconds()/hour*3600-minute*60)%60;
		int nano = d.getNano();
		
		//of() :설정
		Period p = Period.of(1, 12, 31); //1년12개월31일
		p.withYears(1);      //2년12개월31일
		p.plusYears(3);      //5년12개월31일
		p.minusYears(3);    //2년12개월31일
		//with()  수정
		//plus()   +수정
		//minus()  -수정
		
		
		
	}

}
