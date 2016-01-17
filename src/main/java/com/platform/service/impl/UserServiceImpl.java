package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.UserDao;
import com.platform.model.User;
import com.platform.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public List<User> findUserByName(String name) {
		
		return userDao.findUsersByName(name);
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUsersById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userDao.delete(id);
	}
	
	
}
