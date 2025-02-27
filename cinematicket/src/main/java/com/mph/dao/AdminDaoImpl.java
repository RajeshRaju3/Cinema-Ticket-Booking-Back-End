package com.mph.dao;

/**
 * @author Prajjawal 
 *
 */
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Admin;
@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	
	@Override
	public void addMovie(Admin movie) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(movie);
		System.out.println("movie added Successfully :)");
	}

	@Override
	public List<Admin> deleteMovie(int movieId) {
		Query query = getSession().createQuery("delete from Admin where movieId=:movieId");
		query.setParameter("movieId", movieId);
		int no_ofRows = query.executeUpdate();
		if(no_ofRows >0)
		{
			System.out.println("Deleted " + no_ofRows + " rows");
		}
		return getAllMovie();
	}

	@Override
	public Admin getMovieById(int movieId) {
		Criteria c = getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("movieId",movieId));
	     Admin admin = (Admin)c.uniqueResult();
		System.out.println("Movie Found : " +admin);
		return admin;
	}

	@Override
	public List<Admin> updateMovie(Admin movie) {
		// TODO Auto-generated method stub
				Query query = getSession().createQuery("update Admin admin set movieId=:movieId,movieName=:movieName,language=:language,amount =:amount,description=:description");
				query.setParameter("movieId", movie.getMovieId());
				query.setParameter("movieName", movie.getMovieName());
				query.setParameter("language", movie.getLanguage());
				query.setParameter("amount",movie.getAmount());
				query.setParameter("description", movie.getDescription());

				
				int noofrows = query.executeUpdate();
				if(noofrows >0)
				{
					System.out.println("Updated " + noofrows + " rows");
				}
				return getAllMovie();
	}

	@Override
	public List<Admin> getAllMovie() {
		// TODO Auto-generated method stub
				Query query = getSession().createQuery("from Admin admin");
				@SuppressWarnings("unchecked")
				List<Admin> movielist = query.list();
				return movielist;
	}
	

}
