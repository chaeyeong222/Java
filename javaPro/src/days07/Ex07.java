package days07;

import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		//예제 4-7 p.150
		/*user와 컴퓨터 가위바위보 게임
		 * user 는 123 입력
		 * 컴퓨터는 임의의 수 발생
		 * user/com 출력
		 * user - com =0 비김
		 * user - com =1/-2 user 이김
		 * user - com =-1/2 com 이김
		 * 
		 * 1.입력값에 대한 유효성 검사
		 * 2. 컴퓨터가 낸 값이 가위, 바위, 보 인지 알려주기
		 * 3. 다시 하고 싶니? y 다시 하기
		*/
		
		int user, com;
		System.out.print("가위1,바위2,보3 중 하나를 입력");
		//입력값에 대한 유효성 검사
		//컴퓨터가 낸 값
		
		Scanner scan = new Scanner(System.in);
	/*	String temp = scan.nextLine();
		user = Integer.parseInt(temp);
		*/
		user = scan.nextInt();
		com = (int)(Math.random()*3+1);
		
		System.out.println("당신은 user, 컴퓨터는 com입니다");
		
		switch(user-com) {
		case 0:
			System.out.println("비김");
			break;
		case 2: case -1:
			System.out.println("당신 짐");
			break;
		case -2: case 1:
			System.out.println("당신 이김");
			break;
		}
		
		
		
		
		
		scan.close();
		
	}//main

}//class
