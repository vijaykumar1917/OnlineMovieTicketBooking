package com.capg.mtb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.exceptions.MovieNotFoundException;
import com.capg.mtb.model.Movie;
import com.capg.mtb.service.IMovieService;

@RestController              // It will take care of http protocal and requests from browser
public class MovieController {
	
	@Autowired               //	Autowiring feature of spring framework enables you to inject the object dependency
	private IMovieService iMovieService;

	@PostMapping("/addMovie") //Add Movie
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(iMovieService.addMovie(movie));
	}
	
	@PostMapping("/updateMovie") //Update Movie
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
		return ResponseEntity.ok(iMovieService.updateMovie(movie));
	}
	
	@DeleteMapping("/removeMovie/{id}") //Remove Movie by id
	public String removeMovie(@PathVariable("id") int movieId) throws MovieNotFoundException {
		iMovieService.removeMovie(movieId);
		return "Success";
	}
	
	@GetMapping("/movieById/{id}")  // Search movie by id
	public ResponseEntity<Movie> view(@PathVariable("id")int id) throws MovieNotFoundException{
		return ResponseEntity.ok(iMovieService.viewMovie(id));
	}
	
	@GetMapping("/viewMovieList")   // View movie by date
	public List<Movie> viewMovieList() {
		return iMovieService.viewMovieList();
	}
	
	@GetMapping("/movieByTheatreId/{id}")  // View movies by theater id
	public List<Movie> viewMovieList(@PathVariable("id")int id){
		return iMovieService.viewMovieList(id);
	}
	
	@PostMapping("/movieByDate/{date}")   // View movie by date
	public List<Movie> viewMovieList(@RequestBody LocalDate date){
		return iMovieService.viewMovieList(date);
	}
}
