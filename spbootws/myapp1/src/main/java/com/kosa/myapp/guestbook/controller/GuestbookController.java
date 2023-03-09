package com.kosa.myapp.guestbook.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.guestbook.domain.GuestbookDto;
import com.kosa.myapp.guestbook.service.GuestbookService;

import jakarta.annotation.Resource;

@RestController
public class GuestbookController {
	@Resource(name = "guestbookService")
	GuestbookService service;
	
//	GET은 데이터 규모가 작아서 데이터 주고 받을 수가 없음
	
	@GetMapping("/guestbook/list")
	public List<GuestbookDto> getList(GuestbookDto dto){
		return service.getList(dto);
	}
	
	@PostMapping("/guestbook/write")
	public void insert(@RequestBody GuestbookDto dto) {
//		json 사용할 때는 @PostMapping, @RequestBody 필수!
		try {
			System.out.println(dto.getTitle());
			service.insert(dto);
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패");
		}
	}
	
	@GetMapping("/guestbook/view/{seq}")
	public GuestbookDto guestbook_getView(@PathVariable("seq")String seq, GuestbookDto dto)
	{
		HashMap<String, Object> map = new HashMap<>();
		
		dto.setSeq(seq);
		GuestbookDto result = service.getView(dto);
		
		try {
			map.put("result", "success");
			map.put("message", "성공");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
			map.put("message", "실패");
		}
		
		return result;
	}
}
