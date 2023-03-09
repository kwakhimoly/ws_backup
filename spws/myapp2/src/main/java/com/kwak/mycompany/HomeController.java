package com.kwak.mycompany;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwak.mycompany.gallery.GalleryDto;
import com.kwak.mycompany.gallery.GalleryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name = "galleryService")
	GalleryService galleryService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/home/carousel_data")
	public Map<String, Object> home_listData(GalleryDto dto, HttpServletRequest request){
		List<GalleryDto> list = galleryService.getList(dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", list);
		
		/*
		 * HttpSession session = request.getSession();
		 * 
		 * MemberDto mDto = new MemberDto();
		 * mDto.setUser_id(session.getAttribute("user_id").toString());
		 */
		return map;
	}
}
