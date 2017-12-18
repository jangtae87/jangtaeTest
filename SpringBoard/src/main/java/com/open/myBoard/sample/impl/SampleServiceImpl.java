package com.open.myBoard.sample.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.myBoard.sample.mapper.SampleQureyMapper;
import com.open.myBoard.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	@Autowired
	private SampleQureyMapper sampleQureyMapper;
	
	@Override
	public String getGradeName() throws SQLException {
		
		//String test = sqlSession.selectOne("TestQureyMapper.test");
		String test = sampleQureyMapper.getGradeName();
		return test;
	}
	
}




