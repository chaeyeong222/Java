package days29;

import java.io.Serializable;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 10:32:02
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		//1.
		//부모가 직렬화가 가능한 클래스로 선언이 되면 
		//자식은 자동으로 직렬화가 가능한 클래스가 된다.
		

	}//main

}//class

/*
//직렬화가 가능한 클래스
class Parent implements Serializable{
	public String name;
}

class Child extends Parent { //implements SerializableX
	public int age;
}
*/