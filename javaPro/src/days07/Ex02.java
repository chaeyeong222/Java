package days07;

/**
 * @author 이채영
 * @date 2022. 2. 23. - 오전 10:30:20
 * @subject p. 178 이름 붙은 반복문
 * @content LG 공채문제 3개중 한 문제
 */
public class Ex02 {

	public static void main(String[] args) {
		//break -> 제어문을 빠져나오는 문
		//코딩의 이름을 OUT로 붙임.
		OUT:	for(int j= 1; j<=3; j++) {
			for(int i =1; i<=10; i++) {
			System.out.println(i);
			if(i==5) break OUT;         //1부터 5까지 1번 반복
		 }
	   }
		
		

		System.out.println("end");
	}

}
