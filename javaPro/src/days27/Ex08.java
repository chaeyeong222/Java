package days27;

import java.io.File;

public class Ex08 {

	public static void main(String[] args) {
		String pathname = ".\\src\\days27\\Ex01.java";
		
		File f = new File(pathname);
		
		System.out.println(f.exists()); //파일 객체의 존재 유무 true/false
		
		if(f.exists() && f.isFile() ) {
			System.out.println( f.canRead());   //읽기가능 true
			System.out.println( f.canWrite());  //쓰기가능 true
			System.out.println( f.canExecute());  //실행가능 true
			System.out.println( f.isHidden());  //숨길파일 false
		}

	}

}
