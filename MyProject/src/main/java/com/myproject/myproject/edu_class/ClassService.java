package com.myproject.myproject.edu_class;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
	
	// 한 페이지당 보여줄 개수
	static final int BOARD_COUNR_PER_PAGE = 10;	

	@Autowired
	private ClassMapper classMapper;
	
	// 화면에 보여줄 데이터를 만들어서 반환
	public BoardListView getBoardListView(int pageNumber) {
		BoardListView boardListView = null;
		// 요청된 페이지에 해당되는 보드리스트
		int boardTotalCount = classMapper.selectTotalCnt(); 
		
		// 전체 보드 개수
		List<UserClass> boardList = null;
		
		int firstRow = 0;
		
		// 페이지 번호가 0이하일때 1로 초기화!
		if(pageNumber <= 0) {
			pageNumber = 1;
		}

		firstRow = (pageNumber - 1) * BOARD_COUNR_PER_PAGE;
			
		// 리스트를 매퍼로 가져옴
		boardList = classMapper.selectBoard(firstRow, BOARD_COUNR_PER_PAGE);
		
		// 화면에 보여줄 모든 데이터를 객체안에 넣어주자
		boardListView = new BoardListView(boardTotalCount, pageNumber, boardList, BOARD_COUNR_PER_PAGE, firstRow);
		
		// 최종으로 반환
		return boardListView;
		
	}
		
	// 과목 하나를 가져오는 로직
	public UserClass getBoard(int num) {
		
		return classMapper.selectUserClassById(num);
	}
	
	// 과목 추가
	public String insertboard(UserClass userclass) {
		
		// 매퍼를 이용하여 DB에 값을 삽입
		int rows = classMapper.insertBoard(userclass);
		if(rows > 0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
				
	}
	
	// 과목 수정하는 로직
	public void updateBoard(UserClass userclass) {
		
		classMapper.updateBoard(userclass);
	}
	
	// 과목 삭제하는 로직
	public String deleteBoard(int num) {
		int row = classMapper.deleteBoard(num);
		
		if(row > 0) {
			return "삭제 성공";
		}else {
			return "삭제 실패";
		}
	}
	
	// 과목 전체를 조회하는 메소드
	// 과목 추가를 할때 사용하기 위함
	public List<UserClass> selectClass() {
		
		List<UserClass> list = null;
		
		list = classMapper.selectClass();
		
		return list;
		
	}
}
