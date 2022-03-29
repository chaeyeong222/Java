package days28;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author 이채영
 * @date 2022. 3. 29. - 오전 10:48:37
 * @subject p. 879 File[InputStream] / File[OutputStream]
 * @content    1. 바이트스트림 + 파일 읽기쓰기 ok
 *                    2. 실행파일, 이미지, 동영상 파일 + 네크워크 (파일 전송)
 *               
 *                    한 학생의 이름, 국영수성적, 총점, 평균 데이터
 *                    성적정보를 파일로 저장
 *                    경로주고
 *                    출력하기위한 스트림 선언
 *                    형식주고, write(), 
 *                    
 */
public class Ex04 {

	public static void main(String[] args) {
		//p. 883
		//BufferedInputStream
		//bufferedOutputStream
		//1. 바이트스트림의 입출력 효율을 높이기 위해서 사용하는 보조스트림
		//2. 한바이트씩 입출력 < 버퍼buffer 사용해서 여러바이트를 입출력 -> 효율적
		
		//p.886 DataInputStream, DataOutputStream 바이트스트림
		//데이터를 읽고 쓰는데 byte 단위가 아닌 기본형으로 읽고쓸 수 있는 장점을 가진 바이트 스트림
		
		String name="이채영";
		//String name="안시은";
		
		int kor = 98, eng = 78, mat=88;
		int tot = kor+ eng+mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		//한 학생의 성적 정보를 파일로 저장하려면?
		
		String fileName = ".\\src\\days28\\students.txt";
		try (FileWriter fw = new FileWriter(fileName, true);//true 주면 계속 추가됨, 안주면 값 변경
				BufferedWriter bw = new BufferedWriter(fw)){ 
			/*
			fw.write(name);
			fw.write(kor);
			fw.write(eng);
			fw.write(mat);
			fw.write(tot);
			fw.write(avg + ""); //더블형 못주니까 문자열로 변환하려고 빈 문자열 줌
			fw.write(gender+""); 
			*/
			String data = String.format("%s,%d,%d,%d,%d,%f,%b\n", name, kor,eng, mat, tot, avg, gender);
			fw.write(data);
			
			//fw.flush();//
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}//try

	}//main

}//class
