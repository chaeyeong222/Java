package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject 프로젝트 때 참고할 사항
 * @content
 */
public class Ex05_03 {

	public static void main(String[] args) {
		 
		
		String sql = " SELECT grade , losal, hisal , COUNT(*) cnt "
					+ " FROM salgrade s JOIN emp e ON sal BETWEEN losal AND hisal "
					+ " GROUP BY grade , losal, hisal  "
					+ " ORDER BY grade ASC ";
		
		String empSql = "  SELECT  d.deptno, dname, empno,ename,sal "
						+ "            ,grade "
						+ " FROM dept d RIGHT JOIN emp e ON e.deptno= d.deptno "
						+ "             JOIN salgrade s ON  sal BETWEEN losal AND  hisal "
						+ "WHERE grade =   ? ";
		 // System.out.println(sql);
		 
		PreparedStatement pstmt = null, empPstmt=null;
		ResultSet rs = null, empRs = null;
		Connection conn = null;
		
		LinkedHashMap<SalgradeDTO,ArrayList<EmpdeptsalgradeDTO>> map = null;
		SalgradeDTO dto = null;//key
		ArrayList<EmpdeptsalgradeDTO> list = null;//value
		
		EmpdeptsalgradeDTO empDTO = null;
		 
		conn = DBconn.getConnection();
		
		try {
			
			map = new LinkedHashMap<>(); //생성위치 상관없음
			
			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			 
			if(rs.next()) { 
				list = new ArrayList< >();
				
				do {
					
					int grade = rs.getInt("grade");
					int hisal = rs.getInt("hisal");
					int losal = rs.getInt("losal");
					int cnt = rs.getInt("cnt"); 
					
					dto = new SalgradeDTO(grade, losal, hisal, cnt); //key
					 				 
				  
					//start
					// 20   RESEARCH   7369   SMITH   800
					
					
					empPstmt = conn.prepareStatement(empSql);
					//?
					empPstmt.setInt(1, grade);
					empRs = empPstmt.executeQuery();
					
					if (empRs.next()) {
						
						list = new ArrayList<EmpdeptsalgradeDTO>();
						
						
						do {
							int deptno = empRs.getInt(1);
							String dname = empRs.getString(2);
							int empno = empRs.getInt("empno");
							String ename = empRs.getString("ename");
							double sal = empRs.getDouble("sal");
							
							empDTO = new EmpdeptsalgradeDTO();
							empDTO.setDeptno(deptno);
							empDTO.setDname(dname);
							empDTO.setEmpno(empno);
							empDTO.setEname(ename);
							empDTO.setSal(sal);
							
							list.add(empDTO);
							 
						} while (empRs.next());
						
						
					} else {
						System.out.println("\t\t 사원이 존재하지 않는다.");
					}
					
					empPstmt.close();
					empRs.close();
					
					map.put(dto, list);
					
					  
					//end
							 
				}while(rs.next());
				
			}//if
			 
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			
		}
		 
		DBconn.close();
		


		 
		System.out.println("end");
	}//main

	private static void printsalgradeEmp(LinkedHashMap<SalgradeDTO, ArrayList<EmpdeptsalgradeDTO>> map) {
	 
		Set<Entry<SalgradeDTO, ArrayList<EmpdeptsalgradeDTO>>> es = map.entrySet();
		Iterator<Entry<SalgradeDTO, ArrayList<EmpdeptsalgradeDTO>>>ir = es.iterator();
		
		while (ir.hasNext()) {
			Map.Entry<SalgradeDTO,ArrayList<EmpdeptsalgradeDTO>> entry = ir.next();
			System.out.println(entry.getKey());
			
	        ArrayList<EmpdeptsalgradeDTO> list = entry.getValue();
	        // 30   SALES   7654   MARTIN   2650
	        Iterator<EmpdeptsalgradeDTO> vir = list.iterator();
	        while (vir.hasNext()) {
				EmpdeptsalgradeDTO dto = vir.next();
				System.out.printf("\t\t%d\t%s\t%d\t%s\t%.2f\n"
						, dto.getDeptno(), dto.getDname(), dto.getEmpno(), dto.getEname(), dto.getSal());
				
			}
	         
		}//while
	}

	 

}//class


/* days26.Ex01.java~~
 * key+value 함께 사용하는
 * map 이용해서 출력 -> 순서 유지되는 것 ㅣ linked
 * LinkHashMap< SalgradeDTO, ArrayList<EmpdeptsalgradeDTO> >
        [실행결과]
      1등급   (  700~1200 ) - 2명               SalgradeDTO(key)
        20   RESEARCH   7369   SMITH   800     ArrayList<empdept~DTO> list (value)
        30   SALES         7900   JAMES   950
      2등급   (   1201~1400 ) - 2명
         30   SALES   7654   MARTIN   2650
         30   SALES   7521   WARD      1750   
      3등급   (   1401~2000 ) - 2명
         30   SALES   7499   ALLEN      1900
         30   SALES   7844   TURNER   1500
      4등급   (   2001~3000 ) - 4명
         10   ACCOUNTING   7782   CLARK   2450
         20   RESEARCH   7902   FORD   3000
         20   RESEARCH   7566   JONES   2975
         30   SALES   7698   BLAKE   2850
      5등급   (   3001~9999 ) - 1명   
         10   ACCOUNTING   7839   KING   5000
       */

