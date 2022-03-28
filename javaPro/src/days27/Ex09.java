package days27;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ex09 {

	public static void main(String[] args) {
		String dir = ".\\src";
		//모든 자바파일을 검색해서 "Lotto"문자열을 포함하는 파일만 찾아서 출력
		String keyword = "Lotto";
		
		File searchDir = new File(dir);
		
		//검색 + 출력하는 메서드
		printSearchFiles(searchDir, keyword);

	}//main

	private static void printSearchFiles(File searchDir, String keyword) {
		//하위폴더, 파일목록
		File[] files = searchDir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {//하위폴더
				printSearchFiles(files[i], keyword);
				
			}else { //파일 -> lotto 있는지 찾음
				// 조건    ??.java 파일만
				String fileName = files[i].getName(); //파일명   ?.java  ?.txt   ?.properties
				String extension =fileName.substring( fileName.lastIndexOf(".") +1);
				
				if(extension.equals("java")) {
								try (FileReader fr = new FileReader(files[i]); //한문자
										BufferedReader br = new BufferedReader(fr); //한 라인 처리 + 성능 = 보조스트림
										){
									String line;
									StringBuffer  sb = new StringBuffer();
									while ((line=br.readLine()) != null) {
										sb.append(line +"\r\n"); //누적
									
									}//while
									if(sb.indexOf(keyword) !=-1) { //키워드를 하나라도 가지고 있는 파일
										System.out.println(files[i]);  //출력
									}
								} catch (Exception e) {
									e.printStackTrace();
								}//try
				}
			}//if
		}//for
		
	}//method

}//class
