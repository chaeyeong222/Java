package days06;

public class Ex06_03 {

	public static void main(String[] args) {
		// 문제풀이
	      // 3번 문제
	      // ___*   i=1   j=3   
	      // __**   i=2   j=2
	      // _***   i=3   j=1
	      // ****   i=4   j=0
		 //                  j=4-i
		
		/*
		 * i =1      j= 1*
		 * i =2      j= 2**
		 * i =3      j= 3***
		 * i =4      j= 4****
		 */
		
		
		for(int i =1; i<=4; i++) {
          //[공백]
			for(int j =1 ; j<=4-i; j++) {
				System.out.print("_");
			}
			for(int k =1; k <= i; k++) {
				System.out.print("*");
			}System.out.println("");
		}
		
		
		
		 for(int i =1; i<=4; i++) {
			  //공백(_)
			 for(int j =1; j<= 4-i; j++) {
					System.out.print("_");
			 }
			 //별(*)
				   for (int k=1; k<=i; k++) {
						 System.out.print("*");
			 }System.out.println("");
		 }
		
		 System.out.println("-------------------------");
		 
		 
		 for(int i =1; i<=4; i++) {
			 for (int j=1; j<=4; j++) {
				 System.out.print(i+j>=5? "*" : "_");   
			 }System.out.println(" ");
		 }
		
	}//main

}//class
