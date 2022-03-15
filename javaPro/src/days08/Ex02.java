package days08;

/**
 * @author 이채영
 * @date 2022. 2. 24. - 오전 11:43:03
 * @subject  메서드(함수) 설명 p.246-277
 * @content 
 * 1. 메서드 정의? 프로그래밍에서 [반복되는 명령어]들을 찾아서 별도로 묶어
 *						 필요시에 불러서 사용할 수 있도록 한것  
 * 2. 프로그램의 구조화(간단해짐)
 * 3. 반복되는 코딩 -> 구조화(재사용 코딩)
 * 4. 함수가 기본이 되는 프로그래밍 방식을 구조적 프로그래밍 언어 C언어
 * 5. 객체가 기본이 되는 프로그래밍 방식을 객체지향적 프로그래밍 언어 : Java, 요즘 대부분 언어
 * 6. 메서드(함수) 선언 형식
 *   [접근지정자] [기타제어자] 리턴자료형 함수명 ([매개변수...]) { 메서드 선언부(프로토타입)
 *     //코딩            =구현부
 *     //코딩
 *     [return 리턴값;]
 *     [return;]
 *     7. 메서드 3가지 이해 :라인 긋기하는 기능 drawLine
 *     ㄱ. 기능 메서드 명 작명
 *     ㄴ. 매개변수
 *     ㄷ. 리턴값+리턴자료형
 *     8. 반복적인 코딩 -> 라인긋기 ->메서드를 선언해서 사용해야겠다
 *     9.메서드 사용 장점
 *        ㄱ. 코드량 줄어든다 -> 컴파일 용량 줄어듦 -> 실행성능향상
 *        ㄴ. 코드 가독성좋아지고, 유지보수 용이
 *        ㄷ. 팀작업-> 개발 생산성 향상
 *     10. 메서드 구현
 *        ㄱ. 윤년체크 반복 발생- 윤년체크 메서드 선언 후 재사용
 *        ㄴ. 기능 :윤년체크하는 메서드   checkLeapYear
 *            매개 변수                  :  체크할 년도       int year
 *            리턴값+리턴자료형        :
 *               int    return -1; return 1;
 *               void  syso"평년" syso"윤년"
 *               String return "평년"    return "윤년"        //   if.equals("윤년")
 *               
 *               boolean 윤년 true  평년 false   if (메서드명()) { }
 *       11. 메서드명(함수명)은 똑같고, 매개변수 개수, 타입이 다른 또다른 함수를 중복해서 선언할 수 있다.
 *          -> 중복함수 (오버로딩)overloading
 *           왜 똑같은 메서드명으로 여러개 중복 선언할까?
 *           .
 *           오버로딩과 오버라이딩 설명?
 *          
 *               
 */
public class Ex02 {

	public static void main(String[] args) {
		
		drawLine();   //매개변수 없이 이름만 가지고 메서드 호출  call by name
		System.out.println("부서원: 사원명");
		drawLine(30);  //call by value
		System.out.println("영업부:  홍");
		System.out.println("총무부:  길 ");
		System.out.println("생산부:  동 ");
		System.out.println("영업부:  아 ");
        drawLine(20, '^'); //call by value
        //The method drawLine(int, char) in the type Ex02 is not applicable for the arguments (int, String)
			//메서드 호출
		}//main
	
		public static void drawLine(){
			
			System.out.println("------------");
			
		};
		//Duplicate method drawLine() in type Ex02
		//동일한 메서드 명으로 중복 선언 가능하다며?  +조건있음
		//메서드명은 같지만, 매개변수의 개수와 타입이 달라야 함.
	
		//원하는 길이의 선을 그리는 중복함수
	public static void drawLine(int n){
			for(int i=0; i<n; i++) {
				System.out.print("-");
			}
			System.out.println();
      };
      
      //원하는 모양으로 원하는 길이만큼 선을그리는 중복함수
      public static void drawLine(int n, char style){
			for(int i=0; i<n; i++) {
				System.out.print(style);
			}
			System.out.println();
      }
	 /*부서원 정보 출력  ㅂ + 한자
		System.out.println("┌────────┐");
		System.out.println("│부서원│사원명│");
		System.out.println(" ├──────│──────┤");		
		System.out.println("│부서명│   홍 │");
		System.out.println("│부서명│   길 │");
		System.out.println("│부서명│   동 │");
		System.out.println("│부서명│   아 │");
		System.out.println("└──┴──┘");	
		*/
		
		

		
	
}//class
