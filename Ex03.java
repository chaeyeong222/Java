package days01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 채영
 * @date
 * @subject DB연동 +  필요한 작업 CRUD
 * @content 
 *           dept테이블의 부서 정보 조회
 */
public class Ex03 {

	 public static void main(String[] args) {

	      // DB 연동 순서      
	      
	      String className = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "SCOTT";
	      String password = "tiger";
	      Connection conn = null;
	      
	      String sql = "SELECT * FROM dept";
	      
	      /*
	        
	       Connection 객체 conn을 사용해서 생성한다.
	      ㄱ. Statement           - 기본 객체
	      ㄴ. PreparedStatement   - ? 바인딩 변수를 사용해서 쿼리 실행
	      ㄷ. CallableStatement   - 저장 프로시저를 호출해서 쿼리 실행
	      */
	      
	      Statement stmt = null;
	            
	      try {
	         // 1. Class.forName() JDBC Driver 로딩 + (ojdbc6.jar 참조)
	         Class.forName(className);
	         // 2. DriverManager.getConnection() 커넥션 객체를 얻어온다 + 연결문자열(url, user, password)
	         conn = DriverManager.getConnection(url, user, password);
	         // 3. 필요한 작업 - CRUD
	         stmt = conn.createStatement();
	         
	         ResultSet rs = stmt.executeQuery(sql);      // SELECT (DQL문)
	         // stmt.executeUpdate(sql);  // INSERT, UPDATE, DELETE(DML문)
	         
	         if(rs.next()) {   // ResultSet 안에 다음 레코드가 있니?
	            // 다음 레코드를 읽어와서 출력
	            int deptno = rs.getInt(1);
	            String dname = rs.getString("dname"); //칼럼명 입력가능, 그냥 2라고 써도 됨.
	            String loc = rs.getString("loc");
	            
	            System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
	            
	         } else {
	            System.out.println("읽을 레코드는 없습니다.");
	         }
	         
	         
	         if(rs.next()) {   // ResultSet 안에 다음 레코드가 있니?
	            // 다음 레코드를 읽어와서 출력
	            int deptno = rs.getInt(1);
	            String dname = rs.getString("dname");
	            String loc = rs.getString("loc");
	            
	            System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
	            
	         } else {
	            System.out.println("읽을 레코드는 없습니다.");
	         }
	         
	         
	         if(rs.next()) {   // ResultSet 안에 다음 레코드가 있니?
	            // 다음 레코드를 읽어와서 출력
	            int deptno = rs.getInt(1);
	            String dname = rs.getString("dname");
	            String loc = rs.getString("loc");
	            
	            System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
	            
	         } else {
	            System.out.println("읽을 레코드는 없습니다.");
	         }
	         
	         
	         if(rs.next()) {   // ResultSet 안에 다음 레코드가 있니?
	            // 다음 레코드를 읽어와서 출력
	            int deptno = rs.getInt(1);
	            String dname = rs.getString("dname");
	            String loc = rs.getString("loc");
	            
	            System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
	            
	         } else {
	            System.out.println("읽을 레코드는 없습니다.");
	         }
	         
	         
	         if(rs.next()) {   // ResultSet 안에 다음 레코드가 있니?
	            // 다음 레코드를 읽어와서 출력
	            int deptno = rs.getInt(1);
	            String dname = rs.getString("dname");
	            String loc = rs.getString("loc");
	            
	            System.out.printf("%d\t%s\t%s\n", deptno, dname, loc);
	            
	         } else {
	            System.out.println("읽을 레코드는 없습니다.");
	         }
	         
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	      }
	        catch (SQLException e) {
	          e.printStackTrace();
	      } finally {
	         try {
	            stmt.close();
	            
	            // 4 close
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         
	      }
	      
	      System.out.println("END");
	      
	      
	      
	   } // main
	 
	} // class