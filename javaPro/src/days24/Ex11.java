package days24;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오후 4:23:09
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("박민주");
		list.add("이동원");
		list.add("마상민");
		list.add("박민주"); //중복

		System.out.println(list);

		//박민주 요소 찾는다?
		int findIndex = list.indexOf("박민주");
		System.out.println(findIndex);
		
		//박민주 모두 찾는다
		ArrayList findList = myIndexOf(list,"박민주");
		System.out.println(findList);

	}

	private static ArrayList myIndexOf(List list, String name) {
		//int [] = new int[??] 배열 크기 정할 수 없을때 arraylist 사용하면 편하다
		ArrayList findList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(name)) {
				findList.add(i);
			}
		}
		return findList;
	}

}
