package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 12:13:20
 * @subject 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		//int x=10, y=20;
		Point p1 = new Point();
		p1.x = 10;
		p1.y = 20;
		//	System.out.printf(">x=%d, y=%d\n",p1.x,p1.y);
		p1.printPoint();


		//두 기억공간의 값을 바꾸는 swap()메서드를 선언해서 코딩을 수정
		//원인: Call by Value -> Call by Reference 참조형  으로 해야함.
		swap(p1);
		//System.out.printf(">x=%d, y=%d\n",p1.x,p1.y);
		p1.printPoint();	
	}

	private static void swap(Point p1) {
		int temp = p1.x;
		p1.x=p1.y;
		p1.y=temp;
	}
	/*
	
	 private static void swap(int x, int y) {
		int temp = x;
		x=y;
		y=temp;

	}*/
	 
	

}//class

//하나의 자바 파일(Ex04_02.java) 안에 여러개의 클래스를 선언할 수 있다.
// public 으로 선언된 클래스는 1개여야함.+ 그 클래스는 파일명.java 와 동일해야함. 
// 에러메시지 : The public type Pint must be defined in its own file
//             자체 파일에 정의되어야 한다.   
class Point{
	//필드 field 
	public int x;
	public int y;

	//메서드 method
	public void printPoint() {
		System.out.printf(">x=%d, y=%d\n",x,y);
	}

}