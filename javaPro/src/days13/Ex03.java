package days13;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] m;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("배열 크기 입력");
		
		int arrayLength = scan.nextInt();
		
		m = new int [arrayLength];
		System.out.println();
		
		System.out.println(Arrays.toString(m));
	}

}
