package com.kosa.myapp.guestbook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestbookController {
	@GetMapping("/guestbook")
	GuestbookDto getView() {
		GuestbookDto dto = new GuestbookDto();
		dto.setId("1");
		dto.setTitle("title1");
		dto.setWriter("writer1");
		dto.setContents("contents1");
		dto.setWdate("20230215");
		
		return dto;
	}
}
