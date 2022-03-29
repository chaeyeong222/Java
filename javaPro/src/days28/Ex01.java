package days28;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ex01 {

	public static void main(String[] args) {
		//실행파일 복사
		String pathname = "C:\\WINDOWS\\system32\\notepad.exe";
		String copyPathname = "C:\\Users\\user\\Documents";

		//처리시간 : >처리시간:21634700ns -파일(1896byte) 복사 완료
		fileCopy_byteStream(pathname, copyPathname);

	}

	private static void fileCopy_byteStream(String pathname, String copyPathname) {
		long start = System.nanoTime();

		File f1 = new File(pathname);
		PrintStream ps = System.out; //화면에 출력하는 스트림 객체
		try( FileInputStream fis = new FileInputStream(f1);
				FileOutputStream fos = new FileOutputStream(copyPathname);
				) {
			int b;
		 while(	(b= fis.read()) !=-1) {
			 //ps.write(b);
			 //ps.println(b);
			 fos.write(b); //파일로 복사			 
		 }
				 
		}catch(Exception e) {
			e.printStackTrace();
		}//try
		
		
		long end = System.nanoTime();
		System.out.println(">처리시간:"+ (end-start) + "ns -파일("+f1.length()+"byte) 복사 완료");


	}

}
