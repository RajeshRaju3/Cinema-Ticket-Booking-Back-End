package com.mph.dao;


import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public void addUser(User user) {
		
		getSession().saveOrUpdate(user);
		System.out.println("User added Successfully :)");
	}

	@Override
	public List<User> getAllUser() {
		
		Query query = getSession().createQuery("from User user");
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		return userList;
	}

	@Override
	public User validateUser(User user) {
		
		Criteria c = getSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", user.getEmail()));
		c.add(Restrictions.eq("password", user.getPassword()));
		User uniqueUser = (User)c.uniqueResult();
		System.out.println("User Retrieved : " + uniqueUser);
		return uniqueUser;
	}

	@Override
	public List<User> updateUser(User user) {
		
		Query query = getSession().createQuery("update User user set fname=:fname,lname=:lname,gender=:gender,phone=:phone where userId =:eno");
		query.setParameter("fname", user.getFname());
		query.setParameter("lname",user.getLname());
		query.setParameter("gender",user.getGender());
		query.setParameter("phone", user.getPhone());
		query.setParameter("eno",user.getUserId());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		return getAllUser();
	}

	@Override
	public List<User> deleteUser(int userId) {

		Query query = getSession().createQuery("delete from User user where userId=:userId");
		query.setParameter("userId", userId);
		int no_ofRows = query.executeUpdate();
		if(no_ofRows >0)
		{
			System.out.println("Deleted " + no_ofRows + " rows");
		}
		return getAllUser();
		
	}
	

	@Override
	public User getUserById(int userId) {

		Criteria c = getSession().createCriteria(User.class);
		c.add(Restrictions.eq("userId", userId));
		User user = (User)c.uniqueResult();
		System.out.println("User Found : " + user);
		return user;
	}

}
