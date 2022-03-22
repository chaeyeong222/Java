package days23;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 10:42:21
 * @subject p.544 simpledateformat
 * @content 
 */
public class Ex03_02 {

	public static void main(String[] args) {
		//Date -> Calendar 변환
		//Calendar ->Date 변환
		
		Date d = new Date();
		/*
		System.out.println(d); //Tue Mar 22 10:39:36 KST 2022
		System.out.println(d.toGMTString()); //22 Mar 2022 01:40:10 GMT
		System.out.println(d.toLocaleString()); //22 Mar 2022 01:40:10 GMT
		*/
		
		//2022년 03월 22일 오전 10:50:44 (화요일) 형식
		String pattern = "yyyy년 MM월 dd일 a hh:mm:ss (E요일)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String sd = sdf.format(d);
		System.out.println(sd);
		
	}

}
