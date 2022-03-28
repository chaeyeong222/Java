package days27;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 12:32:58
 * @subject   텍스트 파일 복사 
 * @content fileCopy_textStream
 *                 FileReader/ FileWriter  while( 한문자 읽기-> 한문자 쓰기)
 *                 BufferedReader / BufferedWriter    보조스트림
 *                   임시저장소                           버퍼
 *                                                         [][][][][]
 *                 
 */
public class Ex06_05 {

	public static void main(String[] args) {

		String pathname = ".\\src\\days27\\Ex01.java";
		String copyPathname = "C:\\Users\\user\\Documents\\Ex01.java";
		
		//처리시간 : >처리시간:21634700ns -파일(1896byte) 복사 완료
		fileCopy_textStream(pathname, copyPathname);
	
	}//main

	private static void fileCopy_textStream(String pathname, String copyPathname) {
		long start = System.nanoTime();
		
		File f1 = new File(pathname);  
		final int BUFFER_SIZE = 1024;
		char [] buffer = new char[BUFFER_SIZE];
		

		
		try(FileReader fr = new FileReader(f1);
			FileWriter fw = new FileWriter(copyPathname);
				BufferedReader  br = new BufferedReader(fr,BUFFER_SIZE);
				BufferedWriter bw = new BufferedWriter(fw,BUFFER_SIZE )) {
			String line;
			int lineNumber = 1;
			
			while(  (line = br.readLine())  !=null) {
				System.out.println(lineNumber++ +":"+line +"\r\n");
			}
			
			/*line = br.readLine();
			System.out.println(lineNumber++ +":"+line);
			line = br.readLine();
			System.out.println(lineNumber++ +":"+line);
			line = br.readLine();
			System.out.println(lineNumber++ +":"+line);
			
			*/
			long end = System.nanoTime();
			
			//>처리시간:26259300ns -파일(1896byte) 복사 완료
			System.out.println(">처리시간:"+ (end-start) + "ns -파일("+f1.length()+"byte) 복사 완료");
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}//class
