package com.mph.service;

/**
 * @author Rajesh
 *
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.SeatDao;
import com.mph.entity.Seat;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Transactional
@Service
public class SeatServiceImpl implements SeatService{
	
	@Autowired
	SeatDao seatDao;
	
	/*
	@Override
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
		seatDao.addSeat(seat);
	}*/

	@Override
	public List<Seat> deleteSeat(int seatId) {
		// TODO Auto-generated method stub
		if(getSeatById(seatId)!= null)
			throw new  DataNotFoundException("Seat with ID : " + seatId + " not found");
		else {
		return seatDao.deleteSeat(seatId);
		}
	}
	@Override
	public Seat getSeatById(int seatId) {
		// TODO Auto-generated method stub
		return seatDao.getSeatById(seatId);
	}

	@Override
	public List<Seat> updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		
		if(getSeatById(seat.getSeatId())!= null)
			throw new  DataNotFoundException("Seat with ID : " + seat.getSeatId() + " not found");
		else {
		return seatDao.updateSeat(seat);
		}
	}
	@Override
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
		System.out.println("in add service \n");
		if(getSeatById(seat.getSeatId())!= null)
			throw new  DataAlreadyExistsException("Seat with ID : " + seat.getSeatId() + " already exists");
		else {
		seatDao.addSeat(seat);	
		}
	}

	

}
