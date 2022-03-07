package days11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오후 4:36:08
 * @subject   배열의 단점
 * @content 1. 배열의 크기를 설정한 후에는 배열의 크기가 자동변경되지 않는다. -> 컬렉션
 *                    개발자 능력 따라서 배열크기 증가/변경해서 사용할 수는 있다
 *                 2. 
 */
public class Ex06 {

	public static void main(String[] args) {
		//배열 크기를 3으로 설정
		int m [] = new int [3];
		Scanner scan =  new Scanner (System.in);
		int idx = 0;
		char con ='y';

		do {
			//배열크기가 남는 것이 있는지 확인 -> 배열크기 증가
			if(idx==m.length) m = Ex04_04.increaseArraySize(m, 3);			
			
			System.out.printf(">m[%d] 정수 입력?",idx);
			//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
			//at days11.Ex06.main(Ex06.java:24)
			
			m[idx++] = scan.nextInt();
			//idx++;
			System.out.println("계속?");
			con = scan.next().charAt(0);
			
		}while(Character.toUpperCase(con)=='Y'); //무조건 대문자로 바꿔서  Y입력하면 ㄱㄱ 

		System.out.println(Arrays.toString(m));
	}

}
