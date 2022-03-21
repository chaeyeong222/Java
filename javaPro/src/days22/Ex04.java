package days22;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 이채영
 * @date 2022. 3. 21. - 오후 2:47:36
 * @subject p. 529 Data -> Calendar 변환 *** 
 *                          Calendar -> Date 변환 *** 암기
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
/*		Date d = new Date();
		System.out.println(d.getTime());  1647842579550
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis());  1647842579569
*/
		//1.date ->calendar변환   -> c.setTime(Date d)
/*		Date d = new Date();
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
*/
		//2. Calendar -> Date 변환    -> Date    c.getTime();
		Calendar c = Calendar.getInstance();
		//              방법1) Date d =c.getTime();
		//              방법2)
		Date d = new Date(c.getTimeInMillis());
		
	
	
	}//main

}//class
