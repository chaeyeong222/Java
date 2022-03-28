package days27;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 11:08:59
 * @subject  어노테이션 설명 예제
 * @content  
 *   미리 의미가 있는 @태그 붙어있는 것 -> javadoc.exe 설명파일 생성
 * 
 *   javadoc.exe 소스코드로부터 추석처리(/** )로 HTML설명파일 생성할 수 있다.
 */
public class Ex04 {
	@Deprecated //앞으로 사용하지 않을 것을 권장
	Ex04(){
		
	}
	@Deprecated
	int getXXX(){
		return 0;
	}

	@SuppressWarnings("resource") //컴파일러의 특정 경고메세지 안나타나게 하는 것
	public static void main(String[] args) {
		// p. 695 열거형의 멤버 추가하기 (정독)
		//p.702 어노테이션 annotation
		//1. 어노테이션? 프로그램 소스코드 안에 "다른프로그램"을 위한 정보를 미리 약속된 형식으로 포함시키기 위한 것
		//2. 사전적 의미? 주석, 메모
		
		//한줄주석처리
		/*
		 여러줄 주석처리
		 */
		
		/**
		   소스코딩에 대한 설명 주석처리 
		*/
		//@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		scan.next();

	}//main
	
	//다른 프로그램(컴파일러)에게 오버라이딩 되었음을 알려주는 역할
	@Override
	public String toString(){
		return "Ex04[toString()=" + super.toString() + "]";
		
	}
}//class
