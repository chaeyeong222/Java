package days27;

import java.util.Calendar;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 9:41:37
 * @subject  p.691 열거형enums 
 * @content      1. 정의 = 열거형 (자료형)
 *                        상수의 나열(열거)
 *                      2. 열거형 선언 형식
 *                        enum 열거형이름 {상수, 상수,상수,상수 }
 *                        +
 *                      3. 열거형 사용하는 방법
 *                         열거형이름.상수명
 *                      4. 열거형의 조상은 java.lang.Enum 클래스
 *                      5. 왜 사용?***
 *                          팀작업) 남/여 성별에 따라 코딩
 *                             int gender = 1/0;
 *                             boolean gender = true/false;
 *                             char gender= 'm' / 'w';
 *                             String gender = "남자"/"여자"
 *                             
 *                             표준화하기 위해서 열거형 JDK 1.5 새로 추가됨
 *                             -> 서로 관련된 상수를 열거하기 위해서                      
 */
public class Ex02 {

	public static void main(String[] args) {
	/*	
		Calendar c = Calendar.getInstance();
		System.out.println(Calendar.YEAR);
		int year= c.get(Calendar.YEAR);
		System.out.println(year);


		System.out.println("====이미 사용하고 있었음====");
		
		System.out.println(Card.CLOVER); //0
		
		int cardType =Card.CLOVER; //0

		switch(cardType) {
		case Card.CLOVER: //코드 가독성 좋아진다
		break; 
		}*/
	}//main

}//class

//카드모양 - 클로,하,다,스
/*
class Card {
	static final int CLOVER = 0;
	static final int HEART = 1;
	static final int DIAMOND = 2;
	static final int SPACE = 3;
}
*/