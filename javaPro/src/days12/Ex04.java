package days12;

import java.util.Arrays;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오전 10:09:05
 * @subject p. 192 배열의 복사 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {

		int [] m = {1,2,3};
		int [] temp = new int [m.length+5];

		/*
		 * for (int i = 0; i < m.length; i++) {
			temp[i]=m[i] ;
       }
		 */ 
		//원하는 위치에 원하는 만큼
		/*
		 * for (int i = 1; i < m.length; i++) {
			temp[i+3]=m[i] ;
       }
		 */
		//1. 기능 : System 클래스 안에 배열 복사하는 메서드 : arraycopy()
		//2. 매개변수 : src, srcPos, dest, destPos, length
		/*Parameters:
		 * src - the source array.src
		 * Pos - starting position in the source array.
		 * dest - the destination array.dest
		 * Pos - starting position in the destination data.
		 * length - the number of array elements to be copied.
		 */
		//3. 리턴값(리턴자료형) void
		//System.arraycopy(src, srcPos, dest, destPos, length);
		
		System.arraycopy(m, 1, temp, 4, 2);
		
		System.out.println(Arrays.toString(m));
		System.out.println(Arrays.toString(temp));

	}//main

}//class
