package com.capg.mtb.service;

import java.util.List;

import com.capg.mtb.exceptions.CustomerNotFoundException;
import com.capg.mtb.model.Customer;

public interface ICustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	
	String deleteCustomer(int userid);
	
	Customer viewCustomer(int custid)throws CustomerNotFoundException;
	
	List<Customer> viewAllCustomers(int movieid) throws CustomerNotFoundException;

}
