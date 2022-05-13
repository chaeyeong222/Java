package days04.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBconn;

public class BoardController {

	private Scanner scanner = null;
	private int selectedNumber;
	private BoardService service = null;
	
	//페이징 처리를 위한 필드
	private int numberPerPage =15;
	private int currentPage =1;
	private int numberOfPageBlock = 10;
	
	public BoardController() {
		this.scanner = new Scanner(System.in);
	}
	
	public BoardController(BoardService service) {
		this();
		this.service  = service;
	}

	public void start() {
		
		while(true) {
			메뉴출력();
			메뉴선택();
			메뉴처리();
		}//while
		
	}//start

	private void 메뉴출력() { 
		String [] menus = {"새글","목록","보기","수정","삭제","검색","종료"};
		System.out.println("[메뉴]");
		for (int i = 0; i < menus.length; i++) {
			System.out.printf("%d. %s\t",i+1,menus[i]);
		}
		System.out.println();
	}

	private void 메뉴선택() {
		System.out.println("메뉴 선택하세요.");
		this.selectedNumber = this.scanner.nextInt();
	}

	private void 메뉴처리() { 
		
		switch(this.selectedNumber) {
		case 1://새글
			새글쓰기();
			break;
		case 2://목록
			목록보기();
			break;
		case 3://보기
			상세보기();
			break;
		case 4://수정
			수정하기();
			break;
		case 5://삭제
			삭제하기();
			break;
		case 6://검색
			검색하기();
			break;
		case 7://종료
			exit();
			break; 
		
		}//switch
	}//메뉴처리

	private void 검색하기() { 
//ㄱ. 검색에 페이징처리 위해서 추가
		System.out.print(">검색 현재 페이지(currentPage)번호를 입력하세요");
		this.currentPage = this.scanner.nextInt();
		//검색조건 : 제목(1) 내용(2) 작성자(3) 제목+내용(4)
		int searchCondition;
		System.out.print("검색조건 : 제목(1) 내용(2) 작성자(3) 제목+내용(4) 선택");
		searchCondition = this.scanner.nextInt();
		System.out.println("검색어입력?");
		String searchWord = this.scanner.next();
		
		//목록보기() 모든 코딩 복사+붙이기
		//ArrayList<BoardDTO> list = this.service.searchService(searchCondition, searchWord );
//ㄴ. 검색에 페이징처리 위해서 추가
		ArrayList<BoardDTO> list = this.service.searchService(currentPage, numberPerPage, searchCondition, searchWord );
		//뷰view 출력담당
		System.out.println("\t\t게시판");
		System.out.println("-------------------------------------------");
		System.out.printf("%s\t%-30s\t%s\t%-10s\t%s\n",
				"글번호","글제목","글쓴이","작성일","조회수");
		System.out.println("-------------------------------------------");
		
		if (list == null) {
			System.out.println("\t\t게시글이 존재하지 않습니다");
		} else {
			Iterator<BoardDTO> ir = list.iterator();
			while (ir.hasNext()) {
				BoardDTO dto = ir.next();
				System.out.printf("%d\t%-30s %s\t%-10s\t%d\n",
						dto.getSeq(),
						dto.getTitle(),
						dto.getWriter(),
						dto.getWritedate(),
						dto.getReaded());
			}

		}
		System.out.println("-------------------------------------------");
		//System.out.println("\t\t[1] 2 3 4 5 6 7 8 9 10>");//페이징블럭
		String pagingBlock = this.service.pageService(this.currentPage
				, this.numberPerPage
				,this.numberOfPageBlock
				,searchCondition //검색조건
				,searchWord);    //검색어
		System.out.println(pagingBlock);
		System.out.println("-------------------------------------------");
		
		
		일시정지();
	}

	private void 수정하기() { 
		System.out.print("수정할 게시글의 글 번호(seq), email, title, content 입력 ");
		int seq = this.scanner.nextInt();
		//1.수정하고자하는 게시글의 정보 출력
		BoardDTO dto = this.service.viewService(seq);
		 
		if(dto ==null) {
			System.out.println("해당 게시물 존재x");
			return;
		}
		//dto가 널 아니면 해당 게시물 정보 출력(view 담당)
		System.out.println("ㄱ.글번호: " + seq);
		System.out.println("ㄴ.작성자: " + dto.getWriter());
		System.out.println("ㄷ.조회수: " + dto.getReaded());
		System.out.println("ㄹ.글제목: " + dto.getTitle());
		System.out.println("ㅁ.글내용: " + dto.getContent());
		System.out.println("ㅂ.작성일: " + dto.getWritedate());
		
		//
		String email = this.scanner.next();
		String title = this.scanner.next();
		String content = this.scanner.next();
		
	    dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setEmail(email);
		dto.setContent(content);
		
		int rowCount = this.service.updateService(dto);
		if(rowCount ==1) {
			System.out.printf("%d 수정완료",seq);
		}
		일시정지();
		
	}

