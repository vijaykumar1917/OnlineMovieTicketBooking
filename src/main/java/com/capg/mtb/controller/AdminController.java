package com.capg.mtb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.mtb.model.Admin;
import com.capg.mtb.service.IAdminService;
@RestController // It will take care of http protocol and requests from browser
public class AdminController {
	@Autowired
	private IAdminService iAdminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
		return ResponseEntity.ok(iAdminService.addAdmin(admin));
	}
}
