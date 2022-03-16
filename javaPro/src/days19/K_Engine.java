package days19;

public class K_Engine implements IEngine{

	int speed;

	@Override
	public void moreFuel(int fuel) {
		this.speed += fuel*0.04;
	}

	@Override
	public void lessFuel(int fuel) {
		this.speed -= fuel*0.04;
	}

	@Override
	public void stop() {
		this.speed = 0 ;

	}

}
