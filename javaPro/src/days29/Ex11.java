package days29;

import javax.swing.JOptionPane;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 3:52:57
 * @subject 
 * @content 
 */
public class Ex11 {

	public static void main(String[] args) {
		// p.752 스레드의 [작업을 취소하는 메서드]
		//interrupt()   : 스레드 작업 취소 !요청!만 한다 -> 실제 종료x
		//                      interrupted 상태만을 false->true로 변경
		//       개발자가 코딩으로  interrupted 상태가 변경되었는지만 체크한다면 스레드 종료시킬 수 있다.
		//interrupted()  :  
		ThreadWorker t = new ThreadWorker();
		t.start();
		
		String inputData = JOptionPane.showInputDialog("아무값이나 입력");
		System.out.println(inputData);
		t.interrupt();

	}

}
class ThreadWorker extends Thread{
	
	@Override
	public void run() {
		int k=10;
		//isInterrupted() : Interrupted상태를 반환하는 메서드 true,false
		while( k !=0 && !isInterrupted()) {
			System.out.println("-");
		//	this.sleep(1000); //실행스레드-> 일시정지
			//처리되는 시간...(지연시간) -> 오랫동안 일 하게끔
			for (long i = 0; i < 25000000000L; i++) {
				
			}
		}System.out.println("스레드 작업 중지");
	}
}