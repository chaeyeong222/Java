package days26;
/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 3:28:41
 * @subject C12 제네릭스, 열거형, 애너테이션
 * @content 
 * /*
		 * 1. C12 제네릭스, 열거형, 애너테이션
		 * 
		 *   p.670 제네릭스란?
		 *     1. JDK 1.5~ 기능
		 *     2. 다양한 타입의 객체들을 다루는 메서드
		 *                                           컬렉션 클래스에
		 *         [컴파일 시]에 타입체크해주는 기능(기술)
		 *     3. 왜? (장점) : 
		 *         ㄱ. 객체타입의 안정성을 높이기 위해
		 *         ㄴ. 형변환의 번거로움을 줄이기위해 -> 코드 간결
		 *         
		 
		//처음부터 Object로 선언하면 모든 타입 다 담을 수 있음
		// -> 템플릿 클래스 but 사용할때마다 형변환해야함..
 */
public class Ex09 {

	public static void main(String[] args) {
		
		
		/*
		Box box1 = new Box(100);
		int value = box1.getValue();
		System.out.println(value);
*/
		/*
		Box box1 = new Box(3.14);
		double value = box1.getValue();
		System.out.println(value);
		*/
		/*
		Box box1 = new Box(true);
		boolean value = box1.getValue();
		System.out.println(value);
	*/
		/*
		Box<Integer> box1 = new Box(100);
		int value = box1.getValue();
		System.out.println(value);
		
		Box<Member> box2 = new Box<>(new Member("홍길동",90));
		Member m = box2.getValue();
		System.out.println(m);
		
		Box<String>box3Box = new
		
		*/
}//main
}//class

//제네릭클래스
class Box<T> { //타입 ==자료형
	//필드
	private T value;

	//생성자
	private Box(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}


/*
class Box{
	//필드
	boolean value;

	//생성자
	private Box(boolean value) {
		super();
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
*/
/*
class Box{
	//필드
	double value;

	//생성자
	private Box(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
*/
/*
class Box{
	//필드
	int value;

	//생성자
	private Box(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
*/