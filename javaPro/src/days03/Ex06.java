package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오후 2:05:34
 * @subject [오후수업]
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) throws IOException {
		// 표준입력장치(키보드)로 부터 입력 받아서 출력.
		//String name = "홍길동";
		
		//System.out.printf("이름은 %s입니다", name);
		
		//[키보드] -> System.in 입력스트림  -> InputStreamReader 클래스 -> BufferedReader 클래스
		//  A              0100 0001                    'A' 'B' ,,                            [A][B][C]
		// "ABC"  
		
		
		//바이트 스트림을 문자로 변환해주는 역할
		// new InputStreamReader(System.in);
		// new BufferedReader(null);
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		//br 변수를 통해서 읽기작업을 하면 키보드로부터 입력한 값을 읽을 수 있다. 
		
		// Ctrl + Shift + O  (필요한 모든 import구문 자동 완성)
		//만약 [대화상자]가 띄워진다면, java.io.BufferedReader, java.test.BufferedReader 선택
		
		String nname;
		
		System.out.print(">이름을 입력하세요?");
		
		//메서드 3가지? 기능, 매개변수, 리턴값   null/String(리턴자료형)
		// Chapter
		nname = br.readLine();   // read읽기 + Line 한 라인
		
		//에러 : Unhandled exception type IOException
		
		System.out.printf("이름은 %s 입니다", nname);

	}

}
