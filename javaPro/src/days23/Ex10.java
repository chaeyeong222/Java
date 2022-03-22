package days23;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오후 4:20:33
 * @subject p.560  instant 클래스 == java.util.Date 클래스를 대체하기위한 클래스
 * @content 
 *           Date -> instant 변환하는 메서드 추가
 *           from()  메서드는  instant -> Date 변환메서드
 *           toInstant()  =    Date -> Instant 변환 메서드
 *           
 *           p.564 예제 10-23 풀어보기
 */
public class Ex10 {

	public static void main(String[] args) {
		LocalDate d= LocalDate.now();  //날짜
		LocalTime t = LocalTime.now();  //시간
		
		//1.
		//날짜 + 시간을 가진 객체 LocalDateTime
		LocalDateTime dt = LocalDateTime.of(d,t);
		
		//2.LocalDateTime dt
		dt = d.atTime(t);
		
		//3. 
		dt = t.atDate(d);
		
		//LocalDateTime  ->LocalDate 만 or LocalTime 만
		LocalDate a = dt.toLocalDate();
		LocalTime b = dt.toLocalTime();
		
		//

	}//main

}//class
