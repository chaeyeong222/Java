package days13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// 검색 - 순차검색 평균횟수 n/2
		// [이진검색 Binary Search] 성능 좋다
		//n개의 데이터의 최대 비교 횟수는 log2n회이고 평균 비교 횟수는 log2(n/2)이다
		//필수 조건: 반드시 정렬되어있어야 한다.
		//                    bottom          middle                           top
		//                        0                 5                                10    
		int [] m =  {1, 3, 8, 11, 15, 17, 20, 21, 25, 30, 34};
		System.out.println(  Arrays.toString(m) );

		int n; // 검색할 정수
		System.out.print("> 검색할 정수 입력 ? ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();  // 

		int idx = binarySearch( m , n );

		if (  idx == -1 ) {
			System.out.println("찾는 정수는 없습니다. ");
		} else {
			System.out.printf("%d 위치에서 찾았다.\n", idx);
		} 
	}

	private static int binarySearch(int[] m, int n) {
		int bottom = 0;
		int top = m.length-1;
		int middle;

		while(bottom<=top) {
			middle = (top+bottom)/2;
			if(m[middle]==n) return middle;
			else if(m[middle] > n) top=middle-1;
			else                             bottom = middle+1;
		}
		return -1;
	}

} // class
