package days29;

import javax.swing.JOptionPane;

/**
 * @author 이채영
 * @date 2022. 3. 30. - 오후 12:39:48
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		//main 스레드 한 개 뿐이다
		//더이상 진행하지 못하고 멈춰있는 것 :  블로킹  ( 창 띄우고 입력 전까지 멈춰있는 것)
		
		//입력용 대화상자를 띄워서 출력하는 스레드 만드는 코딩
		String inputData = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println(inputData);
		System.out.println("END");
	}

}
