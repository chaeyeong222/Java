package days05;

/**
 * @author 이채영
 * @date 2022. 2. 21. - 오후 2:41:27
 * @subject  while 조건 + 반복문 
 * @content 
 * 
			 * for        반복횟수       
			 * while    반복조건
 */
public class Ex07 {

	public static void main(String[] args) {
		/*
		 * if(condition) {  } 조건이 참이면 {}블럭처리
		 * while(condition) {} 조건이 참일동안 반복해서  {}블럭처리
		 * 
		 
		 //헬로월드 10번 출력 while 문
		int i =1;
		while(i <=10) {
			System.out.println("헬로우월드");
			i++;
		}*/
		
		//1-10 합 while 사용해서 출력
	
		int i = 1, sum =0;
		while(i<=10) {
			sum +=i;
			System.out.println("i" );
			i++;
			
		}
		System.out.println("="+sum);
	}

}
