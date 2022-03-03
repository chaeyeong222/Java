package days04;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 4:46:54
 * @subject  연산자 마지막 예제
 * @content p.136두 문자열을 비교할때는 equals()메서드는 사용한다.
 */
public class Ex12 {

	public static void main(String[] args) {
		// 스캐너 사용해서 이름 똑같이 입력받아 name2에 저장 
		//name1, name2 같은지 확인.
		
		String name1 = "홍길동";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름입력");
		String name2 = scan.next();
		
		//System.out.println(name1 == name2); //같게나옴? false    왜?
		/*문자열의 같다, 아니다를 확인할 경우
		equals()라는 메서드사용한다.
		*/
		
		System.out.println(name1.equals(name2)); //같게나옴? false    왜?
		
		
		
		
		
		
		
		
		scan.close();
		

	}

}
