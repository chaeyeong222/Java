package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 2:49:04
 * @subject  p.425 예외발생시키기
 * @content   개발자가 고의로 예외를 발생시킬 수 있다.
 *                  왜?
 *                  throw 문 사용
 *                  1) 예외 객체 생성
 *                  2) throw문 예외 객체;
 */
public class Ex12 {

	public static void main(String[] args) {
		
		int a =10;
		int b=20;
		
		NullPointerException e = new NullPointerException("강제 널 예외 발생");
		throw e;
		//throw new NullPointerException("강제 널 예외 발생");
		
		//throw new RuntimeException();
				
		//int c= a+b;
		//System.out.printf("%d+%d=%d\n",a,b,c);
		
		//System.out.println("정상 종료");

	}

}
