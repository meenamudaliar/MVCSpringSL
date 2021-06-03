package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
//@RequestMapping("/myapp")
public class FileController {
	
	
	
//@RequestMapping(value = "/login" , method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}


//@RequestMapping(value = "/register" , method = RequestMethod.GET)
	@GetMapping("/register")
public String register() {
	
	return "register";
}

}
