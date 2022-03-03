package days04;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 4:00:24
 * @subject  Scanner 연습 예제 
 * @content 
 */
public class Ex08_05 {

	public static void main(String[] args) {
		// String 이름, int 나이, boolean 성별, double 키
		
		String name;
		int age;
		boolean gender;
		double height;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 나이 성별 키 입력?");  //홍길동 20 true 175.87
				
		name = scan.next();
		age = scan.nextInt();
		gender = scan.nextBoolean();
		height = scan.nextDouble();
		
	
		System.out.printf("이름:%s, 나이:%d, 성별:%b, 키:%.2f\n", name, age, gender, height);
		
		scan.close();

	}

}
