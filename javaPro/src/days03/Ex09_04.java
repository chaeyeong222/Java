package days03;

public class Ex09_04 {

	public static void main(String[] args) {
		/* `1.일반논리연산자 : &&   ||    !      p. 114
		 *      ㄱ. && 일반논리and 연산자(논리곱)   -> 둘 다 참일 때만 참
		 *      ㄴ. ||   일반논리 or 연산자 (논리합)  -> 둘 중 하나이상 참이면 참
		 *      ㄷ. !  부정연산자  ==  not연산자
		 * 
		 * 
		 */

		System.out.println(3>5  &&   100<2);    //false
		
		// 연산자 우선순위를 알아야 함
		// The operator ! is undefined for the argument types(s) int    p.91
	   // ! 피연산자가 5 int 정수값이 왔다.
	//	System.out.println(!5 >3);   //비교연산자보다 부정연산자가 우선순위가 높아서 오류남.
	
		
	
	}

}
