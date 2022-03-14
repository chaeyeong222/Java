package days07;

public class Ex04 {

	public static void main(String[] args) {
		// ASCII 코드 - 문자 확인
        //            65 - 'A'
		// ASCII 코드 7bit 128가지           0~127 정수코드 - 문자
		//확장 ASCII  8bit 256가지           0~255 정수코드 - 문자
		
//		System.out.printf("%d - %c\n", 65, 65);  //같음
	//	System.out.printf("%1$d - '%1$c'\n", 65);
		
		//0~31 특수문자
		//32~127 일반문자
		//ㄴ48(숫자'0') ~57(숫자'9')
		//ㄴ65('A')~90('Z')대문자
		//ㄴ97('a')~122('z')소문자
		//128~255 선, 사선 등등 문자
/*
		for(int i =0; i<= 255; i++) {
			System.out.printf("%1$d - '%1$c'\n", i);
		}
	*/
		// 엔터치면(개행)     '\r' + '\n' 개행 제어문자   (CR LF 새줄 문자 확인)
		// LF10 \n 새줄
		// CR13 \r  라인이동
		
		//한 라인에 10개씩 출력

		for(int i =0; i<=255; i++) {
			System.out.printf("[%c]", i);
			if(i%10==9) System.out.println();
		}
		
	}

}
