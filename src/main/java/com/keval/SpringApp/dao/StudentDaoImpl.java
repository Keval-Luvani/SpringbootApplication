package com.keval.SpringApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Student;

@Component
public class StudentDaoImpl implements StudentDao{

	@Autowired
	StudentRepository studentRepository;
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public Student getStudent(String emailId) {
		return studentRepository.findByEmail(emailId);
	}

	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

}
