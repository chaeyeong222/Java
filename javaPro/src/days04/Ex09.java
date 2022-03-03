package days04;
/**
 * @author 이채영
 * @date 2022. 2. 18. - 오후 4:09:25
 * @subject 
 * @content p.118. 효율적인 연산 short circuit evaluation
 */
public class Ex09 {
	public static void main(String[] args) {
		//앞에것만 참 거짓 확인하고 결과값나온다면 다음 것 의미 없음. 결과값 출력.
		
		int a =1, b=2, c=3, d=4;
		System.out.println(a>b && c>d);
		
		System.out.println(a>b || c>d);
		
		
	}
}
