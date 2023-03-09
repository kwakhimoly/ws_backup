package 인터페이스;

import java.util.List;

public interface IBoardDao {
//	인터페이스는 상수하고 함수 header 부분만, 객체 만들 게 아님
	public List<BoardDto> getList();
}
