package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 4:25:09
 * @subject p.268 참조형 반환타입
 * @content 
 */
public class Ex09_02 {

	public static void main(String[] args) {
		int a = 10;
		int b = test(a);
		System.out.println(b);

		//[참조형 반환타입 설명]
		MyPoint p1 = new MyPoint();
		p1.x=1;
		p1.y=2;

		MyPoint p2 = new MyPoint();
		p2.x=100;
		p2.y=200;

		MyPoint p3 = plusPoint(p1, p2);	
		p3.dispPoint();
	}

	//리턴자료형이 'MyPoint'라는 클래스 참조타입
	private static MyPoint plusPoint(MyPoint p1, MyPoint p2) {
		MyPoint p3 = new MyPoint();

		p3.x = p1.x+p2.x;
		p3.y = p1.y+p2.y;

		return p3;
	}

	//                         기본형 리턴타입
	private static int test(int a) {

		return a+100;
	}

}
