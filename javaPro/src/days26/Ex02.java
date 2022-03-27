package days26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오전 11:02:52
 * @subject Hashtable
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		
		//p.647 예제11-31 참조해서 코딩해보기 - 전체 총점, 전체평균, 최고점, 최저점, 팀 총점, 팀평균		
		// key = 팀명, value = 팀원->Arraylist(중복 안되니까)
		Hashtable<String, ArrayList<Member>> ht = new Hashtable<>();

		ArrayList<String> tnList = new ArrayList<String>();
		tnList.add("코린이조");
		tnList.add("코딩을자바조");
		tnList.add("자바잡스");
		
		
		ArrayList<Member> team1 = new ArrayList<>();
		team1.add(new Member("유환재",90));
		team1.add(new Member("김기태",78));
		team1.add(new Member("도성한",66));
		
		ArrayList<Member> team2 = new ArrayList<>();
		team2.add(new Member("안시은",89));
		team2.add(new Member("김서영",99));
		team2.add(new Member("마상민",65));
		
		ArrayList<Member> team3 = new ArrayList<>();
		team3.add(new Member("함세강",65));
		team3.add(new Member("김재우",28));
//		team3.add(new Member("김희진"));
		
		
		ht.put(tnList.get(0), team1);
		ht.put(tnList.get(1), team2);
		ht.put(tnList.get(2), team3);
		
	/*	//2팀의 팀원정보 출력
		ArrayList<Member> list = ht.get("코딩을자바조");
		Iterator<Member> ir = list.iterator();
		while (ir.hasNext()) {
			Member m = (Member) ir.next();
			System.out.println(m);
		}
		*/
		
		//문제 : 1조, 코린이조(인원수)
		//          조원1,2,3
		//          2조, 코딩을자바조
		
		//문제 : 출력팀의 순서가 안맞음
		Set<Entry<String, ArrayList<Member>>> es = ht.entrySet();
		Iterator<Entry<String, ArrayList<Member>>> ir = es.iterator();
		int no=1;
		while (ir.hasNext()) {
			Entry<String,ArrayList<Member>> entry = (Entry<String,ArrayList<Member>>) ir.next();
			
			String tname = entry.getKey();
			ArrayList<Member> memberList = entry.getValue();
			System.out.printf("%d조 - %s(%d명)\n",no++,tname,memberList.size());
			
			Iterator<Member> ir2= memberList.iterator();
			while (ir2.hasNext()) {
				Member member = (Member) ir2.next();
				System.out.println("\t"+member);
			}
			
		}//while
		
	}//main

}//class

class Member{
	String name;
	int      score;
	
	public Member(String name, int score) {
		super();
		this.name=name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", score=" + score + "]";
	}

}