package days26;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex10 {

	  public static void main(String[] args) {
	       
	      /*
	      ArrayList  list = new ArrayList();
	      list.add(100);  // Object
	      list.add("str");
	      list.add(true);
	      
	      int n = (int) list.get(0);
	      String s = (String) list.get(1);
	      boolean b = (boolean) list.get(2);
	      */

	      ArrayList<String> list = new ArrayList<String>();
	      list.add("a");
	      list.add("b");
	      // list.add( 100 );  //  ㄱ. 객체 타입의 안전성
	      
	      Iterator<String> ir =  list.iterator();
	      while (ir.hasNext()) {
	         String s =  ir.next();   //  ㄴ.  형변환 번거로움 줄이기 위해서  -> 코드 간결        
	         System.out.println( s );
	      }
	      
	   }  // main

	} // class