package days05;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("정수 입력");
		
		Scanner scan = new Scanner(System.in);
		
		String result="";    //null과 ""의 차이점? 
		
		int n = scan.nextInt();
		if(n%2==0) {result= "짝수";}
		else    {result= "홀수";}
		System.out.println(result);
		
		scan.close();

	}

}
