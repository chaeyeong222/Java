package days06;

public class Ex05 {

	public static void main(String[] args) {
		// 문제-내가 푼 것.
		
		//1번
		for(int i=1; i<=4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}System.out.println("");
		}
	
		//2번
		for(int i=4; i >= 0; i--) {
			for(int j=i; j>0; j-- ) {
			System.out.print("*");
			}System.out.println("");
		}
			
		//3번
				for(int i=0; i <4; i++) {
			       for(int j=0; j<4-i; j++ ) {
				    	System.out.print(" ");
					}
					for(int j=0; j< i+1; j++) {
						System.out.print("*");
					}
				   System.out.println();
		}
		
		//4번

		for (int i = 0; i<4; i++) {
			for(int j = 0; j<i ; j++) {
				System.out.print(" ");
			}for(int j =0; j<4-i; j++) {
			System.out.print("*");
			}
		    System.out.println();
		}
		
		//5번 ?
		//6번  ?
		//7번
		for(int i=1; i<=4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println("");
		}

		//8번
		for(int i=4; i >= 0; i--) {
			for(int j=i; j>0; j-- ) {
			System.out.print("*");
			}System.out.print("*");
			System.out.println("");
		}
		//9번 ?
	}}
