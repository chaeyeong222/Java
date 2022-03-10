package days14;

public class Ex02 {

	public static void main(String[] args) {
		// 2차원 배열을 사용하는 예제
		
		int [][] m = new int [5][5];
	//	fillM01(m);		
	//	fillM02(m);		
	//	fillM03(m);		
	//	fillM04(m);		
		fillM05(m);		
		//	fillM04(m);		
		dispM(m);

	}

	private static void fillM05(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				
				m[i][j] = (5-i)+(5*j);
			}
		}
		
	}

	private static void fillM04(int[][] m) {
	/*	//방법1 값기준
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i%2==0) m[i][j] = 5*i+j+1;
				else            m[i][j] = 5*(i+1)-j;
				//m[i][j] = i%2==0? 5*i+j+1 : 5*(i+1)-j
			}
		}*/
		
		//방법2 칸기준
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i%2==0)  m[i][j] = 5*i+j+1;
				else            m[i][4-j] = 5*i+j+1;
				// m[i][j2==0? j : 4-j] =  5*i+j+1;
			}
		}
	}

	private static void fillM03(int[][] m) {
/*			//값기준
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = (5-i)+(5*j);
			}
		}*/
	//칸기준(왼쪽으로 90도 회전하는 코딩)
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m.length; j++) {
						m[4-j][i] = 5*i+j+1;
					}
				}
		
	}

	private static void fillM02(int[][] m) {
		//풀이4
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[4-i][4-j] = 5*i+j+1;
			}
		}
	/*
	 * 	// 풀이 3
	 
		for (int i = m.length-1; i>=0; i--) {
			for (int j =m[i].length; j++) {
				m[4-i][4-j] = 5*i+j+1;
			}
		}*/
	}

	private static void fillM01(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 5*i+j+1;
			}
		}
/*
 * int k=1;
 * for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++,k++) {
				m[i][j] = k;
			}
		}

 * 
 */
		
	}

	private static void dispM(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("[%02d]",m[i][j]);
			}System.out.println();
		}
		
	}

}
