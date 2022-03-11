package days15;

//package(==default) 접근지정자 선택하니까 앞에 안붙음
public class Person {
	
	String name;
	int age;
	
	public void walk() {
		System.out.printf("%s이 걷는다\n", name);
	}
	public void run() {
		System.out.printf("%s이 뛴다\n",name);
	}

}
