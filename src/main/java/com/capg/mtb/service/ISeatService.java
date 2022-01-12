package com.capg.mtb.service;

import com.capg.mtb.model.Seat;

public interface ISeatService {
	public Seat bookSeat(Seat seat);
	public String cancelSeatBooking(Seat seat);
	public Seat blockSeat(Seat seat);

}
