package days04;
/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 2:22:32
 * @subject [인덱스operator 연산자]
 * @content 
 * String[] args
 * -> 배열? 동일한 자료형을 메모리상에 연속적으로 놓이게 하는 것
 *       선언형식)  
 *        자료형 [] 변수명  = new 자료형 [갯수];
 *        int [] kors = new int [50];
 *                             heap(힙) 동적메모리 영역 int * 50
 */
public class Ex07 {

	public static void main(String[] args) {
		
		int [] kors = new int [3];
		
		kors[0] = 90;
		kors[1] = 80;
		kors[2] = 60;
		
		System.out.println(kors[0]);
		System.out.println(kors[1]);
		System.out.println(kors[2]);
		
		

	}

}
