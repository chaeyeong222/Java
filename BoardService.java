package days04.board;

import java.sql.SQLException;
import java.util.ArrayList;

//BoardController -> BoardService -> BoardDAOImpl -> 오라클서버
//
public class BoardService {


	private BoardDAO dao = null;

	//1.생성자DI
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}
	//2. setter DI
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	//1. 게시글 목록 서비스 메서드
	public ArrayList<BoardDTO> selectService(){
		ArrayList<BoardDTO> list = null;


		try {
			//1. 로그 기록 서비스
			System.out.println(">게시글 목록 조회 -> 로그 기록 작업..");
			//2. 게시글 목록 
			list = this.dao.select();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list;
	}
	//1-1. 게시글 목록 서비스 메서드 + 페이징 처리 추가
	public ArrayList<BoardDTO> selectService(int currentPage, int numberPerPage){
		ArrayList<BoardDTO> list = null;


		try {
			//1. 로그 기록 서비스
			System.out.println(">게시글 목록 조회 -> 로그 기록 작업..");
			//2. 게시글 목록 
			list = this.dao.select(currentPage, numberPerPage);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list;
	}

	//2. 게시글 추가 서비스 메서드
	public int insertService(BoardDTO dto) {
		int rowCount = 0;

		try {
			//트랜잭션 처리 시작
			//1. 로그 기록 서비스
			System.out.println(">게시글 추가 -> 로그 기록 작업..");
			//2. 게시글 추가
			rowCount = this.dao.insert(dto);
			//3. 작성자 포인트 1 증가
			//this.dao.updatePoint(작성자);
			//트랜잭션 처리 종료
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}



	//3. 게시글 상세보기 메서드
	public BoardDTO viewService( int seq ) {
		BoardDTO dto = null;
		try {
			//트랜젝션 시작
			((BoardDAOImpl) this.dao).getConn().setAutoCommit(false);
			//1. 조회수 증가
			this.dao.increaseReaded(seq);
			//2. 게시글 정보
			dto = this.dao.view(seq);
			//3. 
			System.out.println(">게시글 상세보기 -> 로그 기록 작업.. ");
			((BoardDAOImpl )this.dao).getConn().commit();
			//트랜잭션 종료
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return dto;
	}

	//4. 게시글 삭제 메서드
	public int deleteService(int seq) {
		int rowCount = 0; 
		try {
			//트랜젝션 시작
			rowCount = dao.delete(seq);
			//3. 
			System.out.println(">게시글 삭제 -> 로그 기록 작업.. ");
			//트랜잭션 종료
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return rowCount;
	}
	public int updateService(BoardDTO dto) { 
		int rowCount = 0; 
		try {
			//트랜젝션 시작
			rowCount = dao.update(dto); 
			System.out.println(">게시글수정 -> 로그 기록 작업.. ");
			//트랜잭션 종료
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return rowCount;
	}
	public ArrayList<BoardDTO> searchService(int searchCondition, String searchWord) {
		//selectService () 메서드 모든 코딩 복사+붙이기
		ArrayList<BoardDTO> list = null;


		try {
			//1. 로그 기록 서비스
			System.out.println(">게시글 검색 목록 조회-> 로그 기록 작업..");
			//2. 게시글 목록 
			list = this.dao.search(searchCondition, searchWord);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list;
	}
	
	public String pageService(int currentPage, int numberPerPage, int numberOfPageBlock) { 
		String pagingBlock = "\t\t";


		try {
			//int totalRecords = this.dao.getTotalRecords();
			int totalPages = this.dao.getTotalPages(numberPerPage);
			int startOfPageBlock = 1;
			int endOfPageBlock ;

			startOfPageBlock = (currentPage-1)/numberOfPageBlock *numberOfPageBlock+1;
			endOfPageBlock = startOfPageBlock + numberOfPageBlock-1;
			if(endOfPageBlock > totalPages) endOfPageBlock = totalPages;

			if(startOfPageBlock != 1 ) pagingBlock += "< "; 
			for (int j = startOfPageBlock; j <= endOfPageBlock; j++) {
				pagingBlock += String.format(j==currentPage?"[%d] ":"%d ",j);
			}

			if(endOfPageBlock != totalPages ) pagingBlock +=">";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return pagingBlock;



	}
	//
	public ArrayList<BoardDTO> searchService(int currentPage, int numberPerPage, int searchCondition,
			String searchWord) { 
		ArrayList<BoardDTO> list = null;


		try {
			//1. 로그 기록 서비스
			System.out.println(">게시글 검색 목록 조회-> 로그 기록 작업..");
			//2. 게시글 목록 
			list = this.dao.search(currentPage,numberPerPage, searchCondition, searchWord);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list;
	}
	public String pageService(int currentPage, int numberPerPage, int numberOfPageBlock, int searchCondition,
			String searchWord) { 
		
		String pagingBlock = "\t\t";


		try {
			//int totalRecords = this.dao.getTotalRecords();
			int totalPages = this.dao.getTotalPages(numberPerPage, searchCondition,searchWord );//검색된 결과의 총페이지수 반환
			int startOfPageBlock = 1;
			int endOfPageBlock ;

			startOfPageBlock = (currentPage-1)/numberOfPageBlock *numberOfPageBlock+1;
			endOfPageBlock = startOfPageBlock + numberOfPageBlock-1;
			if(endOfPageBlock > totalPages) endOfPageBlock = totalPages;

			if(startOfPageBlock != 1 ) pagingBlock += "< "; 
			for (int j = startOfPageBlock; j <= endOfPageBlock; j++) {
				pagingBlock += String.format(j==currentPage?"[%d] ":"%d ",j);
			}

			if(endOfPageBlock != totalPages ) pagingBlock +=">";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return pagingBlock;
	}

}//class