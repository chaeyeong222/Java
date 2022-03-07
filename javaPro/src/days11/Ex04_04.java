package days11;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오후 3:16:08
 * @subject 배열의 길이 변경하는 메서드 선언 +호출 p.189
 * @content 
 *                  1. 기능 - 배열의 크기를 원하는 길이만큼 증가시키는 메서드 increaseArraySize
 *                  2. 매개변수 - int [] m(원래 배열명), int 증가할 배열 크기
 *                  3. 리턴값(리턴자료형) - x void
 */
public class Ex04_04 {

	public static void main(String[] args) {

		int [] m = new int [3];
		m[0]=100;
		m[1]=85;
		m[2]=93;

		//2개의 정수를 더 저장해야한다면?
		//m배열의 크기(길이)를 2개 더 증가(변경)

		m= increaseArraySize(m,5);
		
		m[3] = 80;
		disp(m);  //배열을 출력하는 함수

	}

	public static int[] increaseArraySize(int[] m, int n) {

		int [] temp = new int [m.length + n];
		for (int i=0;i<m.length;i++) {
			temp[i]= m[i];
		}
		m=temp; //메인함수의 값은 그대로임 증가된 추소값을 메인함수가 참조하도록 해야함.
		return temp;
	}

	private static void disp(int[] m) {
		for(int i =0; i<m.length; i++) {
			System.out.printf("m[%d]=%d\n",i,m[i]);
		}
	}

}
