package days06;

public class Ex06_04 {

	public static void main(String[] args) {
		// 문제풀이
	      // 4번 문제
	      // ****
	      // _***
	      // __**
	      // ___*
		

		for(int i =1; i<=4; i++) {
			
			//[공백]
			for(int k = 1; k<=i-1; k++) {
				System.out.print("_");
			}
				//[별]
			for(int j = i; j<=4; j++ ) {
				System.out.print("*");
			}System.out.println("");
		}
		

	}//main

}//class
