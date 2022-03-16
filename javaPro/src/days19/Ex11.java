package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 2:39:21
 * @subject p.423 
 * @content 
 *                   다중 catch문 : catch블럭을 여러 개 사용한 것
 *                   멀티 catch문 : | 기호 사용한 것
 *                            -> 상속관계가 있는(부모 | 자식클래스)클래스 사용시 에러 발생함.
 */
public class Ex11 {

	public static void main(String[] args) {
		int [] m = new int [3];
		
		//멀티 catch 문
		try {
			m[0]=1;
			m[100]=20;  //ArrayIndexOutOfBoundsException
			int result = 100/0;  //ArithmeticException
		    System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
			//instanceof 연산자를 사용해서 어떤 예외인지 확인 가능하다
			//if ( e instanceof ArrayIndexOutOfBoundsException)
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("그 외의 예외 발생함");
		}
	
		
		
		/*   다중catch 문 설명
		 try {
			m[0]=1;
			m[100]=20;  //ArrayIndexOutOfBoundsException
			int result = 100/0;  //ArithmeticException
		    System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 벗어남");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
		}catch (Exception e) {
			System.out.println("그 외의 예외 발생함");
		}
		 */
		
	}

}
