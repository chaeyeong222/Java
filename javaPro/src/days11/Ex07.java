package days11;

import java.util.Random;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// 한 반에 30명의 학생 이름, 국영수 점수, 총점, 평균, 등수를 처리하는 코딩
		Scanner scan =  new Scanner (System.in);
		
		final int STUDENT_COUNT = 20; // final 사용할때
		
		String [] names = new String [ STUDENT_COUNT];
		int [] kors = new int [ STUDENT_COUNT];
		int [] engs = new int [ STUDENT_COUNT];
		int [] mats = new int [ STUDENT_COUNT];
		int [] tots = new int [ STUDENT_COUNT];
		double [] avgs = new double [ STUDENT_COUNT];
		int [] ranks = new int [ STUDENT_COUNT];

		//입력받은 학생의 수 + 각 배열에 채워넣을 위치 (ex. idx)
		int cnt = 0;
		char con = 'y';

		do {
			System.out.printf(">[%d]번학생 이름 국어 영어 수학 입력",cnt+1);
			String name = getRandomName();     //scan.next();
			int kor = getRandomScore();  //scan.nextInt
			int eng = getRandomScore();
			int mat = getRandomScore();
			int tot = kor + eng+mat;
			double avg = (double)tot/3;
			int rank =1;  //기본값1로 설정해놓기

		    names[cnt] = name;
		    kors[cnt] = kor;
		    engs[cnt] = eng;
		    mats[cnt] = mat;
		    tots[cnt] = tot;
		    avgs[cnt] = avg;
		    ranks[cnt] = rank;

		    cnt++; //입력받은 학생수는 1증가 + 각 배열에 채워넣을 위치 (idx)1 증가
			
			System.out.println("계속?");
			con = scan.next().charAt(0);
		}while( Character.toUpperCase(con)=='Y');

		System.out.println("입력받은 학생수: "+ cnt + "명");
		
		//등수를 처리하는 코딩 -> [과제]
		for(int j=0; j<STUDENT_COUNT; j++) {
		for(int i=0;i< STUDENT_COUNT; i++) {
			if(tots[j]<tots[i])  ranks[j]++;
		   }
		}
		
		
		
		//입력받은 학생에 대한 정보
		for(int i = 0; i<cnt; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
					names[i], kors[i],engs[i],mats[i],tots[i],avgs[i],ranks[i]);
		}



	}

	private static String getRandomName() {
		String name = null;
		//무작위로 대문자(65~90) 5문자 넣기->이름이라고 가정해서 사용할 것
		Random rnd = new Random();
		
		char [] names = new char[5];
		for (int i = 0; i < names.length; i++) {
		   names[i] = (char)(rnd.nextInt(26)+65);
		}
		//dyas10.Ex03
		//char[] -> String 변환 코딩
		//String-> char[] 변환코딩	
		
		name = new String(names);
		
		
		return name;
	}

	private static int getRandomScore() {
		Random rnd = new Random();
		return rnd.nextInt(101);
	}

}
