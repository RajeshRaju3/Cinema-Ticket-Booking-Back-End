package com.mph.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		getSession().saveOrUpdate(booking);
		/*Query query = getSession().createQuery("insert into Ticket(booking) values (?)");
		query.setParameter("booking", booking);*/
		System.out.println("booking added Successfully :)");
		
	}
	
	@Override
	public List<Booking> deleteBooking(int bookingId) {
		Query query = getSession().createQuery("delete from Booking where bookingId=:bookingId");
		query.setParameter("bookingId", bookingId);
		int no_ofRows = query.executeUpdate();
		if(no_ofRows >0)
		{
			System.out.println("Deleted " + no_ofRows + " rows");
		}
		return getAllBooking();
		
		
	}
	

	@Override
	public Booking getBookingById(int bookingId) {
		Criteria c = getSession().createCriteria(Booking.class);
		c.add(Restrictions.eq("bookingId",bookingId));
	     Booking b = (Booking)c.uniqueResult();
		System.out.println("Booking Found : " +b);
		return b;
	}

	@Override
	public List<Booking> updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("update Booking booking set bookingId=:bookingId,movieId=:movieId,no_ofSeatsSelected=:no_ofSeatsSelected,showTime=:showTime,amount=:amount, where bookingId=:bookingId");
		query.setParameter("bookingId", booking.getBookingId());
	
		query.setParameter("no_ofSeatsSelected",booking.getNo_ofseatNameSelected());
		
		query.setParameter("amount",booking.getAmount());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		return getAllBooking();
	}

	private List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Booking booking");
		@SuppressWarnings("unchecked")
		List<Booking> bookinglist = query.list();
		return bookinglist;
	}

	

	

}
