package days06;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// 윤년인지 평년인지 구하기
		
		int year;
		Scanner scan = new Scanner(System.in);
		System.out.println("년도 입력?");
		//입력값에 대한 유효성검사를 한 후에 year 변수 대입.
		//year= scan.nextInt();
		//회원가입 -> 필수사항, 비밀번호 4~8문자, 특수문자, 알바텟 대1소1문자 (유효성검사)
		
		//우선 문자열 "2021"  =>sYear 저장
		
	// 	String sYear = scan.next();
		
		// String.matches()메서드
		//1. 기능 : 주어진 매개변수인 정규표현식 (regex)에 일치하는지 체크하는 메서드
		//2. 매개변수 : String regex
		//3. 리턴자료형 : boolean형 t/f로 반환
		//regex = regular expression 의 줄임말
		//[0-9] 0부터 9까지 / '+' -> 반복횟수(1번이상)
	   // String regex = "[0-9]+";   ==  String regex = "\\d+";
		//System.out.println(sYear.matches(regex));
			
		//입력이 잘못되었을 경우 다시 연도를 입력받도록 처리한다. 
		/*
		String regex = "\\d+";
		if(sYear.matches(regex)) {
			year = Integer.parseInt(sYear);
		}
		scan.close();
		*/
		
		String regex = "\\d+";
		String sYear;
		
		//Tells whether or not this string matches the given regular expression.
		do {
			System.out.print("연도?");
			sYear = scan.next();
		}while ( !sYear.matches(regex));
			
		year = Integer.parseInt(sYear);
		System.out.println(year);

		if(year %4 ==0 && year%100 !=0 || year %400==0) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
		
	}

}
