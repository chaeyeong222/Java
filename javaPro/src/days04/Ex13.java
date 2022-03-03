package days04;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 5:26:56
 * @subject p.135 조건문과 반복문
 * @content   if, switch, for , while 문
 *          [if 문] 조건문
			조건에 따라 실행 여부 결정
			if 조건문 형식
			if (조건식(참/거짓)) {
					} {블럭은 조건식이 참일때만 실행됨}
 */
public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("값 입력");
		int n = scan.nextInt();
		
		if(n%2 == 0 ) {
			System.out.println(" A ");
		}
		System.out.println(" D ");
		
		scan.close();
	}

}
