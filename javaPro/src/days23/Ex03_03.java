package days23;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 10:42:21
 * @subject p.544 simpledateformat
 * @content 
 */
public class Ex03_03 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//simpledateformat 사용해서
		//2022년 03월 22일 오전 10:50:44 (화요일) 형식 출력
		
		c.set(2022, 3, 22);
		Date d = c.getTime();
		SimpleDateFormat day;
		day = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss (E요일)");
		System.out.println(day.format(d));

	}

}
