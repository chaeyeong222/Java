package days12;

import java.util.Arrays;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오전 11:17:18
 * @subject 
 * @content p. 202  예제 5-10 정렬sort : 자료를 일정한 기준에 따라 나열하는 것(ex. 키, 성적, 나이)
/*	                                                       작은->큰(어센딩 Ascending, 오름차순 정렬)
	                                                       큰->작은(디센딩 Descending  내림차순 정렬)
                                                              한글:  ㄱ ㄴ ㄷ ㄹ ㅁ ... ㅎ  오름차순
 *         [정렬방법] -> 정보처리기사 실기(알고리즘)
 *         1. 선택정렬, 	삽입정렬,  버블정렬, 병합정렬        - 퀵, 힙 정렬 등등..
 */
public class Ex08 {

	public static void main(String[] args) {
		/*
		 * 1. 버블정렬 BubbleSort - ASC오름차순 정렬 설명	
		 *       : 서로 이웃한 데이터들을 비교하며 가장 큰 데이터를 가장 뒤로 보내며 정렬하는 방식
		 * 2. 선택정렬 SelectionSort
		 *       : 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환해나가는 방식   	
		 */
		int [] m = {3,5,2,4,1};
		//		m= bubbleSort(m);
		m = selectionSort(m);

		System.out.println(Arrays.toString(m));
	}
	private static int[] selectionSort(int[] m) {

		int minIndex;
		for (int i = 0; i < m.length-1; i++) {
			minIndex =i;
			//가장 작은 값, 위치값
			for (int j = i+1; j < m.length; j++) {
				if(m[minIndex] >m[j]) minIndex = j;
			}//for j
			if(i != minIndex) {
				int temp = m[i];
	               m[i] = m[minIndex];
	               m[minIndex] = temp;
			}
		}// for i
		
		return m;
	}
	/*
	private static int[] selectionSort(int[] m) {
      //  0 1  2  3  4
      //  [1],                        5, 2, 4, 3    회전 자리바꿈 1번 

      // 앞값 > 뒤값  자리바꿈. 
      // 0-1 0-2 0-3 0-4                    [1] 0 0 0 0
      // 1-2  1-3 1-4                             [1][2] 0 0 0
      // 2-3 2-4
      // 3-4

      for (int i = 0; i < m.length-1; i++) {
         for (int j = i+1; j < m.length; j++) {
            System.out.printf("%d-%d\t",  i , j );   
            if( m[i] > m[j] ) {
               System.out.print(" ***  ");
               int temp = m[i];
               m[i] = m[j];
               m[j] = temp;
            }
            System.out.println( Arrays.toString(m) );
         }
         //System.out.println();
      }

      return m;
   }
	 */
	private static int[] bubbleSort(int[] m) {
		// 앞> 뒤 자리 바꿈
		// 0-1 1-2 2-3 3-4   1회전  0 0 0 0 [5]
		// 0-1 1-2 2-3         2회전  0 0 0 [4] [5]
		// 0-1 1-2               3회전  0 0 [3] [4] [5]
		// 0-1                     4회전  [1] [2]  [3] [4] [5]
		for (int i = 0; i < 4; i++) {
			System.out.println((i+1)+"회전");
			for (int j = 0; j < 4-i; j++) {


				System.out.printf("%d-%d자리비교", j, j+1);
				if(m[j]>m[j+1]) {
					System.out.println("***"); //자리바꿈 일어난 경우 체크.
					int temp = m[j];
					m[j] = m[j+1];
					m[j+1] = temp;
				}System.out.println(Arrays.toString(m));
			}
		}

		return m;
	}

}
