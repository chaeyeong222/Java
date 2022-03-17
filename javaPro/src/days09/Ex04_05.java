package days09;

import java.util.Random;

public class Ex04_05 {

	public static void main(String[] args) {
		
		int [] lotto = new int [6];
		
		fillLotto(lotto);
		
		dispLotto(lotto);
		
		
		

	}
	public static boolean isDuplicateLotto(int [] lotto, int idx, int temp) {
		return false;
	}

	private static void dispLotto(int[] lotto) {
		Random rnd= new Random();
		for(int i = 0; i<lotto.length; i++) {
		lotto [i] = rnd.nextInt(45)+1;
		}
		
		
	}

	private static void fillLotto(int[] lotto) {
		
		
	}

}
