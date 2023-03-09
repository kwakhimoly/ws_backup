package com.kosa.myapp3.board;

import java.util.List;

public interface BoardDao {
	public int getTotalCnt(BoardDto dto);
	public List<BoardDto> getList(BoardDto dto);
	public void insert(BoardDto dto);
	public BoardDto getView(BoardDto dto);
	public void reply(BoardDto dto);
	public void update_level(BoardDto dto);
	public void modify(BoardDto dto);
	public int getChildCount(BoardDto dto);
	public void delete(BoardDto dto);
}