package days06;

public class Ex06_07 {

	public static void main(String[] args) {
	      // 7번 문제
	      // *
	      // _*
	      // __*
	      // ___*
	      // ____*


		for(int i =0; i<5; i++) {
			for(int j = 0; j<=i-1; j++) {
				System.out.print("_");
			}System.out.print("*");
			System.out.println(" ");
		}
		
		//방법 2   -> 같은 행, 열 일때는 * 찍고 아니면 공백처리/ if else 문 사용
		for(int i =0; i<5; i++) {
			for(int j = 0; j<=5; j++) {
				if(i==j) 
				System.out.print("*");
				else
				System.out.print("_");	
			}
			System.out.println(" ");
		}
		
		

	}//main

}//class
