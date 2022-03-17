package days09;

import java.util.Random;

public class Ex04_04 {

	public static void main(String[] args) {
		// 배열 안에서 중복 체크
		Random rnd = new Random();
		boolean flag = false;//중복안됨, 되면 true

		int [] lotto = new int[6];
		
		int idx = 0;
		
		while(idx<=5) {
			int temp = rnd.nextInt(45)+1;
			
			if(!isDuplicateLotto(lotto, idx, temp)) {
				lotto[idx++] =temp;
				
			}
			
		}
		
		System.out.println("end");
		
	}
	//배열 안에서 해당위치 값을 중복체크해서 중복되면 true 안되면 false 값으로 반환
	public static boolean isDuplicateLotto(int [] lotto, int idx, int temp) {
		boolean flag=false;
		for(int i = 0; i<idx; i++ ) {
			if(temp==lotto[i]) {;
			flag = true;
			break;
			}
		   }return flag;
	}

}
