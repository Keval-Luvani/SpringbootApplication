package com.keval.SpringApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Assignment;
import com.keval.SpringApp.Model.Teacher;

@Component
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{

	public List<Assignment> findAllByTeacher(Teacher teacher);

}
