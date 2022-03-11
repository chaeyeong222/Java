package days15;
/**
 * @author 이채영
 * @date 2022. 3. 10. - 오후 2:04:30
 * @subject p.240 객체 배열 **
 * @content 수 많은 객체를 만들때 배열을 사용하면 편리하다 
 */
public class Ex05_02 {

	public static void main(String[] args) {
			/*
		Person p1 = null;
		p1.name="1번 사람";
		p1.run();

		*/
	
		 Person [ ] ps = new Person[5];

		for (int i = 0; i < ps.length; i++) {
			
			ps[i] = new Person(); //**인스턴스 생성** 이거 빠져서 오류났던 것
			ps[i].name =(i+1)+"번 사람"; //java.lang.NullPointerException
			ps[i].run();
		
		}


	}

}
