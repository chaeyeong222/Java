package days25;

import java.util.LinkedList;
import java.util.Queue;

public class Ex04 {

	public static void main(String[] args) {
		//Deque인터페이스의 조상 Queue 인터페이스
		//Queue 는 인터페이스 -> LinkedList implements List, Deque
		//인터페이스 업캐스팅 가능
		//FIFO구조
		Queue q = new LinkedList();
		
		q.add("김희진"); //추가 실패하면 예외 발생
		q.offer("도성한");
		q.offer("박단");
		
		System.out.println(q.size()); //3
		
		//q.peek(); ->제거하지 않고 읽어옴
	/*	
		String name= (String)q.remove();
		System.out.println(name);
		name= (String)q.remove();
		System.out.println(name);
		name= (String)q.remove();
		System.out.println(name);
		name= (String)q.remove();
		System.out.println(name); //꺼낼것 없으면 에러 java.util.NoSuchElementException
		
		*/
		String name= (String)q.poll();
		System.out.println(name);
		name= (String)q.poll();
		System.out.println(name);
		name= (String)q.poll();
		System.out.println(name);
		name= (String)q.poll();
		System.out.println(name); //null
		
		
	}

}
