package com.open.myBoard.mainboard.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.open.myBoard.mainboard.vo.BoardVO;

@Mapper
public interface MainBoardMapper {

	public List<BoardVO> getBoardList(BoardVO boardVO) throws SQLException;

	public void insertWrite(BoardVO boardVO) throws SQLException;

	public String selectSeq() throws SQLException;

	public void updateWriteData(BoardVO boardVO) throws SQLException;
	
}
