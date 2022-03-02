package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오후 2:39:08
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) throws IOException {
		// 이름을 키보드로부터 입력받아서 name 변수에 저장하고 
		// 출력형식) 이름 = 홍길동   출력하세요
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		name = br.readLine();
		
		System.out.println("이름을 입력하세요?");
		
		System.out.printf("이름=%s", name );
		

	}

}
