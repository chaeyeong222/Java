package days16;

//import days15.MyMath;

public class Ex08 {

	public static void main(String[] args) {
		/*
		 * Q. static변수=클래스 변수를 왜 선언해서 사용하나요?
		 *    Save.rate 필드처럼
		 *      객체를 생성하기 전에도 하나만 생성해서 공유해서 사용하기 위해
		 * Q. static메서드 = 정적 메서드를 왜 선언해서 사용하나요?
		 *    ㄱ. 객체를 생성하기 전에 static클래스 변수는 메모리에 할당되고,
		 *          클래스명.클래스변수 를 사용할 수 있음.
		 *          but, private 선언하였다면 접근할 수 없음.
		 *          따라서  static + getter, setter
		 *          클래스명.정적메서드 (); 선언해서 사용       ->ex. 클래스명.getter();
		 *     ㄴ. 자주 사용되는 메서드는 static 메서드로 선언한다.
		 *         (객체를 생성해서 사용x, 클래스명.static메서드 바로 호출o)     
		 */

		//Math.pow(2,3)
		//클래스명.static메서드();ㅣ
		
		//MyMath math = new MyMath();
		System.out.println(MyMath.sum(1,2,3));
		System.out.println(MyMath.sum(1,2,3,5,6,7));
		int [] m = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(MyMath.sum(1,2,3));
		
	}

}
class MyMath{
public static int sum(int...m) {  //가변 인자, int...m = int [] m을 의미함.
	int result = 0;
	for (int i = 0; i < m.length; i++) {
		result += m[i];
	}
	return result;
}
}
