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
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		//List<User> temp =userDao.findAllUser();
		//System.out.println(temp);
		return userDao.findAllUser();
	}

	@Override
	public List<User> findUserByName(String name) {
		
		return userDao.findUsersByName(name);
	}
	
	
}
