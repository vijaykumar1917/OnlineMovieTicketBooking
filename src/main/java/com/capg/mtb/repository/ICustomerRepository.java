package com.capg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.mtb.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

	@Query(value="select * from customers where user_id in(select user_id from bookings where show_id in (select show_id from shows where movie_id = 1))", nativeQuery = true)
	List<Customer> findByMovieid(int movieid);

}
