package days25;

import java.util.HashSet;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 3:50:46
 * @subject p.634-636
 * @content 
 */
public class Ex12 {

	public static void main(String[] args) {
		
		System.out.println(("홍길동"+25).hashCode());
		
		//순서유지x, 중복허용x
		HashSet<Person> hs = new HashSet<Person>();
		Person p1 = new Person("박예린", 24);
		System.out.println(p1.hashCode());
		hs.add(p1);
		Person p2 = new Person("도성한", 26);
		hs.add(p2);
		Person p3 = new Person("박예린", 24); //같은 사람 but다른 객체로 인식함. hashcode값 다름
		System.out.println(p3.hashCode());
		hs.add(p3);
		
		System.out.println(hs);
		
		//이름과 나이가 둘 다 같으면 같은 객체로 인식해서 중복되지 않도록 하기. hashset추가x

	}//main

}//class

