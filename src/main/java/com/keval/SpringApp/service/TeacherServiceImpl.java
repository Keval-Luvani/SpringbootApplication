package com.keval.SpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.Teacher;
import com.keval.SpringApp.dao.TeacherDaoImpl;

@Component
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherDaoImpl teacherDaoImpl;
	
	public void addTeacher(RegistrationData registrationData) {
		Teacher teacher = new Teacher(
			registrationData.getEmail(),
			registrationData.getName(),
			registrationData.getMobileno(),
			null
	    );
		teacherDaoImpl.addTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDaoImpl.updateTeacher(teacher);
	}

	public Teacher getTeacher(String emailId) {
		
		return teacherDaoImpl.getTeacher(emailId);
	}

	public List<Teacher> getTeachers() {
		return teacherDaoImpl.getTeachers();
	}

}
