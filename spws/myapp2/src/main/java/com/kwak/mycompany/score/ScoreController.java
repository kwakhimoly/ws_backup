package com.kwak.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
	@Resource(name = "scoreService")
	ScoreService service;

	@RequestMapping("/score/list")
	public String getList(Model model, ScoreDto dto) {
		List<ScoreDto> list = service.getList(dto);
		model.addAttribute("list", list);
		return "score/list";
	}
}
