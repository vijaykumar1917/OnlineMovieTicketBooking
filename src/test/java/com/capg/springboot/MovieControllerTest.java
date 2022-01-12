package com.capg.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.capg.mtb.MovieTicketBookingApplication;
import com.capg.mtb.model.Movie;
import com.capg.mtb.repository.IMovieRepository;
import com.capg.mtb.service.impl.IMovieServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTicketBookingApplication.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = MovieTicketBookingApplication.class)
public class MovieControllerTest {
	@InjectMocks
	private IMovieServiceImpl iMovieServiceImpl;
	@Mock
	private IMovieRepository iMovieRepository;
	
	@Test
	public void testmovie() {
		Movie movie = new Movie();
		movie.setMovieName("RRR");
		movie.setMovieGenre("Fantasy");
		movie.setMovieHours("03:00");
		movie.setLanguage("telugu");
		movie.setDescription("rajamouli film");
		
		Mockito.when(iMovieRepository.save(movie)).thenReturn(movie);
		assertEquals(movie, iMovieServiceImpl.addMovie(movie));
	}

}
