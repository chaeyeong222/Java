package days29;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 10:32:02
 * @subject 
 * @content 
 */
public class Ex02_03 {

	public static void main(String[] args) throws IOException {
		//1.
		//부모가 직렬화가 가능한 클래스로 선언이 되면 
		//자식은 자동으로 직렬화가 가능한 클래스가 된다.
		
		Child c=new Child();
		c.name = "admin";
		c.age=20;
		
		//oos.writeObject(c);
		//2. 부모의 멤버는 직렬화 대상에서 제외
		//    자식 멤버만 직렬화 대상이 된다.
		
		//3. 부모의 직렬화 대상의 제외된 멤버도 직렬화에 포함하고 싶다면
		//      직접 메서드 구현
		
		try ( FileOutputStream fos = new FileOutputStream(".\\src\\days29\\child.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			Child c1= new Child();
			c1.name = "admin";
			c1.age =20;
			
			oos.writeObject(c1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("엔터치면 계속");
		System.in.read();
		System.in.skip(System.in.available());
		
		try ( FileInputStream fis = new FileInputStream(".\\src\\days29\\child.dat");
				ObjectInputStream oos = new ObjectInputStream(fis)) {
			
			Child c1= (Child)oos.readObject();
			System.out.println(c1.name);
			System.out.println(c1.age);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class

//직렬화가 가능한 클래스
class Parent {
	public String name;
}

//직렬화가 가능한 클래스

class Child extends Parent implements Serializable { 
	//generate로 자동생성하면 고유값 생성됨.
	private static final long serialVersionUID = -1937494941033300428L;
//implements SerializableX
	public int age;
	
	//oos.writeObject(c)
	private void writeObject(ObjectOutputStream out)throws IOException{
		
		out.writeUTF(name); //부모의 직렬화 제외된 필드를 추가한 것.
		out.defaultWriteObject(); //Child 필드 -age
	}
private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
		
	name = in.readUTF();
	in.defaultReadObject();//child필드 -age
	}
}