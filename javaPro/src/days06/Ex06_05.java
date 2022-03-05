package days06;

public class Ex06_05 {

	public static void main(String[] args) {
		// 문제풀이
	      // 5번 문제 ( 이등변 삼각형 )
	      // __*       i = 1          2
	      // _***     i = 2          1 
	      // *****   i = 3          0
		//                           j=3-i(공백)

		for(int i =1; i<=3; i++) {
			for(int j = 1; j <=3-i; j++) {
				System.out.print("_");
			}
			for(int j = 1; j<=(2*i-1); j++) {
				System.out.print("*");
			}
		System.out.println("");
		}
		

		 System.out.println("-------------------------");
		 
		 for(int i =1; i<=3; i++) {
			 for (int j=1; j<=5; j++) {
//				 System.out.print(i+j>=4 ? "*" : "_");   
	//			 System.out.print(j-2<=i  ? "*" : "_");   
				 System.out.print(i+j>=4 && j-2<=i? "*" : "_");   
			 }
			System.out.println("");
			}

		 
		 
	}//main

}//class
