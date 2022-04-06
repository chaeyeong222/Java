package days29;

import javax.swing.JOptionPane;
/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 4:40:00
 * @subject 예제 13-14
 * @content 
 */
public class Ex11_02 {

	public static void main(String[] args) {

		ThreadWorker02 t = new ThreadWorker02();
		t.start();

		String inputData = JOptionPane.showInputDialog("아무값이나 입력");
		System.out.println(inputData);
		t.interrupt();
		System.out.println(t.isInterrupted());
		System.out.println("main end");

	}

}
class ThreadWorker02 extends Thread{

	@Override
	public void run() {
		int k=10;
		while( k !=0 && !isInterrupted()) { //!false = true
			System.out.println("-");
			try {
				this.sleep(1000);
			} catch (InterruptedException e) { //자동으로 interrupted상태 ->초기화 false값
				//e.printStackTrace();
				this.interrupt(); //false -> true변경(추가)
			}
		}System.out.println("스레드 작업 중지");
	}
}