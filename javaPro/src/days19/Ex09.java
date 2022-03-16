package days19;

/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 2:20:03
 * @subject p.418 예제 8-3
 * @content 
 */
public class Ex09 {

	public static void main(String[] args) {
		
		int number = 100;
		int result =0;
		
		for (int i = 0; i < 10; i++) {
			try {
			result = number/(int) (Math.random()*10);  //0-9정수 발생
			System.out.println(result);
			}catch (ArithmeticException e) {
				System.out.println(0);
			}
			}

	}

}
