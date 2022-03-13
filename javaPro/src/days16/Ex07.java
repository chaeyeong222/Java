package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오후 2:27:12
 * @subject  static 키워드 설명
 * @content  정적 변수 = static변수 = 클래스 변수 = 공유변수shared
 *                  정적 메서드 = static 메서드 
 *                  정적 클래스 = static 클래스 (중첩클래스) 아직 설명x
 *                  
 *                  변수 3가지 종류
 *                  - 지역변수, 인스턴스 변수, [클래스 변수]
 *                  메서드 2가지 종류
 *                  - 인스턴스 메서드, static 메서드(정적메서드)
 *    ======================
 *    1.제어자 modifier - static 키워드
 *    2. 클래스 앞 선언 -> public static class Test {}
 *        변수 앞 선언 ->  public static int x;
 *        메서드 앞 선언 -> publi static void disp(){}
 *    3. static 사용할 수 있는 곳 : 멤버변수(필드), 메서드, 초기화 블럭 p. 302
 */
public class Ex07 {

	public static void main(String[] args) {
		/* 1. 저축과 관련된 클래스 선언 - Save
		 *     속성, 기능 파악-> 목록 작성
		 *      ㄴ 예금주, 잔고(금액), 이자율, 가입일...
		 *      ㄴ 입금,출금...
		 */

		Save p1 = new Save("일길동", 15000, 0.02);
		Save p2 = new Save("이길동", 4000, 0.02);
		Save p3 = new Save("삼길동", 50000, 0.02);
		Save p4 = new Save("사길동", 500, 0.02);
		Save p5 = new Save("오길동", 105000, 0.02);

		//에러메시지 : The field Save.rate is not visible
		//->접근지정자가 private이라 접근 못함.
		//Save.rate = 0.04;
		//클래스명.정적메서드()
		Save.setRate(0.04);
		System.out.println(Save.getRate());

		Save [] ps = {                              
				new Save("일길동", 15000, 0.02), 
				new Save("이길동", 4000, 0.02),  
				new Save("삼길동", 50000, 0.02), 
				new Save("사길동", 500, 0.02),   
				new Save("오길동", 105000, 0.02)
		}; //alt+shift+a 로 복사함

		for (int i = 0; i < ps.length; i++) {
			ps[i].dispSave();
		}
		ps[3].setRate(0.07);
		for (int i = 0; i < ps.length; i++) {
			ps[i].dispSave();
		}

	}	
}
