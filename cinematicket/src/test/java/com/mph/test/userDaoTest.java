package com.mph.test;
/**
 * @author Prashant
 *
 */
import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mph.dao.UserDao;
import com.mph.dao.UserDaoImpl;
import com.mph.entity.User;



//Unit Testing on a functionality from DAO layer(CustomerDaoImpl)

public class userDaoTest {

	UserDao userDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		System.out.println("Initiating Unit Testing ...");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception
	{
		System.out.println("Terminating Unit Testing ...");
	}
	
	@Before
	public void setUp() throws java.lang.Exception
	{
		System.out.println("@Before calling Test method");
		userDao = new UserDaoImpl();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		userDao=null;
		System.out.println("@After calling Test method");
	}
	
	@Test
	public void testUserId()
	{
		System.out.println("Testing if the returned user id and the requested user id are the same! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter an existing user ID");
		int userId=sc.nextInt();
		try {
		User userReturned=userDao.getUserById(userId);
		assertEquals(userReturned.getUserId(), userId);
		}
		catch(Exception e)
		{
			System.out.println("Oops!The user does not exist!");
		}

		finally {
			System.out.println("User verified Successfully!");
		}
     }
}
