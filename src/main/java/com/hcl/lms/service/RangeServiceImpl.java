package com.hcl.lms.service;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.LeaveTypesRepository;
import com.hcl.lms.repository.RangeRepository;
import com.hcl.lms.util.LmsConstants;

@Service
public class RangeServiceImpl implements RangeService {
	/**
	 * This program implements an application that displays leave history to the
	 * standard output.
	 *
	 * @author Saicharan
	 * @version 1.0
	 * 
	 */
	@Autowired
	RangeRepository rangeRepository;
	@Autowired
	LeaveTypesRepository leavesTypeRepository;

	@Autowired
	HistoryService historyService;

	@Override
	public List<LeaveHistoryWithinDateOutput> getRange(Integer userId, Integer range) {
		
		List<LeaveHistoryWithinDateOutput> ranges = new ArrayList<LeaveHistoryWithinDateOutput>();


		LocalDate date = LocalDate.now();
		LocalDate dateRange = date.minus(range, ChronoUnit.MONTHS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = date.format(formatter);
		String fromDate = dateRange.format(formatter);

		List<LeaveHistoryWithinDateOutput> leave = historyService.leaveHistoryWithinDates(fromDate, toDate, userId);
		if(!leave.isEmpty())
		{
		leave.forEach(obj -> {
			LeaveHistoryWithinDateOutput dto = new LeaveHistoryWithinDateOutput();
			dto.setAppliedLeaveDate(obj.getAppliedLeaveDate());

			dto.setDescription(obj.getDescription());

			dto.setLeaveType(obj.getLeaveType());
			ranges.add(dto);
		});
		return ranges;}
		else
			throw new LmsException(LmsConstants.NOAPPLIEDLEAVES);

	}
}
