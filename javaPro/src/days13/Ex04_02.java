package days13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex04_02 {

	 public static void main(String[] args) {
	       // [문제]  찾을 정수  n의  모든 위치값(인덱스값)을 출력하는 코딩을 하세요.
	       int [] m =  new int[30]; 
	       Random rnd = new Random();
	       for (int i = 0; i < m.length; i++) {
	         m[i] = rnd.nextInt(20)+1;
	      }       
	      System.out.println(  Arrays.toString(m) );
	      
	      int n; // 검색할 정수
	      System.out.print("> 검색할 정수 입력 ? ");
	      Scanner scanner = new Scanner(System.in);
	      n = scanner.nextInt();  // 1
	       
	      // sequenceSearch(   m ,   n    );
	      int []  idxs = sequenceSearch(   m ,   n    );       
	      // System.out.println(  Arrays.toString(  idxs )  );
	      if(  idxs[0] == -1 )
	         System.out.println("찾는 정수는 없습니다. ");
	      else {
	         for (int i = 0; i < idxs.length  ; i++) {
	            if(  idxs[i] != -1  )
	            System.out.printf("%d 위치에서 찾았다.\n", idxs[i]);
	         }
	      }
	      
	      /*
	      int idx = sequenceSearch(   m ,   n    );
	      if (  idx == -1 ) {
	         System.out.println("찾는 정수는 없습니다. ");
	      } else {
	         System.out.printf("%d 위치에서 찾았다.\n", idx);
	      } 
	      */

	   } // main

	   
	   // 리턴자료형  int []
	   private static int[] sequenceSearch(int[] m, int n) {
	      int [] idxs = new int[ m.length ]; // -1 초기화
	      Arrays.fill(idxs, -1); // [2,4,7,-1,-1,-1,-1,-1,-1,-1,-1,.... 30개]
	      int idx=0;
	      for (int i = 0; i < m.length; i++) {         
	         if( m[i] == n ) {
	             idxs[idx++] = i;
	         } // if         
	      } // for i      
	      return idxs;
	   }
	 
	   // 메서드  -> 재사용 X
	   // 검색  -> 수정, 삭제 활용
	   /*
	   private static void sequenceSearch(int[] m, int n) {
	      int idx = -1;    
	      for (int i = 0; i < m.length; i++) {         
	         if( m[i] == n ) {
	            idx = i;
	            System.out.printf("%d 위치에서 찾았다.\n", idx);
	         } // if         
	      } // for i        
	   }
	   */
	   
	   /*
	   private static int sequenceSearch(int[] m, int n) {
	      int idx = -1;    
	      for (int i = 0; i < m.length; i++) {         
	         if( m[i] == n ) {
	            idx = i;
	            break;
	         } // if         
	      } // for i       
	      return idx;
	   }
	*/
	} // class

	/* 문제는 풀었지만 재사용이 불가함
	 * private static void sequenceSearch(int[] m, int n) {
      int idx = -1; 

      for(int i=0;i<m.length;i++) {
         if(m[i]==n) {
                        
            idx=i;
            System.out.printf("%d위치에서 찾았다,\n",idx);
         }
      }
   }
	 */

