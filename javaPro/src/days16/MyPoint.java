package days16;

public class MyPoint {
	//필드 field = 멤버변수
	//필드를 초기화하지 않으면 각 자료형이 기본값으로 초기화되어있다. 
	private int x;
	private int y;  
	
	//생성자 선언
	public MyPoint(int x, int y) {
		this.x=x;
		//y=y;   //우측의 y가 int y인지 필드값의 y인지 몰라
		this.y=y;  //클래스의 멤버 y
		System.out.println(">MyPoint 2 생성자 호출됨");
	}

	public MyPoint() {
		System.out.println(">MyPoint 디폴트 생성자 호출됨");
	}

	public MyPoint(int x) {
		//**다른 모든 코딩보다 맨 위에 있어야 한다**
		this(x, 100);   //this의 두 번째 용도 : 생성자에서 또 다른 생성자 MyPoint (int x, int y)호출하는 this
		//this.x=x;
		//this.y            //this의 첫 번째 용도 : 멤버(필드)를 가리키는 this
		System.out.println(">MyPoint 1 생성자 호출됨");
	}
	

	public MyPoint(MyPoint p) {
		x = p.x;
		y = p.y;
	}

	//getter / setter 자동 생성 Alt + Shift+ s(오른쪽마우스 source)
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		if(x>=-100 && x<=100) {
			this.x = x;
		}else {
			System.out.println("x값의 유효범위가 벗어났다. ");
		}//*** this 키워드?

	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//메서드
	public void disPoint() {
		System.out.printf(">x=%d, y=%d\n", this.x, this.y);
	}
	//offsetPoint() 메서드를 호출한 객체, 즉 p1이 this이다
	//
	public void offsetPoint(int pos) {
		this.x += pos;
		this.y += pos;
	}
	//this == p1
	//p1.offsetPoint(p2);
	//p1.x = 15, y =105     x=16, y=107
	//p2.x =1, y=2             x=1,y=2	
/*	public void offsetPoint(MyPoint p) {
		this.x += p.x;
		this.y += p.y;
	}
	*/
	//[암기]
	// 오버로딩 - 메서드명 동일, 매개변수 갯수, 타입 달라야한다
	//              리턴자료형만 다르다고 오버로딩 되지 않는다.	
	
	public MyPoint offsetPoint(MyPoint p) {
		this.x += p.x;
		this.y += p.y;
		
		return this;   //this의 3번째 용도
	}


}
