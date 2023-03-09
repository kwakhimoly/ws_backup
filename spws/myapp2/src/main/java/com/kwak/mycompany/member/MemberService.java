package com.kwak.mycompany.member;

import java.util.List;

public interface MemberService {
public void insert(MemberDto dto);
public boolean isDuplicate(MemberDto dto);
public MemberDto login(MemberDto dto);
public MemberDto findid(MemberDto dto);
public MemberDto findpw(MemberDto dto);

public List<MemberDto> getList(MemberDto dto);
public int totalCnt(MemberDto dto);
}
