package days17;

public class Ex01 {

	public static void main(String[] args) {
		
		/*
		 * new Document();
		 
		new Document();
		new Document("자바");   //자바문서 -3
		new Document("C");     //C문서 -4
		new Document();
*/
		System.out.println(Document.count);
		
		
		//Math.모든 메서드가 static 메서드// 이유? 자주사용하기 때문에 객체 생성할 필요 없이!
		System.out.println("END");
		
		}

}

	
	class Document{
		{
	count++;
}
			
			public  static int count;
			
			static {
				count=1;
				System.out.println(">s{ }" + count);
			}
			
			public Document() {
			//	count++; ->인스턴스로 선언해줘서 중복 제거
				System.out.println("문서 : "+count);
			}
			public Document(String title) {
			//	count++;
				System.out.println(title+"문서 : "+count);
			}
		}
		
		
		
