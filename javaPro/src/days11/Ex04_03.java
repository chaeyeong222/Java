package days11;

/**
 * @author 이채영
 * @date 2022. 3. 3. - 오후 3:16:08
 * @subject 배열의 길이 변경 p.189
 * @content 
 */
public class Ex04_03 {

	public static void main(String[] args) {

		int [] m = new int [3];
		m[0]=100;
		m[1]=85;
		m[2]=93;
		
		//2개의 정수를 더 저장해야한다면?
		//m배열의 크기(길이)를 2개 더 증가(변경)
		
		{
			int [] temp = new int [5];
			for (int i=0;i<m.length;i++) {
				temp[i]= m[i];
			}
			m=temp;
		}
		m[3] = 80;
		disp(m);  //배열을 출력하는 함수
	}

	private static void disp(int[] m) {
		for(int i =0; i<m.length; i++) {
			System.out.printf("m[%d]=%d\n",i,m[i]);
			}
	}

}
