package days05;

import java.util.Scanner;

public class Ex12_03 {

	public static void main(String[] args) {
		
		char ch;
		Scanner scan = new Scanner(System.in);
		String data = scan.next();
        ch = data.charAt(0);  
	
		//char -> 래퍼클래스 Character
        //boolean Character.isDigit(ch)   숫자인지 아닌지  t/f
        //Digit가 숫자니 아니니
        
        /* Character.isAlphabetic(ch)       대문자인지 아닌지
       
        Character.isUpperCase(ch)    대문자
        Character.isLowerCase(ch)    소문자
         */
		if(Character.isUpperCase(ch)) {
		System.out.println("대문자");
		}else if(Character.isLowerCase(ch)) {
			System.out.println("소문자");
		}else if( Character.isDigit(ch)) {
			System.out.println("숫자");
		}else if(  '가'  <= ch  && ch<='힣') {
			System.out.println("한글");
		}else if( '#'==ch  ||  '@'==ch   || '@'==ch  ||  '&' == ch) {
			System.out.println("특수문자");
		}else {
			System.out.println("알수없음");
		}
		
		scan.close();

	}

}
