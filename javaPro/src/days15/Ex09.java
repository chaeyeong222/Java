package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 3:55:42
 * @subject p. 264 기본형 매개변수와 참조형 매개변수
 * @content p. 268 참조형 반환타입
 */
public class Ex09 {

	public static void main(String[] args) {
		MyPoint p1 = new MyPoint();
		p1.x = 10;
		p1.y = 20;
		p1.dispPoint();
		
		//기본형 int 5 == 기본형 매개변수
		
		
		p1.offsetPoint(5);
		p1.dispPoint();
		//x=15,y=25
		
		MyPoint p2 = new MyPoint();
		p2.x=1;
		p2.y=2;
		
		//     MyPoint 2 == 참조형 매개변수
		p1.plusPoint( p2);
		//p1.x = p1.x+ p2.x;
		//p1.y = p1.y+ p2.y;
		p1.dispPoint();
	
	}

}
