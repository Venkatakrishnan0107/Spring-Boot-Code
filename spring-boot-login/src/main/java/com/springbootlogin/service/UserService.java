package com.springbootlogin.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootlogin.model.User;
import com.springbootlogin.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void addUser(User userObj) {
		String password = userObj.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		userObj.setPassword(encodedPassword);
		ur.save(userObj);
	}

	public boolean validateUser(User userObj) {
		User obj = ur.findByUsername(userObj.getUsername());
		if(!Objects.isNull(obj))
			return passwordEncoder.matches(userObj.getPassword(), obj.getPassword());
		return false;
	}

}
