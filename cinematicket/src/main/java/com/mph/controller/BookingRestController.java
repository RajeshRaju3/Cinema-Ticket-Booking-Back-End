package com.mph.controller;

/**
 * @author Rajesh 
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

import com.mph.entity.Booking;
import com.mph.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/booking")
public class BookingRestController {
		
	@Autowired
	BookingService bookingService;
	@Autowired
	SeatRestController seatRestController;
	
	
	@PostMapping("/booking")
	public  Booking setbooking(@RequestBody Booking booking){
		seatRestController.getBooking(booking);
		//ticketRestController.getBooking(booking);
		bookingService.addBooking(booking);
		return booking;
	}
		
	@DeleteMapping("/deletebooking/{id}")
	public  ResponseEntity<List<Booking>> deletebooking(@PathVariable("id") int bookingid){
		List<Booking> bookingList = bookingService.deleteBooking(bookingid);
		System.out.println("From Rest all bookings : " + bookingList);
		
		if(bookingList.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
	}
	
	@PutMapping("/updatebooking")
	public  ResponseEntity<List<Booking>> updatebooking(@RequestBody Booking booking){
		List<Booking> bookingList = bookingService.updateBooking(booking);
		System.out.println("From Rest allemp: " + bookingList);
		
		if(bookingList.isEmpty())
		{
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
	}
	
	@GetMapping("/searchbooking/{uid}")
	public  ResponseEntity<Booking> searchbooking(@PathVariable("uid") int bookingid){
		Booking bookingById = bookingService.getBookingById(bookingid);
		System.out.println("From Rest allemp: " + bookingById);
		
		if(bookingById == null)
		{
			return new ResponseEntity<Booking>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Booking>(bookingById,HttpStatus.OK);
	}
}
