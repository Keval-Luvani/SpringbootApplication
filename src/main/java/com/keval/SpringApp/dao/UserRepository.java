package com.keval.SpringApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
