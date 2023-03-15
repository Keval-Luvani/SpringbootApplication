package com.keval.SpringApp.service;

import java.util.List;

import com.keval.SpringApp.Model.RegistrationData;
import com.keval.SpringApp.Model.User;

public interface UserService {
	
	public void addUser(RegistrationData registrationData);
	public User getUser(String emailId);
	public List<User> getUsers();
}
