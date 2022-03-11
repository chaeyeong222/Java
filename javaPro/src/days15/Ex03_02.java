package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오전 11:08:40
 * @subject 
 * @content 
 */
public class Ex03_02 {

	public static void main(String[] args) {

		Tv t1 = null;
		t1 = new Tv();
		t1.channel = 11;
		t1.power();

		Tv t2 = new Tv();//새로운 인스턴스가 생성되는 코딩.
		t2.channel =100;
		
		//*****중요*****
		//Tv t3 = null; //인스턴스 선언x 객체만 선언o
		//t3 = t2;
		Tv t3 = t2;
		//t2, t3은 같은 인스턴스를 참조하고 있기에 t2.channel=5, t3.channel = 5
		t2.channel =5;
		System.out.println(t3.channel);  //5

	}

}
