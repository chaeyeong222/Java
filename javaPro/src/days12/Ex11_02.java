package days12;
/**
 * @author 이채영
 * @date 2022. 3. 4. - 오후 3:40:26
 * @subject  p.214 다차원배열 설명
 * @content 
 */
public class Ex11_02 {

	public static void main(String[] args) {
		//	int []m =new int [8];
		//	System.out.println(m.length); //8 :배열의 크기
		//	dispM(m); //1차원배열 출력

		//int [][] m =new int [4][2];
		//		System.out.println(m.length); //4  :배열 행의 크기
		//	System.out.println(m[0].length); //2  :배열 열의 크기
		//System.out.println(m[1].length); //2  :배열 열 크기
		//System.out.println(m[2].length); //2  :배열 열의 크기
		//dispM(m); //2차원배열 출력
		
		//3차원배열
		int [][][] m =new int [2][3][4];
		disp(m);
//		System.out.println(m.length);  //2  :배열 면의 크기
//		System.out.println(m[0].length);//3  :배열 행의 크기
//		System.out.println(m[0][0].length);//4  :배열 열의 크기

		//m[행][열]
		//m[0][0] ~ m[3][1]
	}

	private static void disp(int[][][] m) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				for (int k = 0; k < m[i][j].length; k++) {
					System.out.printf("m[%d][%d][%d]=%d\t",i,j,k, m[i][j][k]);
				}System.out.println();
			}System.out.println("\n");
		}
		
	}

	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) { //행
			for (int j = 0; j < m[i].length; j++) { //열
				System.out.printf("m[%d][%d]=%d\t",i,j, m[i][j]);
			}System.out.println();
		}
}

	private static void dispM(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("m[%d]=%d\t",i,m[i]);
		}

	}

}
