package com.capg.mtb.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.mtb.exceptions.MovieNotFoundException;
import com.capg.mtb.model.Movie;

public interface IMovieService  {
	
	 Movie addMovie(Movie movie);
	 
	 Movie updateMovie(Movie movie);
	 
	 void removeMovie(int id) throws MovieNotFoundException;
	 
	 Movie viewMovie(int id) throws MovieNotFoundException;
	 
	 List<Movie> viewMovieList();
	 
	 List<Movie> viewMovieList(int theatreid);
	 
	 List<Movie> viewMovieList(LocalDate date);
}
