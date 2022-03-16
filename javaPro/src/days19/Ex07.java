package days19;
/**
 * @author 이채영
 * @date 2022. 3. 16. - 오후 12:20:27
 * @subject p.414 Chapter 08 예외처리
 * @content 
 *           1.프로그램 오류? 프로그램 오작동 또는 비정상 종료된 원인
 *           2. 발생시점
 *              ㄱ. 컴파일 오류     int x = 10 
 *              ㄴ. 런타임(실행) 오류    int [] m = new int [3];
		                                     m[100]=3;
		                      자바에서 실행 오류를 2가지 구분
		                        1) 에러error
		                           -> 메모리부족, 스택오버플로워 에러, 복구할 수 없는 심각한 오류
		                           error 클래스
		                           자식클래스
		                        2) 예외 exception
		                           -> 수습될 수 있는 비교적 덜 심각한 실행오류
		                           Exception 클래스
		                           자식클래스
		       => ㄱ+ㄴ = 빌드오류
		         ㄷ. 논리적 오류    -> [ 에러 처리 가장 어려움]
		                int a = Integer.MAX_VALUE;
		                long b = a +100;
		                System.out.println(b);  //-2147483549(음수값 나옴)
		     3. 예외 클래스의 계층 구조(상속 관계 ) p.415 그림 8-1
		        Exception 클래스 2 그룹
		           ㄱ. RuntimeException + 그 하위 예외 클래스
		           ㄴ. Exception + 그 하위 클래스 (  ㄱ 제외)
		      4. 예외처리 ex.08.java
		           
		     
		     
		     
 */
public class Ex07 {

	public static void main(String[] args) {
		// 자바 + awt + 계산기 구현 -> 연습해보기


	}

}
