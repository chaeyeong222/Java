package days18;

import days17.Regular;

public class Ex04 {

	public static void main(String[] args) {
		//p.347 추상abstract 키워드
		//abstract기타제어자를붙여서 선언한 몸체가 없는 불완전한 메서드를 추상메서드라고 한다
		// 왜 사용?
		//employee에는 getPay함수 x, R/S/T getPay() 0
		//  emp.getPay() 호출불가   -> 호출되게 하기 위해서
		
		//Employee- getPay() 급여계산하는 메서드 없음
		//R-getPay() 재정의- s 재정의-getPay()
		//T-getPay() 재정의    <- 
		
		//다형성 E=R, E=S, E=T
		//         dispEmpInfo() 호출가능
		//         getPay() 호출 불가능
		
		//추상클래스            클래스             업캐스팅 가능
		Regular emp2 = new Regular("김재우","서울 강남구","010-2345-6789","2019-03-05",3000000);
		

	}

}
