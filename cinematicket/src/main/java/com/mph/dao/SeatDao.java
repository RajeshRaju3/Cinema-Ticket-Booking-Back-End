package com.mph.dao;

/**
 * @author Rishabh
 *
 */
import java.util.List;

import com.mph.entity.Seat;

public interface SeatDao {
	public void addSeat(Seat seat);

	public List<Seat> deleteSeat(int seatId);

	public Seat getSeatById(int seatId);

	public List<Seat> updateSeat(Seat seat);
}
