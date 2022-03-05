package days06;

public class Ex08 {

	public static void main(String[] args) {
		// 구구단의 한 단을 입력받아 출력
		
		for(int dan=2; dan<=9; dan++) {
			for(int i =1; i<9; i++) {
				System.out.printf("%d*%d=%d\t",dan, i, dan*i);
			}
			System.out.println();
		}

	}

}
