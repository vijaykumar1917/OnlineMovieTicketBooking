package com.capg.mtb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="id is not available")
public class CustomerNotFoundException extends Exception {

	
	public CustomerNotFoundException(String string) {
		super(string);
	}
}
