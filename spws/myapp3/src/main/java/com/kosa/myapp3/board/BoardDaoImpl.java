package com.kosa.myapp3.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int getTotalCnt(BoardDto dto) {
		return sm.selectOne("Board_getTotalCnt", dto);
	}

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		sm.update("Board_updateHit", dto);
		return sm.selectOne("Board_getView", dto);
	}

	@Override
	public void reply(BoardDto dto) {
		sm.insert("Board_reply", dto);
	}

	@Override
	public void update_level(BoardDto dto) {
		sm.update("Board_reply_level_update", dto);
	}

	@Override
	public void modify(BoardDto dto) {
		sm.update("Board_modify", dto);
	}

	@Override
	public void delete(BoardDto dto) {
//		dto : group_id, depth, g_level이 파라미터로 들어와야 함 -> 준 적이 없어서 안 들어올 가능성이 있기 때문에 또 처리를 해줘야 함.
		System.out.println("그룹 아이디: "+dto.getGroup_id());
		System.out.println("깊이: "+dto.getDepth());
		System.out.println("레벨: "+dto.getG_level());
		
		int cnt = sm.selectOne("Board_getChildCount", dto);
		
		if(cnt==0) {
//			글을 삭제
			sm.update("Board_delete1", dto);
		} else {
//			자식이 있을 경우 delyn2 필드 값만 삭제 표시
			sm.update("Board_delete2", dto);
		}
	}

	@Override
	public int getChildCount(BoardDto dto) {
		return sm.selectOne("Board_getChildCount", dto);
	}

	
}
