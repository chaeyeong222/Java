package days06;

public class Ex06_08 {

	public static void main(String[] args) {
		// 문제풀이
	      // 8번 문제
	      // ____*
	      // ___*
	      // __*
	      // _*
	      // *
		for(int i =1; i<=5; i++) {
			for(int j = 1; j<=6-i; j++) {
				System.out.print("_");
			}System.out.print("*");
			System.out.println(" ");
		}
		
		//방법 2   -> 같은 행, 열 일때는 * 찍고 아니면 공백처리/ if else 문 사용
		for(int i =0; i<5; i++) {
			for(int j = 0; j<=5; j++) {
				if(i==5-j) 
				System.out.print("*");
				else
				System.out.print("_");	
			}
			System.out.println(" ");
		}

	}//main

}//class
