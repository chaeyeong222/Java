package days23;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오후 4:06:28
 * @subject p.558 truncatedTo() 절삭(제거)하다
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
	
		LocalTime t = LocalTime.of(12, 34,56);
		System.out.println(t); //12:34:56
		
		//시간 밑으로는 전부 제거
		t = t.truncatedTo(ChronoUnit.HOURS);
		System.out.println(t); //12:00
		
		
		

	}

}
