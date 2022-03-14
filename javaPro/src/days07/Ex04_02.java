package days07;

public class Ex04_02 {

	public static void main(String[] args) {
		//각 줄마다 라인번호 붙이고 싶다
		
		for(int i =0; i<=255; i++) {
			if(i%10 == 0) System.out.printf("%d : ", i/10+1);
			System.out.printf("[%c]", i); 
			if(i%10==9) System.out.println();
		}System.out.println();
		
		System.out.println("--------------------------------");
		
		int lineNumber = 1;
		for(int i =0; i<=255; i++) {
			if(i%10 == 0) System.out.printf("%d : ", lineNumber++);
			System.out.printf("[%c]", i); 
			if(i%10==9) System.out.println();
		}
		
	}

}
