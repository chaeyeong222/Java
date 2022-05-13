package days04.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAOImpl implements BoardDAO {
	//필드
	private Connection conn= null;
	private PreparedStatement pstmt = null;
	private ResultSet rs =  null;

	//생성자
	public BoardDAOImpl() {	}

	//1.생성자를 통해서 의존성 주입(DI)
	public BoardDAOImpl(Connection conn) {	
		this.conn=conn;
	}
	//2. setter를 통해서 의존성 주입(DI)
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Connection getConn() {
		return conn;
	}

	@Override
	public ArrayList<BoardDTO> select() throws SQLException {

		ArrayList<BoardDTO> list= null;
		BoardDTO dto = null;
		
		int seq;
		String writer;
		String email;
		String title;
		Date writedate;
		int readed;
		
		
		String sql = "SELECT seq, writer, email, title, readed, writedate "
					+ "FROM tbl_cstvsboard "
					+ "ORDER BY seq DESC  ";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		
		if(this.rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				
				seq = this.rs.getInt("seq");
				writer = this.rs.getString("writer");
				email = this.rs.getString("email");
				title =this.rs.getString("title");
				writedate = this.rs.getDate("writedate");
				readed = this.rs.getInt("readed");
				
				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				
				
				list.add(dto);
				
			} while (this.rs.next());
		}//if
		
		this.rs.close();
		this.pstmt.close();

		return list;
	}
	@Override
	public ArrayList<BoardDTO> select(int currentPage, int numberPerPage) throws SQLException {

		ArrayList<BoardDTO> list= null;
		BoardDTO dto = null;
		
		int seq;
		String writer;
		String email;
		String title;
		Date writedate;
		int readed;
		
		int begin = (currentPage -1)*numberPerPage +1; 
		int end = begin + numberPerPage -1	;
		
		
		String sql = "SELECT * "
				+ "FROM (  "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM ( "
				+ "        SELECT seq,  writer, email, title, readed , writedate   "
				+ "        FROM tbl_cstvsboard   "
				+ "        ORDER BY seq DESC "
				+ "    ) t "
				+ ") m "
				+ "WHERE m.no BETWEEN   ?  AND ?  ";
		
		this.pstmt = this.conn.prepareStatement(sql);
		//"WHERE m.no BETWEEN   ?  AND ?  ";
		this.pstmt.setInt(1, begin);
		this.pstmt.setInt(2, end);
		this.rs = this.pstmt.executeQuery();
		
		if(this.rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				
				seq = this.rs.getInt("seq");
				writer = this.rs.getString("writer");
				email = this.rs.getString("email");
				title =this.rs.getString("title");
				writedate = this.rs.getDate("writedate");
				readed = this.rs.getInt("readed");
				
				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				
				
				list.add(dto);
				
			} while (this.rs.next());
		}//if
		
		this.rs.close();
		this.pstmt.close();

		return list;
	}

	@Override
	public int insert(BoardDTO dto) throws SQLException {
		int rowCount = 0;
		String sql = " INSERT INTO tbl_cstvsboard(seq, writer,pwd, email, title,tag,content) "
					+ "VALUES (seq_tbl_cstvsboard.NEXTVAL, ?,?,?,?,?,?) ";
		
		this.pstmt = this.conn.prepareStatement(sql);
		//writer,pwd, email, title,tag,content
		//?,?,?,?,?,? 파라미터 설정
		this.pstmt.setString(1, dto.getWriter());
		this.pstmt.setString(2, dto.getPwd());
		this.pstmt.setString(3, dto.getEmail());
		this.pstmt.setString(4, dto.getTitle());
		this.pstmt.setInt(5, dto.getTag());
		this.pstmt.setString(6, dto.getContent());
		
		rowCount = this.pstmt.executeUpdate(); //자동커밋
	 
		
		this.pstmt.close();
		return rowCount;
	}

	@Override
	public void increaseReaded(int seq) throws SQLException {
		String sql = "UPDATE tbl_cstvsboard "
				+ "SET readed = readed +1 "
				+ "WHERE seq = ? "; 
		this.pstmt= this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq); //WHERE seq = ?	
		int rowCount = this.pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public BoardDTO view(int seq) throws SQLException {
		 
		String sql = " SELECT seq, writer, email, title, readed, writedate, content "
					+ " FROM tbl_cstvsboard "
					+ " WHERE seq = ?  ";
		this.pstmt= this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq); //WHERE seq = ?	
		this.rs = this.pstmt.executeQuery();
		
		BoardDTO dto = null;
		
		if(this.rs.next()) {
			dto = new BoardDTO();
			dto.setSeq(seq);
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(this.rs.getString("email"));
			dto.setTitle(this.rs.getString("title"));
			dto.setReaded(this.rs.getInt("readed"));
			dto.setWritedate(this.rs.getDate("writedate"));
			dto.setContent(this.rs.getString("content"));
			
		}
		
		this.rs.close();
		this.pstmt.close();
		return dto;
	}

	@Override
	public int delete(int seq) throws SQLException { 
		
		String sql = "DELETE FROM tbl_cstvsboard "
						+ "WHERE seq = ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq);
		int rowCount = this.pstmt.executeUpdate();  
		this.pstmt.close(); 

		return rowCount;
	}

	//seq, title, email, content 
	@Override
	public int update(BoardDTO dto) throws SQLException {
		String sql = "UPDATE tbl_cstvsboard "
				+ "SET email = ?, title=?, content =? "
				+ "WHERE seq = ? ";
		int rowCount= 0;
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dto.getEmail());
		this.pstmt.setString(2, dto.getTitle());
		this.pstmt.setString(3, dto.getContent());
		this.pstmt.setInt(4, dto.getSeq());
		rowCount = this.pstmt.executeUpdate();
				
		
		this.pstmt.close();
		
		return rowCount;
	}

	@Override
	public ArrayList<BoardDTO> search(int searchCondition, String searchWord) throws SQLException {
		 //select() 메서드의 모든 코딩 복사+붙이기
		ArrayList<BoardDTO> list= null;
		BoardDTO dto = null;
		
		int seq;
		String writer;
		String email;
		String title;
		Date writedate;
		int readed;
		
		
		String sql = "SELECT seq, writer, email, title, readed, writedate "
					+ "FROM tbl_cstvsboard ";
		switch (searchCondition) {
		case 1: //제목검색
			sql += "WHERE REGEXP_LIKE(title,?,'i') ";
			break;
		case 2: //내용검색
			sql += "WHERE REGEXP_LIKE(content,?,'i') ";
			break;
		case 3: //작성자검색
			sql += "WHERE REGEXP_LIKE(writer,?,'i') ";
			break;
		case 4: //제목+내용검색
			sql += "WHERE REGEXP_LIKE(title,?,'i') OR REGEXP_LIKE(content,?,'i') ";
			break; 
		}
			sql	+= "ORDER BY seq DESC  ";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, searchWord); //1234
		if(searchCondition ==4) 
			this.pstmt.setString(2, searchWord);
		this.rs = this.pstmt.executeQuery();
		
		if(this.rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				
				seq = this.rs.getInt("seq");
				writer = this.rs.getString("writer");
				email = this.rs.getString("email");
				title =this.rs.getString("title");
				writedate = this.rs.getDate("writedate");
				readed = this.rs.getInt("readed");
				
				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				
				
				list.add(dto);
				
			} while (this.rs.next());
		}//if
		
		this.rs.close();
		this.pstmt.close();

		return list;
	}

	@Override
	public int getTotalRecords() throws SQLException { 
		String sql = " SELECT COUNT(*) "
					+ " FROM tbl_cstvsboard ";
		int totalRecords = 0;
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();
		
		this.rs.next();
		totalRecords = rs.getInt(1);
		
		this.rs.close();
		this.pstmt.close();
		
		return totalRecords;
	}

	@Override
	public int getTotalPages( int numberPerPage) throws SQLException { 
		String sql = " SELECT CEIL( COUNT(*)/? ) "
				+ " FROM tbl_cstvsboard ";
		int totalPages = 0;
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, numberPerPage);
		this.rs = this.pstmt.executeQuery();
		
		this.rs.next();
		totalPages = rs.getInt(1);
		
		this.rs.close();
		this.pstmt.close();
		
		
		return totalPages;
	}

	@Override
	public ArrayList<BoardDTO> search(int currentPage, int numberPerPage, int searchCondition, String searchWord)throws SQLException{
		ArrayList<BoardDTO> list= null;
		BoardDTO dto = null;
		
		int seq;
		String writer;
		String email;
		String title;
		Date writedate;
		int readed;
		
		int begin = (currentPage -1)*numberPerPage +1; 
		int end = begin + numberPerPage -1	;
		
		
		String sql = "SELECT * "
				+ "FROM (  "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM ( "
				+ "        SELECT seq,  writer, email, title, readed , writedate   "
				+ "        FROM tbl_cstvsboard   ";
				
				switch (searchCondition) {
				case 1: //제목검색
					sql += "WHERE REGEXP_LIKE(title,?,'i') ";
					break;
				case 2: //내용검색
					sql += "WHERE REGEXP_LIKE(content,?,'i') ";
					break;
				case 3: //작성자검색
					sql += "WHERE REGEXP_LIKE(writer,?,'i') ";
					break;
				case 4: //제목+내용검색
					sql += "WHERE REGEXP_LIKE(title,?,'i') OR REGEXP_LIKE(content,?,'i') ";
					break; 
				} 
				sql += "        ORDER BY seq DESC "
				+ "    ) t "
				+ ") m "
				+ "WHERE m.no BETWEEN   ?  AND ?  ";
			
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, searchWord);
		
		if(searchCondition ==4) {
			this.pstmt.setInt(3, begin);
			this.pstmt.setInt(4, end);
		}else {
			this.pstmt.setInt(2, begin);
			this.pstmt.setInt(3, end);
		}
		  
		this.rs = this.pstmt.executeQuery();
		
		if(this.rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				
				seq = this.rs.getInt("seq");
				writer = this.rs.getString("writer");
				email = this.rs.getString("email");
				title =this.rs.getString("title");
				writedate = this.rs.getDate("writedate");
				readed = this.rs.getInt("readed");
				
				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				
				
				list.add(dto);
				
			} while (this.rs.next());
		}//if
		
		this.rs.close();
		this.pstmt.close();

		return list;
	}

	//검색된 총 페이지 수 반환하는 메서드
	@Override
	public int getTotalPages(int numberPerPage, int searchCondition, String searchWord) throws SQLException {
		String sql = " SELECT CEIL( COUNT(*)/? ) "
				+ " FROM tbl_cstvsboard ";
		switch (searchCondition) {
		case 1: //제목검색
			sql += "WHERE REGEXP_LIKE(title,?,'i') ";
			break;
		case 2: //내용검색
			sql += "WHERE REGEXP_LIKE(content,?,'i') ";
			break;
		case 3: //작성자검색
			sql += "WHERE REGEXP_LIKE(writer,?,'i') ";
			break;
		case 4: //제목+내용검색
			sql += "WHERE REGEXP_LIKE(title,?,'i') OR REGEXP_LIKE(content,?,'i') ";
			break; 
		} 
		
		int totalPages = 0;
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, numberPerPage);
		if(searchCondition ==4) {
			this.pstmt.setString(3, searchWord);
		}
		
		
		this.rs = this.pstmt.executeQuery();
		
		this.rs.next();
		totalPages = rs.getInt(1);
		
		this.rs.close();
		this.pstmt.close();
		
		
		return totalPages;
	}

	
}//class
