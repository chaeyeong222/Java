package days29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오전 9:53:43
 * @subject  
 * @content 
 * //객체를 직렬화하고 역직렬화하는 방법x - 직접 구현할 필요 없음
		//ObjectInputStream, ObjectOutputStream 클래스 존재+사용방법숙지
		 * 
		 * 939p. transient
		 * 
		 * 
		 * 
 */
public class Ex01_03 {

	public static void main(String[] args) {

		String fileName = ".\\src\\days29\\member.dat";
	Member m1 = new Member("박단", 25,false,2);

		//m1.객체를 직렬화해서 파일로 저장


		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos= new ObjectOutputStream(fos)){

			oos.writeObject(m1);
		} catch (Exception e) {
			e.printStackTrace();
		}


		//파일->스트림-> 객체변환(역직렬화)
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois= new ObjectInputStream(fis)){

			Member m= (Member)ois.readObject();
			System.out.println(m);
			//박단,25,false,0  type필드는 직렬화대상에서 제외되었기에 기본값0나옴
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");

	}//main	

}//class

//[직렬화가 가능한 클래스 선언]
// 1. implements Serializable 빈 인터페이스
//2.  implements Externalizable  
//      ㄴ writeExternal()
//      ㄴ readExternal()    -> 개발자 직접 구현
class Member implements Serializable{
	// 시리얼버전 UID
	private static final long serialVersionUID = 2336313051081995427L;
	private String name;
	private int age;
	private boolean gender;
	private transient long type;  //transient: 직렬화 제외 = 객체-> 스트림

	public Member() {}

	public Member(String name, int age, boolean gender, long type) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s,%d,%b,%d",name,age,gender,type);
	}

}//class

class Person implements Externalizable {
	
	String name;
	int age;
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
}