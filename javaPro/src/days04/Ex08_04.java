package days04;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 3:38:53
 * @subject 
 * @content 
 */
public class Ex08_04 {

	public static void main(String[] args) {
		// Java API Doc 예제
		// 이클립스 단축키 Ctrl + Shift + O
		 String input = "1 fish 2 fish red fish blue fish";
		 
		 /*
		  * \\s?      space 공백
		  * *?        반복횟수 0~여러번
		  * fish?     
		  */
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     
	     System.out.println(s.nextInt());  //1
	     System.out.println(s.nextInt());  //2
	     System.out.println(s.next());      //red
	     System.out.println(s.next());      //blue
	     
	     
	     s.close();

		
	}

}
