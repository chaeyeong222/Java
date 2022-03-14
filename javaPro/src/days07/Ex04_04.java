package days07;

import java.io.IOException;
import java.util.Scanner;

public class Ex04_04 {

	public static void main(String[] args) throws IOException {
		//스캐너 사용해도 될까? yes. 단, scan.next 말고 scan.nextLine 사용
		
		int lineNumber = 1;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i =0; i<=255; i++) {
			if(i%10 == 0) System.out.printf("%d : ", lineNumber++);
			System.out.printf("[%c]", i); 
			if(i%10==9) {
				System.out.println();
				if(lineNumber % 10==1) {
				System.out.print("> 계속하려면 엔터 치세요");
			    //scan.next( ); //일시정지     -> 문자를 입력하고 엔터쳐야지 이어짐. 
			    
			    /*Finds and returns the next complete token from this scanner.
			     * A complete token is prceded and followed by input that matches the delimiter pattern.
			     * This method may block while waiting for inputto scan, 
			     * even if a previous invocation of hasNext returned true.
			     */
			    scan.nextLine();
			    /*
					Advances this scanner past the current line and returns the input that was skipped.
					This method returns the rest of the current line, excluding any lines eparator at the end. 
					The position is set to the beginning of the next line. 
					Since this method continues to search through the input looking for a line separator, 
					it may buffer all of the input searching for the line to skip if no line separators are present.
					Returns:the line that was skippedThrows:NoSuchElementException 
					- if no line was foundIllegalStateException - if this scanner is closed
			     * 
			     */
				}	
			}
		}
		
	}//main

}//class
