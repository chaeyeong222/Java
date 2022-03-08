package days12;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오전 10:44:53
 * @subject p.202 예제 5-6(197p) 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		int [] score = {79,88,91,33,100,55,95};
		int max = score[0];
		int min = score[0];
		for (int i = 1; i < score.length; i++) {
			//max = max<score[i[? score[i]:max;
			if(score[i] >= max) max = score[i];  
			else if(score[i] <= min) min = score[i];  
		}System.out.printf("최대값: %d, 최소값:%d",max, min);
		

	}

}
