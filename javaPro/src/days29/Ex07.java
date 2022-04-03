package days29;
/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 2:19:35
 * @subject 
 * @content 
 *  완벽하게 10-9-8-.. 순서로 종료되지 않음, 
 *    우선권만 준 거지 관리는 os가 하기때문
 */
public class Ex07 {

	public static void main(String[] args) {
		//p738.스레드의 우선순위
		//   ㄴ멀티스레드 :os 자동관리 ( 자원CPU..할당)
		//   ㄴ 우선권(priority) 설정      -setPriority(1~10)  기본값:5
		//   ㄴ   10(우선권 제일 높은 값)
		// 10 의미-> 특정 스레드가 더 많은 작업시간을 갖도록 하는 설정.
		PriorityWorker [] t = new PriorityWorker[10];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new PriorityWorker();
			t[i].setName("t"+(i+1));   // t1, t1,   t10
			t[i].setPriority(i+1);         //  1   2     10
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}

	}

} 

class PriorityWorker extends Thread{
	 @Override
	 public void run() {
		 String tName = this.getName(); //스레드 이름
		int tPriority =  this.getPriority();//1 ~ 10
		for (int i = 0; i < 10000; i++) {
			try {
				this.sleep(1); //다른 스레드에게 실행상태를 넘기겠다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.printf("%s 스레드 : 우선권[%d] 종료 \n",tName, tPriority);
	 }//run
}