package com.newgen.course.socialMedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping
	public String homePage() {
		return "index";
	}
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/otherPage")
	public String otherPage() {
		return "otherPage";
	}
	@GetMapping("/addUser")
	public String addUserPage() {
		return "addUser";
	}

}
