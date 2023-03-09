package com.kwak.mycompany.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}

	@Override
	public boolean isDuplicate(MemberDto dto) {
		int result = sm.selectOne("Member_idcheck", dto);

		if (result == 0) {
			//count(*) = 0 : 사용중인 사람이 없으니까 아이디로 쓸 수 있음
			return false;
		} else {
			//아이디 사용 못함
			return true;
		}
	}

	@Override
	public MemberDto login(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_login", dto);
	}

	@Override
	public MemberDto findid(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_findid", dto);
	}

	@Override
	public MemberDto findpw(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_findpw", dto);
	}

	@Override
	public List<MemberDto> getList(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Member_getlist", dto);
	}

	@Override
	public int totalCnt(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_totalcnt", dto);
	}


}
