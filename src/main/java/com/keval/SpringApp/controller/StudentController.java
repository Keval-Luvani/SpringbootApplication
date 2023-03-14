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
@RequestMapping("/student")
public class StudentController {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profilePage(Model model) {
		Student student = studentServiceImpl.getStudent("kluvani22@gmail.com");
		System.out.println("mobile no : " + student.getMobileno());
		model.addAttribute("user",student);
		return "../userProfile.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updatePage(Model model) {
		Student student = studentServiceImpl.getStudent("kluvani22@gmail.com");
		model.addAttribute("role","student");
		model.addAttribute("student",student);
		return "../updateUser.jsp";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@ModelAttribute("student") Student student) {
		System.out.println(student);
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
		return "../assignmentList.jsp";
	}
		
}
