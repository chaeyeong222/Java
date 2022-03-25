package days25;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex01 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			list.add(rnd.nextInt(100)+1);
		}System.out.println(list); //[97, 33, 31, 42, 63] 중복될 수도 있음
		
		//Comparator c = new ListDescendingComparator();
		//list.sort(c);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}

}
/*
class ListDescendingComparator implements Comparator{
	
	@Override
	public int compare(Object o1, Objecto2) {
		if(o1 instanceof Integer && instanceof Integer) {
			int i = (int)o1;
			int j = (int)o2;
			return (i-j)*-1;
			
		}return 0;
	}
}
*/
//[문제1] 용어 설명
//ㄱ. 컬렉션 프레임워크 ( JCF ) ?
//ㄴ. 프레임워크 ?  
//ㄷ. 컬렉션 ?  
//ㄹ. 컬렉션 클래스 ? 

//[문제2]  컬렉션 프레임워크의 핵심 인터페이스와 특징.
/*
 *  list,set , map
 *  list -> 중복허용, 순서유지, 
 *  set0>증복x, 순서유지x
 *  map->key+value ->key는 중복x, value는 중복ㅇ, 둘다 순서유지x
 */

//[문제3] 
//ArrayList list 객체에 임의의 정수( 1~100 ) 까지의 정수  5개를 입력하고
//내림차순으로 정렬해서 출력하세요. 


//[문제4]
//java.time 패키지 클래스 사용. (   LocalDateTime )

// 1) 설문 시작일 22.3.15 09:00:00
// 2) 설문 종료일 22.3.24 09:00:00      
// 오늘 현재 설문 가능한여부를 출력하세요.

/*
LocalDateTime startDay = LocalDateTime.of(22, 3,15, 9 ,00,00);
LocalDateTime endDay = LocalDateTime.of(22, 3,24, 9 ,00,00);
LocalDateTime today = LocalDateTime.now();

Duration d = Duration.between(startDay, endDay);
System.out.println(d);
*/
