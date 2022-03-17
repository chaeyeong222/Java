package days09;

import java.util.Random;

public class Ex04_03 {

	public static void main(String[] args) {
		// 배열 안에서 중복 체크
		Random rnd = new Random();
		boolean flag = false;//중복안됨, 되면 true

		int [] lotto = new int[6];
		lotto [0] =7;
		lotto [1] =32;
		lotto [2] =15;
		lotto [3] =8;
		
		int idx = 4;
		int temp;

		do {
			flag = false;//초기화
			temp = rnd.nextInt(45)+1;
		
		for(int i = 0; i<idx; i++ ) {
			if(temp==lotto[i]);
			flag = true;
			break;
		   }
		}while(flag);
		
		
	}

}
