package days12;

import java.util.Arrays;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오후 2:34:16
 * @subject p.204   예제 5-11 
 * @content 
 */
public class Ex09 {

	public static void main(String[] args) {
		//
		/*
		 * int []m = {3,5,2,4,1];
		 * Arrays.sort(m);
		 * System.out.println(Arrays.toString(m));
		 * 		 */
		
		int [] m = new int [30];
		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*10);          //rnd.nextInt(10); 
		}
		System.out.println(Arrays.toString(m));
		
		/*int cnt=0;
		for (int i = 0; i <10; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i == m[j]) 
					cnt++; 	   
			} System.out.printf("%d의 개수: %d\n", i, cnt );
			cnt = 0;	
		}
		 * 
		 */
		//[0의개수] [1의개수] ...
		int [] counter = new int [10];
		for (int i = 0; i < m.length; i++) {
			counter[m[i]]++;
		}
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("%d의 개수: %d\n", i, counter[i] );
		}
		
		
		
	}

}
