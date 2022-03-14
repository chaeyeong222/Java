package days07;

import java.io.IOException;

public class Ex05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * System.in.read() 3가지 기능
		 * 1. 기능 : 입력스트림(키보드)으로부터 다음 1바이트를 읽어서 0~255 정수 int 값으로 반환하는 메서드
		 * 2. 매개변수  X
		 * 3. 리턴값(리턴자료형)  0~255 int
		 *                               -1
		 */
		// 'a' '\r' '\n'
		
		//1번
		char one;
		System.out.print("한 문자 입력");
		
		//one = scanner.next().charAt(0)
		
		
		one = (char) System.in.read();  //   System.in.read() 원래는 int 만 가능
		System.out.println(one);
		
		//a 쳤을 때 엔터인 '\r'이 들어있었음
		//System.in.read(); -> 한 문자 읽어가서 버리겠다.
		//System.in.read(); -> 한 문자 읽어가서 버리겠다.
		//System.in.read(); -> 한 문자 읽어가서 버리겠다.
		
		System.in.skip(System.in.available()) ;  //한 문자 입력하고 나머지 다 버림.
		
		//2번  
		System.out.print("한 문자 입력");
		one = (char)System.in.read();  
		System.out.println(one);
		
	    System.out.println("end");
		
	}

}
