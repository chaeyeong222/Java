package days03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.util.DBconn;

public class Ex01 {

	public static void main(String[] args) {


		
		String fileName = ".\\src\\com\\util\\jdbc.properties";
		String url,user,password;
		
		System.out.println(System.getProperty("user.dir"));
		
		
		
		}//main

	}//class

/*



String sql = "SELECT *\r\n"
		+ "FROM departments\r\n"
		+ "WHERE manager_id is null ";

//Properties p = new Properties();

String className = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String password = "lion"; 

Statement stmt = null;
ResultSet rs = null;

ArrayList<DepartmentsDTO> departmentsList = null;
Connection conn = DBconn.getConnection(url, user, password);

try {
	
	Class.forName(className);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);

	if(rs.next()) {

		departmentsList = new ArrayList<DepartmentsDTO>();
		do {
			int DEPARTMENT_ID = rs.getInt(1);
			String DEPARTMENT_NAME = rs.getString(2);
			int MANAGER_ID = rs.getInt(3);
			int LOCATION_ID = rs.getInt(4);
			
			DepartmentsDTO dto = new DepartmentsDTO(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID);
			departmentsList.add(dto);
		}while(rs.next());		



		}else {
			System.out.println("찾는 값 없음");
		}




	} catch (SQLException e) { 
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}

	}


*/