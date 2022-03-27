package days26;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 2:55:01
 * @subject 
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		//Properties 컬렉션 클래스
		//Map
		//String String
		//환경설정
		//load(), store()
		// setProperty(), getProperty()
		// ???.properties
		
		//시스템의 속성들을 얻어오는 메서드
		Properties p = System.getProperties();
		//ArrayList열거자 출력
		//Enumeration<Object> en = p.elements();
		
		/*
		//속성이름들 반환하는 메서드
		Enumeration<String> en = (Enumeration<String>) p.propertyNames();
		while (en.hasMoreElements()) {
			String pname = (String) en.nextElement();
			System.out.println(pname + " = " + System.getProperty(pname));
		}*/

	}//main

}//class
