package com.capg.mtb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.exceptions.BookingNotFoundException;
import com.capg.mtb.model.Booking;
import com.capg.mtb.service.IBookingService;
//it is responsible for rest api requests
@RestController                 // It will take care of http protocal and requests from browser
public class BookingController {  //

	@Autowired                  //	Autowiring feature of spring framework enables you to inject the object dependency
	IBookingService iBookingService;
	
     //@ResponseBody annotations are used to bind the HTTP request/response body with a domain object in method parameter 
	@PostMapping("/addBooking") // Booking Ticket
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws Exception {
		return ResponseEntity.ok(iBookingService.addBooking(booking));
	}
	

	@PostMapping("/updateBooking") // Update Ticket
	public Booking updateBooking(@RequestBody Booking booking) throws BookingNotFoundException {
		return iBookingService.updateBooking(booking);
	}
	
    //@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable
	@DeleteMapping("/cancelBooking/{id}") //cancel Tcieket
	public String cancelBooking(@PathVariable("id") int id) throws BookingNotFoundException {
		iBookingService.cancelBooking(id);
		return "Success";
	}
	

	@GetMapping("/bookingByMovieId/{movieId}")  //Search ticket by movie id
	public List<Booking> showAllBooking(@PathVariable("movieId") int movieid) throws BookingNotFoundException {
		return iBookingService.showAllBooking(movieid);
	}
	

	@PostMapping("/bookingByDate")         // Search By Date 
	public List<Booking> showAllBooking(@RequestBody Booking booking) throws BookingNotFoundException {
		if(booking.getBookingDate()==null)
			throw new BookingNotFoundException("booking date is mandatory");
		
		return iBookingService.showAllBooking(booking.getBookingDate());
	}
	

	@GetMapping("/bookingByShowId/{showId}")  //Search by show id
	public List<Booking> showAllBookingList(@PathVariable("showId") int showid) throws BookingNotFoundException {
		return iBookingService.showAllBookingList(showid);
	}

	
	@GetMapping("/calculateTotalCost/{bookingid}")  // Total cost
	public double calculateTotalCost(@PathVariable("bookingid") int bookingid)throws BookingNotFoundException {
		return iBookingService.calculateTotalCost(bookingid);
	}

}
