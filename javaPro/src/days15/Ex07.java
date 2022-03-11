package days15;

public class Ex07 {

	public static void main(String[] args) {
		//p.348 접근제어자 access modifier  = 접근 지정자
		// [멤버(필드,메서드, 생성자constructor)선언시 앞의 접근지정자의 종류, 설명]
		/* 1.public        - 패키지 내/외부 어디서나 접근(참조) 가능
		 * 2.default       - 같은 패키지 내에서만 접근(참조) 가능
		 * 3. private		- 같은 클래스 내에서만 접근(참조) 가능
		 * 4. protected  - 같은 패키지 내에서만 접근(참조) 가능
		 *                                 +상속( 다른 패키지의 자손클래스에서 접근(참조)가능)
		 *
		 *범위 : public > protected > default > private
		 *
		 *지역변수는 접근지정자 붙일 수 없다
		 */

		//test -> time 클래스와 비교
		//days15 -> 같은 패키지 내부O 같은 클래스X
		Time t = new Time();
		//에러메시지 : The field Time.hour is not visible ***
		//원인: 접근지정자 때문에 보이지 않는다.
		//	t.hour = 12;
		t.minute =35;             //default
		t.millisecond = 1234;  //public
		t.nano = 1234;           //public
	}

}
