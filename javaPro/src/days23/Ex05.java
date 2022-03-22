package days23;

import java.text.MessageFormat;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 11:37:46
 * @subject p.549 MessageFormat 클래스
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		String name = "kenik";
		int age=20;
		boolean gender =true;
		
		//이름:kenik, 나이:20살, 성별:남자
		//printf 나 String.format 사용 가능
		
		/* 아래와 같이 코딩하지 않아도 된다.
		 String pattern="";
		 MessageFormat mf = new MessageFormat(pattern);
		String message = mf.format();
		System.out.println(message);
		*/
		//이유 ? static 메서드 이므로 class명으로 바로 호출가능
		String message = MessageFormat.format("이름:{0}, 나이:{1}살, 성별:{2}",
				name,age,gender?"남자":"여자");
		System.out.println(message);
		
				

	}//main

}//class
