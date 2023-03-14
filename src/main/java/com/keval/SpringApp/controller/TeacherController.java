package com.keval.SpringApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringApp.Model.Student;
import com.keval.SpringApp.Model.Teacher;
import com.keval.SpringApp.service.StudentServiceImpl;
import com.keval.SpringApp.service.TeacherServiceImpl;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profilePage(Model model) {
		Teacher teacher = teacherServiceImpl.getTeacher("b@gmail.com");
		System.out.println("mobile no : " + teacher.getMobileno());
		
		model.addAttribute("user",teacher);
		return "../userProfile.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updatePage(Model model) {
		Teacher teacher = teacherServiceImpl.getTeacher("b@gmail.com");
		model.addAttribute("role","teacher");
		model.addAttribute("teacher",teacher);
		return "../updateUser.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute("teacher") Teacher teacher) {
		System.out.println(teacher);
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
		return "../assignmentList.jsp";
	}
}
