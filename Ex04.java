package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

import days02.DeptDTO;

public class Ex04 {

	public static void main(String[] args) {
		//deptno, dname, empno, ename, hiredate, job, sal, comm, pay, grade 컬럼출력
		//ArrayList<> list
		//printEmp(list) {} 출력

		//preparedstatement 사용

		String sql = "  SELECT d.deptno, dname, empno, ename, hiredate, job, sal, comm,  sal+NVL(comm,0) pay, grade  "
				+ " FROM emp e JOIN dept d ON e.deptno= d.deptno   "
				+ "  JOIN salgrade s ON  sal BETWEEN losal AND  hisal  ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpdeptsalgradeDTO> list = null;
		EmpdeptsalgradeDTO dto = null;


		conn = DBconn.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();


			if(rs.next()) {
				list = new ArrayList<EmpdeptsalgradeDTO>();

				do {
					String dname = rs.getString("dname");
					String ename = rs.getString("ename");
					int grade = rs.getInt("grade");

					dto = new EmpdeptsalgradeDTO();
					dto.setDname(dname);
					dto.setEname(ename);
					dto.setGrade(grade);

					list.add(dto);
				}while(rs.next());

			}//if

		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}

		}

		DBconn.close();

		printEmp(list);

		System.out.println("end");

	}//main

	private static void printEmp(ArrayList<EmpdeptsalgradeDTO> list) { 

		Iterator<EmpdeptsalgradeDTO> ir = list.iterator();

		while (ir.hasNext()) {
			EmpdeptsalgradeDTO dto = ir.next();
			System.out.println(dto);
		}


	}
}//class 