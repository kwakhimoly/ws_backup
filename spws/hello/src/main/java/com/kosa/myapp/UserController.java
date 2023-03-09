package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	
	@RequestMapping(value = "/post/userinfo", method = RequestMethod.POST)
	public String userinfo(UserDto dto, Model model) {
		model.addAttribute("dto", dto);
		
		
		return "post/userinfo";
	}
}
