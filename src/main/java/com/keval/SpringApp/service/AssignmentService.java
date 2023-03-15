package com.keval.SpringApp.service;

import java.util.List;

import com.keval.SpringApp.Model.Assignment;

public interface AssignmentService {
	public List<Assignment> getAssignments();
	public List<Assignment> getAssignmentByTeacher();
	public Assignment getAssignment(int assignmentId);
	public void addAssignment(Assignment assignment);
	public void updateAssignment(Assignment assignment);
	public void deleteAssignment(int assignmentId);
}
