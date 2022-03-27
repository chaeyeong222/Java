package days25;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 4:29:13
 * @subject p. 638 TreeSet 컬렉션 클래스
 * @content 
 */
public class Ex14 {

	public static void main(String[] args) {
		//[TreeSet]특징
		//1.중복허용x, 순서유지x
		//2.이진검색트리 사용해서 데이터 저장
		//    -> 검색, 정렬, 범위 검색하는데 성능 뛰어남
		//3. 링크드리스트처럼 노드가 서로 연결된 구조 []-[]-[]-[]
		//4. 최상위 노드를 root노드 ,   부모-자식 노드 관계, 형제 노드관계
		//6. class Node{
		//           Node 왼쪽자식노드;  
		//           Object value;
		//            Node 오른쪽자식노드;
	    //  }
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(7);
		ts.add(4);
		ts.add(9);
		ts.add(1);
		ts.add(5);
		ts.add(6);
		System.out.println(ts);
		
		System.out.println(ts.first());
		System.out.println(ts.last());
		
		SortedSet<Integer>ss = ts.subSet(1, 7);
		System.out.println(ss);// [1, 4, 5, 6]

	}

}
