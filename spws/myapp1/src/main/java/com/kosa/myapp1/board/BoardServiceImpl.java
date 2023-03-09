package com.kosa.myapp1.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
//	service -> 트랜잭션 단위로 처리(화면단위로 처리) / dao -> 테이블 단위로 처리
@Service("boardService") //서비스 객체 만들기
public class BoardServiceImpl implements BoardService{
	
//	@Autowired
//	BoardDao boardDao; //객체는 스프링이 만들어서 우리한테 줘야한다.
//	resource 대신에 이거 사용해도 됨
	
	@Resource(name="boardDao")
	BoardDao boardDao;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		// TODO Auto-generated method stub
		return boardDao.getList(dto);
	}

	@Override
	public BoardDto getView(String seq) {
		// TODO Auto-generated method stub
		return boardDao.getView(seq);
	}

	@Override
	public void insert(BoardDto dto) {
		// Dao - 테이블 단위
		// Service - 화면 단위, 여러개의 dao(테이블)을 소유할 수 있음
		
		boardDao.insert(dto);
		
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

}
