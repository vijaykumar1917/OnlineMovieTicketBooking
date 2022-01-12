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
import com.capg.mtb.model.Customer;
import com.capg.mtb.repository.ICustomerRepository;
import com.capg.mtb.service.impl.ICustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieTicketBookingApplication.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = MovieTicketBookingApplication.class)
public class CustomerControllerTest {
	@InjectMocks
	private ICustomerServiceImpl iCustomerServiceImpl;
	@Mock
	private ICustomerRepository iCustomerRepository;
	
	@Test
	public void testcustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("sri");
		customer.setAddress("Pune");
		customer.setMobileNumber("848364737547");
		customer.setEmail("sri123@gmail.com");
		customer.setPassword("sri222");
		
		Mockito.when(iCustomerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, iCustomerServiceImpl.addCustomer(customer));
		
		
	}
}
