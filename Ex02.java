package days05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject [트랜잭션 처리 - 자바 jdbc]
 * @content 트랜잭션 처리x상태
 */
public class Ex02 {

	public static void main(String[] args) {
		//[트랜잭션 처리 - 자바 jdbc]
		//하나의 논리적인 작업 단위 모두 완료(성공) - 커밋
		//                   모두 완료 x - 롤백
		//예) 계좌이체
		//  1. A 돈 인출
		//  2. B 인출된 돈 입급
		
		// 1. dept 부서테이블 90/QC/SEOUL 추가 - 성공 -> 추가취소
		// 2. dept 부서테이블 90/XX/YY 추가 - 실패
		
		Connection conn = null;
		DBconn.getConnection();

		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		String sql = " INSERT INTO dept VALUES (?,?,? )   "; 
		
		try {
			// 1. dept 부서테이블 90/QC/SEOUL 추가 - 성공
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "QC");
			pstmt.setString(3, "SEOUL");
			rowCount = pstmt.executeUpdate();
			if(rowCount ==1) {
				System.out.println(" dept 부서테이블 90/QC/SEOUL 추가 - 성공 ");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "XX");
			pstmt.setString(3, "YY");
			rowCount = pstmt.executeUpdate();
			if(rowCount ==1) {
				System.out.println(" dept 부서테이블 90/XX/YY 추가 - 성공 ");
			}
			
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			 try {
				pstmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		
		
		DBconn.close();
		System.out.println("=END=");
		
		
	}//main

}//class
