package days05;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject CallableStatement sctmt = null; 저장 프로시저 사용
 * @content
 */
public class Ex03 {
 
	public static void main(String[] args) {
		//emp테이블에 사원을 추가하는 up_insertemp 저장프로시저를 선언   up_insertemp
		// CallableStatement 를 사용해서 사원 추가하는 코딩
		
		int empno = 9999;
		String ename = "admin";
		int mgr = 7369;
		int deptno =20;
		Date hiredate = new Date(1981,2,20);
		String sql = "{call up_insertemp(pempno=>?, pename=>?, pmgr => ?,pdeptno=>?, phiredate=>?)}";
		Connection conn = null;
		CallableStatement cstmt = null;
		int rowCount = 0;
		
		conn = DBconn.getConnection();

		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, mgr);
			cstmt.setInt(4, deptno);
			cstmt.setDate(5, hiredate);
			
			rowCount = cstmt.executeUpdate();
			
			if(rowCount==1) {
				System.out.println("사원추가완료");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DBconn.close();
		
		System.out.println("=end=");
	}//main

}//class
