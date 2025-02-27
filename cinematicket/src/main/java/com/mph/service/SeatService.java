package com.mph.service;


import java.util.List;

import com.mph.entity.Seat;

public interface SeatService {
	public void addSeat(Seat seat);
	public List<Seat> deleteSeat(int seatId);
	public Seat getSeatById(int seatId);
	public List<Seat> updateSeat(Seat seat);
	
}
