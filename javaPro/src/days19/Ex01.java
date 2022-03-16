package days19;

public class Ex01 {

	public static void main(String[] args) {


		Car myCar = new Car();
		myCar.setEngine(new H_Engine());  //setter통한 의존성 주입(DI)
		//myCar 10년 이용
		myCar.setEngine(new K_Engine()); //낡은 엔진바꾸기, 호환됨
		
		myCar.setEngine(new H_Engine());

	}

}
/*
 * 1. OOP의 특징에 대해서 자세히 설명하세요 . 
 *     상속성, 다형성, 캡슐화, 추상화
 * 2. 패키지와 import문에 대해서 설명하세요 
 *    패키지는 클래스들의 집합
 *    다른 패키지 안의 클래스를 사용하려면 패키지명.클래스명 으로 작성해야하는데
 *    매번 다른 패키지의 명을 작성하기 번거로우므로 import문을 사용하여 한번만 넣고
 *    반복해서 사용한다.
 *    
 * 3. abstract 키워드에 대해서 설명하세요
 *     추상화
 * 3-2. 추상 메서드
 *   100%추상 메서드
 * 3-3. 추상 클래스
 *    본체를 가지고 있지 않은 클래스
 * 4. 싱글톤을 구현하는 방법에 대해서 설명하세요. 
 * 5. 업캐스팅과 다운캐스팅에  대해서 설명하세요.
 *   업캐스팅 : 자식클래스가 부모클래스의 변수를 사용하는 것 , 자동 형변환
 *   다운캐스팅 : 부모클래스가 자식클래스의 변수를 사용하는 것, 강제로 형변환 해줘야 한다.
 * 6. 매개변수의 다형성에 대해서 설명하세요.
 * 
 * 7. 인터페이스의 다형성에 대해서 설명하세요.
 * 
 * 8. 멤버 앞에 붙이는 접근 지정자에 대해서 자세히 설명하세요. 
 *   public 패키지 내부.외부에서 사용가능
 *   protected 같은 패키지에서만사용 가능 + 상속
 *   default 같은 패키지 안에서만 사용가능
 *   private 같은 클래스 안에서만 사용 가능
 * 9. 인터페이스 개요 
 * 
 * 9-2. 인터페이스 선언 형식
 * 9-3. 인터페이스 장점
 *   4가지
 * 9-4. 인터페이스의    멤버의  제약 사항
 * 9-5. 아래 코딩에서 인터페이스 관련해서 설명할 수 있는 것에 대해서 설명하세요 
   public static void main(String[] args) { 
   
      List  list = new ArrayList();  ->인터페이스 업캐스팅 
      disp(  list  );
      disp( new ArrayList() );
   } // main        
   private static void disp(  List list  ) {  ->인터페이스 다형성
   }
 * 
 * */