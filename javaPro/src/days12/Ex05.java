package days12;

import java.util.Arrays;

/**
 * @author 이채영
 * @date 2022. 3. 4. - 오전 10:22:46
 * @subject 배열의 단점               -> 컬렉션으로 대체
 * @content  1. 배열의 길이가 자동 증가/감소 X
 *                  2. 배열의 추가/수정/삭제 는 개발자가 직접 처리해야함. 
 */
public class Ex05 {

	public static void main(String[] args) {
		int [] m = {1,2,3,4,5};
		System.out.println(Arrays.toString(m));

		//1.새로운 요소를 추가
		int idx = 5;
		if(idx==m.length) {
			System.out.println("배열크기 부족");
			m = days11.Ex04_04.increaseArraySize(m, idx);
		}
		
		m[idx] = 100;
		System.out.println(Arrays.toString(m));
		idx++;
		
		/*[1, 2, 3, 4, 5, 100, 0, 0, 0, 0]
		 * m[3] 요소의 값을 제거
		 * [1, 2, 3, 5, 100, 0, 0, 0, 0, 0]
		 * 한 칸씩 당기고 남은 자리에 0 넣어야함
		 * 1. 제거할 위치보다 큰 인덱스의 배열값을 앞으로 한 칸씩 이동 (값이 들어있는 것들만)
		 * 2. 마지막 값(100)은 다시 초기화
		 * 3. idx 를 1 감소
		 
		for (int i = 3; i < 6; i++) {
			m[i]=m[i+1];
			m[m.length-1]=0;
		}System.out.println(Arrays.toString(m));
		*/
		for (int i = 4; i < idx; i++) {
			m[i-1]=m[i];
		}
		m[idx-1]=0;
		idx--;
		System.out.println(Arrays.toString(m));
		
	}//main

}//class
