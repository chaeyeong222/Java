package days05;

public class Ex04 {

	public static void main(String[] args) {
		//for 문
		
		int sum = 0;
		for ( int i=1; i <= 10; i++) {
			System.out.print(i + "+");
			sum = sum + i ;
		}
		System.out.println("=" + sum);

	}

}
