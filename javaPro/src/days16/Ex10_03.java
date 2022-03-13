package days16;
/**
 * @author 이채영
 * @date 2022. 3. 11. - 오후 4:53:54
 * @subject  p.307 초기화 예제   
 * @content     + p.306 예제는 과제
 */
public class Ex10_03 {

	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document();
		Document d3 = new Document("자바문서.txt");
		Document d4 = new Document();

	}

}

class Document{
	static int count =0;
	String fileName;
	
	{
		count++;
	}
	
	public Document() {
		this("제목없음 -" + count);
		
	}
	public Document(String fileName) {
		this.fileName = fileName;
		System.out.printf("문서 \"$\"가 생성되었습니다.\n", this.fileName);
	}
}