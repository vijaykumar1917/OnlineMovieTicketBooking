package com.capg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.mtb.model.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	
	//Custom Query
	@Query(value = "select movie_Id from Shows m where theatre_id = 1", nativeQuery = true)
	List<Integer> findByTheatreId(int theatreId);
	
}
