package com.keval.SpringApp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.service.AssignmentServiceImpl;

@Controller
@RequestMapping("/assignment")
@PreAuthorize("hasRole('ROLE_TEACHER')")
public class AssignmentController {
	
	@Autowired
	AssignmentServiceImpl assignmentServiceImpl;
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public String createPage(Model model) {
		model.addAttribute("todayDate",LocalDate.now());
		model.addAttribute("assignment",new Assignment());
		return "../assignment.jsp";
	}
	
	@RequestMapping(value="/update{assignmentId}",method = RequestMethod.GET)
	public String updatePage(Model model,@PathVariable int assignmentId) {
		Assignment assignment = assignmentServiceImpl.getAssignment(assignmentId);
		model.addAttribute("todayDate",LocalDate.now());
		model.addAttribute("assignment",assignment);
		return "../assignment.jsp";
	}
	
	@RequestMapping(value="/delete{assignmentId}",method = RequestMethod.GET)
	public String delete(@PathVariable int assignmentId) {
		assignmentServiceImpl.deleteAssignment(assignmentId);
		return "redirect:/teacher/assignments";
	}
	
	@RequestMapping(value="/submit",method = RequestMethod.POST)
	public String create(@ModelAttribute("assignment") Assignment assignment) {
	
		if(assignment.getId()==0) {
			assignmentServiceImpl.addAssignment(assignment);
		}else {
			if(assignmentServiceImpl.getTeacher().getId() == assignment.getTeacher().getId()) {
				assignmentServiceImpl.updateAssignment(assignment);
			}else {
				return "../error.jsp";
			}
		}
		return "redirect:/teacher/assignments";
	}
}
