package days04;


/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 12:41:39
 * @subject  [복합대입연산자] 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// 어떤 기억공간의 값을 5만큼 증가, 감소시키는 코딩
		int x = 10;
		x = x+5;	
		System.out.println(x);
		x = x-5;
		System.out.println(x);

		
		/* 아래 두 식 동일.
		 *  x = x+5;
		 * x +=5 ;
		 * -----------
		 * x = x * 100;
		 * x *=100;
		 * 
		 */
	}

}
