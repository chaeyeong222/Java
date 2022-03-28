package days27;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 11:49:51
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {

		String pathname = ".\\src\\days27\\Ex01.java";
		File f1 = new File(pathname);  //파일크기, 언제 생성.. 파일의 정보 출력위해 객체 선언

		//Ex01.java  -> File f1  ->  읽기 작업 Input   -> 화면 출력Output
		//                                       FileReader: O
		//                              FileInputStream: X 바이트스트림이니까 안됨.
		//텍스트 파일                         문자스트림 2	바이트(1문자)

		try {
			//FileReader fr = new FileReader(pathname);  //String pathname
			//Input 읽기용 스트림
			FileReader fr = new FileReader(f1);  //File file
			
			//메서드   1) 기능  2) 매개변수  3) 리턴값
			//                                       읽어온 한 문자 - int 반환
			//                                        -1               스트림의 끝=파일 끝 (함수가 그렇게 정함)
			int n;
			while( (n=fr.read()) != -1) {
				System.out.printf("%c",(char)n);
			}
			
			/*
			int n = fr.read();
			System.out.println(n + ":" + (char)n); //112 =='p'
			n = fr.read();
			System.out.println(n + ":" + (char)n); //97:a
			n = fr.read();
			System.out.println(n + ":" + (char)n); //99:c
			*/
		} catch (FileNotFoundException e) { //만약 파일 존재하지 않을 경우
			e.printStackTrace();
		} catch (IOException e) {
			// IO 예외 발생 == 예외처리
			e.printStackTrace();
		}




	}//main

}//class
