package days23;

import java.text.DecimalFormat;

public class Ex02_03 {

	public static void main(String[] args) {
		//p.542 예제 10-10
		//p.543 예제 10-11
		
		String smoney = "1,234,400";
		//, 없애기
		//방법1
	/*	
		int money =  Integer.parseInt(smoney.replaceAll(",", ""));
		System.out.println(money);
*/
		//2.
		String pattern = "";
		DecimalFormat df = new DecimalFormat(pattern);
		//문자열 = df.format(숫자형)
		
		
	//숫자형(Number) df.parse(문자열)
		//숫자 래퍼클래스의 부모클래스 Number
		try {
			Number num = df.parse(smoney);
			int money = num.intValue();//number타입->int 변환하는 메서드
			System.out.println(money);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
