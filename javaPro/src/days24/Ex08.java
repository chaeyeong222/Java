package days24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 이채영
 * @date 2022. 3. 23. - 오후 3:34:39
 * @subject String [] -> ArrayList 변환
 * @content Arrays.asList 사용하면 된다.
 */
public class Ex08 {

	public static void main(String[] args) {
		//기억
		//String [] -> ArrayList 변환 
		String [] names = {"박예린","이채영","정도연","마상민","김희진"};
	/*	ArrayList list = new ArrayList();
		
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}System.out.println(list); 
		*/ 
		
		List a = Arrays.asList(names); 
	//	ArrayList list = new ArrayList();
		ArrayList list = new ArrayList(Arrays.asList(names)); //위의 코딩 한번에
		System.out.println(list);

	}//main

}//class
