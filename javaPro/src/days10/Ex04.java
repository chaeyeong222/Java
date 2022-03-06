package days10;

import java.util.Scanner;
import days06.Ex07_02;

/**
 * @author 이채영
 * @date 2022. 3. 2. - 오전 11:45:39
 * @subject  main() 메서드의 매개변수의 의미/활용
 * @content  main() 메서드는 언제 호출되는가?
 *                 >java.exe   Ex04.java                   Ex04.class
                    >java.exe   Ex04 매개변수 매개변수 ,, 실행->시작객체(Ex04 클래스) -> main() 메서드 호출해서 실행
 */ 
public class Ex04 {

	public static void main(String[] args) {
		// main() 메서드의 매개변수가 String [] (문자열 배열) args 선언
		/*
		for(int i = 0 ; i<args.length; i++) {
			System.out.printf("args[%d]=%s\n",i,args[i]);
		}
	*/	
	//년도를 입력받아 윤년/평년 출력
		
		//java.exe  Ex04  2000치고 엔터치겠따
		int year = Integer.parseInt(args[0]);
	
 		if( days06.Ex07_02.isLeapYear(year)) {
	 //		if(isLeapYear(year)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
		
		System.out.println("=end=");
	}

}
