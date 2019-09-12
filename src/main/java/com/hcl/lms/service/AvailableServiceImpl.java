package com.hcl.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.AvailableDto;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.entity.LeaveType;
import com.hcl.lms.repository.LeaveTypesRepository;
import com.hcl.lms.repository.LeavesRepository;
/**
* This  program implements an application that
* displays available leaves  to the standard output.
*
* @author  Saicharan
* @version 1.0
* 
*/
@Service
public class AvailableServiceImpl implements AvailableService {
@Autowired
LeaveTypesRepository leavesTypeRepository;
@Autowired
LeavesRepository leavesRepository;
	@Override
	public List<AvailableDto> availableLeaves(Integer userId) {
		List<AvailableDto> available=new ArrayList<AvailableDto>();
	
		List<Leave> leaves=leavesRepository.findByuserId(userId);
		

	leaves.forEach(leave->{
		AvailableDto availableDto=new AvailableDto();
		availableDto.setAvailableLeaves(leave.getAvailableLeaves());
	
		availableDto.setLeaveTypeId(leave.getLeaveTypeId());
		Optional<LeaveType> leaveTypes=leavesTypeRepository.findById(leave.getLeaveId());
	availableDto.setLeaveType(leaveTypes.get().getLeaveType());

	available.add(availableDto);
	});
		return available;
	}

}
