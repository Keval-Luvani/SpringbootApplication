package com.keval.SpringApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.Student;
import com.keval.SpringApp.Model.Teacher;
import com.keval.SpringApp.service.AssignmentServiceImpl;
import com.keval.SpringApp.service.StudentServiceImpl;
import com.keval.SpringApp.service.TeacherServiceImpl;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasRole('ROLE_STUDENT')")
public class StudentController {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@Autowired
	AssignmentServiceImpl assignmentServiceImpl;
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profilePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
		Student student = studentServiceImpl.getStudent(userDetails.getUsername());
		model.addAttribute("role","Student");
		model.addAttribute("user",student);
		return "../userProfile.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updatePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
		Student student = studentServiceImpl.getStudent(userDetails.getUsername());
		model.addAttribute("role","student");
		model.addAttribute("student",student);
		return "../updateUser.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute("student") Student student) {
		studentServiceImpl.updateStudent(student);
		return "redirect:profile";
	}
	
	@RequestMapping(value = "/teachers",method = RequestMethod.GET)
	public String teachers(Model model) {
		List<Teacher> teacherList = teacherServiceImpl.getTeachers();
		model.addAttribute("teacherList",teacherList);
		return "../teacherList.jsp";
	}
	
	@RequestMapping(value = "/assignments",method = RequestMethod.GET)
	public String assignments(Model model) {
		List<Assignment> assignments = assignmentServiceImpl.getAssignments();
		model.addAttribute("assignmentList",assignments);
		return "../student_assignment.jsp";
	}
		
}
