package days10;

/**
 * @author 이채영
 * @date 2022. 3. 2. - 오전 9:05:49
 * @subject 
 * @content 제어문 + 배열 응용/활용 예제
 */
public class Ex01 {

	public static void main(String[] args) {
		// 피보나치 수열
		// 첫번째 항과 두번째 항은 1로 고정, 세번째 항 부터는 앞의 두 항의 합
		//1 1 2 3 5 8 13 21 34 55 ...  ?
		//                                        <=150
		int first = 1;
		int second = 1;
		int sum = 0;
		
		
		int [] a = new int [100]; 
		
		a [0] = first;
		a [1] = second;
		for(int i=0; a [i] <=150; i++) {
			a[i+2] = a[i] + a[i+1];
			sum+=a[i];
			System.out.printf("%d+",a[i]);
		}System.out.printf("\b="+sum);
		
	}

}
