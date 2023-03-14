package com.keval.SpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.Student;
import com.keval.SpringApp.dao.StudentDaoImpl;

@Component
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDaoImpl studentDaoImpl;

	public void addStudent(RegistrationData registrationData) {
		Student student = new Student();
		student.setEmail(registrationData.getEmail());
		student.setMobileno(registrationData.getMobileno());
		student.setName(registrationData.getName());
		studentDaoImpl.addStudent(student);
	}

	public void updateStudent(Student student) {
		studentDaoImpl.updateStudent(student);
	}

	public Student getStudent(String emailId) {
		
		return studentDaoImpl.getStudent(emailId);
	}

	public List<Student> getStudents() {
		return studentDaoImpl.getStudents();
	}
}
