package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBconn;

public class Ex05 {

	public static void main(String[] args) {
		String sql = "{ call up_deleteDept( ? ) }";
		// 1. up_deleteDept 저장 프로시저 생성
		// 2. Ex04.java 복사 붙이기 수정

		Connection conn = null;
		CallableStatement cstmt = null; 

		conn = DBconn.getConnection();
		int rowCount = 0 ;
		try { 
			cstmt =  conn.prepareCall(sql);
			cstmt.setInt(1,  90 ); 
			rowCount = cstmt.executeUpdate();
			if (rowCount == 1 ) {
				System.out.println("> 부서 삭제 성공!!!");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				//DBConn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}

		DBconn.close();

	} // main

}//class
