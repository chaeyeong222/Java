package days26;

import java.io.FileReader;
import java.util.Properties;

public class Ex06_03 {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		String fileName = dir + "\\src\\com\\util\\jdbc.properties";
		
		Properties  p = new Properties();
		
		try {
			p.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(p.getProperty("className"));

	}

}
