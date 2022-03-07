package days11;

public class Ex01 {

	public static void main(String[] args) {
		int year, month; //2010년 5월
		
		if(args.length !=2) {
			System.out.println(">java.exe Ex01 2010 5 년도, 월 매개변수 필요합니다");
			return;
		}
		
		year = Integer.parseInt(args[0]);
		month = Integer.parseInt(args[1]);

		
	
		/* 1. 달력 그리기(생성)
		 *    ㄱ. 년, 월의 1일이 무슨 요일? 토요일
		 *            1. 총날짜수   1.1.1~2010.05.01
		 *            2. 총날짜수  % 7   0일 1월 2화 3수 4목 5금 6토
		 *    ㄴ. 년, 월이 마지막 날짜? 28/29/30/[31]
		 *            1. 28일 - 2월(평년)
		 *            2. 29일 - 2월(윤년)
		 *            3. 30일 - 4/6/9/11월
		 *            4. 31일 - 1/3/5/7/8/10/12월    
		*/
		for(int j=2008; j<=2010; j++){
		for(int i=1;i<=12;i++) {
			printCalendar(j,i);
		}} 
	//	printCalendar(year,month); //메서드호출 부분
		
	}
	private static void printCalendar(int year, int month) {
		// 총 날짜수      1.1.1~?.?.?
		 int dayOfWeek = getDayOfWeek(year, month);
		//System.out.println(">총날짜수: " + "일월화수목금토".charAt(dayOfWeek)+"요일");
		

		int lastDay = getLastDay(year, month);
	//	System.out.println(">마지막날짜 :" + lastDay);
		//달력출력
		System.out.printf("\t\t\t%d년 %d월\n", year, month); //2010년 5월(1일:토~31일까지) 
		
		days08.Ex02.drawLine(50, '-');
		String week = "일월화수목금토";
		for(int i=0;i<week.length();i++)  System.out.printf("\t%c",week.charAt(i));
			System.out.println();
		
		days08.Ex02.drawLine(50, '-');
		
		
		//1일~31일
		for(int i=0;i< dayOfWeek; i++) {
			System.out.print("\t");
		}
		for(int i=1; i<=lastDay; i++) {
			System.out.print("\t"+i);
			if((dayOfWeek +i)%7 ==0) System.out.println();
		}
		System.out.println();
		days08.Ex02.drawLine(50, '-');
		
		
	 }
	private static int getLastDay(int year, int month) {
		int lastDay;
		
		switch(month) {
		case 2:
			lastDay = (days06.Ex07_02.isLeapYear(year))? 29:28;
			break;
		case 4: case 6: case 9: case 11:
			lastDay =30;
			break;
		default:
			lastDay =31;
			break;
		
		}
		
		return lastDay;
	}
	private static int getDayOfWeek(int year, int month) {
		// 총 날짜수 % 7 = 요일 (0-6)
		int totalDays = getTotalDays(year,month,1);
	//	System.out.println("총날짜수:"+totalDays);
		int dayOfWeek = totalDays %7;
		
		return dayOfWeek;
	}
	private static int getTotalDays(int year, int month, int date) { //3.2.13
		// 1.구하고자 하는 이전년도 (year(2010)-1 == 2009)의 총 날짜수
		int totalDays =0;
		/*
		for(int i=1; i<year;i++) {
			if(days06.Ex07_02.isLeapYear(i)) totalDays +=366;
			else            totalDays+=365;
		}
		*/
		
		totalDays = (year-1) *365 +(year-1)/4 - (year-1)/100 + (year-1)/400;
		
		// 2. 그 해의 1,2,3... (month-1)   + month의 날짜(ex.1)
		
		//풀이3 [암기하기] 
		int [] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0; i<month-1;i++) totalDays += m[i];
		if(days06.Ex07_02.isLeapYear(year) && month >=3) totalDays++;
		totalDays+=date;		
		
		/*풀이2
		 * for(int i=1; i<month; i++) {
		 * switch(i) {
			case 2:
				totalDays += (days06.Ex07_02.isLeapYear(year))? 29:28;
				break;
			case 4: case 6: case 9: case 11:
				totalDays +=30;
				break;
			default:
				totalDays +=31;
				break;
			
			}totalDays+=date; 
			}
		 */
			
			 
		
		/* 풀이1
		 * switch (month) {  // 5월
      case 1:         
           totalDays +=  1; //1대신 date 더하기 
         break;
      case 2:      
         totalDays += 31 + 1;
         break;
      case 3:         // case 3 윤년 +1
         totalDays += 31+28 + 1;
         break;
      case 4:         
         totalDays += 31+28+31 +1;
         break;
      case 5:         
         totalDays += 31+28+31+30 + 1;
         break;
      case 6:         
         totalDays += 31+28+31+30+31 + 1;
         break;
      case 7:         
         totalDays += 31+28+31+30+31+ 30+ 1;
         break;
      case 8:         
         totalDays += 31+28+31+30+31+ 30+31 + 1;
         break;
      case 9:         
         totalDays += 31+28+31+30+31+ 30+31+31 + 1;
         break;
      case 10:      
         totalDays += 31+28+31+30+31+ 30+31+31+30+ 1;
         break;
      case 11:         
         totalDays += 31+28+31+30+31+ 30+31+31+30+31+ 1;
         break;
      case 12:         
         totalDays += 31+28+31+30+31+ 30+31+31+30+31+30+ 1;
         break; 
      }
    
      if( days06.Ex06_02.isLeapYear(year) &&  month >=3) totalDays++;
		 */
		
		return totalDays;
	}

}
