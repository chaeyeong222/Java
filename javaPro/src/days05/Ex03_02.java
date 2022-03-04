package days05;

import java.util.Scanner;

public class Ex03_02 {

	public static void main(String[] args) {
		// [문제]
		/*국어점수를 입력받아서 수/우/미/양/가
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		int kor = scan.nextInt();
		
		//if문 사용풀이 2
		
		String grade = "가";    //초기값을 가 로 설정
		
		if(0 <= kor && kor <=100) {    //수~가 등급처리
			if(90<= kor)          grade = "수";
			else if(80 <=kor)   grade = "우";
			else if(70 <=kor)   grade = "미";
			else if(60 <=kor)   grade = "양"; 
				System.out.println(grade);
			
		} else {
	 		System.out.println("숫자를 다시입력하세요");
		}
		scan.close();
		
	}

	
}
