package days25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오전 10:31:22
 * @subject p.600 예제11-5 ,11-6
 * @content 
 */
public class Ex02_03 {

	public static void main(String[] args) {
		// 예제 11-5
		ArrayList al = new ArrayList(2000000);
		LinkedList il = new LinkedList();

		System.out.println("=순차적으로 추가하기=");
		System.out.println("ArrayList :" + add1(al));
		System.out.println("LinkedList : " + add1(il));

		System.out.println("=중간에 추가하기=");
		System.out.println("ArrayList :" + add2(al));
		System.out.println("LinkedList : " + add2(il));

		System.out.println("=중간에 삭제하기=");
		System.out.println("ArrayList :" + remove2(al));
		System.out.println("LinkedList : " + remove2(il));

		System.out.println("=순차적으로 삭제하기=");
		System.out.println("ArrayList :" + remove1(al));
		System.out.println("LinkedList : " + remove1(il));

	}
	public static long remove1(List list) {
		long start = System.currentTimeMillis();
		for (int i = list.size()-1; i >=0; i--)  list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long remove2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)  list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long add1(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++)  list.add(i+"");
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long add2(List list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)  list.add(500, "X");
		long end = System.currentTimeMillis();
		return end - start;
	}
}
