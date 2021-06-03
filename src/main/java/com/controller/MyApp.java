package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.User;
import com.service.UserService;

@Controller
//@RequestMapping("/myapp")

public class MyApp {
	@Autowired
	private UserService us;
	@GetMapping("/welcome")
	public String viewHomePage() {
		return "welcome";
	}

	@PostMapping("/login")
	 
	public String loginValid( @RequestParam("uname") String name, @RequestParam("pass") String pass,ModelMap map) {

		if (us.loginValid(name, pass)) {
			return "success";
		}
		map.put("errorMessage", "Login Failed");
		return "login";
	}

	
	  @PostMapping("/register") public String registerUser(@RequestParam("uname")
	  String name, @RequestParam("pass") String pass,
	  
	  @RequestParam("email") String email, @RequestParam("city") String city) {
	  
	  us.addUser(name, pass, email, city);
	  
	  return "success";
	  }
	  @GetMapping("/findAll")
	  @ResponseBody
	  public List<User>loadAll(){
		  return us.loadUsers();
	  }
	  @GetMapping("/finduser/{name}")
	  public String findUser(@PathVariable("name")String name) {
		  
		  if(us.findUser(name)) {
			  return "user found";
		  }
		  return "user not found";
	  }
	  @GetMapping("/deleteuser/{name}")
	  public String deleteUser(@PathVariable("name")String name) {
		  
		  if(us.deleteUser(name)) {
			  return "user deleted";
		  }
		  return "user not found";
	  }
	  
	  @GetMapping("/updateuser/{uname}/{pass}/{email}/{city}") public String updateUser(@PathVariable("uname")
	  String name, @PathVariable("pass") String pass,
	  
	  @PathVariable("email") String email, @PathVariable("city") String city) {
	  
	  us.updateUser(name, pass, email, city);
	  
	  return "user updated successfully"; }
	 
 
}
