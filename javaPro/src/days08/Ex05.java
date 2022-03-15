package days08;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오후 3:28:02
 * @subject   제어문+연산자+[메서드 선언 + 호출] 응용/ 활용 예제
 * @content 
 *                     메서드를 매개변수를 사용해서 호출하는 방법
 *                     1. Call by Name          이름만가지고 호출
 *                     2. Call by Value          ->값을 가지고 메서드 호출방법
 *                     3. Call by Point            X c언어에서 씀
 *                     4. Call by Reference       참조형(배열, 클래스, 인터페이스)을 가지고 메서드 호출 방법
 */
public class Ex05 {

	public static void main(String[] args) {
		// 두 기억공간의 값을 교환
		int x=10, y=20;
		
		System.out.printf("x=%d, y=%d\n",x,y); //x=10,y=20
		
		//[문제] 두 값을 교환하는 메서드 swap 를 선언 +호출 
		/*
		{
			int temp =x;
			x=y;
			y=temp;
		}*/
		
		swap(x, y);
		System.out.printf("x=%d, y=%d\n",x,y); //x=10,y=20

	}

	private static void swap(int x, int y) {
		System.out.printf("swap before : x=%d, y=%d\n",x,y); 
		int temp =x;
		x=y;
		y=temp;
		System.out.printf("swap after : x=%d, y=%d\n",x,y); 
	}

		
	

}
