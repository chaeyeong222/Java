package days07;

import java.io.IOException;
import java.util.Scanner;

public class Ex04_03 {

	public static void main(String[] args) throws IOException {
		// 10개의 라인을 출력하고 난 후, 엔터를 쳐야 다음 10개 라인을 출력하도록 코딩.
		
		/* 1. 10개 라인 출력 인식 - 메시지, 멈추고 물어보기 -> lineNumber가 10배수?
		 * 
		 */
		
	//	Scanner scan = new Scanner(System.in);
		
	  //  char e = scan.next
		
		int lineNumber = 1;
		
		for(int i =0; i<=255; i++) {
			if(i%10 == 0) System.out.printf("%d : ", lineNumber++);
			System.out.printf("[%c]", i); 
			if(i%10==9) {
				System.out.println();
				if(lineNumber % 10==1) {
				System.out.print("> 계속하려면 엔터 치세요");
			   
				System.in.read();  //엔터칠 때까지 멈춤. 아무값도 입력안하고 엔터치면 \r, \n이 들어가져서 \r만 들어가고 \n이 남아있음.
				System.in.skip(System.in.available()); //첫 문자 빼고 나머지는 다 지워버린다는 뜻.
				}	
			}
		}
		
	}//main

}//class
