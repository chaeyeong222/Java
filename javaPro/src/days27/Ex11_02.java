package days27;

import java.io.File;
import java.io.IOException;


/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 3:50:46
 * @subject  
 * @content 
 */
public class Ex11_02 {

	public static void main(String[] args) {
//		String pathname = "C:\\Users\\user\\Documents\\upload\\2022-03-28\\Test.java";
//		String pathname = "C:\\Users\\user\\Documents\\upload\\2022-03-28";
		String pathname = "C:\\Users\\user\\Documents\\upload";

		File file = new File(pathname);
		
		System.out.println(file.delete()); //true 파일 삭제
		
		
	}//main

}//class
