package com.keval.SpringApp.dao;

import java.util.List;

import com.keval.SpringApp.Model.Teacher;

public interface TeacherDao {
	public void addTeacher(Teacher teacher);
	public List<Teacher> getTeachers();
	public Teacher getTeacher(String emailId);
	public void updateTeacher(Teacher teacher);
}
