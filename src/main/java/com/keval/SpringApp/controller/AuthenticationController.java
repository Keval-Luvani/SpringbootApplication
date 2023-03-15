package com.keval.SpringApp.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.config.CustomUserDetailService;
import com.keval.SpringApp.config.JwtUtils;
import com.keval.SpringApp.service.StudentServiceImpl;
import com.keval.SpringApp.service.TeacherServiceImpl;
import com.keval.SpringApp.service.UserServiceImpl;

@Controller
public class AuthenticationController {
	RegistrationData teacherRegistrationData = new RegistrationData();
	RegistrationData tempData = new RegistrationData();
	@Autowired
	UserServiceImpl	userServiceImpl;
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@Autowired
	TeacherServiceImpl teacherServiceImpl;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailService userDetailService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String loginPage(Model model,HttpServletRequest request) {
		String authorizationToken=jwtUtils.getToken(request);
		String jwtToken ="";
		if(authorizationToken!=null) {
			jwtToken = authorizationToken.substring(6);
		}
		
		if(authorizationToken!=null&&jwtUtils.validateToken(jwtToken)) {
			String username = jwtUtils.getUsername(jwtToken);
			User user = userServiceImpl.getUser(username);
			if(user.getRole().equals("ROLE_TEACHER")) {
		    	return "redirect:/teacher/assignments";
		    }else {
		    	return "redirect:/student/assignments";
		    }
		}
		model.addAttribute("user",new User());
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user,HttpServletResponse response,Model model) throws Exception {
		
		List<User> emailList = userServiceImpl.getUsers();
		if(!emailList.stream().anyMatch(userdata -> userdata.getEmail().equals(user.getEmail()))){
			model.addAttribute("error","user not register, please register<br>");
			user.setPassword(null);
			model.addAttribute("user",user);
			return "login.jsp";
		}
		 
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		}catch(UsernameNotFoundException unf ) {
			model.addAttribute("Error","Wrong Credential<br>");
			user.setPassword(null);
			model.addAttribute("user",user);
			return "login.jsp";
		}catch(BadCredentialsException bd) {
			model.addAttribute("Error","Wrong Credential<br>");
			user.setPassword(null);
			model.addAttribute("user",user);
			return "login.jsp";
		}
		
		UserDetails userDetails = this.userDetailService.loadUserByUsername(user.getEmail());
		String token = this.jwtUtils.generateToken(userDetails);
		
		Cookie cookie = new Cookie("jwtToken", "Bearer"+token);
	    cookie.setMaxAge(120); 
	    cookie.setHttpOnly(true);
	    cookie.setSecure(false); 
	    cookie.setPath("/");
	    response.addCookie(cookie);
	    
	    if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TEACHER"))) {
	    	return "redirect:/teacher/assignments";
	    }else {
	    	return "redirect:/student/assignments";
	    }
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("registrationData",tempData);
		tempData = null;
		return "register.jsp";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@ModelAttribute("register") RegistrationData registrationData,Model model) {
		tempData = registrationData;
		List<User> emailList = userServiceImpl.getUsers();
		if(emailList.stream().anyMatch(user -> user.getEmail().equals(registrationData.getEmail()))){
			model.addAttribute("error","user already exists<br>");
			model.addAttribute("registrationData",registrationData);
			return "register.jsp";
		}else if(!registrationData.getPassword().equals(registrationData.getConfirmPassword())) {
			model.addAttribute("error","password and confirmpassword does not match<br>");
			model.addAttribute("registrationData",registrationData);
			return "register.jsp";
		}
		
		if(registrationData.getRole().equals("ROLE_TEACHER")) {
			teacherRegistrationData=registrationData;
			return "confirmation.jsp";
		}
		
		userServiceImpl.addUser(registrationData);
		studentServiceImpl.addStudent(registrationData);
		model.addAttribute("user",new User());
		return "redirect:login";
	}
	
	@RequestMapping(value = "/confirmation",method = RequestMethod.POST)
	public String confirmation(@RequestParam("securitycode") String securitycode,Model model) {
		
		if(securitycode.equals("!!@weq456**")) {
			userServiceImpl.addUser(teacherRegistrationData);
			teacherServiceImpl.addTeacher(teacherRegistrationData);
			teacherRegistrationData = null;
		}else {
			model.addAttribute("error","Security Code is not valid");
			return "confirmation.jsp";
		}
		
		return "redirect:login";
	}
	
	@RequestMapping(value = "/signout",method = RequestMethod.GET)
	public String logoutpage(HttpServletRequest request,HttpServletResponse response) {
		Cookie cookie = WebUtils.getCookie(request, "jwtToken");
		if(cookie!=null) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "redirect:login";
	}
}
