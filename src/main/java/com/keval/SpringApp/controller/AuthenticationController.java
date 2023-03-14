package com.keval.SpringApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.service.StudentServiceImpl;
import com.keval.SpringApp.service.TeacherServiceImpl;
import com.keval.SpringApp.service.UserServiceImpl;

@Controller
public class AuthenticationController {
	RegistrationData teacherRegistrationData = new RegistrationData();
	
	@Autowired
	UserServiceImpl	userServiceImpl;
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@Autowired
	TeacherServiceImpl teacherServiceImpl;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user",new User());
		return "login.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("registrationData",new RegistrationData());
		return "register.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@ModelAttribute("register") RegistrationData registrationData,Model model) {
		List<User> emailList = userServiceImpl.getUsers();
		if(emailList.stream().anyMatch(user -> user.getEmail().equals(registrationData.getEmail()))){
			System.out.println("*Entered here--");
			model.addAttribute("error","user already exists");
			model.addAttribute("registrationData",registrationData);
			return "register.jsp";
		}
		
		if(registrationData.getRole().equals("ROLE_TEACHER")) {
			System.out.println("*Entered here in confirmation---");
			teacherRegistrationData=registrationData;
			return "confirmation.jsp";
		}
		userServiceImpl.addUser(registrationData);
		studentServiceImpl.addStudent(registrationData);
		model.addAttribute("user",new User());
		return "login.jsp";
	}
	
	@RequestMapping(value = "/conformation",method = RequestMethod.POST)
	public String confirmation(@RequestParam("securitycode") String securitycode,Model model) {
		System.out.println(teacherRegistrationData.getEmail());
		System.out.println(teacherRegistrationData.getMobileno());
		System.out.println(securitycode);
		if(securitycode.equals("!!@weq456**")) {
			userServiceImpl.addUser(teacherRegistrationData);
			teacherServiceImpl.addTeacher(teacherRegistrationData);
			teacherRegistrationData = null;
		}else {
			model.addAttribute("error","Security Code is not valid");
			return "confirmation.jsp";
		}
		
		model.addAttribute("user",new User());
		return "login.jsp";
	}
}
