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
import com.mph.entity.Seat;
import com.mph.service.SeatService;

@CrossOrigin(origins = "http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/seat")
public class SeatRestController {
	
	@Autowired
	SeatService SeatService;
	@Autowired
	Booking booking;
	
	
	public void getBooking(Booking booking) {
		this.booking=booking;
	}
	
	

	@PostMapping("/Seat")
	public  Seat setSeat(@RequestBody Seat seat){
		seat.setBooking(booking);
		SeatService.addSeat(seat);
		
		return seat;

	}
	
	@DeleteMapping("/deleteSeat/{id}")
	public  ResponseEntity<List<Seat>> deleteSeat(@PathVariable("id") int seatid){
		List<Seat> seatList = SeatService.deleteSeat(seatid);
		System.out.println("From Rest all Seats : " + seatList);
		
		if(seatList.isEmpty())
		{
			return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Seat>>(seatList,HttpStatus.OK);
	}
	
	@PutMapping("/updateSeat")
	public  ResponseEntity<List<Seat>> updateSeat(@RequestBody Seat seat){
		List<Seat> seatList = SeatService.updateSeat(seat);
		System.out.println("From Rest allemp: " + seatList);
		
		if(seatList.isEmpty())
		{
			return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Seat>>(seatList,HttpStatus.OK);
	}
	
	@GetMapping("/searchSeat/{uid}")
	public  ResponseEntity<Seat> searchSeat(@PathVariable("uid") int seatid){
		Seat seatById = SeatService.getSeatById(seatid);
		System.out.println("From Rest allemp: " + seatById);
		
		if(seatById == null)
		{
			return new ResponseEntity<Seat>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Seat>(seatById,HttpStatus.OK);
	}
}
