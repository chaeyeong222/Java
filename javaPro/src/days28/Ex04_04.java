package days28;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * @author 이채영
 * @date 2022. 3. 29. - 오전 11:35:06
 * @subject  student.data 파일 읽기 작업
 * @content 
 */
public class Ex04_04 {

	public static void main(String[] args) {
		//
		String name;
		
		int kor = 98, eng = 78, mat=88;
		int tot = kor+ eng+mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		String fileName = ".\\src\\days28\\students.dat";
		try (
				FileInputStream in = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(in); //보조스트림
			){ 
			
			//dis.available() 체크 
			//java.io.EOFException => 파일의 끝 예외 발생
			//while(dis.available() >0) {
			while(true) {
				name = dis.readUTF();
				kor = dis.readInt();
				eng = dis.readInt();
				mat = dis.readInt();
				tot = dis.readInt();
				avg = dis.readDouble();
				gender = dis.readBoolean();
				
				System.out.printf("name = %s,kor=%d,eng=%d,mat=%d,tot=%d,avg=%.2f,gender=%b\n"
						, name, kor,eng, mat, tot, avg, gender);
				//System.out.println(dis.available());
			}
		}catch(EOFException e ) {
			//아무것도 안주면 아무것도 처리안함.
		}
		catch (Exception e) {
			e.printStackTrace();
		}//try
			System.out.println("=end=");
	}//main

}//class
