package days02;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject
 * @content 메뉴처리 예제
        //DQL문
		//DML문
		//dept 테이블에 DQL문, DML문 사용하는 예제
 */
public class Ex05 {

	private static Connection conn=null;
	private static String[] menus = {
			"부서 조회",
			"부서 추가",
			"부서 수정",
			"부서 삭제",
			"부서 검색",
			"종료"
	};
	private static int selectedNumber;
	private static Scanner scan = new Scanner(System.in);
	private static char _continue = 'Y';

	public static void main(String[] args) { 

		conn = DBconn.getConnection();

		while(true) {
			메뉴출력();
			메뉴선택();
			메뉴처리();


		}//while

	}//main


	private static void 메뉴출력() { 
		System.out.println("메뉴출력");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s\n",(i+1), menus[i] );
		}//for

	}//메뉴출력



	private static void 메뉴선택() { 
		System.out.print("메뉴선택하세요");
		selectedNumber =  scan.nextInt();
	}//메뉴선택

	private static void 메뉴처리() { 

		switch (selectedNumber) {
		case 1: //조회	
			selectAllDept();
			break;
		case 2: //추가	
			insertDept();
            break;
		case 3: //수정	
			updateDept();
			break;
		case 4: //삭제
			deleteDept();
			break;
		case 5: //검색
			searchDept();
			break;
		case 6: //종료
			exit();
			break;
		default:
			break;
		}

	}//메뉴처리

	private static void searchDept() {
      //검색조건 1. 부서명, 2 지역명, 3 부서명 또는 지역명
	  // 검색어 : "O"
	  //SELECT 조회
		System.out.println("[검색조건선택]");
		System.out.println("1.부서명");
		System.out.println("2.지역명");
		System.out.println("3.부서명 + 지역명");
		
		System.out.println("검색조건 선택하세요");
		int searchCondition = scan.nextInt();
		
		System.out.println("검색어를 입력하세요");
		String searchWord = scan.next();
		
		
		String sql = "SELECT *"
				+ " FROM dept ";

		if(searchCondition==1) {
			sql += String.format("WHERE dname LIKE '%%%s%%'", searchWord);
		}else if(searchCondition==2) {
			sql += String.format("WHERE loc LIKE '%%%s%%'", searchWord);
		}else if(searchCondition==3) {
			sql += String.format("WHERE dname LIKE '%%%1$s%%' OR loc LIKE '%%%1$s%%'", searchWord);
		} 
		sql += "ORDER BY deptno ASC";
		
		Statement stmt = null;
		ResultSet rs = null;
		//ArrayList<Student> list
		ArrayList<DeptDTO> deptList = null;


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

		//java.sql.SQLRecoverableException: 접속 종료
		//DBconn.close();

		//ArrayList 출력
		printDept(deptList);

		일시정지();
	 
	}//searchDept


	private static void deleteDept() { 
		System.out.println("삭제할 부서번호 deptno 입력");
		int pdeptno = scan.nextInt();
		
		String sql = String.format(
				"DELETE "
				+ "FROM dept "
				+ "WHERE deptno ='%d'", pdeptno);
		System.out.println(sql);
		
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			int rowCount = stmt.executeUpdate(sql);
			
			if(rowCount ==1) {
				System.out.println("1개부서 삭제완료");
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		일시정지();
	}//deleteDept


	private static void updateDept() {

		System.out.println("수정할 부서번호 deptno 입력");
		int pdeptno = scan.nextInt();
		System.out.println("수정할 부서명, 지역명 입력");
		String pdname = scan.next();
		String ploc = scan.next();
		
		String sql = String.format(
				" UPDATE dept"
				+ " SET dname = '%s', loc ='%s' "
				+ " WHERE deptno = %d" 
				, pdname, ploc, pdeptno);
		System.out.println(sql);
		Statement stmt = null;

		try {
			stmt =  conn.createStatement();
			int rowCount= stmt.executeUpdate(sql); //DML문
			//암기, 자동으로 커밋된다 AutoCommit

			if(rowCount ==1) {
				System.out.println("1개부서 수정 완료");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}//try
		}//try

		일시정지();
	}//updateDept


	//부서 추가
	private static void insertDept() { 

		do {
			//deptno, dname, loc
			System.out.println("[부서정보입력]");
			System.out.print("1.부서명 입력");
			String pdname = scan.next();
			System.out.print("2.지역명 입력");
			String ploc=  scan.next();

			//String sql="INSERT INTO dept(deptno, dname, loc) VALUES ( seq_dept.NEXTVAL"+pdname+","+ploc+")";
			String sql= String.format("INSERT INTO dept(deptno, dname, loc) VALUES ( seq_dept.NEXTVAL , '%s' ,'%s' )"
					,pdname, ploc);
			//System.out.println(sql);

			Statement stmt = null;

			try {
				stmt =  conn.createStatement();
				int rowCount= stmt.executeUpdate(sql); //DML문
				//암기, 자동으로 커밋된다 AutoCommit

				if(rowCount ==1) {
					System.out.println("1개부서 추가완료");
				}
			} catch (SQLException e) { 
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}//try
			}//try

			계속여부확인();
		}while(Character.toUpperCase(_continue)=='Y');

		일시정지();


	}//insertDept


	

	private static void 계속여부확인() {
		System.out.println("계속할거니?");
		try {
			_continue = (char)System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}


	//모든 부서 정보 조회
	private static void selectAllDept() {  

		String sql = "SELECT *"
				+ " FROM dept "
				+ "ORDER BY deptno ASC";
		Statement stmt = null;
		ResultSet rs = null;
		//ArrayList<Student> list
		ArrayList<DeptDTO> deptList = null;


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

		//java.sql.SQLRecoverableException: 접속 종료
		//DBconn.close();

		//ArrayList 출력
		printDept(deptList);

		일시정지();

	}//selectAllDept

	private static void 일시정지() {
		System.out.println("\t\t 엔터치면 계속합니다.");
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//일시정지



	private static void printDept(ArrayList<DeptDTO> deptList) { 

		System.out.println("----------------------");
		System.out.printf("%s\t%s\t%s\n","DEPTNO","DNAME","LOC");
		System.out.println("----------------------");


		if(deptList ==null) {
			System.out.println("부서존재x"); 
		}
		Iterator<DeptDTO> ir = deptList.iterator();

		while (ir.hasNext()) {
			DeptDTO dto = ir.next(); //형변환 필요없음 다운캐스팅 안해도됨
			System.out.println(dto);

		}//while
		System.out.println("----------------------");
	}//printDept


	private static void exit() { 

		System.out.println("프로그램 종료됩니다");
		DBconn.close();//db닫기
		System.exit(-1); //임의의 값 넣어줘서 종료시키기

	}//exit



}//class
