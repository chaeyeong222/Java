package days05;

import java.util.Scanner;

public class Ex03_03 {

	public static void main(String[] args) {
		// [문제]
		/*국어점수를 입력받아서 수/우/미/양/가
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		
		int kor = scan.nextInt();
		String grade;
		
		System.out.println("점수를 입력하세요");
		
		//switch 문 사용풀이
		//boolean형은 switch문에 사용불가
		
		switch( kor/10) {
		case 10:
			grade="수";
			break;
		case 9:
			grade="우";
			break;
		case 8:
			grade="미";
			break;
		case 7:
			grade ="양";
			break;
		default:
			grade ="가";
			break;
		
		}
		
			System.out.println(grade);
			
			
			
	
		
		scan.close();
		
	}

}
