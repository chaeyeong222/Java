package days11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오전 11:44:51
 * @subject 제어문 + 배열+알고리즘(로직) 응용/활용
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("정수입력");
		int n= scan.nextInt();
		
		String binaryStr = Integer.toBinaryString(n);
		
		System.out.printf("%016d\n", Integer.parseInt(binaryStr));
		
		
	}

}
