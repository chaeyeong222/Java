package days05;
/**
 * @author 채영
 * @date
 * @subject 페이징처리
 * @content
 */
public class Ex01 {

	public static void main(String[] args) { 
		//1. 한 페이지에 출력할 게시글 수 :15
		int numberPerPage =15;
		//2. 현재 페이지 : 1번페이지
		int currentPage =1;
		//3. 총 레코드 수 : 347
		int totalRecords = 347;
		//4. 총 페이지 수 : 24
		//int totalPages = (int)Math.ceil((double)totalRecords/numberPerPage);
		//오라클에서 쿼리로 처리하는 게 더 편리함
		int totalPages = 24;
		//5.페이지블럭수 1 2 3 4 5 6 7 8 9 10
		int numberOfPageBlock = 10;
		//6. 페이징블럭의 시작값
		int startOfPageBlock = 1;
		int endOfPageBlock ;
		
		//*****
		for (int i = 1; i <= totalPages; i++) {
			startOfPageBlock = (i-1)/numberOfPageBlock *numberOfPageBlock+1;
			endOfPageBlock = startOfPageBlock + numberOfPageBlock-1;
			if(endOfPageBlock > totalPages) endOfPageBlock = totalPages;
			//System.out.printf("현재 페이지:%d\t%d ~ %d\n",i, startOfPageBlock,endOfPageBlock);
			System.out.printf("현재 페이지:%d\t",i);
			
			if(startOfPageBlock != 1 ) System.out.print("< ");
			
			
			for (int j = startOfPageBlock; j <= endOfPageBlock; j++) {
				System.out.printf(j==i?"[%d] ":"%d ",j);
			}//for j
			
			if(endOfPageBlock != totalPages ) System.out.print(">");
			System.out.println();
		}//for i
		
		

	}//main

}//class



/*
 *   
   <prev버튼  페이징블럭시작값         페이징블럭종료값   next버튼>
현재 페이지:1   [1] 2 3 4 5 6 7 8 9 10 >
현재 페이지:2    1 [2] 3 4 5 6 7 8 9 10 >
현재 페이지:3    1 2 [3] 4 5 6 7 8 9 10 >
현재 페이지:4             :
현재 페이지:5             :
현재 페이지:6             :
현재 페이지:7
현재 페이지:8
현재 페이지:9
현재 페이지:10    1 2 3 4 5 6 7 8 9 [10] >
현재 페이지:11   [11] 12 13 14 15 16 17 18 19 20 >
현재 페이지:12
현재 페이지:13
현재 페이지:14             :
현재 페이지:15
현재 페이지:16             :
현재 페이지:17
현재 페이지:18             :
현재 페이지:19
현재 페이지:20 
현재 페이지:21   [21] 22 23 24
현재 페이지:22   21 [2]2 23 24
현재 페이지:23   21 22 [23] 24
현재 페이지:24   21 22 23 [24]
*/