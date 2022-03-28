package days27;

import java.io.File;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 3:37:24
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		// C:\\upload폴더 있는지 확인 후에 없으면 생성  -> 폴더 생성
		String pathname = "C:\\Users\\user\\Documents\\upload";
		//파일, 디렉토리 관리하는 클래스 - File 클래스
		File file = new File(pathname);
		
		//exists() 파일/ 디렉토리 존재 유무  true/false
		if(  !file.exists() ) { //폴더 존재하지 않는다면
			//System.out.println(file.createNewFile()); //파일 생성
			//System.out.println(file.mkdir());  //디렉토리 생성 upload도 없는데 그 안에 하위폴더 만들 수x
			
			System.out.println(file.mkdirs());  //s가 붙음: upload 없으면 만들고 하위폴더도 만듦
		}

	}//main

}//class
