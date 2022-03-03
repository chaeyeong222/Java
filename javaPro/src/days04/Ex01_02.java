package days04;

public class Ex01_02 {

	public static void main(String[] args) {
		// 출력서식
		//%[argument_index$][flags][width]conversion
		//%conversion    %c %b %f %t 등등
		
		//%. width    conversion
		//%  10.2           f            -> 소수점 2자리 출력

		//[argument_index$]
		String name = "홍길동";
		
		//System.out.println(name);
		System.out.printf("%s\n%s\n%s\n",name, name, name); //한개만 써서 같이 출력하려면? 1$ 사용
		System.out.printf("%1$s\n%1$s\n%1$s\n",name); //한개만 써서 같이 출력하려면? 1$ 사용
		
	}

}
