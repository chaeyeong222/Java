package days25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 3:34:56
 * @subject p. 633 예제 11-22
 * @content 
 */
public class Ex11 {
	public static void main(String[] args) {
		//랜덤한 수 1-50 까지의 수   5행5열로 채우기
		//set은 집어넣는 대로 순서유지x 중복유지x 
		//랜덤한 숫자가 집어넣어진 대로 순서유지하기위해 linkedhashset 사용
		//Set<Integer> set = new HashSet<Integer>();
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		while(set.size()<25) {
			set.add((int)(Math.random()*50)+1);
			
		}
		
		
		//1차원 -> 2차원
		//2차원 -> 1차원
		int [][]bingo = new int [5][5];

		Iterator<Integer> ir = set.iterator();
		int idx=0;
		while (ir.hasNext()) {
			Integer n = (Integer) ir.next();
			bingo[idx/5][idx%5] = n;
			idx++;
			System.out.printf("[%02d]",n);
			if(idx%5==0 ) System.out.println();
		}
	}//main
	}//class
/*		
	LinkedHashSet<Integer> lh = new LinkedHashSet<Integer>();
	Random rnd = new Random();
	lh.add(rnd.nextInt(25)+1);
	
	Iterator<Integer> ir = lh.iterator();
	while (ir.hasNext()) {
		Integer m = (Integer) ir.next();
		
	}
	
	}




}
*/
