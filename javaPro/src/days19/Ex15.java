package days19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 3:37:57
 * @subject  p. 431 예제 변형
 * @content 
 */
public class Ex15 {

	public static void main(String[] args) {
		//파일 읽어서 화면 출력
		String fileName = "C:\\temp\\.log";
	    //File f= createFile( filePath );
		
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String line = "";
		//BufferedReader br=null;
		int lineNumber = 1;
		
		try {	FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		Scanner scan = new Scanner(System.in);
	//	br = new BufferedReader(new FileReader(fileName));
		while((line = br.readLine()) !=null) {
			System.out.printf("%d:%s\n",lineNumber++,line);
		}
		}catch (FileNotFoundException e) {
		System.out.println("읽고자 하는 파일 없음");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
		/*	try {
				br.close();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			*/
		}

	}

}

//복습문제: test.html파일을 읽어서 라인번호를 붙여 출력하기(파일읽기)
