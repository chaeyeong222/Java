package days23;

import java.util.Calendar;
import java.util.Date;

public class Ex03 {

	public static void main(String[] args) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();

		System.out.println(toString(c));
		System.out.println(toString(d));
	}
		//2022년 3월 22일 00:00:00(화요일)
		public static String toString(Date d) {
			return String.format("%d년 %d월 %d일 %02d:%02d:%02d (%s)"
					,d.getYear()+1900
					,d.getMonth()+1
					,d.getDate()
					,d.getHours()
					,d.getMinutes()
					,d.getSeconds()
					,"일월화수목금토".charAt(d.getDay())+"요일")	;
		}

		public static String toString(Calendar c) {
			return String.format("%d년 %d월 %d일 %02d:%02d:%02d (%s)"
					,c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1
					,c.get(Calendar.DATE),c.get(Calendar.HOUR)
					,c.get(Calendar.MINUTE)
					,c.get(Calendar.SECOND)
					, "일월화수목금토".charAt(c.get(Calendar.DAY_OF_WEEK)-1)+"요일");
		}



}
