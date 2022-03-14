package days07;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// 가위바위보 유효성 검사 예제
		
		Scanner scan = new Scanner(System.in);
		
		int user;
		String sUser;
		String regex = "정규표현식";
		
		do{
		System.out.print("가위1,바위2,보3 중 하나를 입력");
		sUser = scan.next();
		}while(!sUser.matches(regex));
	
	      user = Integer.parseInt(sUser);
	      
	      System.out.println(user);
	
	      scan.close();
}
}
