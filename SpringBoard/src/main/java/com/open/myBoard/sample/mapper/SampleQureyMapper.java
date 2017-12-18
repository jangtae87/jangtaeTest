package com.open.myBoard.sample.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleQureyMapper {
	public String getGradeName() throws SQLException;
}

