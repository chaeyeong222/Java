package days24;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오전 9:54:33
 * @subject p.575 날짜/시간형식의 문자열을 날짜/시간으로 변환(파싱)하기
 * @content 
 */
public class Ex02_03 {

	public static void main(String[] args) {
		
		String s1 = "2022년 2월 15일 12시 34분 56초";
		String pattern = "yyyy년 M월 dd일 HH시 mm분 ss초";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime t = LocalDateTime.parse(s1,formatter);
		System.out.println(t);
		
		
		/*
		//String -> LocalDate 변환
		
		String s1 = "12:34:56";
		s1="12시34분56초";
		
		//hh:1-12   HH: 0-23
		String pattern = "HH시 mm분 ss초";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		
		LocalTime t = LocalTime.parse(s1,formatter);
		System.out.println(t); //12:34:56
		*/
		/*
		//String -> LocalDate 변환
		String s1 = "2022-02-15";
		s1="2022년2월15일"; 

		String pattern = "yyyy년 M월 dd일";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate d = LocalDate.parse(s1, formatter);
		System.out.println(d);
		 */
	}

}
