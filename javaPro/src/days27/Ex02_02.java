package days27;

import java.util.Iterator;

public class Ex02_02 {
	
//public enum Card{ CLOVER=0,	 HEART=1 , DIAMOND=2 ,SPACE=3 };
	
	public static void main(String[] args) {
		//Enum : name(), ordinal(), values() 기억
		
		Card c = Card.HEART;
		System.out.println(c.toString()); //HEART
		System.out.println(c.name());  //HEART
		System.out.println(c.ordinal()); //1   상수의 순서
				
		//values() : 열거형 안에 선언된 모든 상수를 반환하는 메서드
		Card [] cArr = Card.values();
		for(Card card : cArr) {
			System.out.printf("%s=%d\n",card.name(),card.ordinal());
		}
		switch (c) {
		case CLOVER: break;
		case HEART: break;
		case DIAMOND: break;
		case SPACE: break;
		}
		
		
		
	}//main

}//class


//public enum Card{ CLOVER,	 HEART , DIAMOND ,SPACE };
