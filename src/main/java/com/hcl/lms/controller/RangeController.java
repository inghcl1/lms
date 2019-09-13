package com.hcl.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;
import com.hcl.lms.service.RangeService;

@RestController
@RequestMapping("/hcl")
public class RangeController {

	@Autowired
	RangeService rangeService;

	@GetMapping("/api/{userId}")
public ResponseEntity<List<LeaveHistoryWithinDateOutput>> getRange(@PathVariable Integer userId,@RequestParam Integer range ) {
		
		return new ResponseEntity<>(rangeService.getRange(userId,range),HttpStatus.OK);
		
	}


}
