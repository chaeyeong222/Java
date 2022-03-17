package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 4:05:49
 * @subject  p.435 예제 8-19
 * @content 
 */
public class Ex16 {

	public static void main(String[] args) {
		int result = method();
		
		System.out.println("end");
		
	}

	private static int method() {
		try {
			System.out.println(">method1() - [1]");
			System.out.println(">method1() - [2]");
			return 1; //리턴값을 가지고 호출한 곳으로 리턴되더라도 finally블럭은 처리함
		} catch (Exception e) {
			System.out.println(">method1() - [3]");
			return -1;
		}finally {
			System.out.println(">method1() - [4]");
		}
		//return 0;
	}

}
