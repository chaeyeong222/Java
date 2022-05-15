package days06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBconn;

public class Ex03 {

	public static void main(String[] args) { 
		/*
		아이디 empno []
		비밀번호 ename []	
		  [로그인][회원가입]
		*/
		
		System.out.println("로그인 체크할 ID(empno), PWD(ename)입력하세요");
		
		Scanner scan = new Scanner(System.in);
		int pempno = scan.nextInt();
		String pename = scan.next();
		
		Connection conn= null;
		CallableStatement cstmt = null;
		String sql = "{ call UP_LOGON(?,?,?)}";
		
		conn= DBconn.getConnection();
		
		try {
			cstmt = conn.prepareCall(sql);
			
			// ? in
			cstmt.setInt(1, pempno);
			//? out
			cstmt.setString(2, pename);
			
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.INTEGER);
			cstmt.executeQuery();
			int logonCheck = (int) cstmt.getObject(3);
			
			if (logonCheck == 0) {
				System.out.println("로그인 성공");
			} else if(logonCheck == 1){
				System.out.println("로그인 실패- id가 존재하지 않습니다");
			}else {//-1
				System.out.println("로그인 실패 - id는 존재, 잘못된 비밀번호 입니다");
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




/*
 * 7369 SMITH
 * 7499 ALLEN
 * 7521 WARD
 */