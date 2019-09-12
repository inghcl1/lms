package com.hcl.lms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.service.AvailableService;


@RestController
@RequestMapping("/hcl")
public class AvailableController {
	@Autowired
	AvailableService availableService;
	@GetMapping("/api/leaves/{userId}")
	public ResponseEntity viewAvailableLeaves(@PathVariable Integer userId ) {
		
		return new ResponseEntity<>(availableService.availableLeaves(userId),HttpStatus.OK);
		
	}

}
