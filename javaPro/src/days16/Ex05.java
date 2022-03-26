package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오후 12:01:59
 * @subject  클래스(객체) 복사copy와 복제clone 
 * @content  얕은 복제(복사)
 *                  깊은     ''
 */
public class Ex05 {

	public static void main(String[] args) {

		MyPoint p1 = new MyPoint(10,20);

	/*	//1. 객체(클래스) 복사 (copy)
	
		   MyPoint p2 = p1;
		   p2.setX(100);
		   System.out.println(p1.getX()); //100
		*/ 
		
	//	MyPoint p2 = new MyPoint(p1.getX(), p1.getX());
		
			MyPoint p2 = new MyPoint(p1); //참조형 매개변수
		
		p2.setX(100);
		System.out.println(p1.getX());   //p2.x에 100 넣더라도 p1값인 10 출력 됨/


	}

}
