package days14;

public class Ex02_03 {

	public static void main(String[] args) {
		int [][] m = new int [5][5];

		fillM(m);

		Ex02_02.dispM(m);

	}

	private static void fillM(int[][] m) {
		int row,col;
		int sum = 0;

		for (int i = 0; i < m.length-1; i++) {
			for (int j = 0; j < m[i].length-1; j++) {
				m[i][j] = 4*i+j+1;	
				
				m[i][4] += m [i][j];
				m[4][j] += m [i][j];
				m[4][4] += m [i][j];
			}	
		}
		


	}

}
