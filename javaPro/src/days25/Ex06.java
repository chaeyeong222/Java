package days25;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 12:01:02
 * @subject p.613 Deque = Double Ended Queue
 * @content  특징: 양쪽 끝에서 추가/추출이 가능하다
 *                       Queue <- Deque
 *                       Deque 구현한 클래스 : LinkedList , Array
 */
public class Ex06 {

	public static void main(String[] args) {
		
		Deque<String> dq = new LinkedList<String>();
		// Queue : offer()/poll()

		//dq.pollFirst();
		//dq.pollLast();
	}

}