	private void 삭제하기() { 
		System.out.print(">삭제할 게시글 글번호(seq) 입력?");
		int seq = this.scanner.nextInt();
		int rowCount = this.service.deleteService(seq);
		if(rowCount == 1) {
			System.out.printf("%d게시글 삭제 완료!\n", seq);	
		}
		일시정지();
	}

	private void 상세보기() {
		System.out.print(">게시글 글번호(seq) 입력?");
		int seq = this.scanner.nextInt();
		BoardDTO dto = this.service.viewService(seq);
		if(dto ==null) {
			System.out.println("해당 게시물 존재x");
			return;
		}
		//dto가 널 아니면 해당 게시물 정보 출력(view 담당)
		System.out.println("ㄱ.글번호: " + seq);
		System.out.println("ㄴ.작성자: " + dto.getWriter());
		System.out.println("ㄷ.조회수: " + dto.getReaded());
		System.out.println("ㄹ.글제목: " + dto.getTitle());
		System.out.println("ㅁ.글내용: " + dto.getContent());
		System.out.println("ㅂ.작성일: " + dto.getWritedate());
		
		System.out.printf("\n[수정][삭제][목록(HOME)]");
		
		일시정지();
	}

	//목록페이지에서 "글쓰기" 버튼 클릭
	//새글 정보 입력 -> dto -> DB insert
	// 목록 페이지 출력
	private void 새글쓰기() { 
		System.out.println("writer, pwd, email, title, tag, content 입력?");
		String [] datas = this.scanner.next().split(",");
		String writer = datas[0];
		String pwd = datas[1];
		String email = datas[2];
		String title = datas[3];
		int tag = Integer.parseInt(datas[4]);
		String content = datas[5];
		
		
		BoardDTO dto = new BoardDTO();
		dto.setWriter(writer);
		dto.setPwd(pwd);
		dto.setEmail(email);
		dto.setTitle(title);
		dto.setTag(tag);
		dto.setContent(content);
		
		int rowCount = this.service.insertService(dto );
		if (rowCount == 1) {
			System.out.println("새 글 쓰기 완료!");
		}
		일시정지();
	}

	//게시글 목록 조회 메서드
	private void 목록보기() { 
		System.out.print(">현재 페이지(currentPage)번호를 입력하세요");
		this.currentPage = this.scanner.nextInt();
		
		ArrayList<BoardDTO> list = this.service.selectService(this.currentPage, this.numberPerPage);
		//뷰view 출력담당
		System.out.println("\t\t게시판");
		System.out.println("-------------------------------------------");
		System.out.printf("%s\t%-30s\t%s\t%-10s\t%s\n",
				"글번호","글제목","글쓴이","작성일","조회수");
		System.out.println("-------------------------------------------");
		
		if (list == null) {
			System.out.println("\t\t게시글이 존재하지 않습니다");
		} else {
			Iterator<BoardDTO> ir = list.iterator();
			while (ir.hasNext()) {
				BoardDTO dto = ir.next();
				System.out.printf("%d\t%-30s %s\t%-10s\t%d\n",
						dto.getSeq(),
						dto.getTitle(),
						dto.getWriter(),
						dto.getWritedate(),
						dto.getReaded());
			}

		}
		System.out.println("-------------------------------------------");
		//System.out.println("\t\t[1] 2 3 4 5 6 7 8 9 10>");//페이징블럭
		String pagingBlock = this.service.pageService(this.currentPage
				, this.numberPerPage
				,this.numberOfPageBlock);
		System.out.println(pagingBlock);
		System.out.println("-------------------------------------------");
		
		일시정지();
	}



	private void 일시정지() { 
		System.out.println("계속하려면 엔터치세요");
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
	}

	private void exit() { 
		DBconn.close();
		System.out.println("\t\t프로그램 종료!!");
		System.exit(-1);
	}

	
}//class
