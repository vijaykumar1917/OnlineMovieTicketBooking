package com.capg.mtb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.model.User;
import com.capg.mtb.service.IUserService;

@RestController
public class UserController {

	
	
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.ok(iUserService.addUser(user));
	}
}
