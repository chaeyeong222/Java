package days08;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오전 9:07:37
 * @subject 로또의 최고순위와~ 
 * @content 
 */
public class Ex01 {

	//main 함수의 기능. 
	public static void main(String[] args) {
		//  등급 - 수우미양가
		//유효성 검사를 해서 입력이 잘못되면 제대로 될때까지 반복해서 입력받기
		
		char grade; 
		String sGrade = null;  //""
		Scanner scan = new Scanner(System.in);
		//String regex = "정규표현식";
		String regex = "[수우미양가]"; //대괄호의 의미-> 안에 있는 것 중 하나만 나오면 돼
		//[A-Z] [a-z] [0-9] [A-Za-z0-9]:알,대소수,   [A-Za-z0-9가-힣]
		
		int check = 0;
		
		do {
			
			if(check >=1) System.out.printf("입력 %d/번 실수 : 입력이 잘못되었습니다. \n", check);
			
			if(check ==5) {
				System.out.println("\n 프로그램종료");
				//break: 제어문을 빠져나가라
				//main 메서드를 빠져나가라 ==프로그램 시작(종료)
				//(방법1)return; //void 니까 리턴값없음, return 만 쓰면 됨.
				System.exit(-1);  //어디에 있던 빠져나가는 메서드, 정수 -1 숫자는무관 
			}
			System.out.println("등급 입력(수,우,미,양,가)");
			//.matches() 사용하려면 입력값을 String으로 받아야함
					sGrade= scan.next();
			
					check++;
			}while(!sGrade.matches(regex)); 
		
		//[제대로 입력된 경우에만 실행되어야 함] ->break는 단순히 제어문만 빠져나가는 것. 프로그램 종료 : 
		
		grade = sGrade.charAt(0);
		
		System.out.println("등급: " + grade);
		
		
		
		
		
		scan.close();
		
	}

}
