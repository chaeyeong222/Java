package days07;

import java.util.Scanner;

public class Ex09 {

		   public static void main(String[] args) {
			      //                                                     1        2        3  
			      // 배열의 초기화                                0        1        2
			      String [] rockPaperScissors =  { "가위", "바위", "보" };
			      
			      Scanner scanner = new Scanner(System.in);
			      int user, com;  // 2 , 1
			      char con ;  // y  n
			      
			      do {
			         com =   (int)(Math.random() * 3)+1;  // 랜덤하게 입력..      
			         System.out.println( "com = " + com );
			         System.out.printf("컴퓨터는 \"%s\"를 냈다.\n",  rockPaperScissors[com-1]  );
			         
			         String sUser;
			           String regex = "[1-3]";      
			         do {
			            System.out.print("> USER  가위(1)바위(2)보(3) 입력 ? ");
			            sUser = scanner.next();  
			         } while (  !sUser.matches(regex) );       
			         user = Integer.parseInt(sUser);
			         
			         // [1].  *** 숫자 1,2,3 유효성 검사를 한 후에 -> user 변수 저장           입력잘못된 경우 다시 사용자 입력
			         // [2]. com = 1 컴퓨터는 "가위"를 냈다.  ---------
			         // 3. 다시 게임할거니 ? y
			         
			         switch (   user - com ) {
			         case 0: 
			            System.out.println("사용자 와 컴퓨터는 비겼다.");
			            break;
			         case 1: case -2 : 
			            System.out.println("사용자 이겼다.");
			            break;
			         default: 
			            System.out.println("컴퓨터 이겼다.");
			            break;
			         } // switch 
			         
			         System.out.print("> 가위바위보 게임 계속 할래 ? ");
			         con = scanner.next().charAt(0);  // 'y'    'n'
			      } while (   con == 'y' || con == 'Y' );
			      
			      
			      
			      System.out.println(" 게임 종료!!! ");

			   } // main

			} // class
