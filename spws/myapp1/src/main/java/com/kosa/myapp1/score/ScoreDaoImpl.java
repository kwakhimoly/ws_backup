package com.kosa.myapp1.score;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("scoreDao")
public class ScoreDaoImpl implements ScoreDao {
	List<ScoreDto> list = new ArrayList<ScoreDto>();
	
	public ScoreDaoImpl() {
		super();
		for(int i = 0; i<10; i++) {
			list.add(new ScoreDto(i+"", "학생"+i, (100-i)+"", (80+i)+"", (70+i)+""));
		}
	}

	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ScoreDto getView(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ScoreDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ScoreDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ScoreDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
