package com.keval.SpringApp.dao;

import java.util.List;

import com.keval.SpringApp.Model.Student;

public interface StudentDao {
	public void addStudent(Student Student);
	public void updateStudent(Student student);
	public Student getStudent(String emailId);
	public List<Student> getStudents();
}
