package com.keval.SpringApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.User;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}

	public User getUser(String emailId) {
		return userRepository.getByEmail(emailId);
	}

	
}
