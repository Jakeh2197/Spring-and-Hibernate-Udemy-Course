package com.jake.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String manipulateUserData(HttpServletRequest request, Model model) {
		// read the request parameter from the html form
		String data = request.getParameter("studentName");
		
		// manipulate the data
		data = data.toUpperCase();
		
		// add the data to the model
		model.addAttribute("message", data);
		
		return "helloworld";
	}

}
