package days27;

import java.io.File;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 4:36:31
 * @subject p. 928 예제 15-34
 * @content 
 */
public class Ex12 {

	public static void main(String[] args) throws IOException {
		//days27 패키지 안에 파일명이 [Ex06]으로 시작하는 파일만 찾아서 출력/삭제/이름변경
		//이름변경 renameTo() 삭제 delete
		String pathname=".\\src\\days27";  //상대경로로 표시했을 때만 abs~ can~ 다름
		File file = new File(pathname);
		
		File[] fileList = file.listFiles();// 폴더, 파일 다 있음
		for (int i = 0; i < fileList.length; i++) {
			if(fileList[i].isFile()) {
				String fileName = fileList[i].getName();
				if( fileName.startsWith("Ex06") ) {
					System.out.println(fileName);
				};
			}
		}//for
	
	}//main

}//class

/* 절대경로로 표시하면 결과값 다 같음
System.out.println(file.getAbsolutePath()); //C:\Users\/user\git\repository\javaPro\.\src\days27
System.out.println(file.getCanonicalPath()); //C:\Users\/user\git\repository\javaPro\src\days27
System.out.println(file.getPath()); //.\src\days27
*/ 