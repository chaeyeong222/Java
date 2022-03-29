package days28;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author 이채영
 * @date 2022. 3. 29. - 오전 9:25:19
 * @subject  p.931 예제 15-37
 * @content  지정된 파일을 지정된 크기로 잘라서 여러개의 파일로 저장
 *   파일경로+ 이름
 *   얼마를 기준으로 자른 건지 크기 지정
 *   출력스트림 + 보조스트림
 *   try-catch문
 *   파일을 불러와서(인풋) 
 *    while 지정크기로 나누어 떨어지면 저장 .close()사용
 *    새로운 이름으로 저장 write() 사용
 */
public class Ex02 {

	public static void main(String[] args) {
		//93,772 바이트
		String pathname = "C:\\Users\\user\\Downloads\\훈련과정 탐색 결과표_(디지털컨버전스) AWS 클라우드 활용 자바(Java) Full-Stack 개발자 양성과정(H)(AIG20210000340243)(1회차).pdf";
		final int VOLUME = 10000;
		
		File f= new File(pathname);
		System.out.println("파일크기: "+f.length() + "bytes");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		int data = 0;
		int i=0; //읽은바이트숫자
		int number=0;
		
		try (
				FileInputStream fis = new FileInputStream(f);
				BufferedInputStream bis = new BufferedInputStream(fis);
			
				){
			while( (data = bis.read())!=-1) {
				if(i%VOLUME ==0) {
					if(i!=0) bos.close();  //저장
					fos = new FileOutputStream( pathname+"_."+ (++number)  );
					bos = new BufferedOutputStream(fos);
				}
				bos.write(data);
				i++;
			}System.out.println("end");
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try

	}

}
