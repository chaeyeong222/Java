package days25;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
/**
 * @author 이채영
 * @date 2022. 3. 24. - 오후 2:30:11
 * @subject 
 * @content 
 */
public class Ex10_02 {

	public static void main(String[] args) {
		//로또게임
		//순서 유지x, 중복허용x
		//HashSet<Integer> lotto = new HashSet<Integer>();

		//*** 순서 유지0, 중복허용x
		HashSet<Integer> lotto = new LinkedHashSet<Integer>();
		fillLotto( lotto );
		dispLotto( lotto );

	}//main



	public static void fillLotto(HashSet<Integer> lotto) {
		// 중복체크할 필요없이 6개만 hashset에 채워넣는 코딩.
		Random rnd = new Random();
		while(lotto.size()<6) {
			lotto.add(rnd.nextInt(45)+1);
		/* 어떤 숫자 나오는지 바로바로 체크하려면..
		 * while(lotto.size()<6) {
			int n = rnd.nextInt(45)+1;
			System.out.println(n);
			lotto.add(n);
		*/	
			
			
		}	
		
		
	}

	public static void dispLotto(HashSet<Integer> lotto) {
		//iterator반복자 사용
		Iterator<Integer> ir = lotto.iterator();
		while (ir.hasNext()) {
			Integer n = (Integer) ir.next();
			System.out.printf("[%d]",n);
			
		}System.out.println();
		

  } // dispLotto
}
