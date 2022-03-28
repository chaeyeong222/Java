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
 * @content 파일-> 읽기(FileReader)  ->      쓰기( FileWriter)->쓰기
 */
public class Ex06_03 {

	public static void main(String[] args) {

		String pathname = ".\\src\\days27\\Ex01.java";
		//복사할 경로
		// 내PC > 문서 ==  C:\Users\\user\Documents   -> user앞에 \하나 넣음 - 오류나서
		String copyPathname = "C:\\Users\\user\\Documents\\Ex01.java";
		
		File f1 = new File(pathname);  

		//자동으로 닫히는 구문 try with resources 문
		try(FileReader fr = new FileReader(f1);
			FileWriter fw = new FileWriter(copyPathname)) {
			int c;
			while( (c=fr.read()) != -1) { //파일에 한 문자씩 읽기
				//System.out.printf("%c",(char)n);
				fw.write(c);  //파일에 한 문자씩 쓰기(저장)
			}
			System.out.println("파일 복사 완료");
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}




	}//main

}//class
