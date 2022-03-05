package days06;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[foreach문 설명]
		/*선언형식
		 * for(자료형 변수명 : 배열 또는 컬렉션){
		 * }
		 */
		
		/*
		//1. 배열선언
		int [] kors = new int [5];
		kors[0] = 90;    //2. 배열 초기화
		kors[1] = 89;
		kors[2] = 78;
		kors[3] = 56;
		kors[4] = 88;
		*/
		//배열선언과 초기화 합쳐서 하는 법 -> 배열 초기화
		
		int [] kors = new int [] {90,89,78,56,88};
		
		//배열의 크기 = 배열명.length
		System.out.println(kors.length);
		//배열의 마지막 요소값     각 배열이ㅡ 요소를 초기화 하지 않았는데도 에러안남.
		System.out.println(kors [kors.length -1]);

		//배열출력
		System.out.println("for문---------------------------");
		
		for(int i=0; i<kors.length; i++) {
			System.out.printf("kors[%d]=%d\n",i , kors[i]);
		}
		System.out.println("foreach문---------------------------");
		
		//iterate 배열의 요소를 반복해서 처리하는 문 : foreach 문
		for(int kor: kors ) {
			System.out.println(kor);
		}
	}

}
