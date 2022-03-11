package days15;

public class Ex01 {

	public static void main(String[] args) {

		//에러메시지 The constructor System() is not visible.
		//인스턴스화 할 수 없는 메세지 이다.(It cannot be instantiated.)
		// ->System system= new System();		

		//클래스 선언 형식
		// [접근지정자] [기타제어자] class 클래스명 [extends슈퍼클래스] [implements인터페이스..]{}


		/*1. oop
		 * - 객체지향 프로그래밍, 각 데이터를 객체로 보고 객체지향적 방법으로 프로그래밍
		 *2. 클래스 
		 *  - 설계도
		 *3. 객체
		 *  - 설계도를 통해 실제로 존재하는 것
		 *4. 인스턴스
		 * - new연산자에 의해 힙영역(메모리 상)에 생성된 객체.
		 *5. 인스턴스화
		 * -클래스로 객체를 만드는 과정
		 *6. 클래스의 구성요소
		 *  - 기능(함수,메서드) + 속성(멤버변수,필드)
		 *  - 필드 2가지 종류 : 인스턴스 필드, 클래스 필드
		 *7. 클래스 선언 형식
		 *  - [접근지정자] [기타제어자] class 클래스명[extends 슈퍼클래스] [implements인터페이스]
		 *8. 클래스 특징 = oop특징
		 * -  추상화, 상속성, 캡슐화, 다형성
		 *9. 객체 선언 및 생성
		 * - 클래스명 변수명 = new 클래스명()
		 *10. 클래스 설계과정
		 *
		 *11. 클래스와 객체와 인스턴스의 차이점 
		 *클래스는 객체의 설계도, 객체는 클래스를 통해 실제로 존재하는 것, 
		 *
		 *[클래스 선언 시 접근 지정자 종류 설명]
		 *1)public :패키지 내/외부 어디서든 상속,참조 가능
		 *2) defalut : 패키지 내부에서만 상속,참조 가능
		 *---------3,4는 독립적인 클래스로 선언할 때는 사용할 수 없는 접근지정자
		 *              중첩클래스(내부클래스)로 선언시에는 가능-------------------------
		 *3) private: 같은 파일 내에서만 상속,참조 가능
		 *4) protected : 패키지 내부에서만 상속,참조 가능 + 패키지 외부에서는 상속만 가능
		 *
		 *
		 *
		 *1) 같은 패키지 안에서 public 클래스 Tv와 default 클래스 Person 참조 가능한지 확인.
		 *days15.Ex01.main() 메서드에서
		 *           ㄴ public days15.Tv         클래스 참조 사용
		 *           ㄴ. public days15.Person 클래스 참조 사용
		 */
		/*		Car myCar = new Car();
		Car 클래스
		myCar 객체
		new Car()  인스턴스화 , (생성된 것: 인스턴스)
		 */

		//          1. Tv 객체 선언하고 생성 -> public으로 

		Tv t1 = new Tv();
		t1.channel = 11;
		t1.channelUp();
		System.out.println(t1.channel);

		//         2. Person 객체 선언하고 생성 ->default로

		Person p1 = new Person(); //default 접근지정자로 선언된 클래스를 같은 패키지 안에서 참조가능한지 확인
		p1.name="홍길동";
		p1.run();
		p1.name = "서영학";
		p1.run();


	}

}