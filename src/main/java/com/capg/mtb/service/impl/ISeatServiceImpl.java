package com.capg.mtb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.mtb.model.Seat;
import com.capg.mtb.repository.ISeatRepository;
import com.capg.mtb.service.ISeatService;

public class ISeatServiceImpl implements ISeatService{
	@Autowired        //	Autowiring feature of spring framework enables you to inject the object dependency
	public ISeatRepository iSeatRepository;

	@Override
	public Seat bookSeat(Seat seat) {
		
		return iSeatRepository.save(seat);
	}

	@Override
	public String cancelSeatBooking(Seat seat) {
		 iSeatRepository.delete(seat);
		 return "Deleted";
	}

	@Override
	public Seat blockSeat(Seat seat) {
		
		return iSeatRepository.save(seat);
	}

}
