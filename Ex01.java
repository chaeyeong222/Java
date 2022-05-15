package days06;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

import days02.EmpDTO;

public class Ex01 {

	public static void main(String[] args) {

		//Statement stmt = null;
		//PreparedStatement pstmt = null;
		//CallableStatement cstmt = null;
		//emp테이블에서 deptno를 파라미터로 입력받아서 사원정보 반환하는 저장프로시저
		
		System.out.print("부서번호 deptno 입력");
		Scanner scan = new Scanner(System.in);
		int pdeptno = scan.nextInt();
		//if 10/20/30/40 체크 
		String sql = "{call UP_SELECTEMP(?,?)}";
		
		Connection conn = null;
		CallableStatement cstmt =null;
		ResultSet rs = null;
		ArrayList<EmpDTO> list= null;
		EmpDTO dto = null;
		
		DBconn.getConnection();
		
		try {
			cstmt= conn.prepareCall(sql);
			cstmt.setInt(1, pdeptno);
			
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR );
			cstmt.executeQuery();
			rs = (ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				list = new ArrayList<EmpDTO>();
				
				do {
					dto = new EmpDTO();
					dto.setEmpno(rs.getInt("empno"));
					dto.setEname(rs.getString("ename"));
					dto.setHiredate(rs.getDate("hiredate"));
					dto.setDeptno(rs.getInt("deptno"));
					 
					list.add(dto);
				} while (rs.next());
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				cstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} 
		
		DBconn.close(); 
		
		printEmp(list);
		
		System.out.println("end");
		
	}//main

	private static void printEmp(ArrayList<EmpDTO> list) { 
		
		if(list==null) {
			System.out.println("사원x");
		}else {
		Iterator<EmpDTO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpDTO dto =  ir.next();
			System.out.println(dto);
		}}
	}//printEmp

}//class
