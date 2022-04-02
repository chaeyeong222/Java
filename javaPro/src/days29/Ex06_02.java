package days29;

import javax.swing.JOptionPane;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 12:39:48
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		//main 스레드 한 개 뿐이다
		//더이상 진행하지 못하고 멈춰있는 것 :  블로킹  ( 창 띄우고 입력 전까지 멈춰있는 것)
		
		//입력용 대화상자를 띄워서 출력하는 스레드 만드는 코딩
		Thread t1 = new InputThread();
		t1.setName("input");
		t1.start();
		
		Thread t2 = new ForThread();
		t2.setName("for");
		t2.start();
		
		System.out.println("END");
	}//main

}//class

class ForThread extends Thread{
	@Override
	public void run() {
		String tName = Thread.currentThread().getName();
		
		for (int i = 0; i < 20; i++) {
			System.out.printf("[%s] - %d\n", tName, i);
			
			long millis = 1000; //1초
			try {
				Thread.sleep(millis); //현재 실행중인 스레드 재운다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}//run
}

class InputThread extends Thread{
	@Override
	public void run() {
		String tName = Thread.currentThread().getName();
		String inputData = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println(inputData);
	}
}

