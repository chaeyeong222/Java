package days15;

public class Ex04 {

	public static void main(String[] args) {
		// 객체 선언 및 생성(인스턴스)
		Tv t1 = new Tv();
		System.out.println(t1.channel); //0
		
		//참조타입의 매개변수를 가지고 메서드 호출:Call by Reference
		changeTv(t1);
		System.out.println(t1.channel); //0

	}
	private static void changeTv(Tv t1) {
		t1.channel=100;
		
	}

}
