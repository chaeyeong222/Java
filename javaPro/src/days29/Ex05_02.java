package days29;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 이채영
 * @date 2022. 3. 30.
 * @subject 파일복사하는 코딩 + 버튼만들기
 * @content 
 */
public class Ex05_02 {

	  public static void main(String[] args) {
	       // 영화, 음악 다운로드 - 멜론
	      // main 스레드 ( 기본 스레드 )
     
		  
	      String originalPath ="C:\\Program Files (x86)\\EditPlus 3\\editplus.exe";
	      String copyPath= "C:\\Users\\redke\\OneDrive\\문서\\editplus.exe";
	      
	      FileCopy target = new FileCopy( originalPath, copyPath );
	      //Thread   파일복사일꾼 = new Thread(target);
	      //파일복사일꾼.start();
	      

	      System.out.println(" END ");
	   } // main

	} // class

	class FileCopy extends Frame  implements Runnable{

	   // 
	   private String originalPath;
	   private String copyPath;
	   
	   Button btnFileCopy; //파일복사하는 버튼
	   
	   public FileCopy(String originalPath, String copyPath) {
	       this.originalPath = originalPath;
	       this.copyPath = copyPath;
	       
	       // 
	       this.setTitle( this.originalPath +" 파일 복사 중...");
	       this.setSize(500, 100);
	       this.setVisible(true); //창 보이게
	       //닫기버튼 누르면 닫힘
	       this.addWindowListener( new WindowAdapter() {
	    	   
	          @Override //닫기버튼 누르면 프로그램 종료
	            public void windowClosing(WindowEvent e) {
	               System.out.println("> 프로그램 종료!!! <");
	               System.exit(-1);
	            }
	      });
	       
	       Thread   파일복사일꾼 = new Thread( this ); //자기자신의 객체
	       파일복사일꾼.setName("fcopy");
	       
	       this.btnFileCopy = new Button("File Copy"); //버튼생성
	       this.btnFileCopy.addActionListener( new ActionListener() { //클릭할때
	         @Override
	         public void actionPerformed(ActionEvent e) { 
	             // 스레드 start() 
	            System.out.println(" > 파일 복사 버튼을 클릭했습니다. 파일 복사 시작합니다~ ");
	            파일복사일꾼.start(); 
	         }
	      }  );
	       this.add(btnFileCopy); //버튼 추가
	   }  // 생성자

	   @Override
	   public void run() {
	       // 파일 복사(다운로드)하는 코딩..
	      // Ctrl + Shift + O
	      long start =    System.nanoTime();      
	      
	      File orignalFile = new File(this.originalPath);
	      System.out.println(  orignalFile.length() +" bytes");  // 2,385,496 bytes      
	      
	      FileInputStream fis = null;
	      FileOutputStream fos = null;
	      //
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	      // 
	      final int BUFFER_SIZE = 1024;
	      byte [] buffer = new byte[BUFFER_SIZE];
	      
	      try {
	         fis = new FileInputStream(orignalFile);// File
	         fos = new FileOutputStream(copyPath);  // String
	         // 보조스트림 사용
	         bis = new BufferedInputStream(fis, BUFFER_SIZE);
	         bos = new BufferedOutputStream(fos, BUFFER_SIZE);
	         
	         int readNumber = -1;  // 실제 읽어온 바이트 수를 저장할 변수
	         
	         while ( (   readNumber = bis.read( buffer )    ) != -1 ) {
	             bos.write(buffer, 0, readNumber);
	         }
	         bos.flush();
	         
	      } catch (FileNotFoundException e) { 
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            bis.close();
	            bos.close();
	            fis.close();
	            fos.close();
	         } catch (IOException e) { 
	            e.printStackTrace();
	         }
	      }
	      long end =    System.nanoTime();
	      
	      System.out.println( "> 처리 시간 : " + (end-start) + "ns" );
	
	   } // run
	   
	}

