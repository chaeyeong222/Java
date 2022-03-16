package days19;

public class H_Engine implements IEngine{

	int speed;

	@Override
	public void moreFuel(int fuel) {
		this.speed += fuel*0.03;
	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= fuel*0.03;
	}

	@Override
	public void stop() {
		this.speed = 0 ;

	}

	//디폴트 메서드 재정의해서 사용할 수도 있다.
	@Override
	public void print() {
		// TODO Auto-generated method stub
		IEngine.super.print();
	}
	

}
