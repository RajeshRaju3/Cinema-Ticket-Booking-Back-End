package com.mph.controller;

/**
 * @author Prajjawal 
 *
 */
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

import com.mph.entity.Admin;
import com.mph.service.AdminService;


@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/movie")
public class AdminRestController {
		
	@Autowired
	AdminService adminService;

	
	@PostMapping("/setmovie")
	public  Admin setbooking(@RequestBody Admin movie){
		
		adminService.addMovie(movie);
		return movie;
	}
		
	@DeleteMapping("/deleteMovie/{id}")
	public  ResponseEntity<List<Admin>> deletemovie(@PathVariable("id") int movieid){
		List<Admin> movieList = adminService.deleteMovie(movieid);
		System.out.println("From Rest all movie : " + movieList);
		
		if(movieList.isEmpty())
		{
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(movieList,HttpStatus.OK);
	}
	
	@PutMapping("/updatemovie")
	public  ResponseEntity<List<Admin>> updatemovie(@RequestBody Admin movie){
		List<Admin> movieList = adminService.updateMovie(movie);
		System.out.println("From Rest allemp: " + movieList);
		
		if(movieList.isEmpty())
		{
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(movieList,HttpStatus.OK);
	}
	
	@GetMapping("/searchmovie/{uid}")
	public  ResponseEntity<Admin> searchmovie(@PathVariable("uid") int movieid){
		Admin movieById = adminService.getMovieById(movieid);
		System.out.println("From Rest allemp: " + movieById);
		
		if(movieById == null)
		{
			return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Admin>(movieById,HttpStatus.OK);
	}
	
	@GetMapping("/allMovie")
public  ResponseEntity<List<Admin>> allMovies(){
	List<Admin> movieList = adminService.getAllMovie();
	System.out.println("From Rest allemp: " + movieList);
	
	if(movieList.isEmpty())
	{
		return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Admin>>(movieList,HttpStatus.OK);
}
}
