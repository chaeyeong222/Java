package days07;

import java.util.Scanner;

public class Ex07_02 {
	public static void main(String[] args) {
		//예제 4-7 p.150
		/* 1.입력값에 대한 유효성 검사
		 * 2. 컴퓨터가 낸 값이 가위, 바위, 보 인지 알려주기
		 * 3. 다시 하고 싶니? y 다시 하기
		*/
		
		String [] rockPaperScissors = {"가위", "바위","보"};
		
		
		
		int user, com;
		System.out.print("가위1,바위2,보3 중 하나를 입력");
		
		Scanner scan = new Scanner(System.in);
		user = scan.nextInt();
		char con;
		do {
					//여기부터 반복하는 부분
				com = (int)(Math.random()*3+1);
				System.out.println("com=" + com);
				System.out.printf("컴퓨터는 \"%s\"를 냈다.\n", rockPaperScissors[com-1] );
				
				String sUser;
				String regex = "[1-3]";
				
				do{
					System.out.print("가위1,바위2,보3 중 하나를 입력");
					sUser = scan.next();
				}while(!sUser.matches(regex));
			       user = Integer.parseInt(sUser);
			      
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
			
			System.out.println("게임 계속 할래?");
			con = scan.next().charAt(0);
			
		}while(con == 'y' || con=='Y');
		
		
		
		
		
		
		

		
		scan.close();
		
	}//main

}//class
