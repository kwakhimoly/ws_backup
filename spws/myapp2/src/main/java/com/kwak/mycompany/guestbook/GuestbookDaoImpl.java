package com.kwak.mycompany.guestbook;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao{
	/*
	<bean id="sm" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory">
		</constructor-arg>
	</bean>
	소환
	 */
//	@Autowired
//	타입만 보고 적당한 개체를 주입한다.
	@Resource(name = "sm")
//	직접 이름을 지정할 수 있음 -> sm은 root-context.xml에서 지정한 id name
//	<bean id="sm" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg index="0" ref="sqlSessionFactory">
//		</constructor-arg>
//	</bean>
	SqlSessionTemplate sm;

	@Override
	public List<GuestbookDto> getList(GuestbookDto dto) {
		return sm.selectList("Guestbook_getList", dto); 
		// "": mapper 파일(Guestbook.xml)에 있는 쿼리의 id 값
		// dto: dto가 parameterType에 전달된다. 
		//		selectList 함수는 xml 파일에서 쿼리를 불러와서 실행시킨 후 결과를 resultType에서 지정한 객체를 만들어 값을 넣은 후
		//		ArrayList 객체를 만들어 dto 객체 추가후 반환을 한다. 
	}

	@Override
	public int getTotalCnt(GuestbookDto dto) {
		return sm.selectOne("Guestbook_getTotalCnt", dto);
	}

	@Override
	public GuestbookDto getView(GuestbookDto dto) {
		// 데이터가 한 건인 경우엔 selectOne 함수 호출
		return sm.selectOne("Guestbook_getView", dto);
	}

	@Override
	public void insert(GuestbookDto dto) {
		sm.insert("Guestbook_insert", dto);
	}

	@Override
	public void update(GuestbookDto dto) {
		sm.update("Gusetbook_update", dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		sm.delete("Guestbook_delete", dto);
	}

}
