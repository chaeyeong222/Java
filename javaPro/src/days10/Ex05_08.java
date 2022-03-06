package days10;

public class Ex05_08 {

	public static void main(String[] args) {
		//[문제]입력받은 주민등록번호 검증
		//"올바른 주민등록번호입니다"
		//"잘못된 주민등록번호입니다"
		/*
	      [ 주민등록번호 검증 규칙 ]
	      ‘ㅍ’은 주민등록번호에 오류가 없는지 확인하는 검증번호로, 아래와 같은 특수한 규칙으로 만든다.
	      ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}
	      즉, 소괄호 안에 있는 것을 계산한 값을 11로 나눠서 나온 나머지를 11에서 뺀 값이 ㅍ이다. (단, 10은 0, 11은 1로 표기한다.)
	      */
		//내가 한거 ㅜ
		int []a = new int [13];
		int sum=0;
		
		String rrn = Ex05_02.getRRN();
		
		//앞 6자리
		for(int i = 0; i<=5; i++) {
			 a[i] = Integer.parseInt(rrn.substring(i , i+1 ));
			  sum = ( a[i] *=(i+2));
			 
			 System.out.printf("(%d * %d)+", a[i], (i+2));
		}
		
		//뒷자리 중 앞 2자리
		a[6] = Integer.parseInt(rrn.substring(7 , 8));
		    System.out.printf("(%d *8)+", a[6]);
		    sum+=sum;
		a[7] = Integer.parseInt(rrn.substring(8 , 9));
		    System.out.printf("(%d *9)+", a[6]);
		    sum+=sum;
		
		//뒷자리 나머지 5자리
		for(int i = 9; i<=13; i++) {
			 a[i] = Integer.parseInt(rrn.substring(i , i+1 ));
			 sum = ( a[i] *=(i-7));
			 System.out.printf("(%d * %d)+", a[i], (i-7));
		}

		System.out.println(sum);
	}

}
