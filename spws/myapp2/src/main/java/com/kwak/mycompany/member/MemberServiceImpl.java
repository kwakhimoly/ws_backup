package com.kwak.mycompany.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name = "memberDao")
	MemberDao dao;
	
	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public boolean isDuplicate(MemberDto dto) {
		return dao.isDuplicate(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public MemberDto findid(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.findid(dto);
	}

	@Override
	public MemberDto findpw(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.findpw(dto);
	}

	@Override
	public List<MemberDto> getList(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}

	@Override
	public int totalCnt(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.totalCnt(dto);
	}

}
