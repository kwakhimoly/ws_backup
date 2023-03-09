package com.kwak.mycompany.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Resource(name = "testDao1")
	TestDao1 testDao1;
	@Resource(name = "testDao2")
	TestDao2 testDao2;
	@Resource(name = "testDao3")
	TestDao3 testDao3;

	@Override
	public void insertData(TestDto dto) {
		try {
			
			testDao1.insertData(dto);
			dto.setTest("23423532515");
			testDao2.insertData(dto);
			
			testDao3.insertData(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
