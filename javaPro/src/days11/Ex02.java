package days11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오전 11:44:51
 * @subject 제어문 + 배열+알고리즘(로직) 응용/활용
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		//정수int를 입력받아서          10
		//2바이트 2진수로 출력하기 00000000 00001010

		
		Scanner scan = new Scanner(System.in);
		System.out.println("정수입력");
		int n= scan.nextInt();
		
		int [] binary = new int [16];
		int idx = binary.length -1;
		
		int share = n; //몫
		int rest; //나머지
		
		while(share!=0) {
			share = n/2; //몫
			rest = n%2; //나머지
			binary[idx--] = rest;
			n=share;
		}	
		System.out.println( Arrays.toString(binary)); //[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0]

		//  \\s 스페이스  |       .replace(a,b) a를 b로 바꾸자
		System.out.println(Arrays.toString(binary).replaceAll(",\\s", ""));//[0000000000001010]
	}

}
