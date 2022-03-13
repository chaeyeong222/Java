package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오전 10:20:51
 * @subject  [ getter/setter 이해 ] 
 * @content private 로 선언된 필트에 접근할 수 있는 메서드
 * 
 *             접근지정자를 바꾸지않고 굳이 getter setter 을 사용하는 이유?
 *                이유1: 쓰기 전용/ 읽기 전용의 멤버를 선언하고자 할 때(제어 할 때)
 *                이유2: 유효한 값을 멤버(필드)에 할당하고자 할 때
 * 
 */
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. MyPoint 클래스 선언
		//2. p1 객체 선언 및 생성
		MyPoint p1 = new MyPoint();
		//3. p1 객체의 멤버(필드)에 값 설정
		//객체명.필드명
		//에러메시지 The field MyPoint.x is not visible -> 접근지정자 때문
		//  private -> 같은 클래스 안에서만 접근할 수 있다. 
		// private 로 선언된 필드 x에 접근하는 방법? getter/ setter
		//p1.x = 10;              A->setX();        ->  x

		// x,y 좌표값의 유효 범위 ( -100 ~ +100)
		p1.setX(10);
		System.out.println(p1.getX());
		// p1.x = 10;
		
		// y 필드의 값을 쓰기는 가능, 읽기 불가능  /// y필드 값을 읽기는 가능, 쓰기 불가능 제어 원할때
		p1.setY(20);
		System.out.println(p1.getY());
	}

}
