package com.platform.dao;

import java.util.List;

import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.User;

public interface UserDao {
	
	public int insertUser(User user);
	public int updateUser(User user);
	public Count countUser();
	public List<User> findUsersByPage(PageBean page);
	public List<User> findUserByNameAndPwd(User user);
	public User findUsersById(int id);
	public int deleteUser(int id);
}
