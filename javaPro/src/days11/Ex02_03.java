package days11;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02_03 {

	public static void main(String[] args) {

		//16진법: 0 1 2 3 4 5 6 7 8 9 a b c d e f
		Scanner scan = new Scanner(System.in);
		System.out.println("정수입력");
		int n= scan.nextInt();

		// 10진수 10을 -> 16진수로 출력   a
	      char [] hex = new char[4];
	      Arrays.fill(hex, '0');
	      
	      int share = n; // 몫 변수
	      int rest;      // 나머지 변수
	      
	      int idx = hex.length-1;
	      while( share != 0 ) {
	         share = n / 16;  // 5
	         rest  = n % 16;   // 0
	         // 나머지 rest 값을 문자로 변환해서 char[ ]hex 에 저장하겠다
	         //1+48 ->'1'
	         // 10+87->'a'
	         char value =  (char)(  rest += rest >= 10 ? 87 : 48 );
	         // System.out.printf("[%d]", rest); // [0][1][0][1]   1010
	         hex[idx--] = value;
	         n = share;
	      }
	      System.out.println("0x"+ Arrays.toString(hex).replaceAll(",\\s", ""));

		
	}

}
