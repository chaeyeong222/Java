package days04;


/**
 * @author 이채영
 * @date 2022. 2. 18. - 오전 11:53:13
 * @subject  쉬프트shift 연산자   >>      <<
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		System.out.println( 15  >> 2 );  //3     첫 부호가 1이면 0        0이면 1?
		System.out.println( 15  >>> 2 );  //3     부호비호 상관없이 모두 0
		System.out.println( 15  << 2 );  //60

		
		//[시험]
		//10                   0000 1010 (2진수 출력표현)
		System.out.println(Integer.toBinaryString(10));  //"1010" String 리턴자료형
		                                                                        // 2진수 값을 문자형으로
		//10->8진수
		System.out.println(Integer.toOctalString(10));  //"12" String 리턴자료형	
		
		// 10-16진수
		System.out.println(Integer.toOctalString(10));  //"a" String 리턴자료형	
		
		
		
		/* 시험   int -> String 변환하는 코딩하기
		 *         String -> int 변환하는 코딩하기   
		 *             
		 * 10    ->  "10"형변환
		 * 	int     -> String 형변환
	    */
		
		String n = 10 +"";  // "10"
		
		int m = Integer.parseInt("10");
		
	 }
}
