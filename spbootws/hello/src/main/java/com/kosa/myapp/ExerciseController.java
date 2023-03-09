package com.kosa.myapp;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
	@GetMapping("/add")
	public HashMap<String, Integer> add(int x, int y) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		
		return map;
	}
	
	@GetMapping("/calc")
	public HashMap<String, Integer> calc(int x, int y, int oper){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("x", x);
		map.put("y", y);
		
//		switch 그냥 한 번 써봤어요
		switch (oper) {
		case 1:
			map.put("result", x+y);
			break;
		case 2:
			map.put("result", x-y);
			break;
		case 3:
			map.put("result", x*y);
			break;
		case 4:
			map.put("result", x/y);
			break;
		}
		return map;
	}
	
	@GetMapping("/score")
	public HashMap<String, Object> score(String name, int kor, int mat, int eng){
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("name", name);
		map.put("kor", kor);
		map.put("mat", mat);
		map.put("eng", eng);
		map.put("total", kor+mat+eng);
		map.put("avg", (kor+mat+eng)/3);
		
		return map;
	}
}
