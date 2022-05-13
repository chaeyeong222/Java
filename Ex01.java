package days04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

import days04.board.BoardController;
import days04.board.BoardDAO;
import days04.board.BoardDAOImpl;
import days04.board.BoardService;

public class Ex01 {
	public static void main(String[] args) {
		//모델2방식의 mvc 패턴으로 개발
		//1. tbl_cstvsboard 게시판 테이블 생성
		//2. days04.board.BoardDTO 
		//3. days04.board.BoardDAO 인터페이스 선언
		// -DAO (data access object)
		// -편리성, 보안성
		//4. days04.board.BoardDAOImpl
		//5. BoardDAOImpl.select() 메서드 구현-> DAO 객체의 select() 메서드 단위 테스트
		//  - dayso4.board.test 패키지 추가
		//  - BoardDAOImplTest 클래스 
		//6. days04.board.BoardService 클래스 추가
		//7. days04.board.test.BoardServiceTest.java
		//8. BoardController 요청-> 처리-> 응답
		//                  메뉴선택 ->처리 -> boardService ->boardDAO -> 콘솔출력
		
		
		Connection conn = DBconn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao );
		BoardController controller = new BoardController(service );
		
		controller.start();
		
		//[게시물 목록]
		//    글쓰기 버튼 클릭 -> 새 정보 입력
		//                     [저장]
		//[게시글 상세보기]
		// 게시글 목록 에서 보고자하는 게시글 제목 클릭하면 -> 글번호-> 상세 게시글 정보 출력
		// 글번호의 조회수 readed 컬럼 1 증가
		// 글번호의 게시글 정보를 BoardDTO에 담아서 반환하는 메서드 만들어야함
		//[게시글 수정] 	//[게시글 삭제]
		//9. 삭제
		//  1) 삭제할 게시글 번호를 입력? 2
		//  2)
		// 게시글상세보기 -> 삭제 -> 게시글 목록
	}//main


}//class

/*

1. 아래와 같이 출력되도록 코딩하세요.    
       ㄱ. 각 부서별 정렬 및 부서 소속 사원수 출력
       ㄴ. 각 부서별 소속된 사원 정보 출력
          ( 조건: sal 많이 받는 순으로 정렬해서 번호 붙여서 출력 )

	[실행 결과]
	deptno(dname) 
	10(ACCOUNTING) - 3명
	  등수  empno   ename   sal
		1	7698	BLAKE	2850.0
		   z
		   z
		   z
		   z
	    2	7499	ALLEN	1600.0
	    3	7844	TURNER	1500.0
	20(RESEARCH) - 3명 
		1	7698	BLAKE	2850.0
	    2	7499	ALLEN	1600.0
	    3	7844	TURNER	1500.0
	30(SALES) - 6명
	    1	7698	BLAKE	2850.0
	    2	7499	ALLEN	1600.0
	    3	7844	TURNER	1500.0
	    4	7521	WARD	1250.0
	    4	7654	MARTIN	1250.0
	    6	7900	JAMES	950.0
	40(OPERATIONS) - 0명
	     사원이 존재하지 않습니다.





	     public static void main(String[] args) {
		String sql = " SELECT  e.deptno, dname, COUNT(*) cnt "
				+ "FROM dept d JOIN emp e ON d.deptno = e.deptno "
				+ "GROUP BY e.deptno, dname "
				+ "ORDER BY e.deptno  ";

		String sql2 = "SELECT deptno, empno, ename, sal ,RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) rank  "
				+ "FROM emp;"; 


		PreparedStatement pstmt = null, empPstmt = null;
		ResultSet rs = null, empRs = null;
		Connection conn = null;

		ArrayList<deptRankDTO> list = null;
		deptRankDTO dto =  null;
		ArrayList<empRankDTO> emplist = null;

		conn = DBconn.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();


			if(rs.next()) {

				list = new ArrayList<deptRankDTO>();
				do {

					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					int cnt = rs.getInt("cnt");

					dto =  new deptRankDTO(deptno, dname, cnt);
					list.add(dto);

					System.out.printf("%d( %s) - %d명", deptno, dname, cnt);

					empPstmt = conn.prepareStatement(sql2);
					empRs = empPstmt.executeQuery();

					if(empRs.next()) {

						do {
							int rank = empRs.getInt("rank");
							int empno = empRs.getInt("empno");
							String ename = empRs.getString("ename");
							double sal = empRs.getDouble("sal");

							System.out.printf("%d\t%d\t%s\t%.2f\n",rank,empno, ename, sal);

						} while (empRs.next());



					}else {
						System.out.println("사원이 존재하지 않습니다.");
					}


				} while (rs.next());





			}






		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}





		DBconn.close();


		printrank(list);



	}//main

	private static void printrank(ArrayList<deptRankDTO> list) {
		Iterator<deptRankDTO> ir = list.iterator();
		while (ir.hasNext()) {
			deptRankDTO dto =  ir.next();
			System.out.println(dto);
		}
	}



















 */


