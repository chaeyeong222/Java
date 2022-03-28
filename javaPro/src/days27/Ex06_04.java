package days27;
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
 */
public class Ex06_04 {

	public static void main(String[] args) {

		String pathname = ".\\src\\days27\\Ex01.java";
		String copyPathname = "C:\\Users\\user\\Documents\\Ex01.java";
		
		fileCopy_textStream(pathname, copyPathname);
	
	}//main

	private static void fileCopy_textStream(String pathname, String copyPathname) {
		long start = System.nanoTime();
		
		File f1 = new File(pathname);  

		
		try(FileReader fr = new FileReader(f1);
			FileWriter fw = new FileWriter(copyPathname)) {
			int c;
			while( (c=fr.read()) != -1) { 
				fw.write(c);  
			}
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
