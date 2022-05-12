package days03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

import days02.DeptDTO;

/**
 * @author 채영
 * @date
 * @subject PreparedStatement 설명 **앞으로 이거 사용
 * @content -하나의 PreparedStatement 객체로 쿼리를 여러번 처리할 수 있다.(재사용)
 *             
 */
public class Ex02 {

	private static Connection conn=null; 
	private static String[] menus = {
			"부서 조회",
			"부서 추가",
			"부서 수정",
			"부서 삭제",
			"부서 검색",
			"종료"
	};
	private static int selectedNumber; //static은 프로그램 종료까지 살아있다
	private static Scanner scan = new Scanner(System.in);
	private static char _continue = 'Y';

	public static void main(String[] args) { 

		conn = DBconn.getConnection(); //DB open(연결성공)

		while(true) { //무한루프
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
			sql += "WHERE dname LIKE ? ";
		}else if(searchCondition==2) {
			//sql +="WHERE loc LIKE ?";
			sql += " WHERE regexp_like(loc, ?,'i')";
		}else if(searchCondition==3) {
			sql +="WHERE dname LIKE ? OR loc LIKE ?";
		} 
		sql += "ORDER BY deptno ASC";
 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//ArrayList<Student> list
		ArrayList<DeptDTO> deptList = null;


		try {
			pstmt = conn.prepareStatement(sql);
			
			//?파라미터 설정 but, 123 선택 시에 달라짐
			
			searchWord = "%" + searchWord +"%";
			
			if(searchCondition==3) {
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
			}else {
				pstmt.setString(1, searchWord);
			}
			
			rs = pstmt.executeQuery();

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
				pstmt.close();
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
 
		String sql = "DELETE FROM dept WHERE deptno = ? ";
		System.out.println(sql);

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//파라미터 설정***
			pstmt.setInt(1,pdeptno);
			int rowCount = pstmt.executeUpdate();

			if(rowCount ==1) {
				System.out.println("1개부서 삭제완료");
			}

		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
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

		//String sql = String.format(
		//		" UPDATE dept"
		//				+ " SET dname = '%s', loc ='%s' "
		//				+ " WHERE deptno = %d" 
		//				, pdname, ploc, pdeptno);
		String sql = " UPDATE dept SET dname = ? , loc = ? WHERE deptno = ? "; 
		
		System.out.println(sql);
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			//stmt =  conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pdname);
			pstmt.setString(2, ploc);
			pstmt.setInt(3, pdeptno);
			
			//int rowCount= stmt.executeUpdate(sql); //DML문
			int rowCount = pstmt.executeUpdate();
			//암기, 자동으로 커밋된다 AutoCommit

			if(rowCount ==1) {
				System.out.println("1개부서 수정 완료");
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
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
			//String sql= String.format("INSERT INTO dept(deptno, dname, loc) VALUES ( seq_dept.NEXTVAL , '%s' ,'%s' )"
			//		,pdname, ploc);
			//System.out.println(sql);
			
			//바인딩변수는 날짜, 문자.. 에 홑따옴표 안씀 그냥 ? 만
			String sql = " INSERT INTO dept(deptno, dname, loc) VALUES ( seq_dept.NEXTVAL ,? ,? )"; 
			
			//Statement stmt = null;
			PreparedStatement pstmt = null;

			try {
				//stmt =  conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				//에러메세지: java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
				// ?,? 파라미터(매개변수) 값을 설정하고 나서 executeUpdate()
				pstmt.setString(1, pdname);
				pstmt.setString(2, ploc);
				
				//int rowCount= stmt.executeUpdate(sql); //DML문 
				int rowCount = pstmt.executeUpdate();
				//암기, 자동으로 커밋된다 AutoCommit

				if(rowCount ==1) {
					System.out.println("1개부서 추가완료");
				}
			} catch (SQLException e) { 
				e.printStackTrace();
				//seq_dept 새로 동적으로 50번부터 시작할 수 있도록 생성하는 작업(동적쿼리 수행작업)
				
			}finally {
				try { 
					pstmt.close();				} catch (SQLException e) { 
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
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		//ArrayList<Student> list
		ArrayList<DeptDTO> deptList = null;


		try {
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql); //재사용할거라서 미리 쿼리 담고있음
			
			//rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery(); //주의 여기에는 sql안담김

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
				//stmt.close();
				pstmt.close();
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
