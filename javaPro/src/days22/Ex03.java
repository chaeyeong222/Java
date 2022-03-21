package days22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex03 {

	public static void main(String[] args) {
		// JDK 1.1 Calendar 추상클래스
		//태국x
//		Calendar c = new GregorianCalendar();
		Calendar c = Calendar.getInstance();
		
		//java.util.GregorianCalendar[
		//time=1647839186968,areFieldsSet=true,areAllFieldsSet=true,lenient=true
		//,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null]
		//,firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1
		//,YEAR=2022,MONTH=2,WEEK_OF_YEAR=13,WEEK_OF_MONTH=4,DAY_OF_MONTH=21
		//,DAY_OF_YEAR=80,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=3
		//		,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=6,SECOND=26,MILLISECOND=968
		//,ZONE_OFFSET=32400000,DST_OFFSET=0]
		System.out.println(c.toString());
		
		//field 설정-> get()
		//c.get(int field)
		System.out.println(Calendar.YEAR);
		System.out.println(c.get(Calendar.YEAR)+"년"); //2022
		System.out.println(c.get(Calendar.MONTH) +1+"월");
		System.out.println(c.get(Calendar.DATE) +"일");
		System.out.println(c.get(Calendar.HOUR) +"시"); //12시
		System.out.println(c.get(Calendar.HOUR_OF_DAY) +"시"); //24시
		
		System.out.println(c.get(Calendar.MINUTE) +"분");
		System.out.println(c.get(Calendar.SECOND) +"초");
		System.out.println(c.get(Calendar.MILLISECOND) +"밀리초");
		//요일  1일2월3화4수5목6금7토   ->date는 0일1월2화...
		System.out.println(c.get(Calendar.DAY_OF_WEEK) +"요일");
		System.out.println(c.get(Calendar.AM_PM));  //1오후

	}

}
