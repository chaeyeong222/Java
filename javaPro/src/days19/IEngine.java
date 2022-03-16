package days19;

public interface IEngine {
	
	//상수 public static final 생략
	int MAX_SPEED = 300;
	
	//추상메서드 public abstract 생략
	void moreFuel(int fuel);
	void lessFuel(int fuel);
	void stop();
	
	default void print() {
		
	};//인터페이스 메서드 추가
	
	//디폴트메서드
	default void addMethod() {
		//코딩
		//코딩
	}
	//static메서드
	static void test() {
		System.out.println(">IEngine.test()...");
	}
}
