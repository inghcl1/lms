package com.hcl.lms.service;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.RangeDto;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.LeaveType;
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
	

	@Override
	public List<RangeDto> getRange(Integer userId,String range) {

		List<RangeDto> ranges = new ArrayList<RangeDto>();
		if (range.equals(LmsConstants.LAST_THREE_MONTHS)) {
			LocalDate date = LocalDate.now();
			LocalDate lastThreeMonths = date.minus(LmsConstants.MONTH_VALUE, ChronoUnit.MONTHS);

			List<AppliedLeave> leave = rangeRepository.findAll(userId,date,lastThreeMonths);
		leave.forEach(obj -> {
				RangeDto dto = new RangeDto();
				dto.setAppliedLeaveDate(obj.getAppliedLeaveDate());

				dto.setDescription(obj.getDescription());
				Optional<LeaveType> leaveTypes = leavesTypeRepository.findById(obj.getLeaveTypeId());
				dto.setLeaveType(leaveTypes.get().getLeaveType());
				ranges.add(dto);
			});
			return ranges;

		}

		else {
			LocalDate date = LocalDate.now();

			List<AppliedLeave> leave = rangeRepository.findByuserId(userId);
			

			List<AppliedLeave> h2 = leave.stream()
					.filter(line -> date.getMonth() == line.getAppliedLeaveDate().getMonth())
					.collect(Collectors.toList());

			h2.forEach(obj -> {
				RangeDto dto = new RangeDto();
				dto.setAppliedLeaveDate(obj.getAppliedLeaveDate());

				dto.setDescription(obj.getDescription());
				Optional<LeaveType> leaveTypes = leavesTypeRepository.findById(obj.getLeaveTypeId());
				dto.setLeaveType(leaveTypes.get().getLeaveType());
				ranges.add(dto);
			});
			return ranges;
		}
	}
}
