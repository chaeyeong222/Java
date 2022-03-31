package days29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex01_02 {

	public static void main(String[] args) {

/*
		Member m1 = new Member("박단", 25,false,2);

		String fileName = ".\\src\\days29\\member.txt";
		// 멤버정보를 파일에 저장
		m1.writeExternal(fileName);
		//저장된 멤버정보를 파일에서 읽어오기

		Member m= m1.readExternal(fileName);
		System.out.println(m);
	
		System.out.println("end");
		
*/
	}//main	

}//class
/*
class Member {
	private String name;
	private int age;
	private boolean gender;
	private long type;

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
	//멤버객체 파일 저장하는 메서드
	public void writeExternal(String fileName){
		try(FileWriter fw = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(fw)) {

			bw.write(this.name+"\n");
			bw.write(this.age+"\n");
			bw.write(this.gender+"\n");
			bw.write(this.type+"\n");

			System.out.println("객체저장완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//파일-> 멤버객체 반환하는 메서드

	public Member readExternal (String fileName) {
		Member m=null;
		
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)) {	

				String name= br.readLine();
				int age = Integer.parseInt(br.readLine());
				boolean gender = Boolean.parseBoolean(br.readLine());
				long type = Long.parseLong(br.readLine());
				
				m = new Member(name, age, gender, type);
				
				return m;
			}
		 catch (Exception e) {
		  return null;
		}
	}



}//class
*/