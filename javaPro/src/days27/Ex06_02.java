package days27;

import java.io.File;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 11:49:51
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// FileReader, FileWriter 스트림 클래스
		String pathname = ".\\src\\days27\\Ex01.java";
		
		//String parent = ".\\src\\days27";
		//String child = "Ex01.java";
		
		//p.915~933 File 클래스
		//1. 파일은 기본적이면서 가장 많이 사용되는 입출력 대상
		//2. 자바에서는 File 클래스를 사용해서 -[파일]과 [디렉토리]를 다룰 수 있다.
		File f1 = new File(pathname);
		//File f1 = new File(parent, child);
		
		//System.out.println(f1.isFile());     //true  -> 파일
		//System.out.println(f1.isDirectory()); //true -> 디렉토리
		
		System.out.println(f1.length() + "bytes"); //1896bytes 파일크기
		System.out.println(f1.getName());        //Ex01.java  파일명
		
		System.out.println(File.separator);   //  \ -> 파일 구분자
		
	}//main

}//class
