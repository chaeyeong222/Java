package days05;


/**
 * @author 이채영
 * @date 2022. 2. 21. - 오후 3:31:16
 * @subject 
 * @content   if
 *  switch
 *  for/ for each
 *  while/ do-while
 *  break
 *  continue
 */
public class Ex10 {

	public static void main(String[] args) {
		/* continue 문
		 * 1~10까지의 합을 출력하는 코딩
		 * 홀수의 합
		*/
		int sum = 0;
		for(int i = 1; i<=10; i++) {
			if(i%2!=0) {
			sum +=i;
			System.out.print(i + "+");
			}	
		}
		System.out.println("=" + sum);

	}

}
