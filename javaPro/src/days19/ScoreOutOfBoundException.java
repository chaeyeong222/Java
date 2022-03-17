package days19;

//사용자 정의 예외 클래스
public class ScoreOutOfBoundException extends Exception {

	//예외(에러) 코드 번호 나타내는 필드
	private final int ERROR_CODE;

	public int getERROR_CODE() {
		return ERROR_CODE;
	}
	
	public ScoreOutOfBoundException(int error_code) {
		this.ERROR_CODE = error_code;
	}
	public ScoreOutOfBoundException(String message) {
		super(message);
		this.ERROR_CODE =1004;
	}
	
	public ScoreOutOfBoundException(int error_code,String message) {
		super(message);
		this.ERROR_CODE = error_code;
	}
}
