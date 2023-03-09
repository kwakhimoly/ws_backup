package com.kwak.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("testDao2")
public class TestDao2Impl implements TestDao2 {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void insertData(TestDto dto) {
		sm.insert("Test2_insert", dto);
	}

}
