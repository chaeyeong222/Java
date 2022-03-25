package days25;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오전 10:14:14
 * @subject  LinkedList 사용
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add("박예린");
		list.add("이동원");
		list.add("안시은");
		System.out.println(list); //[박예린, 이동원, 안시은]
		
		list.addFirst("김서영"); //맨 앞에 넣기
		//list.add(0."김서영");
		System.out.println(list); //[김서영, 박예린, 이동원, 안시은]
		
		list.add(3,"이채영"); //성능우수
		System.out.println(list);
		
		//list.get(3);
		//list.getFirst();==list.get(0);
		//list.getLast();==list.get(list.size()-1)
		
		//list.remove(1); 제거
		System.out.println(list.size());
		
//		Iterator ir = list.descendingIterator();
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println(name);
			
		}
		
		//p.599 메서드 정리  ->Queue 설명할때 정리
		//element()
		//offer()
		//peek()
		//poll()
		//remove()


	}

}
