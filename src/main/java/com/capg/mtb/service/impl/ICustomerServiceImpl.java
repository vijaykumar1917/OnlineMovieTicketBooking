package com.capg.mtb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.mtb.exceptions.CustomerNotFoundException;
import com.capg.mtb.model.Customer;
import com.capg.mtb.repository.ICustomerRepository;
import com.capg.mtb.service.ICustomerService;
@Component
public class ICustomerServiceImpl implements ICustomerService {
	
	 @Autowired          //	Autowiring feature of spring framework enables you to inject the object dependency
	 ICustomerRepository iCustomerRepository;
	
	

	@Override
	public Customer addCustomer(Customer customer) {
		return iCustomerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {	
		boolean exists = iCustomerRepository.existsById(customer.getUserId());
		if (!exists) {
			throw new CustomerNotFoundException("No Customer id is found:" + customer.getUserId());
		}
		customer = iCustomerRepository.save(customer);
		return customer;
	}

	@Override
	public String deleteCustomer(int userid) {
		
		Customer customer = iCustomerRepository.findById(userid).orElseThrow();
		iCustomerRepository.delete(customer);
		return "Deleted";
		
	}

	@Override
	public Customer viewCustomer(int userid) throws CustomerNotFoundException{
		Optional<Customer> customer =iCustomerRepository.findById(userid);
		if(!customer.isPresent()) 
		    {
			throw new CustomerNotFoundException("No Customer id is found:" + userid);
			}
		return customer.get();
	}

	@Override
	public List<Customer> viewAllCustomers(int movieid) throws CustomerNotFoundException {
		return iCustomerRepository.findByMovieid(movieid);
		
	}

}
