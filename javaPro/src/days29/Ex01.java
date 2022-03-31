package days29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author 이채영
 * @date 2022. 3. 30.
 * @subject 직렬화
 * @content 
		 * 멤버정보
		 * 파일읽어와서
		 * try catch 라인별로 읽기
		 * 배열에 저장하고
 * 
 */
public class Ex01 {

	public static void main(String[] args) {
		//직렬화  (객체-스트림변환 )
		//   -> 객체단위로 입출력 하기위해서 직렬화 한다.
		//      직렬화 -> 역직렬화(스트림-객체 변환)
		
		//한 멤버의 정보를 네트워크전송/파일저장
		
		Member m1 = new Member("박단", 25,false,2);
		
		String fileName = ".\\src\\days29\\member.txt";
	//멤버정보를 파일에 저장
		try(FileWriter fw = new FileWriter(fileName)) {
	
			fw.write(m1.toString());
			fw.flush(); //저장(파일), 전송(네트워크)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
		//저장된 멤버정보를 파일에서 읽어오기
		/*
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)) {
			
			String line;
			while((line =br.readLine()) != null) {
				System.out.println(line);
				
				String []datas = line.split(",");
				String name= datas[0];
				int age = Integer.parseInt(datas[1]);
				boolean gender = Boolean.parseBoolean(datas[2]);
				long type = Long.parseLong(datas[3]);
				Member m = new Member(name, age, gender, type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		*/
		
		System.out.println("end");

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
	
}
*/