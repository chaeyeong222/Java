package days02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

public class Ex04 {

	public static void main(String[] args) { 
		//부서번호 입력받아서 해당 부서원의 정보 출력
		//ArrayList<EmpDTO> list 
		// printEmp(ArrayList) 메서드 출력
		Connection conn = null;
		ResultSet rs = null;		
		Statement stmt = null;
		int pdeptno = 10; //숫자 상관없음 초기값 설정해둔 것
		ArrayList<EmpDTO> empList = null;
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("부서입력");
		pdeptno = scan.nextInt();
		
		
		String sql = "SELECT *\r\n"
				+ "   FROM emp "
				+ "WHERE deptno=" + pdeptno;
		 
		
		conn =  DBconn.getConnection();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				empList = new ArrayList<EmpDTO>();
				do {
					int empno = rs.getInt(1);
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate = rs.getDate("hiredate");
					Double sal = rs.getDouble("sal");
					Double comm = rs.getDouble("comm");
					pdeptno = rs.getInt("deptno");
					
					EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, pdeptno );
					empList.add(dto);
					
				} while (rs.next());
			}//if 
 	
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		DBconn.close();
        printEmp(empList);
		
		System.out.println("end");
		

	}//main

	private static void printEmp(ArrayList<EmpDTO> empList) {
		
		if(empList ==null) {
			System.out.println("사원존재x");
			return;
		}//if
			
		 
		Iterator<EmpDTO> ir = empList.iterator();
		
		while (ir.hasNext()) {
			EmpDTO dto =   ir.next();
			System.out.println(dto); //toString() 오버라이딩 해야함 (원하는 형태로 출력 위해서)
		}//while
		
	}//printEmp
}//class
