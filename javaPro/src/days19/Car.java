package days19;

public class Car {

		String name;
		String gearType;
		int door;
		
		//IEngine 인터페이스 선언 -> 구현 S_,K_,H_Engine 클래스선언
		//추상클래스 업캐스팅
		//인터페이스 업캐스팅
		private IEngine engine = null;
		
		public IEngine getEngine() {
			return engine;
		}
		public void setEngine(IEngine engine) {
			this.engine = engine;
		}
		
		// 디폴트생성자
		Car() {
			this.engine = new S_Engine();
		}
		//엔진 객체 생성자 주입(의존성 주입)DI
		Car(IEngine engine) {
			this.engine = engine;
		}
		
		void speedUp(int fuel) {
			this.engine.moreFuel(fuel);
		}
		
		void speedDown(int fuel) {
			this.engine.lessFuel(fuel);
		}

		void stop() {
			this.engine.stop();
		}
	}


