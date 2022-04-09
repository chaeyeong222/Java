package days17;

public class Ex08_04 {

	public static void main(String[] args) {
		/*
		Temp emp5 = new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000);
		emp5.dispEmpInfo(); // 재정의 메서드 호출( 확인 )
		System.out.println( emp5.getPay() ) ; // 근무일수 *  하루일당
		*/

		// 업캐스팅( 자동 )
		Employee emp5 = new Temp("정도연", "경기도 남양주", "010-8278-8888", "2020-04-09", 21, 100000);
		emp5.dispEmpInfo(); // 재정의 메서드 호출( 확인 )
		// System.out.println( emp5.getPay() ) ; // is undefined 에러 메시지...
		
	} // main

} // class

