package days25;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오전 11:29:35
 * @subject 
 * @content List 인터페이스 구현 클래스들: 
 * ArrayList가장많이씀, Vector, LinkedList비순차적삽입삭제, Stack(LILF), Queue(LinkedList)FIFO 각각의 특징 암기
 * 
 */
public class Ex05 {

	public static void main(String[] args) {
		//예제 11-10코딩해보기
		//p.612 PriorityQueue = 우선순위 + 큐 FIFO
		//    특징: 저장한 순서에 상관없이 우선순위가 높은 것 부터 꺼낸다
		
		//컬렉션 클래스 안에 Integer값을 저장하겠다는 의미
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.offer(3);
		q.offer(5);
		q.offer(2);
		q.offer(4);
		q.offer(1);
		System.out.println(q); //[1, 2, 3, 5, 4] -> 아무렇게나 들어가있음
		
		//숫자인 경우에는 오름차순 정렬해서 가져온다
		//1이 우선순위임. 5가 제일 나중
		//문자열 ㄱ~ㅎ
		while(!q.isEmpty()) {
			int n = q.poll();
		System.out.println(n); //1 2 3 4 5 
		}
		
		
	}

}
