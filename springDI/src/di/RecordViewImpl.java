package di;

import java.util.Scanner;


//RecordViewImpl 객체는 RecordImpl객체에 의존한다(의존관계)
//Engine + Car 클래스 
public class RecordViewImpl implements RecordView{

	private RecordImpl record = null;
	//private RecordImpl record = new RecordImpl();//결합력이 높은 코딩이라서 좋지 않음

	public RecordViewImpl() {
		this.record = record;
	}

	//[의존성주입 -생성자DI 방식]
	public RecordViewImpl(RecordImpl record) {
		super();
		this.record = record;
	}

	//[프로퍼티 setter 설정 방식]
	public void setRecord(RecordImpl record) {
		this.record = record;
	}

	@Override
	public void input() {
		try (Scanner scanner = new Scanner(System.in)){
			record = new RecordImpl();

			System.out.println("> kor, eng, mat input ? ");

			int kor = scanner.nextInt(); // kor
			int eng = scanner.nextInt(); // eng
			int mat = scanner.nextInt(); // mat

			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // input()

	@Override
	public void output() {

		System.out.printf("> kor:%d, eng:%d, mat:%d, total:%d, avg:%.2f"
				, this.record.getKor()
				, this.record.getEng()
				, this.record.getMat()
				, this.record.total()
				, this.record.avg());
	}
} // class