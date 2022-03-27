package days25;

import java.util.HashSet;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 12:46:27
 * @subject 
 * @content 
 * List -ArrayList, Vector, LinkedList, Stack, Queue, Deque, PrioritQueue,
 *         iterator, enumeration, listIterator,
 *          Comparable, comparator
 * set->HashSet p. 631
 *               1. set인터페이스 중에서 가장 많이 쓰는(대표적인) 컬렉션 클래스이다
 *               2. 특징: 중복 허용x,순서 유지x 
 */
public class Ex10 {

	public static void main(String[] args) {
		//자료형 : 기본형x, 참조형 o -> int 안됨 Integer로 써야함 : insert "Dimensions" to complete ReferenceType
		//<?extends Integer> 무슨 의미?
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(9);
		hs.add(1);
		hs.add(15);
		hs.add(20);   //add-> 리턴값 boolean형
		
		System.out.println(hs.add(15));  //false
		System.out.println(hs); //[1, 20, 9, 15] -> 순서 유지x
		
		//hs.get(index); remove(index)-> 순서 없으니까 get,remove 함수도 없음
		
		hs.remove(20); //객체로 없애는 건 가능
		System.out.println(hs);
		
		
	}

}
