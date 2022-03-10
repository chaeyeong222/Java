package days14;

public class Ex02_02 {

	public static void main(String[] args) {

		int [][] m = new int [5][5];

		//마방진 = 가로,세로,대각선의 합이 모두 같음
		fillMagicSquare(m);
		dispM(m);

	}

	private static void fillMagicSquare(int[][] m) {
		//짝수            [홀수]행 마방진 5*5
		//1. 첫번째 행의 가운데 열 : 1
		//2-1. 5의 배수 -> 행만 증가
		//2-2. 5의 배수가 아니면 -> 열 1 증가, 행 1 감소
		//   ㄱ. 행이 벗어나면 -> 가장 큰 행으로 가서 다음 숫자 넣음(열은 동일)
		//   ㄴ. 열이 벗어나면 -> 가장 작은 열로 가서 다음 숫자 넣음(행은 동일)
		
		int row=0, col=m.length/2;  //행, 열 저장할 변수
		int n =1;
		
		while(n<=m.length*m.length) {
			m[row][col] = n;
			
			if(n%m.length==0) row++;
			else {
				col++;
				row--;
				if(row<0) row=m.length-1;
				if(col>m.length-1) col=0;
			}
			n++;
		}
		

		
/*
 * m[0][2] = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				if(m[i][j]%5==0) m[i+1][j] = 5*i+j+1;
				else  {
					m[i++][j--]= 5*i+j+1;
					if(i>=m.length) m[4][j]=5*i+j+1;
					else if(j<0) m[i][0]=5*i+j+1;
				}
			}
		}

 */
		


	}

	public static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("[%02d]",m[i][j]);
			}System.out.println();
		}

	}

}
