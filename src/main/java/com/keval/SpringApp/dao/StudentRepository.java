package com.keval.SpringApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.Student;

@Component
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findByEmail(String email);

}
