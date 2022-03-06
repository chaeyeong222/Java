package days10;

public class Ex05_10 {
	public static void main(String[] args) {
		
		String rrn = Ex05_02.getRRN();
		  
		int [] m = {2,3,4,5,6,7,8,9,2,3,4,5};
		int tot=0;
		for(int i=0; i<=12; i++) {
			if(i==6) continue; // 배열의 -자리에 0넣고 if문 안써도 됨.
			tot+= Integer.parseInt(  rrn.substring(i, i+1)) * m[i];
		}
	      
	      int ㅍ = 11-((tot % 11))%10;   
	      
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