package days11;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오후 3:16:08
 * @subject 배열의 길이 변경 p.189
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] m = new int [3];
		m[0]=100;
		m[1]=85;
		//배열 사용시 가장많이 발생하는 에러 : java.lang.ArrayIndexOutOfBoundsException
		//                                               배열+인덱스 가 범위에서 벗어났다.
		//m[3]=50;
		
		//현재 m에는 배열의 시작주소가 들어가있음
		//GC -자동메모리 관리/ 가비지 컬렉터
		m=null;
		disp(m);  //배열을 출력하는 함수
	}

	private static void disp(int[] m) {
		// TODO Auto-generated method stub
		for(int i =0; i<m.length; i++) {
			System.out.printf("m[%d=%d\n]",i,m[i]);
		}//m에 null값을 선언했으므로 주소값을 잃어버려 m[i]값 출력 불가
	}

}
