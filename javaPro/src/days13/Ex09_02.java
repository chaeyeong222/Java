package days13;

import java.awt.DisplayMode;
import java.util.Random;
import java.util.Scanner;

public class Ex09_02 {

	   public static void main(String[] args) {
	       
		      // 동적 배열
		      int [][] lottos ; // 배열 선언
		      int gameNumber = 1;
		      Scanner scanner = new Scanner(System.in);      
		      System.out.print("> 게임 회수 입력 ? ");
		      gameNumber = scanner.nextInt();      
		      
		      lottos = new int[gameNumber][6];      
		      
		      // **** [p 216 그림 5-5] 반드시 이해할 것 ****
		      // 2차원 배열 로또번호 채워넣는 코딩
		      for (int i = 0; i < gameNumber ; i++) {
		         fillLottoOne(lottos[i]);  // score[1]
		      }
		      
		      // 출력
		      for (int i = 0; i < gameNumber ; i++) {
		         System.out.printf("%d 로또번호 : " , (i+1)); 
		         dispLottoOne(lottos[i]);
		      }
		   } // main
		   
		   // days09.Ex04_02.java 파일 안에 코딩 그대로 복사 (단, 이름만 One 붙여서 수정)
		   public static boolean isDuplicateLotto(int [] lotto, int idx, int temp) {
		      boolean flag = false;
		      for (int i = 0; i < idx; i++) {
		         if( temp == lotto[i]) {
		            flag = true;
		            break;
		         }
		      }
		      return flag;
		   }
		   
		   private static void dispLottoOne(int[] lotto) { 
		      for (int i = 0; i < lotto.length; i++) {
		           System.out.printf("[%d]", lotto[i]);
		      }
		      System.out.println();  
		   }  
		   
		   private static void fillLottoOne(int[] lotto) { 
		      Random  rnd = new Random();      
		        int idx = 0;      
		      while(  idx <= 5 ) { 
		         int temp = rnd.nextInt(45) + 1;  
		         if( !isDuplicateLotto(lotto, idx, temp)   ) {
		            lotto[idx++] = temp;
		         } 
		      } 
		   }
		 
		} // class
