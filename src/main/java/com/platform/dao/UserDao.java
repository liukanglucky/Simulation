package com.platform.dao;

import java.util.List;

import com.platform.model.PageBean;
import com.platform.model.User;

public interface UserDao {
	
	public int insertUser(User user);
	public int updateUser(User user);
	
	
	public List<User> findAllUser();
	public List<User> findUsersByName(String name);
	public List<User> findUsersByPage(PageBean p);
	public User findUsersById(int id);
 	
	public int delete(int id);
}
