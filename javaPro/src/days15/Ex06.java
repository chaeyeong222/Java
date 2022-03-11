package days15;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 2:23:50
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		//한 반에 30명 학생의 이름, 국영수성적, 총점, 평균, 등수 처리하는 예제: days11.Ex07.java
		//1. Student 클래스 선언 - 속성, 기능 파악해서 목록 작성  
		//2. 객체배열 == 클래스 배열
		Scanner scan = new Scanner(System.in);
		final int STUDENT_COUNT = 30;
		Student [] students = new Student[STUDENT_COUNT];
		int cnt=0;
		char con = 'y';
		
		do {
			int no = cnt+1;
			System.out.printf(">[%d]번학생 이름 국어 영어 수학 입력",no);
			
			String name = getRandomName();     //scan.next();
			int kor = getRandomScore();  //scan.nextInt
			int eng = getRandomScore();
			int mat = getRandomScore();
			int tot = kor + eng+mat;
			double avg = (double)tot/3;
			int rank =1;  //기본값1로 설정해놓기

			students[cnt] = new Student();//**안넣으면 NullPointError 발생함
			students[cnt].no = no;
			students[cnt].name = name;
		    students[cnt].kor = kor;
		    students[cnt].eng = eng;
		    students[cnt].mat = mat;
		    students[cnt].tot = tot;
		    students[cnt].avg = avg;
		    students[cnt].rank = rank;

		    cnt++; //입력받은 학생수는 1증가 + 각 배열에 채워넣을 위치 (idx)1 증가
			
			System.out.println("계속?");
			con = scan.next().charAt(0);	
		}while( Character.toUpperCase(con)=='Y');
		
		System.out.println("입력받은 학생수: "+ cnt + "명");
		//2. 성적처리 코딩
		for(int j=0; j<cnt; j++) {
			for(int i=0;i< cnt; i++) {
				if(students[i].tot<students[j].tot)  
					        students[i].rank++;
			   }
			}
		
		//1. 학생정보 출력 코딩
		
		for (int i = 0; i < cnt; i++) {
			students[i].printInfo();
		}

	}//main
	public static String getRandomName() {
		String name = null;
		Random rnd = new Random();
		
		char [] names = new char[5];
		for (int i = 0; i < names.length; i++) {
		   names[i] = (char)(rnd.nextInt(26)+65);
		}
		
		name = new String(names);
		
		
		return name;
	}//getRandomName

	public static int getRandomScore() {
		Random rnd = new Random();
		return rnd.nextInt(101);
	}//getRandomScore()

}
