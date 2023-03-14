
package com.keval.SpringApp.dao;

import java.util.List;
import com.keval.SpringApp.Model.User;

public interface UserDao {
	public List<User> getUsers();
	public void addUser(User user);
}
