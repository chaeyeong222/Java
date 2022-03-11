package days15;

//수학 관련 속성, 기능을 구현한 클래스
public class MyMath {

	// 두 정수의 합을 반환하는 메서드
	
	public int sum(int...m) {  //가변 인자, int...m = int [] m을 의미함.
		int result = 0;
		for (int i = 0; i < m.length; i++) {
			result += m[i];
		}
		return result;
	}
	
	/*
	public int sum(int a, int b) {
		return a+b;
	}

	public int sum(int a, int b, int c) {
		return a+b+c;
	}

	public int sum ( int [] m) {
		int result = 0;
		for (int i = 0; i < m.length; i++) {
			result += m[i];
		}
		return result;
	}
	*/
}
