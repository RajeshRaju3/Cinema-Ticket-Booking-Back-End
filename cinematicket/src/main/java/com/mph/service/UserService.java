package com.mph.service;

/**
 * @author Rakesh
 *
 */
import java.util.List;



import com.mph.entity.User;



public interface UserService {
	public void addUser(User user);
	public List<User> getAllUser();
	public User validateUser(User user);
	public List<User> updateUser(User user);
	public List<User> deleteUser(int userid);
	
	public User getUserById(int userid);
}
