package com.keval.SpringApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.Teacher;
import com.keval.SpringApp.dao.AssignmentDaoImpl;

@Component
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired
	AssignmentDaoImpl assignmentDaoImpl;
	
	@Autowired
	TeacherServiceImpl teacherServiceImpl;

	public Teacher getTeacher() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Teacher teacher = teacherServiceImpl.getTeacher(userDetails.getUsername());
		return teacher;
	}
	
	public List<Assignment> getAssignments() {
		return assignmentDaoImpl.getAssignments();
	}


	public Assignment getAssignment(int assignmentId) {
		return assignmentDaoImpl.getAssignment(assignmentId);
	}
	

	public List<Assignment> getAssignmentByTeacher() {
		return assignmentDaoImpl.getAssignmentByTeacher(getTeacher());
	}
	
	public void addAssignment(Assignment assignment) {
		assignment.setTeacher(getTeacher());
		assignmentDaoImpl.addAssignment(assignment);
	}

	
	public void updateAssignment(Assignment assignment) {
		assignment.setTeacher(getTeacher());
		assignmentDaoImpl.updateAssignment(assignment);
	}

	public void deleteAssignment(int assignmentId) {
		assignmentDaoImpl.deleteAssignment(assignmentId);
	}

}
