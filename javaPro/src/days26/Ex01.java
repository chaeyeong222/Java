package days26;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오전 9:37:56
 * @subject p 644. HashMap 과 Hashtable 설명 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		//  HashMap 과 Hashtable 설명 
		//1. Map 인터페이스를 구현한 컬렉션 클래스
		//2. Entry = (key+value)
		//3. Hashtable      <HashMap (권장)
		//4. Hash : 해싱을 사용하기 때문에 많은 양의 데이터를 [검색할 때 성능이 뛰어남]
		// 해싱?
		//5. Vector와 ArrayList관계와 비슷 ( 동기화 처리 유무)
		//    동o            동x
		//6. key 중복x,        value 중복o
		
		//<T>   Type
		//<E>   Element
		//<K ,V > key 어떤 타입? value 어떤 타입? 설정
		// id  name
	//	HashMap<String, String> hm = new HashMap<String, String>();
		HashMap<String, String> hm = new HashMap(); //생략가능
		hm.put("kenik", "이창익");
		hm.put("admin", "관리자");
		hm.put("hong", "홍길동");
		
		//hong 찾아서 홍길동 -> 이동원 수정
		if(hm.containsKey("hong")) {
			hm.replace("hong", "이동원");
			//hm.replace("hong","홍길동", "이동원");
			
		}System.out.println(hm);
		/*
		if(hm.containsKey("hong")) {
			//삭제한 엔트리의 value값을 반환
			String returnValue = hm.remove("hong");
			System.out.println(returnValue);
		}
		System.out.println(hm);
	*/
		/*			
		//key-value 전부 출력 -> entry(key+value)
		Set<Entry<String, String>> es = hm.entrySet();
		Iterator<Entry<String, String>> ir =es.iterator();
		while (ir.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) ir.next();
			String key = entry.getKey();
			String value= entry.getValue();
			System.out.println(key + ":"+ value);
		}
		
	//모든 value 값만 출력
		Collection<String> vc = hm.values();
		Iterator<String> ir = vc.iterator();
		while (ir.hasNext()) {
			String value = (String) ir.next();
			System.out.printf("value=%s\n",value);
		}
		
	//모든 키 만 출력
		Set<String> ks = hm.keySet();
		Iterator<String> ir= ks.iterator();
		while (ir.hasNext()) {
			String key = (String) ir.next();
			String value = hm.get(key);
			System.out.printf("key(id)=%s, value(name)=%s\n",key,value);
		}
		
		
		//hm.clear();   모든 엔트리 삭제
		
		System.out.println(hm); //{hong=홍길동, kenik=이창익, admin=관리자}
		//id가 있는 지 확인 후 name 출력
		
		String id = "admin";
		//hm.clone(); 복제
		//hm.containsKey(id);
		//hm.containsValue(name);
		
		if(hm.containsKey(id)) {
			String name= hm.get(id);
			System.out.printf("key(id)=%s, value(name)=%s\n",id,name);
		}else {
			System.out.println("찾는 key 없음");
		}
		
		//key 중복허용x, 새로 저장됨(대체)
		hm.put("admin", "김재우");
		
		//value 중복허용 ㅇ
		hm.put("park", "홍길동");
		
		hm.put(null, null);
		hm.put(null, "널"); //null이라는 key로 한개의 value값만 가짐
		
		System.out.println(hm); 
		*/
		
		

	}

}
