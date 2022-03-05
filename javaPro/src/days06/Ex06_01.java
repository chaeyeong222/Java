package days06;

public class Ex06_01 {

	public static void main(String[] args) {
		// 문제풀이
		// 1번 문제
	      // *
	      // **
	      // ***
	      // ****
		
		/*
		 * i =1      j= 1*
		 * i =2      j= 2**
		 * i =3      j= 3***
		 * i =4      j= 4****
		 	*/
		
		 for(int i =1; i<=4; i++) {
			 for (int j=1; j<=i; j++) {
				 System.out.print("*");
			 }System.out.println("");
		 }
		 

		 System.out.println("-------------------------");

	
		
		for(int i =1; i<=4; i++) {
			 for (int j=1; j<=4; j++) {
				 if(i>=j)  System.out.print("*");
				 else      System.out.print("_");    //i>=j? "*":"_" 로 간단하게도 가능
			 }System.out.println("");
		 }
		
		
		
		
		
		
		
		
	}//main

}//class
