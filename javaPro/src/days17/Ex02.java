package days17;

public class Ex02 {

	public static void main(String[] args) {
		// p.310 Chapter 07 객체지향적 프로그래밍 2
		//클래스들간의 2가지 관계
		/*1) has -a 관계
		 *     Car - Engine 클래스들 간의 관계
		 * 2) is -a 관계 (상속)
		 */

		//Car.engine.moreFuel(20);
		Engine engine = new Engine();
		
		Car myCar = new Car();  //생성자 통한 의존성 주입
		
		myCar.setEngine(engine); //setter통한 의존성 주입
		myCar.speedUp(20);
		
		System.out.println("END");
	}

}
