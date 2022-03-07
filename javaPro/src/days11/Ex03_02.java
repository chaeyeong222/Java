package days11;

import java.util.Scanner;

public class Ex03_02 {

	public static void main(String[] args) {
		int money;
		Scanner scan = new Scanner(System.in);
		System.out.print("머니 입력"); //125760원
		money = scan.nextInt();
		
		//스위치변수
		//한번은 더하고 한번은 뺄때 와 같이 두가지가 반복될때 유용
		
		int unit = 50000;
		int count = 0;
		boolean sw=false;
		
		while(unit>=1) {
			count = money / unit;
			System.out.printf("%d원: %d개\n", unit, count);
			money %=unit;
			
			unit=unit/(sw? 2:5);
			sw=!sw;
			
		}
		
	}

}
