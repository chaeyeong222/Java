package days26;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 3:17:12
 * @subject 
 * @content   ~663p.
 */
public class Ex06_02 {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		String fileName = dir + "\\src\\com\\util\\jdbc.properties";
		
		Properties  p = new Properties();
		
		try (
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
		) {
			
			String line;
			while(   (line=br.readLine() )  != null) {
				if(!line.startsWith("#")) {
					String[] kv = line.split("=");
					String key = kv[0];
					String value = kv[1];
					p.setProperty(key,value);
				}
			}
			System.out.println( p );
	         /*
	         {       user=scott, 
	               url=jdbc\:oracle\:thin\:@localhost\:1521\:xe, 
	               password=tige,
	               className=oracle.jdbc.driver.OracleDriver
	         }
	         */
	      } catch (Exception e) {
	         e.printStackTrace();
	      }


	}//main

}//class
