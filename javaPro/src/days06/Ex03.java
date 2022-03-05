package days06;

/**
 * @author 이채영
 * @date 2022. 2. 22. - 오전 11:34:47
 * @subject 중첩 for문
 * @content  
 */
public class Ex03 {

	public static void main(String[] args) {
		// for 문의 반복 변수의 이름 간단하게 주기   ex. i, j, k ...
		
		for(int i =1; i<=3; i++) {
			System.out.println("i=" + i);
			
			System.out.print("\tj=");
			for(int j = 0; j<4; j++) {
				System.out.print(j + ",");
				
			}System.out.println();
		}

	}
	/*
	 * 결과값
	 * i=1
			j=0,1,2,3,
		i=2
			j=0,1,2,3,
		i=3
			j=0,1,2,3,
	 */
	

}
