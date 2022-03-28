package days27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 10:21:32
 * @subject 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		// 열거형 활용 예제
		ArrayList<Student> list = new ArrayList(30);

		list.add(new Student(1, "유환재", 90, 89, 78, 257, 85.66, 1) );
		list.add(new Student(2, "박재영", 80, 89, 78, 247, 82.66, 1));
		list.add(new Student(3, "도성한", 90, 99, 78, 267, 88.66, 1));

		//정렬  Comparator 인터페이스, comparable 인터페이스 차이점?
		//1.성적   StudentSortOptions.SCORE)
		//2.이름   StudentSortOptions.NAME)
		//3.학번   StudentSortOptions.NO)

		//에러 The constructor StudentComparator(StudentSortOptions) is undefined
		//생성자 선언 안됨
	//	list.sort(new StudentComparator(StudentSortOptions.NAME)); //학생이름으로 정렬될 것..
	//	list.sort(new StudentComparator(StudentSortOptions.SCORE)); //학생이름으로 정렬될 것..
		list.sort(new StudentComparator(StudentSortOptions.NO)); //학생이름으로 정렬될 것..
			
		System.out.println("모든학생정보출력");
		Iterator<Student> ir = list.iterator();
		while (ir.hasNext()) {
			Student s = ir.next();
			System.out.println(s);
		}

	}//main

}//class

enum StudentSortOptions {SCORE, NAME, NO};

class StudentComparator implements Comparator<Student>{

	private StudentSortOptions sortOption; //이 값을 compare에서 사용하기 위해서 선언
	public StudentComparator(StudentSortOptions sortOption) {
		this.sortOption = sortOption;
	}

	@Override
	public int compare(Student o1, Student o2) {
		switch (this.sortOption) {
		case NAME:		
			String name1 = o1.getName();
			String name2 = o2.getName();
			return name1.compareTo(name2);// 0 양수  음수
			//	return name1.compareTo(name2)*-1;// 0 양수  음수 -> -1 곱하면 역순 정렬
		case SCORE:	
			return Integer.compare(o1.getTot(), o2.getTot());
		case NO:	
			return Integer.compare(o1.getNo(), o2.getNo());
		default:
			return Integer.compare(o1.getNo(), o2.getNo()); //의미없는 값
		}


	}

}

class Student {

	private int no,kor,eng,mat,tot,rank;
	private String name;
	private double avg;

	public Student() {
		super();
	}
	//단축키로 생성자 만듦
	public Student(int no, String name,
			int kor, int eng, int mat,
			int tot,  double avg, int rank ) {
		super();
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.rank = rank;
		this.name = name;
		this.avg = avg;
	}
	//단축키로 get,set 만듦
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	//단축키로 toString 오버라이딩 만듦
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot=" + tot  + ", avg=" + avg + ", rank="
				+ rank + "]";
	}

}//class