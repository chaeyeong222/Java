package days05;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		/*0보다 작거나 100보다 크거나    x <0  || x>100      !(x>0 && x<=100
		 * 키보드 사용해서 문자 입력받아서 ch변수에 저장한 뒤
		 * 대,소,숫자,한글, 특수문자 인지 구분해보기
		 * 대문자     'A'  <= ch  && ch<='Z'
		 * 소문자     'a'  <= ch  && ch<='z'
		 * 숫자        '0'  <= ch  && ch<='9'
		 * 한글        '가'  <= ch  && ch<='힣'
		 * 특수문자    '#'==ch  ||  '@'==ch   || '@'==ch  ||  '&' == ch
		*/
		
		char ch;
		
		Scanner scan = new Scanner(System.in);
		
		 //스캐너로 문자 읽는 메서드 x, 스캐너 사용해서 한문자 읽는 방법
		String data = scan.next();
		//문자열을 한문자로 변환한다는 것 자체가 불가능한 말. 여러개->한개
          // "a" = 'a' +'\0'		
		
		ch = data.charAt(0);   //"a"-'a'
	//	System.out.println(ch);         //   "a" ->'a' 변환
		
		if( 'A'  <= ch  && ch<='Z') {
		System.out.println("대문자");
		}else if( 'a'  <= ch  && ch<='z') {
			System.out.println("소문자");
		}else if( '0'  <= ch  && ch<='9') {
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
