package days27;

import java.io.File;

import com.util.FileUtil;

public class Ex10 {

	public static void main(String[] args) {
		//com.util.FileUtil.java
		
		String path= System.getProperty("user.dir") + "\\src\\days01\\Ex07.java";
		System.out.println(path);
		File f = new File(path);
		
		//1.전체경로에서 파일명 필요
		String fileName = f.getName();
		System.out.println(fileName); //Ex07.java
		
		//2.확장자
		String ext = FileUtil.getExtension(f);
		System.out.println(ext); //.java
		
		//3.순수 파일명 Ex07 (확장자 제외)
		String baseName = FileUtil.getBaseName(fileName);
		System.out.println(baseName); //Ex07

	}//main

}//class
