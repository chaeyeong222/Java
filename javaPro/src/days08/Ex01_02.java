package days08;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오전 9:07:37
 * @subject 
 * @content 우편번호 안내
 * 1.우편번호란?
 * 2. 우편번호 구성?
 * 
 */
public class Ex01_02 {

	
	public static void main(String[] args) {
		//[문제] 유효성검사 ==정규표현식 == String regex = [??]
		/*우편번호를 입력받아서        우편번호O / 우편번호X
		 * 우편번호 체계 : 000-000    또는 00000    정규표현식으로 나타내기
		*/
		//[0-9] == [0123456789]
		//[2345678] == [2-4[6-8]]
		//[0-9&&[2-5]]->교집합 2-5
		//[0-9&&[^2-5]] -> ^ 들어가면 뺀거
		//   \d 숫자면 된다
		//   \D 숫자면 안된다
		//   \s 공백문자열    \S 공백제외
		//   \w 숫,영, 
		
		String postcode;
		Scanner scan = new Scanner(System.in);
		
		//String regex = "[0-9][0-9][0-9]-[0-9][0-9][0-9]";
		//String regex = "\\d\\d\\d-\\d\\d\\d";
		String regex = "\\d{3}-\\d{3}|\\d{5}";
		
		System.out.print("우편번호 입력( 000-000    또는 00000)");
		
		 String sPostcode =scan.next();
		
		 if(sPostcode.matches(regex)) {
			 System.out.println(" 우편번호O");
			 
		 }else System.out.println("우편번호X");
		 
			
		
		scan.close();
		
		
		
		
	}//main

}//class
