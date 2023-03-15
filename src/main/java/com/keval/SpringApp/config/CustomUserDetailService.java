package com.keval.SpringApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.keval.SpringApp.Model.User;
import com.keval.SpringApp.dao.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.getByEmail(email);
	
		if(user==null){
			throw new UsernameNotFoundException("NO USER");
		}
		
		return (UserDetails)user;
	}
}
