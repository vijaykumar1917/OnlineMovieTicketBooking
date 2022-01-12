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
import com.capg.mtb.model.Theatre;
import com.capg.mtb.repository.ITheatreRepository;
import com.capg.mtb.service.impl.ITheatreServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTicketBookingApplication.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = MovieTicketBookingApplication.class)
public class TheatreControllerTest {
	@InjectMocks
	private ITheatreServiceImpl iTheatreServiceImpl;
	@Mock
	private ITheatreRepository iTheatreRepository;
	
	@Test
	public void testTheatre() throws Exception {
		Theatre theatre = new Theatre();
		theatre.setTheatreName("Venkateswara");
		theatre.setTheatreCity("Razole");
		theatre.setManagerName("Tanuj");
		theatre.setManagerContact("9515699360");
		
		Mockito.when(iTheatreRepository.save(theatre)).thenReturn(theatre);
		assertEquals(theatre, iTheatreServiceImpl.addtheatre(theatre));
	}


}
