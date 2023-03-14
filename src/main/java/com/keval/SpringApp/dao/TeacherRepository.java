package com.keval.SpringApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Teacher;

@Component
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	public Teacher getByEmail(String emailId);

}

