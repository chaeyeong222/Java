package days05;

public class Ex11 {

	public static void main(String[] args) {
		// 
		int i = 1, sum = 0;
		
		while(i<=10) {
			sum += i;
			
			if(i==10 ) {
				System.out.print(i);
			}else
				System.out.print(i+"+");
			i++;
			
		}System.out.println("="+sum);
		
		//3항연산자로도 가능 System.out.print( i ==10? i : i+"+);
		
		//while
		//   '\b' 제어문자 back space
		System.out.println("\b=" + sum);

	}

}
