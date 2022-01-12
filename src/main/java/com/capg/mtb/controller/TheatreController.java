package com.capg.mtb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.model.Theatre;
import com.capg.mtb.service.ITheatreService;

@RestController                // It will take care of http protocal and requests from browser
public class TheatreController {
	
	@Autowired                  //	Autowiring feature of spring framework enables you to inject the object dependency
	private ITheatreService iTheatreService;
	
	@PostMapping("/addTheatre")    //Adding Theatre
	public ResponseEntity<Theatre> addMovie(@RequestBody Theatre theatre){
		return ResponseEntity.ok(iTheatreService.addtheatre(theatre));
	}
}
