package days08;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// 두 정수 입력받아서 합 출력하는 코딩
		
		int x, y;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("두 정수 x,y 입력?");
		
		x=scan.nextInt();
		y=scan.nextInt();
		
		int z = sum(x,y);
		
		System.out.printf("%d+%d=%d\n",x,y,z);
		
		
		scan.close();
	
	}//main

	//두 정수의 합을 구해서 리턴하는 메서드 
	/*1. 기능-메서드명 sum
	 * 2. 매개변수
	 * 3. 리턴값(리턴자료형)
	 */
	
			public static int sum(int x, int y) {
				
				return x+y;  //return 수식;
				
				/*int result  = x+y; (^이게 더 좋은 수식)
				 * return result;     
				 */
			}
	
}//class
