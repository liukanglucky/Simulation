package com.platform.service;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.User;

public interface UserService {
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	
	public Count countUser();
	
	public List<User> findAllUser();
	public List<User> findUsersByPage(PageBean page);
	
	public List<User> findUserByName(String name);
	public List<User> findUserByNameAndPwd(User user);
	public User findUserById(int id);
}
