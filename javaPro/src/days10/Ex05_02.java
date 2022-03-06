package days10;

import java.util.Scanner;

public class Ex05_02 {

	public static void main(String[] args) {


		String rrn = getRRN();
		System.out.println(rrn);
		
		//1.주민등록번호로 부터 성별을 출력. "남","여"
		boolean gender = getGender(rrn);
		System.out.println(gender?"남자":"여자");

	}

	//남자라면 true 반환 여자라면 false반환
	private static boolean getGender(String rrn) {
	
		return rrn.substring(7,8).matches("[13579]");
		
		//풀이3	
	//	if(Integer.parseInt( rrn.substring(7, 8)) % 2 ==1) return true;
	//	else return false;
		
		
		
		
	 }	/*//풀이1
		if( (rrn.charAt(7)-48) %2 !=0) return true;
		else return false;*/
 
	//풀이2 return (rrn.charAt(7)-48) %2 ==1? true:false;

	public static String getRRN() {
		String rrn,regex = "\\d{6}-\\d{7}";
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print(">주민등록번호 입력?"); //000000-0000000
			rrn = scan.next();
		}while(!rrn.matches(regex));		
		return rrn;
	}

}
