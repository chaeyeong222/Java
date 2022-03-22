package days23;

import java.text.DecimalFormat;

public class Ex02_02 {

	public static void main(String[] args) {
		//int no = 10;
		//0010    4자리 숫자형식으로 출력		
		//1.String sno = String.format("%04d", no);
		
		//2.no 자리를 계산해서 로직으로 앞에 0문자를 붙이는 방법
		
		//3. #0000
		//패턴기호# 숫자있으면 출력 없으면 비움
		//패턴기호# 에서 제외escape 시킬때 ' 붙여줌 "'#'0000"
		double no = 10.1;
		String pattern ="0000.##"; //#없으면 비움, 0없으면 0으로 채움
		DecimalFormat df = new DecimalFormat(pattern);
		String sno = df.format(no);
		System.out.println(sno);
		
		
	}

}
