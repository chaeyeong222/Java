package days29;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 30. 
 * @subject 음악다운로드와 같이 파일을 복사하는 코딩
 * @content 
 * 파일경로   복사할경로
 * FileCopy 메서드 만들기 =>start()
 * 
 * FileCopy클래스
 * 
 * 
 */
public class Ex05 {

	public static void main(String[] args) {
		//음악다운로드
		//main 스레드 
/*
		String originalPath = "C:\\WINDOWS\\system32\\notepad.exe";
		String copyPath = "C:\\Users\\user\\Documents";

		FileCopy target = new FileCopy(originalPath, copyPath);
		Thread 파일복사일꾼 = new Thread(target);
		파일복사일꾼.start();
		
	}//main

}//class

class FileCopy implements Runnable{
	
	private String originalPath;
	private String copyPath;

	public FileCopy(String originalPath, String copyPath) {

		this.originalPath = originalPath;
		this.copyPath =copyPath;
	}

	@Override
	public void run() {
		long start =    System.nanoTime();      
		File orignalFile = new File(originalPath);
		System.out.println(  orignalFile.length() +" bytes");  // 2,385,496 bytes      
		FileInputStream fis = null;
		FileOutputStream fos = null;
		//
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		// 
		final int BUFFER_SIZE = 1024;
		byte [] buffer = new byte[BUFFER_SIZE];

		try {
			fis = new FileInputStream(orignalFile);// File
			fos = new FileOutputStream(copyPath);  // String
			// 보조스트림 사용
			bis = new BufferedInputStream(fis, BUFFER_SIZE);
			bos = new BufferedOutputStream(fos, BUFFER_SIZE);

			int readNumber = -1;  // 실제 읽어온 바이트 수를 저장할 변수

			while ( (   readNumber = bis.read( buffer )    ) != -1 ) {
				bos.write(buffer, 0, readNumber);
			}
			bos.flush();

		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
				fis.close();
				fos.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
		long end =    System.nanoTime();
		System.out.println( "> 처리 시간 : " + (end-start) + "ns" );
*/
	}//run

}//class
