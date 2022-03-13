package days16;

public class Ex10_02 {

	
		static {
			System.out.println("static{}");
		}

		{
			System.out.println("{ }");
		}
		
		Ex10_02(){
			System.out.println("디폴트 생성자.");
		}
		public static void main(String[] args) {
			System.out.println("1........");
			Ex10_02 obj = new Ex10_02();
			
			System.out.println("2........");
			Ex10_02 obj2 = new Ex10_02();
			
			
		
	}

}
