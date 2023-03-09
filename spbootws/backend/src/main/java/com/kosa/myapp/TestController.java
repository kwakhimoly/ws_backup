package com.kosa.myapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {
//	add?x=5&y=7 (예전 방식)
//	add/5/7 (새로운 방식)
	@GetMapping("/add/{x}/{y}")
	public Map<String, String> add(@PathVariable("x")int x,@PathVariable("y")int y){
		int result = x+y;
		
		Map<String, String> map = new HashMap<>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));
		
		return map;
	}

//	postman 앱의 body -> x-www-form-urldncoded < form 태그로 전송	
	@PostMapping("/add_json")
	public Map<String, String> add_json
	(@RequestBody HashMap<String, String> paramMap, HttpServletRequest req){
//		json으로 받을 때는 @RequestBody로 받아야 한다.
//		기본 타입 변수로는 못 받는다
//		HashMap이나 Dto로만 받을 수 있다. 
		
		
		int result = Integer.parseInt(paramMap.get("x"))+Integer.parseInt(paramMap.get("y"));
		
		Map<String, String> map = new HashMap<>();
//		form 태그의 enctype="multipart/form-data" 로 전송하면 request 객체가 값을 못 받음
//			대신 MultipartResolver에 의해 값을 처리 해야 한다. 
//			스프링부트가 사고 안나게 내부적인 처리를 해서 postman 결과가 나오는 것.
//		map.put("req_x", req.getParameter("x"));
//		map.put("req_y", req.getParameter("y"));
		
		map.put("x", paramMap.get("x"));
		map.put("y", paramMap.get("y"));
		
//		String.valueOf(기본타입 변수) -> 문자열로 전환해준다.
//		x(int) => int는 객체가 아니다. toString() 함수 없음
//		java int => 객체로 전환해야 할 때가 있는데, Integer, Float, Double wrapper class들로
//				기본 값을 감싸서 개체로 전환할 때는 toString()함수가 있다. 그냥 기본값 자체로 개체로 전환되지 않는다.
//		c#은 int와 Integer 간에 기본 타입과 객체 타입 간에 전환이 자유자재임
//		s = new Integer(x); s.toString(); => 이게 toString() 함수 사용 가능
//		x+"" : 스트링이 아닌 타입을 스트링으로 전환시켜서 더한다. 
		map.put("result", String.valueOf(result));
		
		return map;
	}
	
	@GetMapping("/calc/{a}/{b}/{oper}")
	public Map<String, Integer> calc
	(@PathVariable("a")int a, @PathVariable("b")int b, @PathVariable("oper")int oper){
		
		Map<String, Integer> map = new HashMap<>();
		map.put("a", a);
		map.put("b", b);
		
		if(oper==1) {
			map.put("result", a+b);
		} else if(oper==2) {
			map.put("result", a-b);
		} else if(oper==3) {
			map.put("result", a*b);
		} else if(oper==4) {
			map.put("result", a/b);
		}
		
		return map;
	}
	
	@GetMapping("/score/{name}/{kor}/{eng}/{mat}")
	public Map<String, Object> score
	(@PathVariable("name")String name, @PathVariable("kor")int kor, 
	@PathVariable("eng")int eng, @PathVariable("mat")int mat){
		Map<String, Object> map = new HashMap<>();
		
		map.put("name", name);
		map.put("kor", kor);
		map.put("eng", eng);
		map.put("mat", mat);
		map.put("total", kor+eng+mat);
		map.put("avg", (kor+mat+eng)/3.0);
		
		return map;
	}
	@PostMapping("/score_json")
	public Map<String, Object> score_json
	(@RequestBody ScoreDto dto){
		Map<String, Object> map = new HashMap<>();
		int kor = dto.getKor();
		int eng = dto.getEng();
		int mat = dto.getMat();
		
		int total = kor+eng+mat;
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		map.put("name", dto.getName());
		map.put("kor", kor);
		map.put("eng", eng);
		map.put("mat", mat);
		map.put("total", total);
		map.put("avg", dto.getAvg());
		
		return map;
	}
	
	@PostMapping("/score_json2")
	public ScoreDto score_json2(@RequestBody ScoreDto dto) {
		int total = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		return dto;
	}
}
