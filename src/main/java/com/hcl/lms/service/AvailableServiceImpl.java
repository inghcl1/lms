package com.hcl.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.AvailableDto;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.entity.LeaveType;
import com.hcl.lms.exception.LmsException;

import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveTypesRepository;
import com.hcl.lms.repository.LeavesRepository;
import com.hcl.lms.util.LmsConstants;

/**
 * This program implements an application that displays available leaves to the
 * standard output.
 *
 * @author Saicharan
 * @version 1.0
 * 
 */
@Service
public class AvailableServiceImpl implements AvailableService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AvailableServiceImpl.class);
	@Autowired
	LeaveTypesRepository leavesTypeRepository;
	@Autowired
	LeavesRepository leavesRepository;
	@Autowired
	AppliedLeaveRepository appliedLeaveRepository;

	@Override
	public List<AvailableDto> availableLeaves(Integer userId) {
		List<AvailableDto> available = new ArrayList<AvailableDto>();
LOGGER.info("entered in availableService");
		List<Leave> leaves = leavesRepository.findByuserId(userId);
if(leaves.isEmpty()) {
	throw new LmsException(LmsConstants.USER_NOT_FOUND);
}
else 
	leaves.forEach(leave -> {
		AvailableDto availableDto = new AvailableDto();
		availableDto.setAvailableLeaves(leave.getAvailableLeaves());

		availableDto.setLeaveTypeId(leave.getLeaveTypeId());

		Optional<LeaveType> leaveTypes = leavesTypeRepository.findById(leave.getLeaveId());
		List<AppliedLeave> leaves1 = appliedLeaveRepository.findByuserIdAndLeaveTypeId(userId,
				leave.getLeaveTypeId());
		availableDto.setAvailed(leaves1.size());
		availableDto.setLeaveType(leaveTypes.get().getLeaveType());

		available.add(availableDto);
	});
	return available;
}

	}
