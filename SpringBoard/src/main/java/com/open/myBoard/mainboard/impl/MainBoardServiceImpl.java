package com.open.myBoard.mainboard.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.myBoard.mainboard.mapper.MainBoardMapper;
import com.open.myBoard.mainboard.service.MainBoardService;
import com.open.myBoard.mainboard.vo.BoardVO;

@Service
public class MainBoardServiceImpl implements MainBoardService {

	@Autowired
	private MainBoardMapper mainBoardMapper;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) throws Exception {
		return mainBoardMapper.getBoardList(boardVO);
	}

	@Override
	public void insertWriteData(BoardVO boardVO) throws Exception {
		mainBoardMapper.insertWrite(boardVO);
	}

	@Override
	public String selectSeq() throws Exception {
		
		String seq = mainBoardMapper.selectSeq();
		
		if ( seq == null ) {
			seq = "1";
		}
		
		return seq;
	}

	@Override
	public void updateWriteData(BoardVO boardVO) throws Exception {
		mainBoardMapper.updateWriteData(boardVO);
		
	}

	
	
}
