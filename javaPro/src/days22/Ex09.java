package days22;

import java.text.DecimalFormat;

/**
 * @author 이채영
 * @date 2022. 3. 21. - 오후 4:41:42
 * @subject p.540 형식화 클래스 DecimalFormat 클래스
 * @content 
 */
public class Ex09 {

	public static void main(String[] args) {
		
		int money = 3257600;
		
		//화폐단위, 3자리마다 콤마
		//\3,257,600출력
		
		//방법1
		/*
		String smoney = String.format("\\%,d", money);
		System.out.println(smoney);
*/
		String pattern = "\u00A4 #,###";
		DecimalFormat df = new DecimalFormat(pattern);
		
		String smoney = df.format(money);
		System.out.println(smoney);
		
	}

}
