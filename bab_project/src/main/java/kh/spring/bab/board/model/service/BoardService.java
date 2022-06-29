package kh.spring.bab.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kh.spring.bab.board.domain.Board;

@Service
public interface BoardService {
	
	
	// 공지사항 조회
		/**
		 *  @param : currentPage, pageSize, board
		 *  @return : dao.selectBoard(board, currentPag, pageSize)
		 *  @author : 윤영원
		 **/
	public List<Board> selectBoard(int currentPage, int pageSize, Board board);
	
	// 공지사항 목록 갯수
		/**
		 *  @param :
		 *  @return : dao.selectTotalCnt()
		 *  @author : 윤영원
		 **/
	public int selectTotalCnt();
	
	// 상세보기 조회
	public Board readBoard(String board_no);
	
	// 공지사항 등록
		/**
		 *  @param : board
		 *  @return : dao.insertBoard(board)
		 *  @author : 윤영원
		 **/
	public int insertBoard(Board board);
	
	// 공지사항 수정
		/**
		 *  @param : board
		 *  @return : dao.updateBoard(board)
		 *  @author : 윤영원
		 **/
	public int updateBoard(Board board);
	
	// 공지사항 삭제
			/**
			 *  @param : board_no
			 *  @return : dao.deleteBoard(board)
			 *  @author : 윤영원
			 **/
	public int deleteBoard(String board_no);
}
