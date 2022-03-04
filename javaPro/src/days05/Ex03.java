package days05;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// [문제]
		/*국어점수를 입력받아서 수/우/미/양/가
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		int kor = scan.nextInt();
		
		//if문 사용풀이
		
		if(90<= kor && kor <=100) 
			System.out.println("수");
		else if(80 <=kor)
			System.out.println("우");
		else if(70 <=kor)
			System.out.println("미");
		else if(60 <=kor)
			System.out.println("양");
		else if(0<=kor)
			System.out.println("가");
		else
			System.out.println("숫자를 다시입력하세요");
			
			
			
	
		
		scan.close();
		
	}

}
