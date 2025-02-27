package com.mph.test;

/**
 * @author Prashant
 *
 */
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;


import com.mph.controller.UserRestController;
import com.mph.entity.User;



public class RestController {
	
	UserRestController userController;
	
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
		userController = new UserRestController();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		userController=null;
		System.out.println("@After calling Test method");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testUserId()
	{
		System.out.println("Testing if the returned user id and the requested user id are the same! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("What is the ID of the user you want to Delete?");
		int userId=sc.nextInt();
		try {
		ResponseEntity<List<User>> userDeleted=userController.deleteUser(userId);
		try{
			assertEquals("redirect:/getcust",userDeleted);
			ResponseEntity<User> user = userController.searchUser(userId);
			if(((List<User>) user).isEmpty())
				System.out.println("User was deleted successfully!");
			}
		catch(Exception exc){
			System.out.println("Oops!The customer could not be deleted!");
		}
		}
		catch(Exception e)
		{
			System.out.println("Oops!The customer does not exist!");
		}

		finally {
			System.out.println("Customer deletion verified Successfully!");
		}
     }

}
