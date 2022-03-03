package days04;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 4:25:39
 * @subject  예제문제
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		//pi실수값을 소수점 4자리에서 반올림한값을 r에 넣어 출력
		double pi=3.141592;     //답: 3.142
		
		//3번풀이    소수점 3까지 나타내라-> 4자리에서 자동 반올림/
		String strPI = String.format("%,3f", pi);
		
		//String->Double 변환
		double dPI = Double.parseDouble(strPI);
		System.out.println(dPI);
		
		//2번풀이
		System.out.printf("%0.f\n",pi);
		
		
		//1번풀이
		
		System.out.println(pi * 1000); //3141.592
		System.out.println(pi * 1000 +0.5); //3142.092
		System.out.println((int)(pi * 1000 +0.5)); //
		System.out.println((int)((pi * 1000 +0.5)/1000d)); //
		double r = (int)(pi * 1000 +0.5)/1000D;
		
		
		System.out.println(r);
		
		

	}

}
