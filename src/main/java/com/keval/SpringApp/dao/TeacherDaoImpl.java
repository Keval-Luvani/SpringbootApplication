package com.keval.SpringApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Teacher;

@Component
public class TeacherDaoImpl implements TeacherDao{

	@Autowired
	TeacherRepository teacherRepository;
	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}
	public Teacher getTeacher(String emailId) {
		return teacherRepository.getByEmail(emailId);
	}
	public void updateTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}
}
