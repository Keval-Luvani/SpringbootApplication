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
@RequestMapping("/teacher")
@PreAuthorize("hasRole('ROLE_TEACHER')")
public class TeacherController {
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
		Teacher teacher = teacherServiceImpl.getTeacher(userDetails.getUsername());
		model.addAttribute("role","Teacher");
		model.addAttribute("user",teacher);
		return "../userProfile.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updatePage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
		Teacher teacher = teacherServiceImpl.getTeacher(userDetails.getUsername());
		model.addAttribute("role","teacher");
		model.addAttribute("teacher",teacher);
		return "../updateUser.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute("teacher") Teacher teacher) {
		teacherServiceImpl.updateTeacher(teacher);
		return "redirect:profile";
	}
	
	@RequestMapping(value = "/students",method = RequestMethod.GET)
	public String students(Model model) {
		List<Student> studentList = studentServiceImpl.getStudents();
		model.addAttribute("studentList",studentList);
		return "../studentList.jsp";
	}
	
	@RequestMapping(value = "/assignments",method = RequestMethod.GET)
	public String assignments(Model model) {
		List<Assignment> assignments = assignmentServiceImpl.getAssignmentByTeacher();
		model.addAttribute("assignmentList",assignments);
		return "../teacher_assignment.jsp";
	}
}
