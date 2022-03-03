package days04;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 12:17:03
 * @subject  [단항연산자]
 * @content   n++ 후위형 증감연산자
 *                   ++n 전위형 증감연산자
 *                   
 *                   
 *                   음수를 나타내는 부호 연산자 : 단항연산자
 *                   산술연산자 : 이항연산자
 */
public class Ex04 {

	public static void main(String[] args) {
		/*  [++             --]
		 * 단항연산자,   증감연산자
		 * 
		 * 
		 * [시험]
		 * 기억공간의 값을 1 증가, 감소시키는 코딩하세요
		 */
		
		int n = 10;
		System.out.printf("n=%d\n", n);
		
		++n;
		
		System.out.printf("n=%d\n", n);


	}

}
