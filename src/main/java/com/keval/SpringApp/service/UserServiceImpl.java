package com.keval.SpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.dao.UserDaoImpl;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDaoImpl userDaoImpl;
	
	public void addUser(RegistrationData registrationData) {
		User user = new User();
		user.setEmail(registrationData.getEmail());
		user.setPassword(registrationData.getPassword());
		user.setRole(registrationData.getRole());
		userDaoImpl.addUser(user);
	}

	public void updateUser(User user) {
	}

	public User getUser(String emailId) {
		return null;
	}
	
	public List<User> getUsers() {
		return userDaoImpl.getUsers();
	}

}
