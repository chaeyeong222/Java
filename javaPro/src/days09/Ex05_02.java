package days09;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 25. - 오후 4:01:32
 * @subject 제어문 연산자 알고리즘 응용/활용
 * @content 
 */
public class Ex05_02 {

	public static void main(String[] args) {

		//수열 squence 규칙 수의 나열
		//1+2+4+7+11+16+22+.. 
		//20번째 값? + 20항까지의 합?
       //
		int increase =0; //증가값
		 int term=1;
		 int sum = 0;
	
		 for(int i=1; i<=20;i++) {
		 term +=increase;
		 System.out.print(term + "+");
		 sum +=term;
		 increase++;
		 }
		 System.out.println("\b="+sum);
		 System.out.println(">20번째항:" +term);
		 
		 
		/*
		 * int a[] = new int [20];
		      a[0] = 1;
		      System.out.println(a[0]);
		      
		      for (int i = 1; i <= 19; i++) {
		         a[i] = a[i-1] + i;
         System.out.println(a[i]);
      }
		 */
		 
		 
		 
		 
		/*
		 term+=increase;
		 System.out.print(term + "+");
		 
		 
		 //3
		 increase++;
		 term += increase;
		 System.out.print(term + "+");
		
*/
	}

}
