package days24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오전 11:17:48
 * @subject  [ArrayList컬렉션 클래스]
 * @content  1. 가장많이 사용되는 컬렉션 클래스
 *                  2. List 인터페이스를 구현한 클래스
 *                  3. 특징 : 순서유지O, 중복허용O
 */
public class Ex05 {

	public static void main(String[] args) {
		int [] m = new int [3];
		//배열array의 단점
		//1. 배열크기 자동 증가X
		// 2. 배열 삽입insert
		//     [1][4][2][3] 배열크기 증가+ 쉬프트작업+

		//<E:Element> 지네릭스generic, 제네릭
		ArrayList list = new ArrayList(3); //초기용량10개

		//요소Element 추가
		list.add(100);  //int -> Integer 오토박싱-> Object
		list.add(200);  //int -> Integer 오토박싱-> Object
		list.add(300);  //int -> Integer 오토박싱-> Object

		list.add(400);  //자동크기증가

		//System.out.println(list.size()); //저장된 객체의 개수 반환

		//요소출력
		/*
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		 */


		//1번째 위치에 500 값을 삽입
		list.add(1, 500);
		//dispList(list);

		// 500 값을 삭제(제거)
		//수정, 삭제하려면 먼저 존재우뮤를 확인해야함. -> 검색 먼저
		//System.out.println(list.contains(500)? "있다":"없다");
		//boolean 형으로 돌려줌 :  contains()
		//위치값을 알려면? 
		//System.out.println(list.indexOf(500)); //찾으면 위치값, 못찾으면 -1
		//1번째에 있다고 알려줌. 
		int findIndex= list.indexOf(500);
		if(findIndex==-1) {
			System.out.println("찾는 값 없음");
			return; //프로그램 종료
		}else {//있다. 제거작업
		//	list.remove(findIndex);
			//list.remove(500); //위치값으로 인식해서 오류남
			list.remove(new Integer(500)); //이렇게 해야함
		}
		//모든 요소 삭제
		//list.clear();
		
		//문제 : 300 찾아서 있으면 3으로 수정, 없으면 300 추가
		findIndex = list.indexOf(300);
		if(findIndex != -1) {
		/*	list.remove(findIndex);
			list.add(findIndex, 300);*/
			list.set(findIndex, 3);			
		}else {
			System.out.println("찾는 객체 없음");
			list.add(300);
		}
		
		//dispList(list);
		//System.out.println(list.toString()); //[100, 200, 3, 400] ->Arrays.toString(m);
		
		//문제: list에서 200보다 같거나 큰 요소는 삭제
		//ch14. 람다와스트림
		list.removeIf((t)-> Integer.parseInt(t.toString())>=200 );
		
	/*
	 	list.removeIf(
	
				//익명클래스        new 인터페이스(){}    new 부모클래스(){}
				//T:Type
				new Predicate() {

					@Override
					public boolean test(Object t) {
						return Integer.parseInt(t.toString())>=200;
					}
		});
		System.out.println(list.toString());
		 */
		
		//에러: java.lang.IndexOutOfBoundsException: Index: 3, Size: 2
		/*
		int listSize = list.size();
	//	for (int i = 0; i < listSize; i++) { -> 오류남
			for (int i = listSize-1; i >=0 ; i--) {
			//Object -> [오토언박싱] -> Int
			if((Integer)list.get(i)>=200) {
				//제거
				list.remove(i);
			}
		}System.out.println(list.toString());
*/ /*
		for (int i = 0; i <list.size() ; i++) { //사이즈도 알아서 줄어듦.
			if((int)list.get(i)>=200) {
				list.remove(i);
				i--;
			}
		}
*/System.out.println(list.toString());
	}//main

	private static void dispList(ArrayList list) {
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			System.out.println(list.get(i));
		}
	}

}//class
