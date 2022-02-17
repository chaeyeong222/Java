package days02;

/**
 * @author 이채영
 * @date 2022. 2. 16. - 오전 11:26:37
 * @subject 
 * @content 
 */
public class Ex04_02 {
	public static void main(String[] args) {
		/*Alt + Shift + A
		
		System.out.print("a");
		System.out.print("b");
		System.out.print("c");
	}
		/*
		
		String name;
		int age;
		
		name="홍길동";
		age=20;

		System.out.println(" 이름은 \""+ name + "\"이고, 나이는 " + age + "살 입니다");
		*/
	

		//printf에서 문자열 출력 서식 : %s
		//               정수 출력 서식: %d
		//                문자 출력 서식: %c
		String name;
		int age;
		name = "홍길동";
		age = 30;
		char grade = 'A';
		System.out.printf("이름은 \"%s\"이고, 나이는 '%d'이고,  학점은 '%c' 입니다.", name, age, grade);
	}	
}
