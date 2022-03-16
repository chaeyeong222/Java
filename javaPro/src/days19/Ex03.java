package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오전 10:26:01
 * @subject p.397 인터페이스 이해 2가지 사항
 * @content   클래스 사용하는 쪽:User/ 제공하는 쪽:Provider
 *       메서드 호출하는 쪽 user                 메서드 선언부만 파악되면 구현된 내용 필요 x
 *       ???Manager 클래스
 *       -> 관리자 클래스 ??? 관리함.
 *        ex. BeanManager
 *          -> new Bean(); 관리     
 *    
 */
public class Ex03 {

	public static void main(String[] args) {
		
	}

}

class A{  //user
	void methodA(IE obj) {
		obj.print();//메서드 호출 . 사용
	}
}
interface IE{
	void print();
}

class B implements IE{
	public void print() {
		
	}
}