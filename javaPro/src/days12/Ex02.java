package days12;

import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {
        //한글 '가'?  44032         '힣'?? 55203
		//      'A' 65 B 66         Z 90
		/*한글 숫자로 구하기
		 * for(int i ='가'; i<='힣';i++) {
			System.out.printf("%c\t%d\n", i,i);
		}
		 */
		
		Random rnd = new Random();
		System.out.print("김");
		for (int i = 0; i < 2; i++) {
			System.out.print((char)(rnd.nextInt(11172)+44032));
		}
		

	}//main

}
