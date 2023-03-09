package com.kosa.myapp3.mapper;

//	Mybatis 3.0부터 인터페이스만 만들면 DaoImpl을 스스로 만든다.
//	함수명은 xml에서 쓴 그대로 써야 mapper가 xml을 인식할 수 있음
import com.kosa.myapp3.member.MemberDto;
public interface MemberMapper {
	public void Member_insert(MemberDto dto);
	public int Member_idcheck(MemberDto dto);
	public MemberDto Member_login(MemberDto dto);
}
