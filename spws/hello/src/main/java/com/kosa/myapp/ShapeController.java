package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShapeController {
	
	@RequestMapping(value = "/circle/{x:.+}", method = RequestMethod.GET)
	public String circle(@PathVariable("x") double x, Model model) {
		System.out.println("x= "+x);
		
		model.addAttribute("x", x);
		model.addAttribute("resultCircle", x*x*3.14);
		
		return "circle";
	}
	
	@RequestMapping(value = "/rectangle/{a}/{b}", method = RequestMethod.GET)
	public String rectangle(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("resultRectangle", a*b);
		return "rectangle";
	}
	
	@RequestMapping(value = "/triangle/{c}/{d}", method = RequestMethod.GET)
	public String triangle(@PathVariable("c") int c, @PathVariable("d") int d, Model model) {
		System.out.println("c="+c);
		System.out.println("d="+d);
		
		model.addAttribute("c", c);
		model.addAttribute("d", d);
		model.addAttribute("resultTriangle", c*d/2);
		return "triangle";
	}
}
