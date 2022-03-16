package days19;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("a,b ?");
		a = scan.nextInt();
		b= scan.nextInt();
		
		//java.lang.ArithmeticException: / by zero 예외발생
		//0을 입력받을 경우를 개발자가 예측해서 예외처리
		//if문은 예외처리로 보지 않음.
		
		
		
		
		double c = a/b;
		
		System.out.printf("%d/%d = %.2f\n",a,b,c);

	}

}
