package days29;

import java.util.Iterator;

public class Ex10 {

	public static void main(String[] args) {
		//멀티 스레드[문제점만파악] 해결 나중에..동기화처리
		//인쇄기 [공유자원]
		// Lock : 하나의 스레드가 점유중일때 다른 스레드는 대기 
		// DeadLock :하나의 스레드가 점유하면서 죽어버리면 다른 스레드는 끝까지 사용x
	
		PrintMachine machine = new PrintMachine();
		
		PrintWorker t1 = new PrintWorker("박예린", machine);
		PrintWorker t2 = new PrintWorker("백경환", machine);
		PrintWorker t3 = new PrintWorker("안시은", machine);
		PrintWorker t4 = new PrintWorker("함세강", machine);
		PrintWorker t5 = new PrintWorker("유환재", machine);
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
		//결과물 : [[[***박백유안함세시경예환린환강재은*******]]
	}//main

}//class

//인쇄하는 일꾼
class PrintWorker extends Thread{
	String content;  //인쇄할 내용물
	
	PrintMachine machine;//인쇄기

	//생성자 의존성 주입 - dipendency injection(DI)
	public PrintWorker(String content, PrintMachine machine) {
		super();
		this.content = content;
		this.machine = machine;
	}
	@Override
	public void run() {
		this.machine.printContent(content); //잠금처리(lock)
		
	}

}

class PrintMachine {

	public void printContent(String content) {  //"홍길동"
		// [***홍길동***] 인쇄
		
		try {
			System.out.print("[");
			Thread.sleep(500); //일시정지해서 다른데로 제어 넘긴다
			System.out.print("***");
			Thread.sleep(500);
			for (int i = 0; i < content.length(); i++) {
				System.out.print(content.charAt(i));
				Thread.sleep(200);
			}
			System.out.print("***");
			Thread.sleep(500);
			System.out.print("]");
			System.out.println(); //개행
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}