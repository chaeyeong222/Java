package days24;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오후 3:39:39
 * @subject p.588 Vector 컬렉션 클래스 
 * @content 
 */
public class Ex10 {

	public static void main(String[] args) {
		// C -> List인터페이스(순서유지0, 중복허용o) 
		//            ->(구현) ArrayList, Vector(멀티스레드 안전-동기화됨)

		//Vector v = new Vector(10,0);
		Vector v = new Vector();

		v.addElement("이채영");
		v.add("정도연");
		System.out.println(v.size()); //2 객체의 수
		System.out.println(v.capacity()); //10 용량의 수(디폴트값10)

		v.trimToSize(); //빈공간 없앰

		System.out.println(v.capacity()); //2 (빈공간 없앤 결과)

		//요소의 갯수 증가+null로 채워짐. 
		v.setSize(6);
		System.out.println(v.capacity()); 
		System.out.println(v); //[이채영, 정도연, null, null, null, null]

		System.out.println(v.get(0)); //이채영   컬렉션을 리스트에서 물려받은 함수
		System.out.println(v.elementAt(0));//이채영 C-L-Vector(elementAt)
		v.copyInto(args);//복사

		//모든 요소를 반환하는 메서드
		//Enumeration 열거자
		Enumeration en = v.elements();
		//hasMoreElements() 요소가 더 있니? true false
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			System.out.println(name);

		}
		//반복자-암기
		//열거자-암기
		//차이는? fail=past

		//첫번째 요소 : v.firstElement() ==v.get(0)==v.elementAt(0)
		//마지막요소 : v.lastElement() == v.get(v.size()-1)

		//요소 삽입:v.insertElementAt(요소, 위치index); == v.add(요소, 위치)

		//v.[list]Iterator(0)

		//v.remove(인덱스);
		//v.remove(객체);
		//v.removeElementAt(인덱스);
		//v.removeElement(객체);

		//Object [] toArray()   -> String[]
		String[] m = (String[])v.toArray();

		//Stringbuffer(동기화x)와 StringBuilder(동기화o) 클래스
		//ArrayList와 Vector 컬렉션 클래스의 차이점 : 동기화처리(벡터)되어있음.

	}//main

}//class
