
package days16;

import days15.Tv;

/**
 * @author 이채영
 * @date 2022. 3. 11. - 오전 10:50:08
 * @subject  p. 291 생성자 constructor ~299
 * @content 
 *               1. 생성자 = 메서드
 *               2. 생성자의 역할 : 인스턴스 초기화(=인스턴스 변수(필드)를 초기화)
 *               3. 생성자 호출 시기 : 인스턴스가 생성될 때 호출된다.
 *                                         생성자는 강제로 호출 X
 *                                         즉, new MyPoint()이 실행될때, 생성자 호출됨
 *               4. 리턴값이 없고, void라는 키워드 조차 적지 않는다.
 *               5. 생성자 이름 == 클래스 이름(반드시)
 *               6. 접근지정자 4가지 사용 가능
 *               7. 매개변수가 없는 생성자를 디폴트 생성자(Default Constrtuctor)라고 부른다
 *               8. 생성자는 오버로딩 가능
 *               9. 클래스에 선언된 생성자가 하나도 없는 경우에 컴파일러가 자동으로 디폴트 생성자를 추가한다
 *               10. 생성자는 상속되지 않는다.
 * 
 */
public class Ex03 {

	public static void main(String[] args) {
		
	//	Tv t1 = new Tv();
		
		MyPoint p1;   //p1 객체 선언
		p1 = new MyPoint();  //인스턴스 생성
		
		p1.disPoint();
		
		p1.setX(10);
		p1.setY(20);
		
		p1.disPoint();
	}

}
