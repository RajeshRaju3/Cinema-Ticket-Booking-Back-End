package com.mph.dao;

/**
 * @author Rishabh 
 *
 */
import java.util.List;

import com.mph.entity.Booking;

public interface BookingDao {
	public void addBooking(Booking booking);
	public List<Booking> deleteBooking(int bookingId);
	public Booking getBookingById(int bookingId);
	public List<Booking> updateBooking(Booking booking);
}
