package days05;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// 1-10까지의 합
		/*
		int sum = 0;
		for(int i=10 ; i>=1; i--) {
 		System.out.print(i + "+");
			sum+=i;
		}
		
		
		System.out.println("="+sum);
	*/
		int i;
		int sum = 0;
		
		for( i = 1; i<=10;i++) {
			System.out.print(i + "+");
			
			sum +=i;
			
		}
		System.out.println("=" + sum);
				System.out.println("=end=");
	}
	/*
	
	// 같음.
	int i;
	int sum = 0;
	for(  ;  ;   ) {
		
		if(i==11) break;
		
		System.out.print(i + "+");
		
		sum +=i;
		
	}
*/
	}
