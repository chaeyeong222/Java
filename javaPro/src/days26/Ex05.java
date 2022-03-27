package days26;

import java.util.TreeMap;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 2:03:59
 * @subject 해싱과 해시함수
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		//해싱? 해시함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법
		// 해시함수? 데이터가 저장되어 있는 곳을 알려주기 때문에 대량의 데이터 중
		//              원하는 데이터를 빠르게 찾을 수 있다.
		
		//p. 654 TreeMap
		//1. Map = entry(k+v)
		//Tree   정렬, 검색, 범위검색 성능 빠르다
		//p, 656 예제 11-34
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		//tm.put(key, value);
		//tm.get(key)
		
		//tm.ceilingKey(null); : 지정된 키와 일치하거나 큰 것 중 제일 작은 것의 키를 반환, 없으면 null반환
		//tm.ceilingEntry(null); : 지정된 키와 일치하거나 큰 것 중 제일 작은 것의 키와 값의 쌍을 반환, 없으면 null반환
		
		//tm.floorKey(null); : 지정된 키와 일치하거나 큰 것 중 제일 큰 것의 키를 반환, 없으면 null반환
		//tm.floorEntry(null); : 지정된 키와 일치하거나 큰 것 중 제일 큰 것의 키와 값의 쌍을 반환, 없으면 null반환
		
		//tm.firstEntry(); TreeMap에 저장된 첫번째(가장 작은)키와 값의 쌍을 반환
		//tm.firstKey(); :  TreeMap에 저장된 첫번째(가장 작은)키를 반환
		

	}

}
