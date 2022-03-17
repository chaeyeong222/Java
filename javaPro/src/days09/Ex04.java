package days09;

import java.util.Iterator;

/**
 * @author 이채영
 * @date 2022. 2. 25. - 오후 12:02:30
 * @subject  
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// [요구분석서]
		/*   로또 645
		 * 1. 온라인복권
		 * 2. 자동/수동/반자동
		 * 3. 1등 금액      판매량
		 * 4. 1등 x 2회 이월제한
		 * 5.  연중무휴
		 *      추첨일 오후8시부터 다음날 오전6시 제외
		 * 6. 만 19세 미만 청소년 
		 * 7. 45(1~45) -> 6개 뽑음. [+1] 임시번호
		 */
	
		//int n = (int) (Math.random()*45+1);
	   //System.out.println(n);
		
		//[중복체크]이전에 발생한 로또번호와 지금 발생한 것이 중복되는 지 체크,
		for(int i=1;i<=6;i++) {
			System.out.println((int) (Math.random()*45+1));
		}
	
	}//main
	
}//class
