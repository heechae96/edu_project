package com.myproject.myproject.edu_class;

import java.util.List;

public class BoardListView {

	private int boardTotalCount;		// 게시글 전체 개수
	private int currentPageNumber;		// 현재 페이지 번호
	private List<UserClass> boardList;	// 한 화면에 보여줄 게시글 리스트
	private int pageTotalCount;			// 페이지 전체 개수
	private int boardCountPerPage;		// 한 페이지당 보드 개수
	private int firstRow;				// 화면상 맨 위에 있는 레코드 row번호
	
	public BoardListView(int boardTotalCount, int currentPageNumber, List<UserClass> boardList, 
			int boardCountPerPage, int firstRow) {
		super();
		this.boardTotalCount = boardTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.boardList = boardList;
//		this.pageTotalCount = pageTotalCount;
		this.boardCountPerPage = boardCountPerPage;
		this.firstRow = firstRow;
		
		// 페이지 전체 개수는 따로 계산해보자!
		pageTotalCount = (int)Math.ceil((double)boardTotalCount/boardCountPerPage);
			
	}

	public int getBoardTotalCount() {
		return boardTotalCount;
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public List<UserClass> getBoardList() {
		return boardList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getBoardCountPerPage() {
		return boardCountPerPage;
	}


	public int getFirstRow() {
		return firstRow;
	}

	@Override
	public String toString() {
		return "BoardListView [boardTotalCount=" + boardTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", boardList=" + boardList + ", pageTotalCount=" + pageTotalCount + ", boardCountPerPage="
				+ boardCountPerPage + ", firstRow=" + firstRow + "]";
	}
}
