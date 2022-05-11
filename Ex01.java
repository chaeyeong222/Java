package days02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {

	public static void main(String[] args) {
	
		
		
		
		
		

	}//main

}//class
/*
 
 1. 동적 쿼리를 사용하는 저장 프로시저 작성하세요.  ( 5분 )
     ㄱ. 커서변수 사용
     ㄴ. open ~ for 문 사용
     ㄷ. 프로시저 안에서  출력까지 하세요.
     ㄹ. deptno 를 파라미터로 해서 emp 테이블의
         deptno, ename, hiredate 를 출력하는 저장 프로시저 작성.
         
         
   CREATE OR REPLACE PROCEDURE up_selEmp
   (
   pdeptno emp.deptno%type
   )      
   IS      
     vdeptno emp.deptno%type;
     vename emp.ename%type;
     vhiredate emp.hiredate%type;
     vcursor SYS_REFCURSOR;
     
     vsql varchar2(1000);
   BEGIN
        vsql := ' SELECT * ';
        vsql := vsql || '  FROM emp ' ;
      
       OPEN vcursor FOR vsql USING pdeptno;
       
       LOOP 
          FETCH vcursor INTO vdeptno, vename, vhiredate;
          EXIT WHEN vcursor%NOTFOUND;
          DBMS_OUTPUT.PUT_LINE( vdeptno ||',' || vename ||','|| vhiredate    );
       END LOOP;
       
         CLOSE vcursor;
   END;
 
 2-1. JDBC 설명하세요.                                         ( 5분 )
      - 자바 데이터 베이스 연동 기술
      - java database connectivity의 약자
      - 자바 표준 인터페이스 : 추상메서드, 상수 + 
      
 2-2. JDBC Driver 설명하세요.
      dbms (오라클, ms..) 연동하기위해 jdbc 구현한 라이브러리(드라이버)
      Oracle : jdbc driver 벤더(회사) 다운 ojdbc6.jar --> 오라클 11g
 2-3. JDBC Driver 종류 설명하세요.
     4가지 type으로 구분가능
       type1  거의 사용 안함, odbc 드라이버 브릿지 연동
       type2 c,c#에서 이용, native library
       type3 미들웨어 서버, 사용x
       type4 가장 많이 사용하는 것, Thin 드라이버, dbms 직접 연결  
 
 3. JDBC를 사용해서 DB에 연결( Connect ) 하는 순서에 대해 설명하세요.  ( 5분 )
      1) Class.forName() 드라이버를 로딩한다
      2) DriverManager의 getConnection() 메서드를 이용해서 객체와 연결한다
      3) 필요한 질의응답을 작성한다
      4) 연결을 종료한다.
      
 4. 위의 순서에 맞춰서 오라클서버에 scott/tiger 로 DB에 연결하는             ( 15분 )
      전체 코딩을 main() 메서드에 하시고, 연결된 Connection 객체 정보
      를  출력하고  Connection 객체 연결 상태를 true, false로 출력하는 코딩을 하세요. 
      
      	String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String password= "tiger";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println(conn);
			System.out.println(conn.isClosed());
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
      
      
      

 5. 부서번호를 입력받아서 해당 부서의 모든 사원 정보를 출력     ?에러남                    ( 15분 )
   ( 조건 :
      ㄱ. 모든 컬럼 출력
      ㄴ. 이름 순으로 오름차순정렬 
   )     
   
String className = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String password= "tiger";
		Connection conn = null;
		
		String sql = "  SELECT *\r\n"
				+ "   FROM emp\r\n"
				+ "   where deptno =10\r\n"
				+ "   order by ename;   ";
		
		 Statement stmt = null;
		
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
			
				do {
					int empno = rs.getInt(1);
					String ename = rs.getString(2);
					String job  = rs.getString(3);
					int mgr  = rs.getInt(4);
					
					System.out.printf("%d\t%s\t%s\t%d",empno,ename,job,mgr);
					
						
				}while(rs.next());
				
			}//if
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		

   
    
 * 
 */