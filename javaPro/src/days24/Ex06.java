package days24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Ex06 {

	public static void main(String[] args) {
		// 컬렉션 프레임워크(JCF)
		// 컬렉션 프레임워크(JCF)의 핵심 인터페이스: C-L,S,            M
		//                                                     특징
		// 컬렉션 클래스 
		//1.ArrayList 컬렉션 클래스 Ex05.java
		
		ArrayList team1 = new ArrayList();
		team1.add("유환재");
		team1.add("김기태");
		team1.add("도성한");
		team1.add("박단");
		team1.add("이상호");
		team1.add("정도연");
		
		ArrayList team2 = new ArrayList();
		team2.add("안시은");
		team2.add("김서영");
		team2.add("마상민");
		team2.add("박재영");
		team2.add("이채영");
		team2.add("김지민");
		
		ArrayList class5 = new ArrayList();
		class5.addAll(team1);
		class5.addAll(team2);
		System.out.println(class5.toString());
		
		//class5.removeAll(team2);//team2 모두 제거
		//class5.retainAll(team2); //team2제외 모두 제거
		
		//[이름을 오름차순으로 정렬]
		ArrayList class5Clone = (ArrayList) class5.clone();
		System.out.println(class5Clone);
		
		//Arrays.sort(m);
		Collections.sort(class5Clone);
		//ㄱㄴㄷ순[김기태, 김서영, 김지민, 도성한, 마상민, 박단, 박재영, 안시은, 유환재, 이상호, 이채영, 정도연]
		System.out.println(class5Clone);
		
	/*	
		//모든 학생 이름을 출력 **암기
		//반복자
		Iterator ir = class5.iterator();
		//boolean hasNext() 다음 요소 가지고 있니? true
		//next()  다음 요소를 읽어오는 메서드
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println(name);
		}
*/
	}

}
