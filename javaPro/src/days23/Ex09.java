package days23;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
/**
 * @author 이채영
 * @date 2022. 3. 22. - 오후 4:11:52
 * @subject p.559 날짜와 시간 비교하는 메서드
 * @content     예제 10-22 코딩해보기
 *                         오늘날짜가 생일이 지났는지 여부 체크
 */
public class Ex09 {

	public static void main(String[] args) {
		/*
		Date d = new Date();
		d.after(when);
		d.before(when);
		d.equals(d);
		d.compareTo(when);
        */
		//LocalDate + LocalTime
		LocalDateTime dt1 = LocalDateTime.now();
		//System.out.println(dt1); //2022-03-22T16:12:47.455
		dt1 = dt1.truncatedTo(ChronoUnit.DAYS);  
		LocalDateTime dt2 = LocalDateTime.of(2022,3,22,0,0,0);
		System.out.println(dt1.isEqual(dt2)); //false 왜? 시간달라서
		System.out.println(dt1.compareTo(dt2)); //0   -1  1

	}

}
