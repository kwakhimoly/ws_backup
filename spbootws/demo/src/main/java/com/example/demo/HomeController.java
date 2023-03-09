package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller : 기존 스프링 프레임워크랑 동일
// @RestController : JSON 형식으로 데이터를 주고 받음
//					스프링부트는 기본이 JSON 형태로 데이터를 받고 결과값 전송도 JSON 형태로 한다.
@RestController
public class HomeController {
	@RequestMapping(value = "/")
	public String home() {
		return "Hello";
	}

//	@ResponseBody 안 붙여도 됨
	@RequestMapping(value = "/data")
	public HashMap<String, String> data() {
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-0000-0000");
		map.put("email", "hong@mail.com");

		return map;
	}
	
	@RequestMapping(value = "/dataList")
	public List<HashMap<String, String>> data_list() {
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("age", "23");
		map.put("phone", "010-0000-0000");
		map.put("email", "hong@mail.com");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "김길동");
		map.put("age", "26");
		map.put("phone", "010-0000-0001");
		map.put("email", "kim@mail.com");
		dataList.add(map);

		map = new HashMap<String, String>();
		map.put("name", "박길동");
		map.put("age", "22");
		map.put("phone", "010-0000-0002");
		map.put("email", "park@mail.com");
		dataList.add(map);
		
		return dataList;
	}
	
	@GetMapping("/info")
	public HashMap<String, String> info(String userid, String password){
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("password", password);
		return map;
	}
	
}
