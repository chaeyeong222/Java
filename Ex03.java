package days02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject 
 * @content 1. dept 테이블의 모든 부서정보를 가져와서 ArrayList 컬렉션 클래스에 저장
 *          2. 부서정보를 출력하는 메서드
 *              printDept(ArrayList list) {
 *                //부서정보 출력
 *              } 
 */
public class Ex03 {

	public static void main(String[] args) {
		String sql = "SELECT *"
				+ " FROM dept";
		Statement stmt = null;
		ResultSet rs = null;
		//ArrayList<Student> list
		ArrayList<DeptDTO> deptList = null;

		Connection conn =  DBconn.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);



			if (rs.next()) {
				deptList = new ArrayList<DeptDTO>();
				do {
					int deptno = rs.getInt(1);
					String dname = rs.getString(2);
					String loc =  rs.getString(3);
					//System.out.printf("%d\t%s\t%s\n",deptno, dname, loc);--> Arraylist에 저장
					//DTO
					//계층(layer)간에 데이터 저장 + 전송 객체
					DeptDTO dto = new DeptDTO(deptno, dname, loc);
					deptList.add(dto);


				}while(rs.next());

			}else {
				System.out.println("부서존재x");
			}

		} catch (SQLException e) { 
			e.printStackTrace();
		}finally{
			//***** 닫는 작업 매우 중요
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}//try 
		DBconn.close();
		
		//ArrayList 출력
		printDept(deptList);
		
		System.out.println("end");

	}//main

	private static void printDept(ArrayList<DeptDTO> deptList) { 
		
		Iterator<DeptDTO> ir = deptList.iterator();
		
		while (ir.hasNext()) {
			DeptDTO dto = ir.next(); //형변환 필요없음 다운캐스팅 안해도됨
			System.out.println(dto);
		}//while
	}//printDept

}//class
