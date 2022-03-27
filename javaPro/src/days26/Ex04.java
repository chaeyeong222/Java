package days26;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author 이채영
 * @date 2022. 3. 25. - 오후 12:25:34
 * @subject p.650 예제 11-33
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		//파일 읽어서 A ####~12 days21.Ex09.java
		
		String fileName = "days20\\Ex01.java";
		String path = String.format("%s\\src\\%s"
	                                          , System.getProperty("user.dir"),
                                                fileName );
		System.out.println(path);

		//                     'A'       누적값
		HashMap<Character, Integer> map = new HashMap();
		
		char one;
		int code;
		
		
		try(
			FileReader fr = new FileReader(path);	){		
			while((code = fr.read())  != -1) {
				one  =(char) code;
				if (map.containsKey(one)) {
					//있으면 value값 증가하는 코딩
					map.put(one, map.get(one)+1);
				} else {
					//없으면 put 하고 1 저장하는 코딩
					map.put(one, 1);

				}
				}//while
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		for (int i = 0; i < counter.length; i++) {
			System.out.printf("[%c] :%s(%d)\n",i+65,PrintBar('*',counter[i]), counter[i]);
		}*/
		
		Iterator<Entry<Character, Integer>>ir=map.entrySet().iterator();
		while (ir.hasNext()) {
			Entry<Character, Integer> entry = (Entry<Character, Integer>) ir.next();
			//entry.getKey();//문자
			//entry.getValue();;//개수
			System.out.printf("[%c] :%s(%d)\n",entry.getKey(),PrintBar('*',entry.getValue()), 
					entry.getValue());
			
		}
	}//main
	public static String PrintBar(char style, int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(style);
		}return sb.toString();
	}

}
