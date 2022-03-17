package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 3:31:45
 * @subject  p.429 예제 8-12
 * @content 
 */
public class Ex14 {

	public static void main(String[] args) throws Exception {
		//try{
		method1();
		//}catch (Exception e) {
		//	e.printStackTrace();
		//}
	}

	private static void method1() throws Exception {
		//try{
		method2();
		//} catch (Exception e) {
		//e.printStackTrace();
		// }
		System.out.println(">method1() 호출됨");
	}

	private static void method2() throws Exception {
		System.out.println(">method2() 호출됨");

		throw new Exception(); //컴파일러가 에외 체크 "checked 예외"
	}

}
