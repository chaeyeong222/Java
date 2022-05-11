package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBconn;

public class Ex02 {

	public static void main(String[] args) {
	
		//클래스 라이브러리 생성 :com.util.BDconn.java
		//hr, lion
		
//		com.util 패키지 안에 파일 추가 : ConnectionString.properties
		
		
		
		/*
		Connection conn  = DBconn.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","lion");
		System.out.println(conn); 
		DBconn.close();
		*/
 		
		/*
		Connection conn  = DBconn.getConnection();
		System.out.println(conn);
//		System.out.println(conn.isClosed());
		DBconn.close();
		
		
		conn  = DBconn.getConnection();
		System.out.println(conn);
//		System.out.println(conn.isClosed());
		DBconn.close();
		
		System.out.println("end");
		
		*/
	}//main

}//class


/*
 * 
 * 	//문제5 새로코딩


		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String password="tiger";

		Connection conn = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("부서번호를 입력하세요");
		int deptno = scan.nextInt();

		String sql = "SELECT * "
				+ " FROM emp "
				+ " WHERE deptno =" + deptno 
				+"ORDER BY ename ASC";

		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);


			if(rs.next()) {

				do {
					int empno = rs.getInt(1);
					String ename = rs.getString(2);
					String job = rs.getString(3);
					int mgr = rs.getInt("mgr");   
					String hiredate = rs.getString(5);
					double sal = rs.getDouble("sal");
					double comm = rs.getDouble(7);
					deptno = rs.getInt(8);
					System.out.printf("%d\t%s\t%s\t%d\t%s\t%.2f\t%.2f\t%d\n"
							, empno, ename,job, mgr, hiredate, sal, comm, deptno);
				}while(rs.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
 
 */
