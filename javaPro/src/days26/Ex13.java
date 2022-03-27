package days26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import days17.Employee;
import days17.Regular;
import days17.Temp;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 4:39:13
 * @subject p.678 와일드카드 ==?
 * @content 
 */
public class Ex13 {

	public static void main(String[] args) {
		//자동 형변환 업케스팅
		Employee emp = new Regular();
		
		Vector<Regular> v1 = new Vector<Regular>();
		v1.add(new Regular());
		v1.add(new Regular());
		v1.add(new Regular());
		
		//Type mismatch: cannot convert from Vector<Regular> to Vector<Employee>
		ArrayList<Temp>list = new ArrayList<Temp>();
		//Vector<Employee>v = new Vector(Collection<? extends Employee> c);		
		Vector<Employee>v = new Vector(list);

	}//main

}//class
