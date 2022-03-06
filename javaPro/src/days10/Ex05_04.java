package days10;

public class Ex05_04 {

	public static void main(String[] args) {
		// days10 동일한 패키지 안에 있을 경우에는
		//[days10.]Ex05_02.getRRN()
		//패키지명. 클래스명. 메서드명()
		
		String rrn = Ex05_02.getRRN();//990112-1411001
		System.out.println(rrn);
		
		//생년월일 출력하기
		
		String birthday = getBirth( rrn);
		System.out.println(birthday);

	}

	public static String getBirth(String rrn) {
		int year = Integer.parseInt(rrn.substring(0, 2));
		int month = Integer.parseInt(rrn.substring(2, 4));
		int day = Integer.parseInt(rrn.substring(4, 6));
		
		switch(rrn.charAt(7)-48) {
		case 0: case 9:
			year +=1800;
			break;
		case 1: case 2: case 5: case 6:
			year += 1900;
			break;
		default:
			year+=2000;
			break;
		}
		//String.format() 내가 원하는 형식의 문자열로 변환
		String birthday = String.format("%d년 %02d월 %d일", year,month,day);
		/*
		if(rrn.substring(7, 8).matches("[1256]")) 
			System.out.printf("19%d년 %d월 %d일",year,month,day);
		else if(rrn.substring(7, 8).matches("[3478]")) 
			System.out.printf("20%d년 %d월 %d일",year,month,day);
		*/
		return birthday;
	}

}
