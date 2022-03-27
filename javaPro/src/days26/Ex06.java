package days26;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 2:18:28
 * @subject  p.656 예제 11-34 주말에 코딩
 * @content  p.658 Properties 컬렉션 클래스 ***
 *                      1. Property == 속성들을 저장할 때 많이 사용
 *                      2. 애플리케이션의 환경설정 저장/읽기 주로 사용
 *                      3. 속성명 = 속성값 한쌍
 *                           key     value
 *                      4. Map인터페이스를 구현한 클래스
 *                      5. (특징) key, value의 자료형이 모두 String 이다
 *                      HashMap<String, String> == Properties
 *                      차이점? 파일 저장/읽기할 수 있는 메서드가
 *                      Properties 구현이 되어있다.
 *                          파일명.properties   ->앞으로 이렇게 하자!(걍 정함)
 *                      
 *                      
 *      String className = "oracle.jdbc.driver.OracleDriver";  fullname
         String url = "jdbc:oracle:thin:@localhost:1521:xe";    서버url
         String user = "scott";                                                 계정(사용자)
         String password = "tiger";                                         계정의 비밀번호
 *                      
 */
public class Ex06 {

	public static void main(String[] args) {
		Properties p = new Properties();
		//p.put(key, value);
		p.setProperty("className",  "oracle.jdbc.driver.OracleDriver");
		p.setProperty("url",  "jdbc:oracle:thin:@localhost:1521:xe");
		p.setProperty("user",  "scott");
		p.setProperty("password",  "tiger");
		
		//System.out.println(p.getProperty("user"));
		
		/* C:\Users\\user\git\repository\javaPro */
		
		String dir = System.getProperty("user.dir");
		//System.out.println(dir);
		String fileName = dir + "\\src\\com\\util\\jdbc.properties";
		
		//try-with-resource문 자동으로 닫히는 문
		try(Writer writer = new FileWriter(fileName);) {
			String comments = ">JDBC 환경설정";
		   p.store(writer, comments);
		   System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}//main

}//class
