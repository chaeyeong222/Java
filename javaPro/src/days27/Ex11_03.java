package days27;

import java.io.File;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 4:07:50
 * @subject 
 * @content 
 */
public class Ex11_03 {

	public static void main(String[] args) {
		//upload폴더에 하위폴더 존재하니까 삭제 안됨 어떻게 해결? 
		//                 모든 하위폴더를 삭제한 후에 삭제할 폴더를 삭제한다
		String pathname = "C:\\Users\\user\\Documents\\upload";

		File file = new File(pathname);
		directoryDelete(file);


		System.out.println(file.delete()); //true 폴더 삭제

		//삭제하는 메서드를 만들어서 재귀메서드
	}//main

	private static void directoryDelete(File file) {   
		while(!file.delete()) {
		
					File[] files=file.listFiles();
		
					for (int i = 0; i < files.length; i++) {
						if(!files[i].delete()) { //폴더인지 파일인지 확인x ->file.delete()
							directoryDelete(files[i]);
						}else {
							System.out.printf("%s 삭제가 완료되었습니다.\n",files[i]);
						} // if
					} // for

		} // while

		System.out.printf("%s 삭제가 완료되었습니다.\n",file);

	} // method

} // class
