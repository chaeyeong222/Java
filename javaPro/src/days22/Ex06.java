package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 이채영
 * @date 2022. 3. 21. - 오후 3:33:10
 * @subject p.532 예제 10-3 풀어보기
 * @content p. 533 예제 10-4 날짜/시간 자주 쓰는 것
 *                          [차이점?]
 *                      오늘 날짜 c.2022.1.31
 *                      c.add(Calendar.DATE, 1 )   2022.2.1
 *                      c.roll(Calendar.DATE, 1)   2022.1.1 다른필드에는 영향x
 */
public class Ex06 {

	public static void main(String[] args) {
		// [문제]개강일로부터 100일 기념으로 휴강, 언제일까?
		Calendar openday = new GregorianCalendar(2022, 2-1,15);
		
		//1년 전
		openday.add(Calendar.YEAR, -1);
		System.out.println(toString(openday));
		
		//한 달 전
		openday.add(Calendar.MONTH, -1);
		System.out.println(toString(openday));
		
		//add()  +100 백일 후
		//add()  - 100 백일 전
		openday.add(Calendar.DATE, 100);
		System.out.println(toString(openday));  //5월25일

	}
	public static String toString(Calendar c) {
		return String.format("%d년 %d월 %d일"
				,c.get(Calendar.YEAR) 
				, c.get(Calendar.MONTH)+1
				,c.get(Calendar.DATE));
	}

}
