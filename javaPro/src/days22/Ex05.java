package days22;

import java.util.Calendar;

/**
 * @author 이채영
 * @date 2022. 3. 21. - 오후 3:12:11
 * @subject p.531 예제 10-2
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 오늘 2022.03.21.월
		// 개강 2022.02.15.화
		// 수료일 2022.07.29. 
		
		//[문제1] 두 날짜 사이의 간격(일 수)얼마?
		// 개강~ 오늘까지 몇 일이 지났나?
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2022, 2-1, 15,0,0,0);
		date2.set(2022, 02, 21);
		
		long different = ((date2.getTimeInMillis()) - date1.getTimeInMillis())/1000;
		System.out.println(different/(24*60*60)+"일 지남");
				
		//[문제2] 두 날짜 사이의 간격
		//오늘~ 수요일까지 몇 일 남았나?
		date1.set(2022, 2, 21);
		date2.set(2022, 6, 29);
		//Calendar.August
		
		long different2 = ((date2.getTimeInMillis()) - date1.getTimeInMillis())/1000;
		System.out.println(different2/(24*60*60)+"일 남음");

	}

}
