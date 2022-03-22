package days23;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 11:46:46
 * @subject p.551
 * @content 
 */
public class Ex05_02 {

	public static void main(String[] args) throws Exception {
		String tableName = "CUST_INFO";
		String fileName= ".\\src\\days23\\data4.txt";
		String msg = "INSERT INTO " + tableName + " VALUES ({0},{1},{2},{3});";
		
		Scanner s = new Scanner(new File(fileName));
		
		String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
		//String pattern = "{0},{1},{2},{3}";
		MessageFormat mf = new MessageFormat(pattern);
		
		while(s.hasNextLine()) {
			String line=s.nextLine();
			//System.out.println(line);
			Object [ ]objs = mf.parse(line);
			for(Object a: objs) {
				System.out.println(a);
			}System.out.println("==========");
		}
		
		

	}

}
