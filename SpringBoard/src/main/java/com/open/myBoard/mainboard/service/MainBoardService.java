package com.open.myBoard.mainboard.service;

import java.util.List;

import com.open.myBoard.mainboard.vo.BoardVO;

public interface MainBoardService {
	
	public List<BoardVO> getBoardList( BoardVO boardVO ) throws Exception;

	public void insertWriteData(BoardVO boardVO) throws Exception;

	public String selectSeq() throws Exception;

	public void updateWriteData(BoardVO boardVO) throws Exception; 

}
