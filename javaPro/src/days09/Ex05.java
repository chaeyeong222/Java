package days09;

import java.util.Scanner;

/**
 * @author 이채영
 * @date 2022. 2. 25. - 오후 4:01:32
 * @subject 제어문 연산자 알고리즘 응용/활용
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {

		//수열 squence 규칙 수의 나열
		//1+2+4+7+11+16+22+.. 
		//20번째 값? + 20항까지의 합?
		
		//문제)
		//1+2+4+7+11+16+22+29+37+46+56+???+[250]= 총합? 과 그 전의 항?
		int term =1;
		int sum=0;
		int increase=1;
	/*	while(true) {
			term +=increase;
			if(term>250) break;
			System.out.println(term+"+");
			sum+=term;
			increase++;	
		}*/
		while((term +=increase) <=250) {
			
			System.out.println(term+"+");
			sum+=term;
			increase++;	
		}
			
		System.out.println("250 직전항까지의 합은"+ sum );
		System.out.println("250 직전 항의 값은: "+ term);
    
	}

}
