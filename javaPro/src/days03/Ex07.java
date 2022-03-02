package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오후 3:00:37
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) throws IOException {
		//Ex04.java 파일 참조해서 코딩.
		//키보드로부터 이름, 국어, 영어, 수학 점수를 입력받아서
		//국어 35, 영어 44, 수학 73, 총점 152, 평균 값을 출력하세요
		
		//1. 변수 선언 먼저
		String name;
		byte kor, eng, mat;
		short tot;
		double avg;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//2. 키보드로부터 값 입력 받기
		System.out.println("이름을 입력하세요");
		name = br.readLine();

		System.out.println("국어점수 입력하세요");
		//byte => String 형변환하기
		//문제원인해결 
		//String("90")          -> byte    Byte.parseByte("90")
		//String("90")          -> int    Integer.parseByte("90")
		//String("90")          -> double    Double.parseByte("90")
		//
		
	//	String kor=br.readLine();
	//	kor = Byte.parseByte(kor);
		 kor=Byte.parseByte( br.readLine());
		
		
		System.out.println("영어점수 입력하세요");
		 eng=Byte.parseByte( br.readLine());
		
		
		System.out.println("수학점수 입력하세요");
		 mat=Byte.parseByte( br.readLine());
     	
     	tot = (short)(kor + eng+ mat);
     	avg = (double)tot/3;     			
     	
	
     	//3. 출력
     	System.out.printf("이름:%s\n 국어: %d\n영어:%d\n 수학:%d\n", name, kor, eng, mat);
     	System.out.printf("총점: %d, 평균: %f", tot, avg);

	} //main

}//class
