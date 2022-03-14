package days07;
/**
 * @author 이채영
 * @date 2022. 2. 23. - 오전 9:03:04
 * @subject chapter4. 제어문(조건문과 반복문)
 * @content  제어문 활용 -> 구구단 출력
 */
public class Ex01 {

	public static void main(String[] args) {
		// 2~5단 하고, 5~9단 출력하기 
	
		 for(int dan = 1; dan <=9; dan++) {
			for(int i = 2; i<=5; i++) {
				System.out.printf("%d*%d=%d\t", i, dan, dan*i);
			}System.out.println();
		}
		System.out.println();
		
		for(int dan = 1; dan <=9; dan++) {
			for(int i = 6; i<=9; i++) {
				System.out.printf("%d*%d=%d\t", i, dan, dan*i);
			}System.out.println();
    }
		System.out.println("-----------------------------------");
		
		for(int k = 1; k <=2; k++) {
			 for(int dan = 1; dan <=9; dan++) {
				 if(k==1)
					for(int i = 2; i<=5; i++) {
						System.out.printf("%d*%d=%d\t", i, dan, dan*i);
					}System.out.println();
				 
				 if(k==2)
					 for(int i = 6; i<=9; i++) {
							System.out.printf("%d*%d=%d\t", i, dan, dan*i);
						}
				}
				System.out.println();
		}
		
		
		
		
	}

}
