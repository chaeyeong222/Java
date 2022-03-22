package days23;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오후 3:45:58
 * @subject 
 * @content 
 *    LocalDate 날짜 클래스 - now(), of(), plusXX(), plus()
 *                                                     , withXX(), with(), minusXX() 
 *                                                     ,getXX(), get()
 */
public class Ex07_03 {

	public static void main(String[] args) {
		LocalTime t = LocalTime.now();
		System.out.println(t); //15:47:52.608

		//시간, 분, 초, 밀초
	     int minute = t.getMinute();
	     System.out.println(minute);
	     
	     minute = t.get(ChronoField.MINUTE_OF_HOUR);
	     System.out.println(minute);
	     
	     //10분후?
	    LocalTime minute2 = t.plusMinutes(10);
	     System.out.println(minute2);  //방법1
	     minute2 = t.plus(10, ChronoUnit.MINUTES);//방법2

	}

}
