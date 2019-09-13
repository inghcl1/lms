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
import com.hcl.lms.service.HistoryService;

@RestController
@RequestMapping("/api")
public class HistoryServiceController {
	@Autowired
	HistoryService historyService;

	@GetMapping("/history/user/{userId}")
	public ResponseEntity<List<LeaveHistoryWithinDateOutput>> leaveHistoryWithinDates(
			@RequestParam("fromDate") String fromdate, @RequestParam("toDate") String todate,
			@PathVariable("userId") Integer userId) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(historyService.leaveHistoryWithinDates(fromdate, todate, userId));

	}

}
