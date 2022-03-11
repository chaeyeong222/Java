package days15;

public class Tv {// extends java.lang.Object 생략 - 상속

	public String color;
	public boolean power;
	public int channel;
	
	public Tv (){
	}
	public Tv(String c) {
		color=c;
	}
	
	public void power(){
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
 	
}

