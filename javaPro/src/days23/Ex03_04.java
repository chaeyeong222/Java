package days23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex03_04 {

public static void main(String[] args) {
		
		// String -> Date 변환 ->  Calendar 변환
		String sdate = "2022.03.22(화)";
		
		// 1.     Date d = new Date(2022, 3, 22);
		
		String pattern = "yyyy.MM.dd(E)";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		Date d;
		try {
			d = sdf.parse(sdate);
			System.out.println(  d.toLocaleString() );
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		
	} // main

} // class
