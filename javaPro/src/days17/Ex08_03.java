package days17;

public class Ex08_03 {

	//final 붙이면 상수 필드됨
	public final static double PI = 3.141592;

	public final int MAX_VALUE;

	Ex08_03(){
		MAX_VALUE = 100;
	}

	public static void main(String[] args) {
		// [상속계층도]
		//   Object
		//     ^||
		//  Employee
		//     ^||
		//  Regular
		//	     ^||
		// final SalesMan(영업직) 사원 클래스

		/*
		 * 1) final 클래스 선언   -> 자식클래스를 가질 수 없는 최종클래스
		 * 2) final 변수   선언   -> 상수***
		 * 3) final 메서드 선언   -> 자식클래스에서 오버라이딩 할 수 없음. 
		 * 
		 *  자바는 모든 부모클래스의 인스턴스 메서드를 자식클래스에서 오버라이드 할 수 있다. 
		 */
		//지역변수
		//illegal modifier for parameter PI; only final is permitted
		//public final double PI = 3.141592;-> 지역변수는 접근지정자 못붙임
		final double PI = 3.141592;

		//disp(100);

		//생성자 호출 순서 암기하기
		//employee - regular- salesman

		/*
		SalesMan emp4	= new SalesMan("백경환", "서울강남구", "010-7845-1212", "2017-01-12", 500000, 20, 75000);
		emp4.dispEmpInfo();
		System.out.println(emp4.getPay());  //2000000기본급 +판매량*커미션

	}*/
		
	/*
		Employee emp4	= new SalesMan("백경환", "서울강남구", "010-7845-1212", "2017-01-12", 500000, 20, 75000);
		emp4.dispEmpInfo();
		System.out.println(emp4.getPay()); //Employee클래스 안에 getPay(), 메서드x
	
	}
*/
		//Employee dispEmpInfo() 호출-> SalesMan.dispEmpInfo() 재정의 메서드가 호출된다. **암기
	Employee emp4	= new SalesMan("백경환", "서울강남구", "010-7845-1212", "2017-01-12", 500000, 20, 75000);
	emp4.dispEmpInfo();
	//System.out.println(emp4.getPay()); //Employee클래스 안에 getPay(), 메서드x

}

	//매개변수 잘에 int i 대신 final int i가 들어가면 100 들어가고 상수화되었으므로 오류남.
	//한번 초기화하고나면 다른 값으로 바꿀수 없음.
	private static void disp(int i) {
		i+=1000;
		System.out.println("i=" +i);  //i=1100

	}

}
