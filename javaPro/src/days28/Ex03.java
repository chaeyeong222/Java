package days28;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * @author 이채영
 * @date 2022. 3. 29. - 오전 10:32:41
 * @subject  p. 874 바이트 스트림
 * @content  바이트 배열을 다루는 메모리 스트림
 *                   메모리스트림을 만드는 이유? 성능(읽기,쓰기)이 좋음
 *                   ByteArrayInputStream (읽기)
 *                   ByteArrayOutputStream( 쓰기) 
 *                   
 *                   데이터 담긴 바이트배열
 *                   옮겨닮을 바이트배열 
 *                   try catch 문 이용
 *                   바이트배열스트림에 원래데이터를 담고 출력할 것 선언
 *                   데이터 읽어와서 쓴다
 *                   
 */
public class Ex03 {

	public static void main(String[] args) {
		byte [] insrc = {0,1,2,3,4,5,6,7,8,9};
		byte [] outsrc = null;

		try (ByteArrayInputStream bais = new ByteArrayInputStream(insrc);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();){

			int b;
			while( (b=	bais.read()) !=-1) {
				baos.write(b);
			}//while

			outsrc = baos.toByteArray(); //새롭게 바이트배열에 할당하는 함수
			System.out.println(Arrays.toString(outsrc));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
