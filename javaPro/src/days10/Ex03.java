package days10;

public class Ex03 {

	public static void main(String[] args) {
		
		String rrn ="830412-1700001";
		//뒷자리가 *로 표시되도록 하기
		/*
		String regex = "-";
		String [] rrns = rrn.split(regex);
		// rrns[0]-rrns[1] //주민번호
		
		rrns[1] ="*******";
		System.out.println(String.join("-", rrns));
		
		//뒷자리에서 성별 제외하고 *로 표시되도록 하기(풀이1)
		String regex = "-";
		String [] rrns = rrn.split(regex);
		
		//rrns[0] = "830412"
		//rrns[1] = "1700001"     ->1******
		
		rrns[1] = rrns[1].charAt(0) + "******";
    	System.out.println(String.join("-", rrns));

		//뒷자리에서 성별 제외하고 *로 표시되도록 하기(풀이2)
		//rrn.substring(int beginIndex, int endIndex)
		//012345 6 7890123
		//830412  -  1700001
		System.out.println(rrn.substring(0, 6)); //830412
		System.out.println(rrn.substring(7, 14)); // 1700001
		System.out.println(rrn.substring(0, 8) + "******"); // 830412-1******
		
		//endIndex를 생략하면 문자열 끝까지 다 가져옴
		// System.out.println(rrn.substring(7));
		*/
		
		//뒷자리에서 성별 제외하고 *로 표시되도록 하기(풀이3)
		
		//하나의 문자열을 한 문자씩 배열로 만들어주는 함수 toCharArray(); 
		
		char[] rrnCharArray = rrn.toCharArray();
		
		for(int i = 8 ; i<rrnCharArray.length; i++)  	rrnCharArray[i] = '*';

		for(int i = 0 ; i<rrnCharArray.length; i++)  	
			System.out.printf("%c", rrnCharArray[i]);
		
		//String -> char [] 변환 : toCharArray()
		//char[] -> String 변환 : 	String str = new String(rrnCharArray);
		
		
		
	}

}
