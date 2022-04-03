package days29;
/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 2:37:37
 * @subject  p. 748 [표13-3]스레드의 상태
 * @content 
 * NEW : 스레드 생성 + start()X 인 상태
 * RUNNABLE : OS로부터 자원을 할당받아서 실행 중 or 실행대기 상태
 * TERMINATED  : 스레드 작업 종료
 * TIMED_WAITING : 일시정지기간이 설정된 경우 쉬고있을 때
 * BLOCKED : 블로킹 당한 것(ex. 창띄우고 입력받을때까지 정지)
 *                  동기화처리에 의해서 잠김(lock) 상태
 * WAITING : Object.wait() 메서드 -> 일시정지 -> Object.notify(), notifyAll()메서드
 */
public class Ex08 {

	public static void main(String[] args) {
		// sleep() RUNNABLE 상태 -> 일시정지상태(TIMED_WAITING ) -> 시간지나면 자동 빠져나옴
		// wait() 특정메서드로 호출해줘야지만 대기상태로 돌아올 수 있음.
		StatusWorker t1 = new StatusWorker();
		//t1 스레드는 생성했지만 t1.start는 호출하지 않은 상태
		//.getState() : 스레드의 상태를 가져올때 사용
		System.out.println(t1.getState()); //NEW

		t1.start();
		System.out.println(t1.getState()); //RUNNABLE

		try {
			Thread.sleep(3000);
			//3초 [실행대기상태에서 main스레드 일시정지, 3초후 자동 다시 실행대기로 돌아옴]
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//1) t1.run(){}처리+자동으로 스레드는 종료 //TERMINATED 
		//2) t1.은 5초동안 일시정지 상태   //TIMED_WAITING
		System.out.println(t1.getState()); 
		
		t1.interrupt();
		
		System.out.println("END");
	}//main

}//class

class StatusWorker extends Thread {
	@Override
	public void run() {

		System.out.println("1..");
		
		try {
			this.sleep(5000); //t1스레드 5초동안 일시 정지
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println(">>>InterruptedException예외..코딩");
		}

		System.out.println("2..");

	}//run
}//class