package days23;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Iterator;

/**
 * @author 이채영
 * @date 2022. 3. 22. - 오전 11:46:46
 * @subject p.551
 * @content 
 */
public class Ex05_03 {

	public static void main(String[] args) {
//		MessageFormat :출력된 데이터로부터 필요한 데이터만 뽑아낸다
		String souce = "이름:kenik, 나이:20살, 성별:남자";
		
		String pattern = "이름:{0}, 나이:{1}살, 성별:{2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object [] objs = mf.parse(souce);
			for(Object a:objs) {
				System.out.println(a);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}//main

}//class
