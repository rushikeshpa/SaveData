package com.cybage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/welcome")
	public String model(Model model) {
		model.addAttribute("user", "Pankaj");
		model.addAttribute("address", "Ankleshwar");
		return "welcome";
	}

	/*
	 * @RequestMapping("/welcome") public ModelAndView model(){ return new
	 * ModelAndView("welcome","user","Pankaj"); }
	 */

}
