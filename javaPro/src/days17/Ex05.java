package days17;

public class Ex05 {

	public static void main(String[] args) {
		// 생성자와 초기화 블럭은 상속되지 않는다.
		//has -a관계(포함관계) p.316
		//Circle-Point 관계
	}
}

//원 클래스
//class Circle extends Point{
	//[필드]
	//원점
	//int x;   상속
	//int y;   상속
	
	//반지름
	//int r;
//}

/*
//원 클래스   //has-a관계
class Circle{
	//[필드]
	//원점
	//int x;
	//int y;
	Point 원점 = null;
	
	Circle(){
		원점 = new Point();
	}
	Circle(Point p){
		this.원점 = p;
	}
	//반지름
	int r;
}

//좌표클래스
class Point {

	int x;
	int y;

	Point(){
		this(0,0); //this의 두번째용도- 생성자에서 또다른 생성자 호출
	}

	Point(int x, int y){
		this.x=x;   //this의 첫번째 용도-멤버(필드,메서드)가리킬 때의 this
		this.y=y;

	}
	String getXY() {
		return String.format("(%d,%d)", x,y);
	}
}*/