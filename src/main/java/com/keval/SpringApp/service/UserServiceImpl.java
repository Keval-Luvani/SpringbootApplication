package com.keval.SpringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.dao.UserDaoImpl;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public void addUser(RegistrationData registrationData) {
		User user = new User();
		user.setEmail(registrationData.getEmail());
		user.setPassword(passwordEncoder.encode(registrationData.getPassword()));
		user.setRole(registrationData.getRole());
		userDaoImpl.addUser(user);
	}
	
	public List<User> getUsers() {
		return userDaoImpl.getUsers();
	}
	public User getUser(String emailId) {
		return userDaoImpl.getUser(emailId);
	}

}
