package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 4:37:23
 * @subject  p. 277 클래스 메서드와 인스턴스 메서드
 * @content 
 *                메서드(멤버함수)의 종류
 *                   1. 클래스 메서드   (static 메서드)   
 *                   2. 인스턴스 메서드 
 *               p.280 클래스 멤버와 인스턴스 멤버간의 참조와 호출
 *               p.283 오버로딩
 *               
 *               p.287 가변인자(var(iable) + args(arguments 인자, 인수) =varargs )와 오버로딩
 *                        가변배열? days14.Ex03
 */
public class Ex10 {

	public static void main(String[] args) {
		//MyMath 클래스
		MyMath math = new MyMath();
		System.out.println( math.sum(1, 2));
		System.out.println( math.sum(1, 2, 3)); //계속 오버로딩 하는 건 번거로움
		
		int [] m = {1,2,3,4,5};
		System.out.println(math.sum(m));

	}

}
