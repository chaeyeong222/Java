package days14;
/**
 * @author 이채영
 * @date 2022. 3. 8. - 오후 3:08:31
 * @subject p. 219 가변배열
 * @content 
 *            2차원 이상의 배열 = 다차원배열   -> 배열의 배열
 *            마지막 차수의 길이를 지정하지 않고, 추후 각기 다른 길이의 배열을 선언할 수 있다(배열의 유연성) 
 */
public class Ex03 {

	public static void main(String[] args) {
		// 3반이 있는데 각 반마다 인원수가 다를 때

		String [][] names = new String[3][];

		names[0] = new String[25];
		names[1] = new String[30];
		names[2] = new String[19];
		
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names[i].length; j++) {
				System.out.printf("[%d]", names[i][j]);
			}System.out.println();
		}
	}

}
