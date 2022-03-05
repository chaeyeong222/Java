package days06;

public class Ex06_02 {

	public static void main(String[] args) {
		// 문제풀이
	      // 2번 문제
	      // ****
	      // ***
	      // **
	      // 
		
		/*
		 * i =1      j= 4****
		 * i =2      j= 3***
		 * i =3      j= 2**
		 * i =4      j= 1*
		 * 
		 * i+j = 5
		 *    j = 5-i
		 
			*/
		//방법1
		
		for(int i =1; i<=4; i++) {
			for(int j =1; j<= 5-i; j++) {
				System.out.print("*");
			}System.out.println();
		}
		
		
		
		//방법2
		
		 for(int i =4; i >0 ; i--) {
			 for (int j=i; j>0; j--) {
				 System.out.print("*");
			 }System.out.println(" ");
		 }
		 

		 System.out.println("-------------------------");

	
		 for(int i =1; i<=4; i++) {
			 for (int j=1; j<=4; j++) {
				 if(i+j<=5)  System.out.print("*");
				 else      System.out.print("_");    //i>=j? "*":"_" 로 간단하게도 가능
			 }System.out.println("");
		 }
		 
		
	}//main

}//class
