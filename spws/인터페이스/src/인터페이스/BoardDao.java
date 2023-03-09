package 인터페이스;

import java.util.ArrayList;
import java.util.List;

public class BoardDao implements IBoardDao{

	List<BoardDto> list = new ArrayList<BoardDto>();
	
	public BoardDao() {
		super();
		list.add(new BoardDto("제목1", "작성자1", "내용1"));
		list.add(new BoardDto("제목2", "작성자2", "내용2"));
		list.add(new BoardDto("제목3", "작성자3", "내용3"));
		list.add(new BoardDto("제목4", "작성자4", "내용4"));
		list.add(new BoardDto("제목5", "작성자5", "내용5"));
		
		/*
		 * 생성자 없는 경우엔
		 * BoardDto dto = new BoardDto();
		 * dto.setTitle("제목1");
		 * dto.setWriter("작성자1");
		 * dto.setContent("내용1");
		 * list.add(dto);
		 * -> 를 반복 했어야 함.
		 */
	}
	
	@Override
	public List<BoardDto> getList() {
		// TODO Auto-generated method stub
		return list;
	}
}
