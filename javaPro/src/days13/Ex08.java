package days13;

public class Ex08 {

	public static void main(String[] args) {
		// 4행 3열 
		int [][] m = { 
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
							};
		//dispM(m);
		
		int [ ]n = new int [m.length * m[0].length];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				n[3*i+j] = m[i][j];  //그냥 int k=0; 선언하고 n[k++]해줘도 됨
			}System.out.println();
		}
		
		dispM(n);

	}

	private static void dispM(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.printf("n[%d]=%d\t",i,n[i]);
		}
		
	}

	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("m[%d][%d]=%d\t",i,j,m[i][j]);
			}System.out.println();
		}
		
	}

}
