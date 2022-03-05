package days06;

public class Ex06_09 {

	public static void main(String[] args) {
		// 문제풀이
	      // 9번 문제
	      // *___*
	      // _*_*
	      // __*
	      // _*_*
	      // *___*
		
		for(int i =1; i<5; i++) {
			for(int j = 1; j<=5; j++) {
				if(i==j || i+j==6) 
				System.out.print("*");
				else
				System.out.print("_");	
			}
			System.out.println(" ");
		}
	}//main

}//class
