package springDI;

import di.RecordImpl;
import di.RecordViewImpl;

public class Ex01 {

	public static void main(String[] args) {

		/*
		 Record 인터페이스 - 추상메서드  총,평
		 RecordImpl 클래스 - 추상메서드 총,평(오버라이딩) + 국영수필드추가
		 RecordView 인터페이스 - 추상메서드 성적정보를 입, 출력
		 RecordViewImpl 클래스
		 * 
		 * */

		//한 학생의 성적정보(,국영수)를 입력받고, 출력하는 코딩
		RecordImpl record = new RecordImpl();
		//생성자를 통해서 di 방식
		//RecordViewImpl rvi = new RecordViewImpl(record);
		
		RecordViewImpl rvi = new RecordViewImpl();
		rvi.setRecord(record);
		
		rvi.input();//학생정보 입력
		rvi.output();//학생정보 출력
		
		System.out.println("END");
		
	}
	
}
