package days15;

//좌표를 다루는 속성, 기능이 구현된 클래스
public class MyPoint {

	//필드
	public int x;
	public int y;
	
	//메서드
	public void dispPoint() {
		System.out.printf("x=%d,y=%d\n",x,y);
	}

	public void offsetPoint(int pos) {
		x += pos;
		y += pos;
		
	}

	//호출한 객체명. 메서드명(참조형 매개변수)
	//p1.plusPoint(p2)
	public void plusPoint(MyPoint p2) {
		x += p2.x;
		y += p2.y;
	//그냥 x라고 해도 plusPoint()메서드를 호출한 객체의 필드 x,
     //즉,      p1.plusPoint의 p1.x가 된다.	
	}
	
	
	
}
