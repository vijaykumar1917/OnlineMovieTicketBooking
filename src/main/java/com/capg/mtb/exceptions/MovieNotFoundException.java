package com.capg.mtb.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="id is not available")
public class MovieNotFoundException extends Exception {


	public MovieNotFoundException(String string) {
		super(string);
	}

}
