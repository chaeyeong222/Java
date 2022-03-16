package days19;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08_02 {

	public static void main(String[] args) {
		int a=0, b=0;
		double c=0;
		Scanner scan = new Scanner(System.in);
		
		
	
		//try ~ catch 문
		//JVM의 '예외처리기' 예외정보를 받아서 exception 객체 전달
		try {
			System.out.println("a,b ?");
			a = scan.nextInt();
			b= scan.nextInt();
			c = a/b;
		
			System.out.printf("%d/%d = %.2f\n",a,b,c);
		}catch (InputMismatchException e) {
			
			try {
				
			} catch (Exception e2) {
				
			}
			
			System.out.println(e.toString());   //에러: java.util.InputMismatchException
		}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage()); //에러:  by zero
		}
		/*catch (Exception e) {//업캐스팅
			e.printStackTrace();
			//java.lang.ArithmeticException: / by zero
			//at days19.Ex08_02.main(Ex08_02.java:19)
		}
		*/
		
		//주의할 점
		//다중 catch {} 를 사용할 때는 부모 예외 catch문을 나중에 코딩한다.
		
		
		
		
		
		

	}

}
