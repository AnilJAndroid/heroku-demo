package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping({"/","/hello"})
	public String hello(@RequestParam(value = "name",defaultValue = "World",required = true) String name,Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	/*
	 * @RequestMapping(name = "/",method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String demo() { return "demo"; }
	 */
}
