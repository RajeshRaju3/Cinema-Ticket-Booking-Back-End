package com.mph.service;

/**
 * @author Prajjawal 
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.AdminDao;
import com.mph.entity.Admin;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public void addMovie(Admin movie) {
		// TODO Auto-generated method stub
		
		adminDao.addMovie(movie);
	}

	@Override
	public List<Admin> deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		return adminDao.deleteMovie(movieId);
	}

	@Override
	public Admin getMovieById(int movieId) {
		// TODO Auto-generated method stub
		return adminDao.getMovieById(movieId);
	}

	@Override
	public List<Admin> updateMovie(Admin movie) {
		// TODO Auto-generated method stub
		return adminDao.updateMovie(movie);
	}

	@Override
	public List<Admin> getAllMovie() {
		// TODO Auto-generated method stub
		return adminDao.getAllMovie();
	}

}
