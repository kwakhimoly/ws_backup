package com.kwak.mycompany.guestbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestbookController {

	@Resource(name = "guestbookService")
	GuestbookService service;
	
	@RequestMapping(value = "/guestbook/list")
	public String getList(GuestbookDto dto, Model model) {
		List<GuestbookDto> list = service.getList(dto);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		System.out.println(dto.getPg());
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "guestbook/list";
	}
	
	@RequestMapping(value = "/guestbook/view")
	public String getView(Model model, GuestbookDto dto) {
		GuestbookDto resultDto = service.getView(dto);
		model.addAttribute("dto", resultDto);
		
		return "guestbook/view";
	}
	@RequestMapping(value = "/guestbook/write")
	public String write(Model model) {
		
		return "guestbook/write";
	}
	@RequestMapping(value = "/guestbook/save")
	public String save(Model model, GuestbookDto dto) {
		service.insert(dto);
		return "redirect:/guestbook/list";
//		redirect를 하는 이유: request 객체의 내용을 지우고 
//		직접 jsp로 이동하는게 아니라 guestbook/list url로 이동 시에 redirect를 해야 한다.
		
//		등록을 하고 나면 getList() 함수를 호출해야 하는데
//		직접 호출을 못함. -> 중간에 프레임워크가 하는 일이 많아서.
//		함수를 직접 호출 못하고 url로 접근해야 함 -> redirect 사용(mapping으로 부여한 url 주소 적기)
	}
}
