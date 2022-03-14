package days07;

public class Ex01_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int k = 1; k <=2; k++) {
			System.out.println("k="+k);
			 for(int i = 1; i <=9; i++) {
				for(int dan = 4*k-2; dan<=4*k-2+3; dan++) {
						System.out.printf("%d*%d=%d\t", i, dan, dan*i);
				}
					System.out.println();
				}System.out.println();
	}

}
}