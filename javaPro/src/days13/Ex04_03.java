package days13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex04_03 {

	public static void main(String[] args) {
		// [문제]  찾을 정수  n의  모든 위치값(인덱스값)을 출력하는 코딩을 하세요.
		int [] m =  new int[30]; 
		Random rnd = new Random();
		for (int i = 0; i < m.length; i++) {
			m[i] = rnd.nextInt(20)+1;
		}       
		System.out.println(  Arrays.toString(m) );

		int n; // 검색할 정수
		System.out.print("> 검색할 정수 입력 ? ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();  // 1

		int startIndex = 0 , idx ;
		while (   (idx = sequenceSearch(   m ,   n  , startIndex  )) !=  -1 ) { 
			System.out.printf("%d 위치에서 찾았다.\n", idx);
			startIndex = idx + 1;
		}

		/*
	      int idx = sequenceSearch(   m ,   n  , startIndex  );      
	      if (  idx == -1 ) {
	         System.out.println("찾는 정수는 없습니다. ");
	      } else {
	         System.out.printf("%d 위치에서 찾았다.\n", idx);
	      } 

	      startIndex = idx + 1;
	      idx = sequenceSearch(   m ,   n  , startIndex  );      
	      if (  idx == -1 ) {
	         System.out.println("찾는 정수는 없습니다. ");
	      } else {
	         System.out.printf("%d 위치에서 찾았다.\n", idx);
	      } 

	      startIndex = idx + 1;
	      idx = sequenceSearch(   m ,   n  , startIndex  );      
	      if (  idx == -1 ) {
	         System.out.println("찾는 정수는 없습니다. ");
	      } else {
	         System.out.printf("%d 위치에서 찾았다.\n", idx);
	      } 
		 */
	} // main


	// 리턴자료형  
	// 찾지 못한 경우는 -1  값을 반환
	private static int sequenceSearch(int[] m, int n, int startIndex) { 
		int idx=-1;      
		for (int i = startIndex; i < m.length; i++) {         
			if( m[i] == n ) {
				idx = i;
				break;
			} // if         
		} // for i      
		return idx;
	}

	private static int sequenceSearch(int[] m, int n) { 
		int idx=-1;      
		for (int i = 0; i < m.length; i++) {         
			if( m[i] == n ) {
				idx = i;
				break;
			} // if         
		} // for i      
		return idx;
	}

} // class
