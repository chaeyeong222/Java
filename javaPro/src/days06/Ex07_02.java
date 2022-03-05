package days06;

import java.util.Scanner;

public class Ex07_02 {

	public static void main(String[] args) {
		// 윤년인지 평년인지 구하기
		
		int year = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("년도 입력?");
		String regex = "\\d+";
		String sYear;
		
		do {
			System.out.print("연도?");
			sYear = scan.next();
		}while ( !sYear.matches(regex));
		
		//days06.Ex07_02.isLeapYear()메서드 선언
		
		if(isLeapYear(year)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		year = Integer.parseInt(sYear);
		System.out.println(year);

		
	}//main
	

	public static boolean isLeapYear(int year) {
	      if ( year % 4 == 0  && year % 100 != 0 || year % 400 == 0) {
	         return true;  // 메서드 호출한 곳으로 리턴
	      } else {
	         return false;
	      } 
	   } // isLeapYear [method == function] == procedure(프로시저)

	
	
}//class
