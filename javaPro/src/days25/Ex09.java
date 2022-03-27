package days25;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 12:25:39
 * @subject p. 628 Comparator 와 Comparable 
 * @content 
 */
public class Ex09 {

	public static void main(String[] args) {
	
		String [] m = {"tiger","cat","Dog","lion"};
		System.out.println(Arrays.toString(m));
		
	//	Arrays.sort(m,new DescendingComparator());
		
		//대소문자 구분하지 않고 정렬
		Arrays.sort(m, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(m));
		
			/*Person  [ ] m = {
				new Person("백경환",27),
				new Person("함세강",24),
				new Person("유환재",26)					
		};
		System.out.println(Arrays.toString(m));
		
		//나이순으로 정렬해서 출력하기
		Arrays.sort(m);
		System.out.println(Arrays.toString(m));
*/
	}//main

}//class

class DescendingComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);  //o1, o2 바꾸면 acsending
	}
	
}
class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		//return this.age = o.age; //같으면 0   /    > : +    / <:-
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		return (name+age).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return this.name.equals(p.name) && this.age ==p.age;
		}
		return false;
	}
	}