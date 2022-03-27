package days25;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 4:15:47
 * @subject p.637 예제 11-25
 * @content 
 */
public class Ex13 {

	public static void main(String[] args) {
		HashSet<Integer> a = new HashSet<Integer>();
		a.add(1);	a.add(2);	a.add(3);	a.add(4);	a.add(5);
		
		HashSet<Integer> b = new HashSet<Integer>();
		b.add(4);	b.add(5);	b.add(6);	b.add(7);	b.add(8);
		
		System.out.println(a);
		System.out.println(b);
		
		//합집합 a ∪ b  [12345678]
		HashSet<Integer> hab = new HashSet<Integer>();
		hab.addAll(a);
		hab.addAll(b);
		System.out.println(hab); // 중복데이터 자동 삭제되므로 합집합 됨.
		
		//교집합  a ∩ b [4 5]
		HashSet<Integer> kyo = new HashSet<Integer>();
		
		//차집합 a-b [123]
		HashSet<Integer> cha = new HashSet<Integer>();
		
		
		Iterator<Integer> ir = a.iterator();
		while(ir.hasNext()) {
		Integer n = (Integer)ir.next();
		if(b.contains(n)) {
			kyo.add(n);
		}else {
			cha.add(n);
		}
		}
		System.out.println(kyo);
		System.out.println(cha);
		

	}//main

}//class
