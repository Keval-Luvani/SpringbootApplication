package com.keval.SpringApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringApp.Model.Registration;
import com.keval.SpringApp.Model.User;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user",new User());
		return "login.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("registration",new Registration());
		//model.addAttribute("user",new User());
		return "register.jsp";
	}
	
	@RequestMapping(value = "/conformation",method = RequestMethod.GET)
	public String confirmation(Model model) {
		return "confirmation.jsp";
	}
}
