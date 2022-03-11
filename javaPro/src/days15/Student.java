package days15;

public class Student {
	
	//필드 - 학번, 성적, 이름, 주민등록번호, 주소 ..
	int no;
	String name;
	int kor, eng, mat, tot, rank;
	double avg;
	
	//디폴트 생성자
	public Student() {
		//super();
	}
	
	public Student(int no, String name, int kor, int eng, int mat, int tot, int rank, double avg) {
		//super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.rank = rank;
		this.avg = avg;
	}


	//메서드
	public void printInfo() {
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n"
				,no,name, kor, eng, mat, tot, avg, rank);
	}

	
	

}
