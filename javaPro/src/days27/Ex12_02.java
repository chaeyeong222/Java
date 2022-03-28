package days27;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 4:36:31
 * @subject p. 928 예제 15-34
 * @content 
 */
public class Ex12_02 {

	public static void main(String[] args) throws IOException {
		//days27 패키지 안에 파일명이 [Ex06]으로 시작하는 파일만 찾아서 출력/삭제/이름변경
		String pathname=".\\src\\days27";  
		File file = new File(pathname);
		
		File [] fileList = file.listFiles( new FilenameFilter() {
			
														@Override
														public boolean accept(File dir, String name) {
															return name.startsWith("Ex06");
														}
													}
		                                       );
		for(File f: fileList) {
			System.out.println(f.getName());
		}
		
	}//main

}//class
