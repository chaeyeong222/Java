package days27;

import java.io.File;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
/**
 * @author 이채영
 * @date 2022. 3. 28. - 오후 2:43:51
 * @subject  p. 919   예제15-29
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		//p. 915 File 클래스설명 - 파일, 디렉토리
		//C:\Users\\user\\git\repository\javaPro
		String currentDirectory = System.getProperty("user.dir");
		//System.out.println(currentDirectory);
		
		File currDir = new File(currentDirectory);
		
		//String []   : currDir.list();
		File [] fileList = currDir.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if(fileList[i].isDirectory()) {
				System.out.print("[폴더]");
			}else if(fileList[i].isFile()){
				System.out.print("[파일]");
			}
			//파일명, 폴더명 출력
			System.out.print("\t" + fileList[i].getName());
			
			//마지막 수정된 날짜
			long lm = fileList[i].lastModified(); // 2022-02-15 오후 2:49
		   Date d = new Date(lm);
		   String pattern = "yyyy-MM-dd a hh:mm";
		   SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			System.out.print("\t"+sdf.format(d));
			
			//4.크기
			if(fileList[i].isFile()) {
				System.out.print("\t"+fileList[i].length()+"bytes");
			}
			
			System.out.println();
		}

	}

}
