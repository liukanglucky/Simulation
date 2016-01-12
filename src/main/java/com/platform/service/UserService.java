package com.platform.service;

import java.util.List;

import com.platform.model.User;

public interface UserService {
	public int insertUser(User user);
	
	public List<User> findAllUser();
	
	public List<User> findUserByName(String name);
}
