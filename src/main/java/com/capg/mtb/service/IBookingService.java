package com.capg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.mtb.exceptions.BookingNotFoundException;
import com.capg.mtb.model.Booking;

public interface IBookingService {
	public Booking addBooking(Booking booking) throws Exception;

	public Booking updateBooking(Booking booking) throws BookingNotFoundException;

	public void cancelBooking(int bookingid) throws BookingNotFoundException;

	public List<Booking> showAllBooking(LocalDate date);

	public List<Booking> showAllBookingList(int showid) throws BookingNotFoundException;

	public double calculateTotalCost(int bookingid) throws BookingNotFoundException;

	public List<Booking> showAllBooking(int movieid) throws BookingNotFoundException;

}
