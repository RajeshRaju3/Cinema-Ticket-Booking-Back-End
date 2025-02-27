package com.mph.dao;


import java.util.List;

import com.mph.entity.User;


public interface UserDao {
	public void addUser(User user);
	public List<User> getAllUser();
	public User validateUser(User user);
	public List<User> updateUser(User user);
	public List<User> deleteUser(int uid);
	
	public User getUserById(int uid);
}
