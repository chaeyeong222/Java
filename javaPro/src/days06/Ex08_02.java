package days06;

public class Ex08_02 {

	public static void main(String[] args) {
		// 구구단의 한 단을 입력받아 출력 (세로출력)
		
		for(int dan=1; dan<=9; dan++) {
			for(int i =2; i<=9; i++) {
				System.out.printf("%d*%d=%d\t",i, dan, dan*i);
			}
			System.out.println();
		}

	}

}
