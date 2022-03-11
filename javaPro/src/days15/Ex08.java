package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 3:42:37
 * @subject 
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		/* p.246 변수와 메서드
		 * 1. 변수의 종류 - 선언 위치에 따라  표 6-3
		 *      ㄱ.클래스변수     static 키워드설명
		 *      ㄴ.인스턴스 변수 
		 *      ㄷ.지역 변수 **
		 */
		//메서드 호출 부분
		// 10,20을 인자, 인수arguments
		sum(10, 20);
		
		//return : 컴파일 할 때 자동으로 추가
		
		//p.261 JVM 의 메모리 구조
		// 용도에따라서
		//  ㄱ. call stack
		//  ㄴ. heap
		//  ㄷ. method area

	}

	//메서드 선언 부분
	//두 정수를 입력받아서 합을 반환하는 메서드
	//x,y 매개변수 parameter
	public static int sum(int x, int y) {
		return x + y;

	}

}
