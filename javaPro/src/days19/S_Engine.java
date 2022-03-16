package days19;

public class S_Engine implements IEngine{

	int speed;

	@Override
	public void moreFuel(int fuel) {
		this.speed += fuel*0.05;
	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= fuel*0.05;
	}

	@Override
	public void stop() {
		this.speed = 0 ;

	}

}
