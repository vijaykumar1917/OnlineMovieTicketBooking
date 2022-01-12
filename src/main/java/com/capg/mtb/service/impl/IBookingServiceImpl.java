package com.capg.mtb.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.exceptions.BookingNotFoundException;
import com.capg.mtb.exceptions.MovieNotFoundException;
import com.capg.mtb.exceptions.ShowNotFoundException;
import com.capg.mtb.model.Booking;
import com.capg.mtb.repository.IBookingRepository;
import com.capg.mtb.repository.ICustomerRepository;
import com.capg.mtb.repository.IShowRepository;
import com.capg.mtb.service.IBookingService;

@Component //It means that Spring framework will autodetect these classes for dependency injection when annotation-based 
           // configuration and classpath scanning is used.
public class IBookingServiceImpl implements IBookingService {

	@Autowired          //	Autowiring feature of spring framework enables you to inject the object dependency
	IBookingRepository iBookingRepository;

	@Autowired         //	Autowiring feature of spring framework enables you to inject the object dependency
	IShowRepository iShowRepository;
	
	@Autowired         //	Autowiring feature of spring framework enables you to inject the object dependency
	ICustomerRepository iCustomerRepository;
	

	@Override
	public Booking addBooking(Booking booking) throws Exception {
		
		//validations
		//if there is no customer it will throw MovieNotFoundException
		if(!iCustomerRepository.existsById(booking.getUserid()))
		{
			throw new MovieNotFoundException("No Customer id is found:" + booking.getUserid());		
		}
		//if there is no show it will throw ShowNotFoundException
		else 
		{
		iShowRepository.findById(booking.getShowId())
				.orElseThrow(() -> new ShowNotFoundException("No show id is found:" + booking.getShowId()));
		}
		
		return iBookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) throws BookingNotFoundException {
		boolean exists = iBookingRepository.existsById(booking.getBookingId());
		
		if (!exists) {
			throw new BookingNotFoundException("Booking does not exists for id=" + booking.getBookingId());
		}
		
		else if (!iBookingRepository.existsById(booking.getShowId())){
			throw new BookingNotFoundException("Show id  does not exists for id=" + booking.getShowId());
		}
		
		booking = iBookingRepository.save(booking);
		return booking;
	}

	@Override
	public void cancelBooking(int bookingid) throws BookingNotFoundException {
		Booking booking = iBookingRepository.findById(bookingid).orElseThrow(() -> new BookingNotFoundException("No show id is found:" + bookingid));
		iBookingRepository.delete(booking);
		
	}

	@Override
	public List<Booking> showAllBooking(int movieid) throws BookingNotFoundException {
		return iBookingRepository.findByMovieid(movieid);
	}

	@Override
	public List<Booking> showAllBooking(LocalDate date) {
		return iBookingRepository.findByBookingDate(date);
	}

	@Override
	public List<Booking> showAllBookingList(int showid) throws BookingNotFoundException {
		return iBookingRepository.findByShowId(showid);

	}

	@Override
	public double calculateTotalCost(int bookingid) throws BookingNotFoundException{
		Booking booking = iBookingRepository.findById(bookingid).orElseThrow(() -> new BookingNotFoundException("No Booking id is found:" + bookingid));
		return booking.getTotalCost();
	}

}
