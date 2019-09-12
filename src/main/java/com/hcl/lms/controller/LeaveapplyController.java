package com.hcl.lms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.LeaveReqDto;
import com.hcl.lms.dto.LeaveResDto;
import com.hcl.lms.service.LeaveapplyService;


/**
 *  controller to apply leave 
 * @author Pradeep AJ
 * @param LeaveReqDto
 * @return LeaveResDto
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class LeaveapplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveapplyController.class);
	
	@Autowired
	private LeaveapplyService leaveapplyService;
	
	@PostMapping("/apply")
	public ResponseEntity<LeaveResDto> applyLeave(@RequestBody LeaveReqDto LeaveReq){
		logger.info("Enter into LeaveapplyController applyLeave()");
		return new ResponseEntity<>(leaveapplyService.applyLeave(LeaveReq), HttpStatus.CREATED);
	}
	

}
