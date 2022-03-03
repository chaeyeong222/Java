package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 2:46:20
 * @subject  [배열을 사용하는 예제]
 * @content 
 */
public class Ex08 {
	public static void main(String[] args) throws IOException {
		//한 학생의 이름, 국, 영, 수 성적을 입력받아 총점, 평균을 출력하는 코딩
		//배열을 사용하기
		
		String name;
		int kor, eng, mat, tot;
		double avg;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//이클립스 디버깅
		//토글브레이크포인트(오른쪽마우스)->이 자리에서 멈추세요
		// 실행 Ctrl + F11      디버깅 F11
		// F6 다음단계 step over
		
		System.out.print("이름, 국어, 영어, 수학 입력?");   //홍길동,90,88,75
		String data = br.readLine();
		
		/*
		System.out.println("입력받은 데이터:" + data);
		"홍길동, 90,88,75"       //콤마(,)를 기준으로 분리   -> 4개
		*/
		
		//split()  1.기능 2. 매개변수  ","   3. 리턴값, 리턴자료형

		String [] dataArray = data.split(",");
		
		
		//문자열 앞뒤에 있는 공백 제거  String.trim() 메서드
		//name = dataArray[].trim()
		name = dataArray[0];
		kor = Integer.parseInt(dataArray[1]);     //"90" (String)   -> 90 (int)
		eng = Integer.parseInt(dataArray[2]);
		mat = Integer.parseInt(dataArray[3]);
		
		tot = kor + eng+ mat;
		avg = (double) tot/3;
		
		System.out.println(dataArray[0]);
		System.out.println(dataArray[1]);
		System.out.println(dataArray[2]);
		System.out.println(dataArray[3]);
		

		System.out.printf("이름=\"%s\",국어=%d,영어=%d,수학=%d,총점=%d,평균=%f ",name,kor,eng,mat,tot,avg );
	}

}
