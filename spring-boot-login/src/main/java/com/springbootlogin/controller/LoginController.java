package com.springbootlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootlogin.model.User;
import com.springbootlogin.service.UserService;

@Controller
@RequestMapping("/userLogin")
public class LoginController {
	
	
	@Autowired
	private UserService us;
	
	@RequestMapping("/register")
	public String getRegistrationDetails(Model model) {
		User userObj = new User();
		model.addAttribute("user", userObj);
		return "addUser";
	}
	
	@RequestMapping("/create")
	public String addUserDetails(User user) {		
		us.addUser(user);
		return "redirect:/userLogin/login";
	}
	
	@RequestMapping("/login")
	public String addLoginDetails(Model model) {	
		User userObj = new User();
		model.addAttribute("user", userObj);
		return "Login";
	}
	
	@RequestMapping("/validate")
	public String validateLoginDetails(Model model,User user) {	
		if(us.validateUser(user))
			return "Welcome";
		else
			return "Login";
	}



}
