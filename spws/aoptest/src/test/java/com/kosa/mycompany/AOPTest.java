package com.kosa.mycompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//스프링의  servlet-context.xml파일 읽으라고 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class AOPTest {
	@Autowired
	SampleService service;

	@Test
	public void test() {
		System.out.println("단위 테스트");
		service.displayName();
		service.displayNumber();
		System.out.println(service.displayNumber(56));
		
		service.guguDan(9);
	}
}
