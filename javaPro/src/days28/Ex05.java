package days28;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 이채영
 * @date 2022. 3. 29. - 오후 12:06:04
 * @subject 
 * @content 
 */
public class Ex05 {

	   public static void main(String[] args) {
		      // p 892  SequenceInputStream
		      // Sequence (순차적) + InputStream( 읽기용도의 바이트 스트림)
		      //  1. 여러 개의 입력 스트림을 연속적으로 연결해서 하나의 스트림으로 처리하고자 할 때 사용한다. 

		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf  ( 5개의 파일로 분리 )
		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.1
		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.2
		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.3
		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.4
		      // 자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.5
		      
		      try {
		         FileInputStream fis1 = new FileInputStream("자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.1");
		         /*
		         int b ;
		         while( (b = fis1.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         */
		         FileInputStream fis2 = new FileInputStream("자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.2"); 
		         /*
		         while( (b = fis2.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         */
		         FileInputStream fis3 = new FileInputStream("자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.3"); 
		         /*
		         while( (b = fis3.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         */
		         FileInputStream fis4 = new FileInputStream("자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.4"); 
		         /*
		         while( (b = fis4.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         */
		         
		         FileInputStream fis5 = new FileInputStream("자바 기반 모바일 융합 SW 개발자 양성 과정 개강 명단.pdf_.5"); 
		         /*
		         while( (b = fis5.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         */
		         
		         // List 인터페이스를 구현한 컬렉션 클래스 사용..
		         // ArrayList
		         Vector<FileInputStream>  vt = new Vector<>();
		         vt.addElement(fis1);
		         vt.addElement(fis2);
		         vt.addElement(fis3);
		         vt.addElement(fis4);
		         vt.addElement(fis5);
		         
		         Enumeration<FileInputStream>   en =  vt.elements();
		         
		         // 와일드 카드 
		         // <?>
		         // <? extends Employee>
		         // <? super Employee>
		         
		         // 제한된 제네릭
		         // <T extends Employee>
		         
		         // 분리된 파일을 합치는 코딩 - > SequenceInputStream 
		         //SequenceInputStream sis = new SequenceInputStream(    Enumeration<? extends InputStream> e)  ;
		         SequenceInputStream sis = new SequenceInputStream(    en   )  ;
		         int b ;
		         while( (b = sis.read() ) != -1 ) {
		            // 읽어와서 출력을 하든지, 파일로 저장
		         }
		         
		      } catch (FileNotFoundException e) { 
		         e.printStackTrace();
		      } catch (IOException e) { 
		         e.printStackTrace();
		      }
		   
		      
		      

		   } // main

		} // class

