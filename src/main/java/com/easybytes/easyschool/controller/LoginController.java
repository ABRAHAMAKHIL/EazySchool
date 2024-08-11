package com.easybytes.easyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String DisplayLoginPage(@RequestParam(value="error",required=false)String error, 
			@RequestParam(value="logout",required=false)String logout, Model model) {
		
		String errorMessge = null;
	
		
		if(error!=null) {
			
			errorMessge="Username or password Incorrect";
		}
		else if(logout!=null) {
			
			errorMessge = "Successfully logged Out";
		}
		
		model.addAttribute("userMessage",errorMessge	);
	    return "login.html";
		

		
		
	}

}
