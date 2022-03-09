package days13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/* 정렬
		 * [검색(Search) == 탐색]
		 * 같은 성질을 갖는 [항목의 집합] 중에서 필요한 특성을 갖는 [항목]을 찾아내는 것
		 * 1. 순차검색(Sequence Search)      평균               n/2횟수
		 * 2. 이진검색(Binary Search)
		 *  
		 */
		int [] m = new int [30];

		Random rnd = new Random();
		for(int i=0; i<m.length; i++) {
			m[i] = rnd.nextInt(20)+1;
		}
		System.out.println(Arrays.toString(m));

		int n; // 검색할 정수
		System.out.println("검색할 정수 입력");
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();

		//순차검색을 하는 메서드
		// 기능
		//매개변수
		//리턴값

		int idx = sequenceSearch(m,n);
		if(idx == -1) {
			System.out.println("찾는 정수가 없습니다.");
		}else {
			System.out.printf("%d위치에서 찾았다,\n",idx);
		}
		System.out.println(idx);

	}

	//기능 : 배열(항목의 집합)에서 정수(특정항목)을 찾아서 위치값을 반환하는 메서드
	//매개변수 : 항목의 집합 int[]       특정항목 int n
	// 리턴값 :특정항목이 없으면 -1을 반환하고 있으면 그 배열의 idx 갑값을 반환.
	
	private static int sequenceSearch(int[] m, int n) {
		int idx = -1; //검색한 숫자가 없는 경우를 대비

		for(int i=0;i<m.length;i++) {
			if(m[i]==n) {
				idx=i;
				break;
			}
		}
		return idx;
	}

}
