package com.mph.service;

/**
 * @author Rajesh
 *
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BookingDao;
import com.mph.entity.Booking;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;
@Transactional
@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	BookingDao bookingDao;
	
	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		if(getBookingById(booking.getBookingId())!= null)
			throw new  DataAlreadyExistsException("Booking with ID : " + booking.getBookingId() + " already exists");
		else {
		bookingDao.addBooking(booking);
		}
	}

	@Override
	public List<Booking> deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		
		if(getBookingById(bookingId)!= null)
			throw new  DataNotFoundException("Booking with ID : " + bookingId + " not found");
		else {
		return bookingDao.deleteBooking(bookingId);
		}
	}

	@Override
	public Booking getBookingById(int bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.getBookingById(bookingId);
	}

	@Override
	public List<Booking> updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		if(getBookingById(booking.getBookingId())!= null)
			throw new  DataNotFoundException("Booking with ID : " + booking.getBookingId() + " not found");
		else {
		return bookingDao.updateBooking(booking);
		}
	}

}
