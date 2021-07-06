package com.jake.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/managers")
	public String showManagersPage() {
		return "managers";
	}
	
	@GetMapping("/admins")
	public String showAdminsPage() {
		return "admins";
	}

}
