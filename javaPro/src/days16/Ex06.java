package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오후 12:14:40
 * @subject  p.295   5.4생성자에서 다른 생성자 호출하기 - this(), this
 * @content 
 *      1. this 키워드 (예약어) 
 *      2. 정의? 클래스 자기 자신의 주소값을 갖는 참조변수(객체)
 *                 객체(인스턴스) 생성
 *                 0x100
 *      3. this의 3가지 용도
 *          ㄱ. 인스턴스(힙영역에 있는 클래스 자기 자신)의 멤버를 가리킬 때의 this
 *                 this.y =y; 
 *                 this.y  -> 멤버변수인 필드를 가리키는 용도
 *                 y         -> 생성자의 매개변수 y MyPoint(int x, int y)
 *          ㄴ. 생성자에서 또 다른 생성자를 호출할 때의 this
 *          ㄷ. 단독으로 사용될때의 this -> 리턴값, 매개변수
 */
public class Ex06 {

	public static void main(String[] args) {
		
		MyPoint p1 = new MyPoint(10);
		p1.disPoint();  //초기값 x 10만 줬는데 y값 100도 함께 출력됨 p.295  
		                      // x=10, y=100

		p1.offsetPoint(5);
		p1.disPoint();  // x=15, y=105
		
		MyPoint p2 = new MyPoint(1,2);
		p1.offsetPoint(p2);
		
		p1.disPoint();   //x=16, y=107
	}

}
