package days06;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수 n,m 입력");
		n = scan.nextInt();
		m= scan.nextInt();
		
		int sum = 0;
		/*
		if(n>m) {
			int temp = n;
			n=m;
			m=temp;
		}
		
		for(int i=n; i<=m; i++) {
			sum +=i;
			System.out.print(i + "+");
		}*/
		
		// 더 좋은 방법
		int min = n>m? m:n;
		int max =n>m? n:m ;
		
		for(int i=min; i<=max; i++) {
			sum +=i;
			System.out.print(i + "+");
		}
		
		System.out.println("\b="+sum);
		 
		
		
		scan.close();

	}

}
