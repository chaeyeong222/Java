package days08;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  //메인함수에 놓고 주고받는게 성능이 좋음.
		
		//스캐너로 국어점수 입력받고 유효성 검사까지, 반환하는 메서드
		//int kor  = getscore("국어", scan);
		int kor = getscore();
		System.out.println(kor);

		//int eng  = getscore("영어", scan);
		int eng = getscore();
		System.out.println(eng);
	}//main
	
	public static int getscore(String subject, Scanner scan) {
		
		int kor;
		String sKor;
		String regex = "100|[1-9]?\\d";
		do {
		System.out.printf(subject + "점수 입력?");
		sKor = scan.next();
		}while(!sKor.matches(regex));
		
		kor=Integer.parseInt(sKor);
		return kor;	
	   
	}
		public static int getscore() {
			return  (int)(Math.random()*101);	
	}

}//class
