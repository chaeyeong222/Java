package days03;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오후 4:00:27
 * @subject  래퍼 (Wrapper) 클래스
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		// 래퍼클래스? 기본형을 사용하기 쉽도록 기능(메서드, 필드)을 구현해 (포장해)놓은 클래스
		// int i = 2147483647;
		
		//기본형 int ==> Integer클래스
		int i = Integer.MAX_VALUE;
		System.out.println(i);
		
		byte b = Byte.MAX_VALUE;
		System.out.println(b);
		
		/* char -Character
		 * byte -Byte
		 * short-Short
		 * int - Integer
		 * long -Long (기본형long을 사용하기 쉽게 만들어놓은 래퍼클래스)
		 * float -Float
		 * double - Double
		 * boolean-Boolean
		 * 
		 * 
		 * int kor = (int)"90"; (x)
		 * cast 연산자는 같은 숫자형일때만 형변환 가능하다.
		 * ㄴ 클래스들간의 형변환 할 때도 사용한다. UpCasting/DownCasting
		 */
		
		
		
		
	}

}
