package days19;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 4:10:39
 * @subject p.436 자동 자원 반환 try -with-resources문 
 * @content JDK 1.7~ 새로추가된 구문
 *                 주로 IO입출력과 관련된 클래스 사용할 때 유용하다.
 *                 
 */
public class Ex17 {

	public static void main(String[] args) {
		//Resource leak: 'scan' is never closed
		/*Scanner scan = new Scanner(System.in);
		
		scan.next();

		scan.close(); //자원반환(닫기)
	*/
		
		//try -with-resources문 자동자원반환
		
		try {Scanner scan = new Scanner(System.in);
		
		scan.next();
		//scan.close(); 안써도 자동으로 닫아줌
		} finally {
			
		}
	}
}
