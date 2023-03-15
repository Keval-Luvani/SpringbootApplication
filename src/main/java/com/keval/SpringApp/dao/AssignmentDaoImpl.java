package com.keval.SpringApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.Teacher;
@Component
public class AssignmentDaoImpl implements AssignmentDao{
	
	@Autowired
	AssignmentRepository assignmentRepository;

	public List<Assignment> getAssignments() {
		return assignmentRepository.findAll();
	}
	
	public Assignment getAssignment(int assignmentId) {
		return assignmentRepository.findById(assignmentId).get();
	}

	public void addAssignment(Assignment assignment) {
		assignmentRepository.save(assignment);
	}

	public void updateAssignment(Assignment assignment) {
		assignmentRepository.save(assignment);
	}

	public void deleteAssignment(int assignmentId) {
		System.out.println("delete id assignment"+ assignmentId);
		assignmentRepository.deleteById(assignmentId);
	}
	
	public List<Assignment> getAssignmentByTeacher(Teacher teacher) {
		return assignmentRepository.findAllByTeacher(teacher);
	}
}
