
package days24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import days15.Student;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오후 2:24:14
 * @subject 
 * @content 
 *   +p.587 예제 11-2
 */
public class Ex07 {

	public static void main(String[] args) {
		// 배열 -> 컬렉션 클래스 추가/수정/삭제/크기 자동증가 등등 용이
		//30명 학생의 이,국영수총평등 처리코딩
		//한 반에 30명 학생의 이름, 국영수성적, 총점, 평균, 등수 처리하는 예제: days11.Ex07.java
		//1. Student 클래스 선언 - 속성, 기능 파악해서 목록 작성  
		//2. 객체배열 == 클래스 배열
		Scanner scan = new Scanner(System.in);
		final int STUDENT_COUNT = 30;
		//Student [] students = new Student[STUDENT_COUNT];
		ArrayList list = new ArrayList(STUDENT_COUNT);
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
			//int w_rank=1;
		
			Student s = new Student(no, name, kor, eng, mat, tot, rank,avg);
			list.add(s);
			
			cnt++; //입력받은 학생수는 1증가 + 각 배열에 채워넣을 위치 (idx)1 증가

			System.out.println("계속?");
			con = scan.next().charAt(0);	
		}while( Character.toUpperCase(con)=='Y');

		System.out.println("입력받은 학생수: "+ cnt + "명");
		//2. 등수처리 코딩
		
		for(int j=0; j<list.size(); j++) {
			Student a = (Student) list.get(j);//등수매길 학생
			for(int i=0;i< cnt; i++) {
				Student b = (Student) list.get(i); //다른 모든 학생
				if(a.tot <b.tot)  
					a.rank++;
			}
		}

		Iterator ir2 = list.iterator();
		while (ir2.hasNext()) {
			Student st = (Student) ir2.next();
			
		}
		//1. 학생정보 출력 코딩
		/*
		//반복자 사용해서 출력
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			Student s = (Student) ir.next();
			System.out.println(s);
		}*/
		
		//C14 람다
		//-> 람다연산자
		//람다식
		list.forEach( s-> System.out.println(s));
		
		System.out.println("====================");
		//1.복제
		ArrayList listClone = (ArrayList) list.clone();
		//2.복제한 arrayList를 성적순으로 오름차순 정렬
		//에러: java.lang.ClassCastException: days15.Student cannot be cast to java.lang.Comparable
		//정렬기준이 없음
		
		listClone.sort(new StudentRankComparator());
		
//		Collections.sort(listClone);
		//Collections.sort(listClone, new StudentRankComparator());
	/*
		Collections.sort(listClone,new Comparator() { //익명클래스 사용
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;
					//return s2.tot-s1.tot;  // 오름차순 0  양수   음수
					return s1.tot-s2.tot; //내림차순 정렬
				}
				return 0;
			}
		});
		*/
		//3.복제한 arrayList를 출력
		listClone.forEach( s-> System.out.println(s));
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

}//class

//학생의 정렬 기준 클래스 선언 Comparator인터페이스 구현 or  comparable인터페이스 구현
class StudentRankComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			//return s2.tot-s1.tot;  // 오름차순 0  양수   음수
			return s1.tot-s2.tot; //내림차순 정렬
		}
		return 0;
	}
	
}
