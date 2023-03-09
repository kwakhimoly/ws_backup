package com.kosa.myapp1.board;

import java.util.List;

public interface BoardService {
	public List<BoardDto> getList(BoardDto dto);
	public BoardDto getView(String seq);
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(BoardDto dto);
}
