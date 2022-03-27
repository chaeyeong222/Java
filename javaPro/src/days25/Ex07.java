package days25;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 12:06:36
 * @subject p.614 Iterator, ListIterator, Enumeration
 * @content         인터페이스 - 컬렉션의 요소를 접근(가져옴)
 * 
 *                   Enumeration(구) - 열거자
 *                   Iterator (신)        - 반복자 fail-fast    
 *                   ListIterator = Iterator +향상된 기능
 */
public class Ex07 {

	public static void main(String[] args) {
		Vector<String> list =  new Vector<String>();
		/*스트링빼고는 못담아서 에러나는 것들
		list.add(1);
		list.add(문자열);
		list.add('ㅊ');
		list.add(true);
		list.add(3.14);
*/
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		//1.Enumeration 열거자
		/*
		Enumeration<String> en = list.elements();
		while (en.hasMoreElements()) {
			String str = (String) en.nextElement();
			System.out.println(str);
		}
		*/
		
		//2.Iterator 반복자  --------->단방향 (이전요소로 갈 수 x)
		/*
		Iterator<String> ir = list.iterator();
		while (ir.hasNext()) {
			String str = (String) ir.next();
			System.out.println(str);
		}
		*/
		//3. ListIterator  
		ListIterator<String> ir = list.listIterator();
		while (ir.hasNext()) {
			String str = (String) ir.next();
			System.out.println(str);
		}
		//향상된 기능 -->  이전요소로 갈 수 있음
		/*
		System.out.println(ir.previous()); //E
		System.out.println(ir.previous()); //D
		System.out.println(ir.previous()); //C  
		*/
		System.out.println("========");
		while (ir.hasPrevious()) {
			String str = (String) ir.previous();
			System.out.println(str);
			
		}		
				
		
		
	}//main

}//class
