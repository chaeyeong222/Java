package days08;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오후 4:58:31
 * @subject p.270. 재귀호출recursive call 재귀함수
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		disp();

	}
	//재귀호출
	//재귀[호출]메서드(함수)

	private static void disp() {
		System.out.println("disp()메서드 호출됨");
		disp();
	}

}
