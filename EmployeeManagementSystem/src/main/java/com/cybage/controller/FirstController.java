package com.cybage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@RequestMapping("/sayHello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/welcome")
	public String welcom(Model model) {
		model.addAttribute("user","alpha");
		return "hello";
	}
	
	@RequestMapping("/wel")
	public ModelAndView wel() {
	
		return new ModelAndView("hello","test","bravo");
	}
}
