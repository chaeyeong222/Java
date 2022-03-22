package days23;

import java.text.DecimalFormat;

public class Ex02_04 {

	public static void main(String[] args) {
		String smoney = "\1,234,567.89";
	//	double money= Double.parseDouble(smoney.replaceAll("[\\,]", ""));
		
		double money;
		String pattern = "#,###.##";
		DecimalFormat df = new DecimalFormat(pattern);
		
		try {
			Number num = df.parse(smoney);
			money = num.doubleValue();//number타입->int 변환하는 메서드
			System.out.println(money);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
