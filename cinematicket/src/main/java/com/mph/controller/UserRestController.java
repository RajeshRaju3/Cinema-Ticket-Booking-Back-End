package com.mph.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.User;
import com.mph.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allUser")
public  ResponseEntity<List<User>> allUsers(){
	List<User> userList = userService.getAllUser();
	System.out.println("From Rest allemp: " + userList);
	
	if(userList.isEmpty())
	{
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
}
	
	
	@PostMapping("/addUser")
public  User addUser(@RequestBody User user){
	userService.addUser(user);
	return user;

}
	
	
	@DeleteMapping("/deleteUser/{uid}")
public  ResponseEntity<List<User>> deleteUser(@PathVariable("uid") int userid){
	List<User> userList = userService.deleteUser(userid);
	System.out.println("From Rest allemp: " + userList);
	
	if(userList.isEmpty())
	{
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
}
	
	
	@PutMapping("/updateUser")
public  ResponseEntity<List<User>> updateUser(@RequestBody User user){
	List<User> userList = userService.updateUser(user);
	System.out.println("From Rest allemp: " + userList);
	
	if(userList.isEmpty())
	{
		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
}
	
	
	@GetMapping("/searchUser/{uid}")
public  ResponseEntity<User> searchUser(@PathVariable("uid") int userid){
	User userById = userService.getUserById(userid);
	System.out.println("From Rest allemp: " + userById);
	
	if(userById == null)
	{
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<User>(userById,HttpStatus.OK);
}
}

