package days08;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오후 4:58:31
 * @subject p.270. 재귀호출recursive call 재귀함수
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		int result = recursiveSum(10); //재귀함수
		System.out.println(result);
		
	}

	//return 10+9+8+7+6+5+4+..+recursiveSume(1)
	private static int recursiveSum(int n) {
		if(n==1) return n;
		else        return n + recursiveSum(n-1);
	}

	private static int sum(int n) {
		int sum =0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}

}//class
