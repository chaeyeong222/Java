package days11;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		int year, month; //2010년 5월

		if(args.length !=2) {
			System.out.println(">java.exe Ex01 2010 5 년도, 월 매개변수 필요합니다");
			return;
		}
	

		year = Integer.parseInt(args[0]);
		month = Integer.parseInt(args[1]);

		for(int j=2008; j<=2010; j++){
			for(int i=1;i<=12;i++) {
				printCalendar(j,i);
			}
		} 
	}
	private static void printCalendar(int year, int month) {

		int dayOfWeek = getDayOfWeek(year, month);
		int lastDay = getLastDay(year, month);

		System.out.printf("\t\t\t%d년 %d월\n", year, month);

		days08.Ex02.drawLine(50, '-');
		String week = "일월화수목금토";
		for(int i=0;i<week.length();i++)  System.out.printf("\t%c",week.charAt(i));
		System.out.println();

		days08.Ex02.drawLine(50, '-');

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

		int totalDays = getTotalDays(year,month,1);

		int dayOfWeek = totalDays %7;

		return dayOfWeek;
	}
	private static int getTotalDays(int year, int month, int date) {
		int totalDays =0;

		totalDays = (year-1) *365 +(year-1)/4 - (year-1)/100 + (year-1)/400;


		int [] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0; i<month-1;i++) totalDays += m[i];
		if(days06.Ex07_02.isLeapYear(year) && month >=3) totalDays++;
		totalDays+=date;		


		return totalDays;
	}

}