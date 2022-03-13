package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오후 3:47:21
 * @subject  p.300 ~307 변수의 초기화
 * @content 
 *     1. 변수의 초기화? 변수를 선언하고 처음으로 값을 저장(할당)하는 것.
 *     2. 지역변수 - 초기화하지않으면 에러남 (**반드시 초기화해야함)
 *         인스턴스 변수, 클래스 변수는 초기화안해도 각 자료형의 기본값으로 자동초기화.
 *     3. p.300 각 타입의 기본값 표
 *           boolean  - false
 *           int, short, byte - 0 
 *           long -0L
 *     4. 필드(멤버변수) 초기화 방법
 *        ㄱ. 명시적 초기화
 *        ㄴ. 생성자
 *        ㄷ. 초기화블럭
 *           1) 인스턴스 초기화 블럭
 *           2) 클래스 초기화 블럭
 */
public class Ex10 {

	public static void main(String[] args) {
		
	Person p1 = new Person ("홍길동", 26,0.04);
	System.out.println(p1.name+"/"+ p1.age+"/"+ p1.rate);
	System.out.println("고유번호: " + p1.serialNo);
	
	Person p2 = new Person();
	System.out.println("고유번호: " + p2.serialNo);
	
	}

}

class Person {
	//필드
	String name;
	int age;
	static double rate = 0.02;
	
	int count ;
	int serialNo;
	
	//생성자
	public Person() {	
		count++;
		serialNo = count;
	}
	public Person(String name, int age, double rate) {
		count++;
		serialNo = count;
		this.name =name;
		this.age = age;
		this.rate = rate;
	}
	
}
