package days01;
/**
 * @author 채영
 * @date
 * @subject
 * @content
 */
public class Ex01 {
	public static void main(String[] args) {
		
		
		/*
		 * 1. JDBC
		 *   ㄱ. Java DataBase Connectivity
		 *   ㄴ. 자바 표준 인터페이스 - DBMS 연동 + 작업 (CRUD)
		 *   ㄷ. Database 연동 기술 
		 * 2. Java 응용 프로그램   +  오라클 DBMS 연동
		 *                    JDBC
		 *     ㄱ.오라클사에서 JDBC를 구현한 드라이버(driver)가 OracleDriver 다운받아야한다
		 *     ㄴ. ojcbc6.jar 파일이  OracleDriver 이다.
		 * 3. JCBC Driver?
		 *    MySQL
		 *    MS SQL
		 *    Oracle
		 *    
		 * 4. JDBC Driver 종류
		 *   ㄱ. Type1 - ODBC Driver 브릿지 사용 연동
		 *   ㄴ. Type2 - Native Library C, C++로 만든 라이브러리로 db연동
		 *   ㄷ. Type3 - 미들웨어 서버 
		 *   ㄹ. Type4 - Thin 드라이버, 순수 자바 만들어짐 DBMS 직접 연결, 가장많이 사용된다.****
		 *   
		 * 5. DBMS 연결(Connection)하는 순서  ***암기  Ex02.java파일 추가
		 *   1) Class.forName() 드라이버(JDBC Driver) 로딩
		 *   2) DriverManager 클래스의 getConnection() 메서드를 사용해서 Connection 객체를 얻어온다.
		 *      어떤 DB서버 연결
		 *      어떤 계정
		 *      계정 비밀번호
		 *      포트
		 *      등등
		 *   3) 필요한(질의응답) 작업 - CRUD
		 *   4) 연결종료(Connection 객체 close)
		 *    
		 */
	}//main

}//class
