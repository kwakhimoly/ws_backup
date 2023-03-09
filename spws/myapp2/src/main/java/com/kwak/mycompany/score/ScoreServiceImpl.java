package com.kwak.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
@Repository("scoreService")
public class ScoreServiceImpl implements ScoreService{

	@Resource(name = "scoreDao")
	ScoreDao dao;
	
	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}

}
