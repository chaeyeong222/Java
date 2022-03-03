package days04;
/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 4:15:58
 * @subject 
 * @content  p. 101-103
 */
public class Ex10 {

	public static void main(String[] args) {
        //[1] char  = 정수계열
		char a = 'a', z='z';
		char A = 'A', Z='Z';
		System.out.printf("%c[%d]\n", a, (int)a);
		System.out.printf("%c[%d]\n", A, (int)A);
		System.out.printf("%c[%d]\n", z, (int)z);
		System.out.printf("%c[%d]\n", Z, (int)Z);
		
		//소문자와 대문자의 차이는 32 (소-대=32)
		
		 //[2] 대문자 A 와 소문자 a 문자코드값의 차를 확인
		System.out.println(a-A);   //값32  문자-문자여도 오류안남
		System.out.println('a'-'A');   //값32  문자-문자여도 오류안남
		
		 //[3] 대문자 A 와 소문자 a 문자코드값의 차를 확인
		char ch = 'x' -32;
		System.out.println(ch);     //결과값 : 'X'(소-32= 대)
 		
		
		
	}

}
