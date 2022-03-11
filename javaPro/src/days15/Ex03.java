package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오전 11:08:40
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		// p. 234 객체(인스턴스)생성과 사용 1-5번 이해
		// p.238 1-2번 이해
		// p.239 1-4번 이해

		//클래스? 객체의 설계도                          Tv
		//객체? 클래스를 자료형으로 선언된 참조변수   t1
		//객체 선언
		Tv t1 = null; //new 연산자에 의해서 인스턴스 생성X

		//The local variable t1 may not have been initialized
		//java.lang.NullPointerException 실제 힙 영역에 선언 x
		//해결 : 인스턴스 생성하기
		t1 = new Tv();
		//필드 초기화 x
		System.out.println(t1.channel); //int 기본값 0
		System.out.println(t1.power);    //boolean기본값 false
		System.out.println(t1.color); //String기본값 null
		//객체명.필드명 =11
		t1.channel = 11;
		//객체명.메서드명
		t1.power();


		/*
		 * int [] m = null;
		 * m[0] = 100; 
		 * 하면 java.lang.NullPointerException 에러남.
		 * 클래스 사용시 가장 많이 나는 오류
		 * 동적영역에 자리잡지 않았기 때문에 오류
		 */

	}

}
