package days13;

public class Ex08_02 {

	public static void main(String[] args) {
		// 1차원 배열-> 2차원 배열 전환

		int [] m = { 1,2,3,4,5,6,7,8,9,10,11,12		};
		
		int [][]n =  new int [6][2];
		
		int col = n[0].length;
		for (int i = 0; i < m.length; i++) {
			 n[i/col][i%col] = m[i];
		}
	
	
		dispM(n);
	}
	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("m[%d][%d]=%d\t",i,j,m[i][j]);
			}System.out.println();
		}
		
	}
}
