package days02;


/**
 * @author 이채영
 * @date 2022. 2. 16. - 오후 2:32:01
 * @subject 
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		//정수를 저장할 x,y변수를 선언하고 각각 10,20으로 초기화 
		// 출력형식:x=10,y=20 출력하는 코딩
		//조건 printf()메서드 사용
		
		int x=10;
		int y=20;
		
		System.out.printf("x=%d, y =%d\n",x,y);
		
		//두 기억공간의 값 교환하기 (임시기억공간 만들기)
		{
		int temp = x;
		x=y;
		y=temp;
		}
		
		System.out.printf("x=%d, y =%d\n",x,y);
		
		

	}
}
