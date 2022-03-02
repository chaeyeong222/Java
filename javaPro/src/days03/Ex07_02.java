package days03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오후 3:42:50
 * @subject 
 * @content 
 */
public class Ex07_02 {

	public static void main(String[] args) throws IOException {
		// 이름,국,영,수 키보드 입력받고, 총점, 평균 계산
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		byte kor, eng, mat;
		short tot;
		double avg;
		
		System.out.print("이름?");
		name = br.readLine();
		
		System.out.print("국어점수?");
		kor = Byte.parseByte(br.readLine());
		
		System.out.print("영어점수?");
		eng = Byte.parseByte(br.readLine());
		
		System.out.print("수학점수?");
		mat = Byte.parseByte(br.readLine());
		
		tot = (short)(kor+eng+mat);
		avg = (double) tot/3;
		
		System.out.printf("이름:%s\n국어:%d영어:%d\n 수학:%d\n총점:%d\n평균:%f\n", name, kor, eng, mat, tot, avg);
		

	}

}
