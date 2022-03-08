package days12;
/**
 * @author 이채영
 * @date 2022. 3. 4. - 오후 3:27:26
 * @subject  p.214 다차원배열
 * @content p.208 char [] ->String, String[] ->char
 */
public class Ex11 {

	public static void main(String[] args) {
		/*
		 * 다차원배열? 2차원 이상의 배열을 다차원 배열이라고 한다
		 *               2차원배열, 3차원배열, 4차원배열...
		 *   지금까지 사용하던 배열은 1차원배열이다
		 *   
		 *   1차원배열 "열"
		 *   2차원배열 "행","열"
		 *   3차원배열 "면", "행","열"
		 *   4차원배열 "권","면","행","열"   
		 *
		 */
		//4행 2열  2차원배열
		int [][] m = new int [4][2];

		//2면 4행 2열  3차원배열
		int [][][] n = new int [2][4][2];
		
		//2권 3면 4행 2열  4차원배열
		int [][][][] k = new int [2][3][4][2];


	}

}
