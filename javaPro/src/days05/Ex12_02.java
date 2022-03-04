package days05;

public class Ex12_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "hong gil dong";
		
		//for 반복문으로 처리
	     //  name.length()   -< 문자열 길이
		
		int len = name.length();
		for(int i=0; i<len; i++) {
			System.out.println(name.charAt(i));
		}
		
		
	}

}
