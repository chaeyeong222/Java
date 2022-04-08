package days17;

public class Ex08_02 {

	public static void main(String[] args) {
		// 클래스들 간의 형변환 upcasting/ downcasting -상속관계가 있어야 한다.
		//[상속계층도]
		// Object
		//    ^||
		//Employee
		//    ^||
		//Regular
		
		//왜? Regular객체를 생성해서 왜 employee 참조?
		//클래스 형변환(E/R 상속관계)
		//자식객체 생성해서 부모객체에 참조시키는 것을 "업캐스팅(upcasting)"이라고 한다
		//업캐스팅은 자동형변환된다
		// 정규직도 사원이다 (is-a관계)
		Regular emp2 = new Regular("김재우","서울 강남구","010-2345-6789","2019-03-05",3000000);
		//체크사항 -> 왜 regular의 재정의한 메서드가 호출되는가?
		emp2.dispEmpInfo();
		//이유는 모르지만 재정의된 메서드가 호출이 된다(기본급도 호출됨) -> 암기
		//System.out.println(emp2.getPay());
		
		//부모객체 emp2를 다시 자식 객체 emp3에 참조시키자(다운캐스팅)  자동형변환 안됨-> 강제형변환 cast 연산자
		Regular emp3 = (Regular) emp2;

	}

}
