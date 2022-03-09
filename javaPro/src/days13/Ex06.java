package days13;

import java.util.Arrays;

public class Ex06 {

	public static void main(String[] args) {
		//한번에 해결하는 함수 Arrays.binarySearch(배열, 찾을정수)
		
		/* 문제 2) 취업 문제 ego(자아)
	       *        String n = "keNik";
	       *        String m= "kKnie";
	       *        
	       *        위의 두 문자열 n, m 이 알파벳과 알파벳갯수가 똑같은지 비교하는 코딩 
	       *        결과는 같을 경우 true/ 다를 경우 false 로 출력.
	       *        조건) 대소문자는 구분하지 않는다.  
	       * */
		String n = "keNik";
		String m= "kKnie";
		
		boolean b = solution(n, m);
		System.out.println(b);
	
		 System.out.println(  b ? "같다" : "다르다" );

	/*if(n.length()==m.length()) {
		
		
		int cnt=0;
		for(int i=0;i<5; i++) {
			if( Character.isUpperCase(n.charAt(i))==Character.isUpperCase(m.charAt(i)))
              cnt++;
		} 
		if(cnt==5) System.out.println("true");
		else System.out.println("false");
		}
		else System.out.println("false");
	 * 	
	 */
	}

	private static boolean solution(String n, String m) {
		n = n.toUpperCase();
		m= m.toUpperCase(); //String 클래스 안에 toUpperCase 메서드
		// System.out.println( n  +" / " + m);
		 //                                    KENIK          KKNIE
		//                     정렬          EIKKN           EIKKN 정렬된 두 문자열이 같니?
		// String -> char[] 이 char 배열을 정렬-> String
		 n =  getStringSort( n ) ;  // "KENIK" ->  "EIKKN"
	      m =  getStringSort( m ) ;  // "KENIK" ->  "EIKKN"
	       
	      return   n.equals(m) ;
	   }
	 private static String getStringSort(String n) {
	      
	      char [] m =  n.toCharArray();
	      Arrays.sort(m); 
	      String temp = new String(m);
	      
	      return temp;
	   }

	   private static String toUpperCase(String n) {  // "keNik"
	      String temp = "";
	      for (int i = 0; i <  n.length() ; i++) {
	         char one =  n.charAt(i);  //  'k'
	         if( 'a' <= one && one <='z' )  one -= 32; 
	         temp += one;
	      } 
	      return temp;
	   }

/*소문자인지 확인하고 대문자로 바꿔주기 32차이남.
 * if('a' <=one && one <='z') one -=32;
 * 
 */
	} // class



