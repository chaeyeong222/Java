package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 2:04:30
 * @subject p.240 객체 배열
 * @content 수 많은 객체를 만들때 배열을 사용하면 편리하다 
 */
public class Ex05 {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		
		p1.name = "1번사람";
		p1.run();
		p2.name = "2번사람";
		p2.run();
		p3.name = "3번사람";
		p3.run();
		p4.name = "4번사람";
		p4.run();
	}

}
