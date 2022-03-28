package days27;
/**
 * @author 이채영
 * @date 2022. 3. 28. - 오전 11:28:29
 * @subject  p. 868 Chapter15 입출력
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		/*
		 * 1. 자바 입출력(Input/Output == IO)
		 * 2. 컴퓨터 내/외부의 장치 + 프로그램간에 데이터를 주고받는 것
		 *    예)   키보드 장치              ->    프로그램(Ex05.java)    -> 콘솔창
		 *                              데이터받기                           데이터주기
		 *                               입력                                     출력
		 * 3. 자바의 모든 입출력은 스트림Stream이라는 개념으로 이루어진다
		 * 4. 스트림 Stream
		 *    ㄱ. 빨대 ==스트림 객체
		 *    ㄴ. 단방향
		 *        읽기 스트림
		 *        쓰기 스트림
		 *    ㄷ. 스트림의 사전적의미 : 흐르는 물
		 * 
		 * 
		 * 5. 자바의 스트림은 2가지 종류 구분(대상) ***
		 *    ㄱ. 문자 (텍스트) 스트림
		 *        -읽기(입력용) 스트림 : 최상위 부모 클래스 Reader
		 *        -쓰기(출력용) 스트림 :                       Writer
		 *        - 유니코드 2바이트 ==1문자==2바이트(16비트)
		 *        - 한문자, 문자열, 문자배열
		 *      예 ) xxxReader, XXXWriter
		 *           BufferedReader, InputStreamReader, FileReader, FileWriter
		 *       
		 *    ㄴ. 바이트 스트림
		 *         -읽기(입력용) 스트림 : 최상위 부모 클래스 InputStream
		 *         -쓰기(출력용) 스트림 :                       OutputStream
		 *         -1바이트(8비트)
		 *         - 바이트, 바이트배열, 정수(int)
		 *       예 ) XXXInputStream XXXOutputStream
		 *                                           FileInputStream, FileOutputStream
		 *                                           
		 * 6. 보조스트림- 어떤 스트림을 더 사용(읽기쓰기)하기 쉽도록 보조해주는 스트림
		 *    예) BufferedReader 문자+ 보조+ 읽기용도의 스트림
		 *    BufferedReader br = new BufferedReader(New FileReader("a.txt") )
		 *    br.readLine(); 한 라인단위로 처리하기 쉽다
		 *    
		 *     New FileReader("a.txt") => 파일을 문자로 읽기위한 스트림
		 * 
		 */

	}

}
