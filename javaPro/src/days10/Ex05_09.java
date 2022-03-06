package days10;

public class Ex05_09 {
	public static void main(String[] args) {
		
		String rrn = Ex05_02.getRRN();
		  int ㄱ = Integer.parseInt(  rrn.substring(0, 1) );
	      int ㄴ = Integer.parseInt(  rrn.substring(1, 2) );
	      int ㄷ = Integer.parseInt(  rrn.substring(2, 3) );
	      int ㄹ = Integer.parseInt(  rrn.substring(3, 4) );
	      int ㅁ = Integer.parseInt(  rrn.substring(4, 5) );
	      int ㅂ = Integer.parseInt(  rrn.substring(5, 6) );
	      //            -                                                 6,7
	      int ㅅ = Integer.parseInt(  rrn.substring(7, 8) );
	      int ㅇ = Integer.parseInt(  rrn.substring(8, 9) );
	      int ㅈ = Integer.parseInt(  rrn.substring(9, 10) );
	      int ㅊ = Integer.parseInt(  rrn.substring(10, 11) );
	      int ㅋ = Integer.parseInt(  rrn.substring(11, 12) );
	      int ㅌ = Integer.parseInt(  rrn.substring(12, 13) );
	      
	      int ㅍ = 11- ( (2 *ㄱ+3*ㄴ+4*ㄷ+5*ㄹ+6*ㅁ+7*ㅂ+8*ㅅ+9*ㅇ+2*ㅈ+3*ㅊ+4*ㅋ+5*ㅌ) % 11 );   
	      
	      if( ㅍ == 10 )   ㅍ = 0;
	      else if( ㅍ == 11 )  ㅍ = 1;
	   
	      int ㅎ =  Integer.parseInt(  rrn.substring(13, 14) ) ;
	             
	      if( ㅍ ==  ㅎ ) System.out.println( "올바른 주민등록번호 입니다.");
	      else                System.out.println( "잘못된 주민등록번호 입니다.");
	      // 입력받은 주민번호 검증해서
	      // "올바른 주민등록번호 입니다."
	      // "잘못된 주민등록번호 입니다. "

	   } // main

	} // class