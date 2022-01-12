package com.capg.mtb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.mtb.model.Booking;

//repositories are clas that encapsulate the logic required yo aceess data source
public interface IBookingRepository extends JpaRepository<Booking, Integer>{
	public List<Booking> findByShowId(int showid);
	
	@Query(value = "SELECT * FROM bookings where show_id in ( SELECT show_id FROM SHOWS where movie_id = 1 )", nativeQuery = true)
	public List<Booking> findByMovieid(int movieid);
	
	public List<Booking> findByBookingDate(LocalDate date);
}
