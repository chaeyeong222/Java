package days24;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex02_02 {

	public static void main(String[] args) {
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
				"yyyy-MM-dd HH:mm:ss",
				"''yy년 MM월 dd일 E요일",
				"yyyy-MM-dd HH:mm:ss.SSS Z VV",
				"yyyy-MM-dd hh:mm:ss a",
				"오늘은 올 해의 D번째 날 입니다.",
				"오늘은 이 달의 d번째 날 입니다",
				"오늘은 올 해의 w번째 주 입니다.",
				"오늘은 올 해의 W번째 주 입니다.",
				"오늘은 이달의 W번 째 E요일 입니다"
		};
		for (String p : patternArr) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(dtf));
		}
			
		}

	}


