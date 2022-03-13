package days16;

//저축 클래스
public class Save {

	//필드
	//인스턴스 변수
	private String name;
	private int money;
	//->인스턴스 변수는 반드시 객체를 생성한 후, '객체명.필드명' 으로 사용한다
	//->클래스 변수는 객체 생성하기 전에도 클래스명.필드명으로 사용이 가능하다.
	//                    프로그램이 시작하면 메모리 잡힘, 종료하면 제거됨.
	
	
	
	//클래스 당 하나만 생성해서 공유 사용
	//공유변수, 정적(static)변수, [클래스 변수]
	private static double rate = 0.02;

	//디폴트 생성자
	public Save() {
		
	}

	//생성자3
	public Save(String name, int money, double rate) {
		this.name = name;
		this.money = money;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	//메서드 method
	//예금 정보를 출력하는 메서드 선언

	//static이 붙어 있는 메서드
	//프로그램이 시작하면 사용할 수 있다.
	
	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		Save.rate = rate;
	}

	//인스턴스 메서드
	public void dispSave() {
	System.out.printf("예금주:%s\t예금액%d\t이자율:%.2f\n"
			              , this.name, this.money, this.rate);	//this 안써도 됨.
	}
	
}
