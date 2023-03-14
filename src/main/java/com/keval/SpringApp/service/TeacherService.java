package com.keval.SpringApp.service;

import java.util.List;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.Teacher;

public interface TeacherService {
	public void addTeacher(RegistrationData registrationData);
	public void updateTeacher(Teacher teacher);
	public Teacher getTeacher(String emailId);
	public List<Teacher> getTeachers();
}
