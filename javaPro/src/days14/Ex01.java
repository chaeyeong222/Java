package days14;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		//다차원 배열 예제
		//한 반 30명, 국영수총점평균 예제 문제 days11.Ex07
		//3반        ''            + 세반의 전교등수
		Scanner scan =  new Scanner (System.in);

		String [][] names = new String [3][30];

		//면=반, 행=학생수, 열=국/영/수/총점/등수/전교등수
		int [][][] infos = new int [3][30][6];
		//행 = 반, 열=평균
		double [][] avgs = new double [3][30];

		int cnt = 0; //입력받은 학생수 저장하는 변수
		char con ='y';
		// cnts[반-1] = 그 반 학생의 입력받은 학생수

		int [] cnts = new int [3]; 

		int ban;
		do{
			//1. 반 입력
			System.out.print("1. 반 입력?");  //1,2,3
			ban = scan.nextInt();  //입력값의 유효성 검사는 필수 -> 여기는 생략.			
			// 2. 그 반의 학생이름, 국영수
			System.out.printf(">%d반의 [%d]번 학생 이름 국어 영어 수학 입력",ban, cnts[ban-1]+1);
			String name = days11.Ex07.getRandomName();     //scan.next();
			int kor = days11.Ex07.getRandomScore();  //scan.nextInt
			int eng = days11.Ex07.getRandomScore();
			int mat = days11.Ex07.getRandomScore();

			// 3. 총점, 평균 계산 + 등,전등은 지금 처리 x
			int tot = kor + eng+mat;
			double avg = (double)tot/3;
			int rank =1;
			int w_rank=1;

			names [ban-1][cnts[ban-1]] = name;

			infos[ban-1][cnts[ban-1]][0] = kor;
			infos[ban-1][cnts[ban-1]][1]= eng;
			infos[ban-1][cnts[ban-1]][2] = mat;
			infos[ban-1][cnts[ban-1]][3] = tot;
			avgs[ban-1][cnts[ban-1]] = avg;
			infos[ban-1][cnts[ban-1]][4] = rank;
			infos[ban-1][cnts[ban-1]][5] = w_rank;
			// 4. 계속?

			cnts[ban-1]++;
			System.out.println("계속?");
			con = scan.next().charAt(0);
		}while( Character.toUpperCase(con)=='Y');

		for(int i=0; i<cnts.length; i++) {
			for(int j=0;i< cnts[i]; j++) {
				int 등수매길학생의총점 = infos[i][j][3];
				
				for (int i2 = 0; i2 < cnts.length; i2++) {
					for (int j2 = 0; j2 < cnts[i2]; j2++) {
						int 등수비교학생의총점 = infos[i2][j2][3];
						if(등수매길학생의총점>등수비교학생의총점) {
							infos[i][j][5]++;
							if(i==i2) infos[i][j][4]++;
						}
					}
				}
			   }
			}

		System.out.println("각 반 입력학생 수");
		for (int i = 0; i < cnts.length; i++) {
			System.out.printf("[%d]반 학생수 : %d명\n", (i+1), cnts[i]);
			for (int j = 0; j < cnts[i]; j++) {
				System.out.printf("%d_%d. %s\t%d\t%d\t%d\t%d\t%.2f\t%d\t%d\n"
						,i+1
						,j+1
						,names[i][j]
						,infos[i][j][0]
						,infos[i][j][1]
						,infos[i][j][2]
						,infos[i][j][3]
						,avgs[i][j]
						,infos[i][j][4]
						,infos[i][j][5]);
			}

		}


	}

}

/*
int [][] kors = new int [3][30];
int [][] engs = new int [3][30];
int [][] mats = new int [3][30];
int [][] tots = new int [3][30];
int [][] ranks = new int [3][30];
int [][] totalranks = new int [3][30];
 */
