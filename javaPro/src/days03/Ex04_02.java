package days03;

/**
 * @author 이채영
 * @date 2022. 2. 17. - 오전 11:48:42
 * @subject 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		//한 학생의 이름, 국어, 영어, 수학, 총점, 평균을 출력

		String name;
		byte kor, eng, mat;
		short tot;   //0 ~ 300
		double avg;
		/* [시험]
		 *  1. 형 변환
		 *     ㄱ. 자동 형변환  2가지
		 *            1) 작은 자료형의 값을 큰 자료형에 대입할때 자동형변환된다.
		 *                    long l = 100;
		 *            2) 작은 자료형 연산 큰 자료형 -> 큰 자료형  자동형변환.
		 *                   300L + 100  
		 *     ㄴ. 강제 형변환
		 *             int tot = 152;
		 *             double avg = (double)tot/3; 
		 * */

		// ㄴ. 강제 형변환
		 //float, double :  %f
	//	int tot = 152;
		//                    int  연산 double => double
		// double avg = tot / 3.0 ;  // 50                       // 50.6666667
		//  개발자 강제로   int -> double 형 변환 필요
		//double avg = (double)tot / 3 ;  // 50                       // 50.6666667
		
	//	System.out.printf("총점 : %d, 평균 :  %f\n", tot, avg);
		// 총점 : 152, 평균 :  50.000000
		// 총점 : 152, 평균 :  50.666667
		
		
		/*
		// 2) 자동 형변환되는  두 번째 경우
		int a = 100;
		long b = 100;  // 자동 형변환 1 경우
		
		long c = b + a;  // long b + int a
		
		System.out.println( c );
		*/
		
		/*
		// 1) 자동 형변환되는  첫 번째 경우
		int i = 100;         // 4
		long j = 10L;       // 8
		
		// long j = int i  자동형변환 O
		j = i;
		*/
		
		
		
		// +  덧셈연산자                  2+3+5
		// +  문자연결연산자             "이름은 : " + "홍길동" + "입니다"
		
		
		// 연산자 우선 순위가 있다.           *    >  +
		// () 최우선연산자                   2*( 3+5 ) 
		// (변환하고자 하는 타입) cast 연산자                     tot / 3
	} // 

} // 
