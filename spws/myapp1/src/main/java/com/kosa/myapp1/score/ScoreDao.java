package com.kosa.myapp1.score;

import java.util.List;

public interface ScoreDao {
	public List<ScoreDto> getList(ScoreDto dto);

	public ScoreDto getView(String seq);

	public void insert(ScoreDto dto);

	public void update(ScoreDto dto);

	public void delete(ScoreDto dto);
}
