package com.keval.SpringApp.dao;

import java.util.List;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.Teacher;

public interface AssignmentDao {
	public List<Assignment> getAssignments();
	public List<Assignment> getAssignmentByTeacher(Teacher teacher) ;
	public Assignment getAssignment(int assignmentId);
	public void addAssignment(Assignment assignment);
	public void updateAssignment(Assignment assignment);
	public void deleteAssignment(int assignmentId);
}
