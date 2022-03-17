package days19;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 3:08:20
 * @subject
 * @content  
 */
public class Ex13_02 {

	public static void main(String[] args) throws IOException {
		
		
		try {
		int kor = getScore();
		
		System.out.println(kor);
		}catch (ScoreOutOfBoundException e) {
			System.out.println(e.getERROR_CODE());
			System.out.println(e.getMessage());
		}catch (Exception e) {
			
		}
	}
	//0-100정수 입력 받아 반환하는 메서드
	public static int getScore() throws Exception{
		Scanner scan = new Scanner (System.in);
		int score;
		System.out.println("점수입력");
		
		String data = scan.next();
		
		if(data.matches("[1-9]?\\d|100")) {
			score = Integer.parseInt(data);
			return score;
		}else {
			//사용자 정의 예외 클래스 사용
		//	throw new ScoreOutOfBoundException("점수범위(0~100)벗어남");
			throw new ScoreOutOfBoundException(1001, "점수범위(0~100)벗어남");
		}
	}

	//메서드 선언 부분
	void method( ) throws NullPointerException, ArithmeticException, IOException{
		
	}
}
