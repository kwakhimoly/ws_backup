package com.kosa.myapp3.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("boardService")
public class BoardServiceImpl implements BoardSerivce {
//	복잡한 작업은 service에서! controller는 연동만
	
	@Resource(name = "boardDao")
	BoardDao dao;
	
	@Override
	public int getTotalCnt(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt(dto);
	}

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		dao.insert(dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		return dao.getView(dto);
	}

	@Override
	public void reply(BoardDto dto) {
//		dto 안에 부모글의 seq 값이 들어 있음
//		부모글의 정보를 가져와야 한다. => controller 말고 service에서 작업
		BoardDto parentDto = dao.getView(dto);
		
//		답글의 group_id, depth, g_level 부모글의 parentDto 통해 설정
		dto.setGroup_id(parentDto.getGroup_id());
		dto.setDepth(parentDto.getDepth()+1);
		dto.setG_level(parentDto.getG_level()+1);
		
		dao.update_level(parentDto); 
//		level 설정은 부모글의 dto 통해
		dao.reply(dto);
//		답글 등록은 자식글 dto 통해
	}

	@Override
	public void modify(BoardDto dto) {
		dao.modify(dto);
	}

	@Override
	public void delete(BoardDto dto) {
		dao.delete(dto);
	}


}
