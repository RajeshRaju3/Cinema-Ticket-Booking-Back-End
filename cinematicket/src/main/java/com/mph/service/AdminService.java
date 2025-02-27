package com.mph.service;


import java.util.List;

import com.mph.entity.Admin;

public interface AdminService {
	
	public void addMovie(Admin movie);
	public List<Admin> deleteMovie(int movieId);
	public Admin getMovieById(int movieId);
	public List<Admin> updateMovie(Admin movie);
	public List<Admin> getAllMovie();

}
