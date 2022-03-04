package days05;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 21. - 오전 10:39:05
 * @subject  [제어문]
 * @content  switch 분기문
 */
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*
		 * key : 변수, 수식, 정수, 문자열
		 * value : 리터럴 (값), 변수 x
 		 */
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String result=""; 
		switch( n %2) {
			case 0 : 
				result = "짝수";
				break;
				
			case 1:
				result = "홀수";
				break;
			
		};
		
		System.out.println("정수 입력");
		
	
		
		scan.close();

	}

}
