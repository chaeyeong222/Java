package days06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject 리플랙션 reflection
 * @content - 반사, 반영, 상
 *  		- ResultSet 결과물에 대한 정보 추출해서 사용할 수 있는 기술
 */
public class Ex04 {

	public static void main(String[] args) {

		String sql = " SELECT table_name "
				+ "FROM tabs "
				+ "ORDER BY table_name ASC  ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String tableName = null; //테이블명 저장할 변수

		conn = DBconn.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int no = 1;
			while (rs.next()) {
				tableName = rs.getString(1);
				System.out.printf("%d. %s\n",no++, tableName);
			}//while
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

		System.out.print("테이블명 입력하세요");
		Scanner scan= new Scanner(System.in);
		tableName = scan.next();

		//***** 테이블명, 컬럼명은 ?(바인딩 변수) 사용할 수 없다. *****
		//java.sql.SQLSyntaxErrorException: ORA-00903: invalid table name
		/*
		 sql = " SELECT *"
		 		+ " FROM ? ";
		 */
		sql = " SELECT *"
				+ " FROM  " + tableName;	


		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, tableName);
			rs = pstmt.executeQuery();

			/*
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);

			} 
			 */
			//특정 테이블이 어떤 칼럼, 컬럼 자료형, 컬럼개수 모를 때 reflection 사용한다
			// => ResultSet 으로 부터 정보를 얻어와서 사용하는 기술

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			//System.out.println("걸럼갯수 : "  columnCount);
			//2. 컬럼명 정보
			/*
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				String columnTypeName = rsmd.getColumnTypeName(i);
				int columnType = rsmd.getColumnType(i);
				int scale = rsmd.getScale(i);
				int precision = rsmd.getPrecision(i);
				System.out.printf("%s - %s(%d) -%d,%d\n"
						,columnName,columnTypeName,columnType,scale, precision);
			}//for
			 */
			System.out.println("-------------------------------");
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%s\t", rsmd.getColumnName(i));
			}//for
			System.out.println("\n-------------------------------");

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {

					int scale =rsmd.getScale(i);
					int columnType = rsmd.getColumnType(i); 
					//2 number  93 date   12varchar2   scale>0 실수

					if (columnType ==2 && scale ==0 ) {
						System.out.printf("%d\t",rs.getInt(i));
					} else if (columnType ==2 && scale !=0 ){
						System.out.printf("%.2f\t",rs.getDouble(i));
					}else if (columnType ==93){
						System.out.printf("%.tF\t",rs.getDate(i));
					}else if (columnType ==12){
						System.out.printf("%s\t",rs.getString(i));
					}
				}System.out.println();
			}

			System.out.println("\n-------------------------------");

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
		System.out.println("=end=");
	}//main

}//class
