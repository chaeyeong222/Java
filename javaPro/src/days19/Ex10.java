package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 2:29:42
 * @subject  p.419 try~catch문 흐름(처리과정)
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		System.out.println("1 코딩");
		System.out.println("2 코딩");

		try {
			System.out.println("3 코딩");
			System.out.println(100/0);
			System.out.println("4 코딩");
		} catch (Exception e) {
			System.out.println("5 코딩");
		}finally { //반드시 있어야 할 문은 아님 
			//예외발생 여부에 관계없이 항상 처리하는 블럭 :finally
			//ex. data 열어서 예외발생과 무관하게 파일 닫는 작업은 수행 
			System.out.println("final{} ..");
		}
		System.out.println("6 코딩");
		System.out.println("정상 종료");
		
	   // e.printStackTrace() : 메서드 정보와 예외메세지를 화면에 출력하는 메서드
	   // e.getMessage()   : 예외 메시지를 반환하는 메서드

	}

}
