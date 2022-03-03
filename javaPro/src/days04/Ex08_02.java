package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex08_02 {

	public static void main(String[] args) throws IOException {
		
		String name;
		int kor, eng, mat, tot;
		double avg;
		
		
		Scanner sc = new Scanner (System.in); 
		
		System.out.print("이름, 국어, 영어, 수학 입력");   //Scanner  쓸 때는 , 대신 공백
		
		name =sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		tot= kor+eng+mat;
		avg = (double) tot/3;
   
	    
	    System.out.printf("이름=\"%s\",국어=%d,영어=%d,수학=%d,총점=%d,평균=%f ",name,kor,eng,mat,tot,avg );
	
	    
	    
	    
	    
		
		

	}

}
