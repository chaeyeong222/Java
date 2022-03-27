package days25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class Ex10_03 {

	public static void main(String[] args) {
		//컬렉션 클래스 사용해서 2차원배열 코딩 수정하기

		//LinkedHashSet [] lottos =new LinkedHashSet[3];
		int gameNumber = 1;
		Scanner scanner = new Scanner(System.in);      
		System.out.print("> 게임 횟수 입력 ? ");
		gameNumber = scanner.nextInt();    

		ArrayList<LinkedHashSet<Integer>> lottos = new ArrayList<LinkedHashSet<Integer>>(gameNumber);
		LinkedHashSet<Integer> lotto=null;

		for (int i = 0; i < gameNumber; i++) {
			lotto	= new LinkedHashSet<Integer>();
			Ex10_02.fillLotto(lotto);
			lottos.add(lotto);
}
		for (int i = 0; i < gameNumber; i++) {
		//	lotto = lottos.get(i);
//			Ex10_02.dispLotto(lotto)
			Ex10_02.dispLotto(lottos.get(i));
		}
	//나온 숫자들을 오름차순으로 정렬?
		//순서유지x LinkedHashSet을 사용했는데, 정렬방법?
	}
	
	


}

