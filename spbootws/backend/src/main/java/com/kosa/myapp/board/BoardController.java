package com.kosa.myapp.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*") //접근허가를 받는 사이트의 도메인이 저장되어야 한다. 
//	도메인이 없는 경우(지금) localhost나 127.0.0.1 사용 BUT 이러면 브라우저에 따라서 다르게 동장
//	그래서 * 사용 : 접속 요청 오는 걸 모두 받겠다.
//	실무에서는 * 사용x 도메인 명을 써줘야 함.
@RestController
public class BoardController {
	@GetMapping("/board/list/{pg}")
	public HashMap<String, Object> getList(@PathVariable("pg")String pg,BoardDto dto){
		HashMap<String, Object> map = new HashMap<>();
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		for(int i=1; i<=20; i++){
			list.add(new BoardDto(""+i,"제목"+i,"작성자"+i,"내용"+i,"file"+i,"image"+i));
		}
		
		map.put("totalCnt", 20);
		map.put("list", list);
		
		return map;
	}
}
