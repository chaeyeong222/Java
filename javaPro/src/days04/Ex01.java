package days04;
/**
 * @author 이채영
 * @date 2022. 2. 18. - 오전 10:43:13
 * @subject 연산자 (operator)
 * @content  실수를 소주점 2자리까지 출력
 */
public class Ex01 {

	public static void main(String[] args) {
		
		
		int score = -70;
		System.out.printf("score=%(d\n",score);  //  (넣으면 음수 대신에 (70)나옴
		
		int money = 12345;
		System.out.printf("money=%,d\n",money);  //  ,넣으면 자동으로 천단위씩 ,
		
		byte kor = 10;
		short eng = 80;
		long mat = 70;
		
		System.out.printf("kor = [%d]\n", kor);  //10진수 정수형태
		
		System.out.printf("kor = [%10d]\n", kor);  //총 자리수 10개 잡고 우측정렬
		System.out.printf("kor = [%-10d]\n", kor);  //총 자리수 10개 잡고 좌측정렬
		System.out.printf("kor = [%010d]\n", kor);  //총 자리수 10개 잡고 빈자리 0으로 채움 우측정렬(암기)
		
		/*
		 *  4자리 잡고 숫자형식 출력
		 */
		int a = 45, b = 55;
		
		System.out.printf("%04d\t%04d\n",a,b);   //  \n:개행    \t:띄어쓰기
		
		
		
		System.out.printf("kor = [%o]\n", kor);  // 8진수 정수형태  
		System.out.printf("kor = [%x]\n", kor); // 16진수 정수형태 ->소문자 a
		System.out.printf("kor = [%X]\n", kor); // 16진수 정수형태 ->대문자 A
		System.out.printf("kor = [%#o]\n", kor); // 앞에 0붙음
		System.out.printf("kor = [%#x]\n", kor); // 16진수 -> 앞에 0x 붙음
		System.out.printf("kor = [%#X]\n", kor); // 16진수 ->대문자 0X 붙음
		
		
		System.out.printf("eng = %d\n", kor);
		System.out.printf("mat = %d\n", kor);
		
		float avg= 87.32342F;
		
		// System.out.printf("avg=%d", avg); 
		// error : IllegalFormatConversionException -> %d 잘못됨, %f 써야함.
		
		System.out.printf("avg=[%.2f]\n", avg);  //소수점 x 자리수 까지 출력 .x
		
		
		

	}

}
