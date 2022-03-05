package days06;

public class Ex06_06 {

	public static void main(String[] args) {
		// 문제풀이
	      // 6번 문제( 마름모 )
	      // __*
	      // _***
	      // *****
	      // _***
	      // __*

		 for(int i =1; i<=5; i++) {
			 for (int j=1; j<=5; j++) {
				 System.out.print(i+j>=4 && j-2<=i && i-j<=2  && j-i <=2 ? "*" : "_");   
			 }
			System.out.println("");
			}
		

	}//main

}//class
