package days06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBconn;

public class Ex02 {

	public static void main(String[] args) {

		System.out.println("중복체크할 id(empno) 입력");
		Scanner scan = new Scanner(System.in);
		int pempno = scan.nextInt();
		
		Connection conn= null;
		CallableStatement cstmt = null;
		String sql = "{ call UP_IDCHECK2(?,?)}";
		
		conn= DBconn.getConnection();
		
		try {
			cstmt = conn.prepareCall(sql);
			
			// ? in
			cstmt.setInt(1, pempno);
			//? out
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.INTEGER);
			
			cstmt.executeQuery();
			int idCheck = (int) cstmt.getObject(2); //1사용x 0사용o
			
			if (idCheck == 0) {
				System.out.println("사용 가능한 id 입니다");
			} else {
				System.out.println("이미 사용중인 id 입니다");

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
		System.out.println("end");

	}//main

}//class
