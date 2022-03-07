package days11;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		int money;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("머니 입력"); //125760원
		money = scan.nextInt();
		
		//화폐단위 : 5만원 1만원 5천원 1천원 3백원 1백원 5십원 1십원
		int share, rest;
		
		//반복문 사용 처리 for/while 
		//풀이2
		int [] unit = {50000,10000,5000,1000,500,100,50,10,5,1};
		String [] s_unit = {"오만원","만원","오천원","천원","오백원","백원","오십원","십원"};
		 for(int i=0;i<unit.length;i++) {
		share = money/unit[i];
		rest = money%unit[i];
		System.out.printf("%s :%d개      %d\n", s_unit[i],share, rest);
		money = rest;
		}

		 scan.close();
	}

}
