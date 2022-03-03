package days04;


/**
 * @author 이채영
 * @date 2022. 2. 18. - 오전 11:36:03
 * @subject  [비트논리연산자]   p. 115
 * @content  비트논리연산자   ~  &  ^  |  (우선순위)
 *             ~ : 틸드연산자(비트 부정 연산자)
 *             & : 비트논리 and 연산자
 *             ^ : XOR 연산자  (exclusiveOR 연산자 => 배타적인=> 서로 다를때 참인 연산자)
 *             | : 비트 논리 or 연산자
 *             
 */
public class Ex02 {

	public static void main(String[] args) {
		
		int i = 10;
		System.out.println( ~i);  //결과값 : -11
		
		/*
		 * 비트연산자 10          0000 1010 (2)
		 * 비트연산자 ~10        1111 0101 (2)
		 *                                -> -11(10진수)
		 */

		System.out.println(10 & 3);
		
		/* 10                  0000 1010
		 *  3                   0000 0011
		 *  &                   0000 0010
		 *  결과값                     2(10진수)
		 */
		
		System.out.println(10 ^ 3);
		/* 10                  0000 1010
		 *  3                   0000 0011
		 *  ^                   0000 1001
		 *  결과값                     9(10진수)
		 */
		
		
		
		System.out.println(10 | 3);
		/* 10                  0000 1010
		 *  3                   0000 0011
		 *  |                   0000 1011
		 *  결과값                     11(10진수)
		  */
		
	}

}
