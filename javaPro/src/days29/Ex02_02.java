package days29;

import java.io.Serializable;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 10:32:02
 * @subject 
 * @content 
 */
public class Ex02_02 {

	public static void main(String[] args) {
		//1.
		//부모가 직렬화가 가능한 클래스로 선언이 되면 
		//자식은 자동으로 직렬화가 가능한 클래스가 된다.
		
		Child c=new Child();
		c.name = "admin";
		c.age=20;
		
		//oos.writeObject(c);
		//2. 부모의 멤버는 직렬화 대상에서 제외
		//    자식 멤버만 직렬화 대상이 된다.

	}//main

}//class

/*
//직렬화가 가능한 클래스
class Parent {
	public String name;
}

//직렬화가 가능한 클래스
class Child extends Parent implements Serializable { //implements SerializableX
	public int age;
	
}*/