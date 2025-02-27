package com.mph.service;

/**
 * @author RaKesh
 *
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UserDao;
import com.mph.entity.User;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Transactional
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public void addUser(User user) {
		if(getUserById(user.getUserId())!= null)
			throw new  DataAlreadyExistsException("User with ID : " + user.getUserId() + " already exists");
		else {
		userDao.addUser(user);
		}
	}

	@Override
	public List<User> getAllUser() {
		
		return userDao.getAllUser();
	}

	@Override
	public User validateUser(User user) {
		
		return userDao.validateUser(user);
	}

	@Override
	public List<User> updateUser(User user) {
		if(getUserById(user.getUserId())!= null)
			throw new  DataNotFoundException("user with ID : " + user.getUserId() + " not found");
		else {
		return userDao.updateUser(user);
		}
	}

	@Override
	public List<User> deleteUser(int userid) {
		if(getUserById(userid)!= null)
			throw new  DataNotFoundException("User with ID : " + userid + " not found");
		else {
		return userDao.deleteUser(userid);
		}
	}

	@Override
	public User getUserById(int userid) {
		
		return userDao.getUserById(userid);
	}



}
