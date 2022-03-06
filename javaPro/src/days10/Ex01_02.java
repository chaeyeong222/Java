package days10;

/**
 * @author 이채영
 * @date 2022. 3. 2. - 오전 9:05:49
 * @subject 
 * @content 제어문 + 배열 응용/활용 예제
 */
public class Ex01_02 {

	public static void main(String[] args) {
		// 피보나치 수열
		// 첫번째 항과 두번째 항은 1로 고정, 세번째 항 부터는 앞의 두 항의 합
		//1 1 2 3 5 8 13 21 34 55 ...  ?
		//                                        <=150
		int first = 1;
		int second = 1;
		int next;
		int sum = 0;
		System.out.printf("%d+%d+",first,second);
		
		while((next = first+second)<=150) {
			System.out.printf("%d+",next);
			first = second;
			second = next;
			sum+=next;
		}System.out.println("\b="+sum);
		

	}

}
