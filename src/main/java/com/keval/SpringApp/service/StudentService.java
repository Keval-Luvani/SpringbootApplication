package com.keval.SpringApp.service;

import java.util.List;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.Student;

public interface StudentService {
	public void addStudent(RegistrationData registrationData);
	public void updateStudent(Student student);
	public Student getStudent(String emailId);
	public List<Student> getStudents();
}
