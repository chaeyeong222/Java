package days28;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * @author 이채영
 * @date 2022. 3. 29. - 오전 11:30:31
 * @subject 
 * @content  students.txt 파일 읽어서 출력 
 */
public class Ex04_03 {

	public static void main(String[] args) {

		//String name="마상민";
		String name;
		
		int kor , eng , mat;
		int tot ;
		double avg ;
		boolean gender;
		
		String fileName = ".\\src\\days28\\students.txt";
		
		try (FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)){ 
		
			String line = "";
			while( (line=br.readLine()) !=null) {
				System.out.println(line);
			}//while
				
		} catch (Exception e) {
			e.printStackTrace();
		}//try

	}//main

}//class
