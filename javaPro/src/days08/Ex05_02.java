package days08;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오후 3:28:02
 * @subject   제어문+연산자+[메서드 선언 + 호출] 응용/ 활용 예제
 * @content 
 *                     메서드를 매개변수를 사용해서 호출하는 방법
 *                     1. Call by Name          이름만가지고 호출
 *                     2. Call by Value          ->값을 가지고 메서드 호출방법   268p.
 *                     3. Call by Point            X c언어에서 씀
 *                     4. Call by Reference       참조형(배열, 클래스, 인터페이스)을 가지고 메서드 호출 방법
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// 두 기억공간의 값을 교환


		int [] m = {10,20};
		
		System.out.printf("x=%d, y=%d\n",m[0],m[1]); //x=10,y=20
		
		swap(m); //call by reference
		//값 Call by Value X. -> 참조형 Call by Reference
		//참조형(배열, 클래스, 인터페이스)을 매개변수 메서드 호출 call by reference
		
		System.out.printf("x=%d, y=%d\n",m[0],m[1]); //x=10,y=20

	}

	private static void swap(int[] m) {
		int temp =m[0];
		m[0]=m[1];
		m[1]=temp;
		
	}

	private static void swap(int x, int y) {
		System.out.printf("swap before : x=%d, y=%d\n",x,y); 
		int temp =x;
		x=y;
		y=temp;
		System.out.printf("swap after : x=%d, y=%d\n",x,y); 
	}

		
	

}
