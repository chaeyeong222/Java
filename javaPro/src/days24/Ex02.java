package days24;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오전 9:35:44
 * @subject p572. 파싱parse과 포멧format 
 * @content  java.time.format패키지 -DateTimeFormatter클래스
 * 
 */
public class Ex02 {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today); //2022-03-23
		
		/*
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String stoday = formatter.format(today);
		System.out.println(stoday); //2022년 3월 23일 (수) LONG /2022년 3월 23일 수요일 FULL
		*/

		//"2022년3월23일"  ->내가 원하는 형태로 만들기 p.573
		String pattern = "yyyy년 M월 dd일";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String stoday = formatter.format(today);
		System.out.println(stoday);
        //[기억]
		//Date, Calendar -> 포멧,파싱 -> SimpleDateFormat 클래스 사용
		//JDK 1.8 LocalDate,LocalTime, LocalDateTime->포멧, 파싱-> DateTimeFormatter클래스 사용
		/*
		//날짜 정보만 가지는 클래스
		LocalDate d = LocalDate.of(2022,2,15);
		System.out.println(d);

		//String s = DateTimeFormatter.ISO_DATE_TIME.format(d); 시간까지 달라하면 오류
		String s = DateTimeFormatter.ISO_DATE.format(d);
		System.out.println(s);

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		s=d.format(formatter);
		System.out.println(s); //위랑 같은 코딩
		 */
	}

}
