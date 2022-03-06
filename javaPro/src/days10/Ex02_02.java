package days10;
/**
 * @author 이채영
 * @date 2022. 3. 2. - 오전 10:30:43
 * @subject 
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
		//  "7655-8988-9234-5677"
		// 카드번호 문자열을 구분자 "-" 로 잘라내기
		
		String card = "7655-8988-9234-5677";
		
		//문자열을 다루는 메서드==String 클래스의 메서드
		//1.문자열의 길이 
		System.out.println(card.length());
		//2.문자열 속에서 원하는 위치의 한 문자 얻어오는 메서드 : charAt(index)
		for(int i=0;i<card.length();i++) {
			System.out.println(""+card.charAt(i)+"");
		}
		//3.String.format() 메서드
		//4.String.matches(pattern) 입력값에 대한 유효성 검사할때
		//5. String.split() 메서드
		String regex = "-";
		String [] cardNumbers = card.split(regex);  // 정규표현식을 기준으로 자른다
		//cardNumbers[0]
		//6. String.join()
		card = String.join("-", cardNumbers);
		System.out.println(card);
		
		for(String cardNumber4 : cardNumbers) {
			System.out.println(cardNumber4);
		}
		
		
		
	}

}
