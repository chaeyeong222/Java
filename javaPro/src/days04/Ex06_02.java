package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06_02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 삼항연산자 이용, 두 정수 x,y를 입력받아서, 큰 값을 max라는 변수에 저장하여 출력
		
		int x, y, max;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("x값 입력");
		 x = Integer.parseInt(br.readLine());
		
		System.out.println("y값 입력");
		 y = Integer.parseInt(br.readLine());
		
		 max = x>y? x:y;
		 
		 System.out.println(max);
		 

	}

}
