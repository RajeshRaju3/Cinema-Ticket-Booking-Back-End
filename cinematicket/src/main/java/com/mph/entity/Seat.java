package com.mph.entity;

/**
 * @author Rishabh
 *
 */


import javax.persistence.Column;
import javax.persistence.Entity
;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SEAT_TABLE")
public class Seat {
	@Id
	@Column(name="SEAT_ID")	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	
	@Column(name="SEAT_NAME")
	private String seatName;

	@ManyToOne
	@JoinColumn(name="bookingId")
	private Booking booking; 

	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int seatId, String seatName, Booking booking) {
		super();
		this.seatId = seatId;
		this.seatName = seatName;
		this.booking = booking;
		
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatName=" + seatName + ", booking=" + booking 
				+ "]";
	}
	
	
}
