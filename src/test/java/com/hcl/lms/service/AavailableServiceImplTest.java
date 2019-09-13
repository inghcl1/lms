package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.hcl.lms.dto.AvailableDto;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.entity.LeaveType;
import com.hcl.lms.entity.User;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveTypesRepository;
import com.hcl.lms.repository.LeavesRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class AavailableServiceImplTest {
	@InjectMocks
	AvailableServiceImpl availableService;
	@Mock
	LeaveTypesRepository leavesTypeRepository;
	@Mock
	LeavesRepository leavesRepository;
	@Mock
	AppliedLeaveRepository appliedLeaveRepository;
	
	@Test
	public void testAvailableLeaves()
	{
		
		LocalDate date=LocalDate.now();
		int userId=1;
		AvailableDto dto=new AvailableDto();
		dto.setAvailed(10);
		List<AvailableDto> available=new ArrayList<>();
		available.add(dto);
		Leave leave=new Leave();
		leave.setAvailableLeaves(10);
		leave.setLeaveId(1);
		LeaveType leaveType=new LeaveType();
		leaveType.setLeaveType("ch");
		List<Leave> leaves=new ArrayList<>();
		leaves.add(leave);
		AppliedLeave appliedLeave=new AppliedLeave();
		appliedLeave.setAppliedLeaveId(1);
		Optional<AppliedLeave> appliedlev=Optional.of(appliedLeave);
		Optional<LeaveType> lev =Optional.of(leaveType);
		Mockito.when(leavesRepository.findByuserId(1)).thenReturn(leaves);

	Mockito.when(leavesTypeRepository.findById(leave.getLeaveId())).thenReturn(lev);
	Mockito.when(appliedLeaveRepository.findByUserIdAndAppliedLeaveDate(userId,date)).thenReturn(appliedlev);
	List<AvailableDto> availableDto=availableService.availableLeaves(userId);
	assertEquals(1,availableDto.size());
	}
	@Test(expected = LmsException.class)
	public void testNoLeaveHistory() {
		User user=new User();
		user.setUserId(100);
		availableService.availableLeaves(user.getUserId());
	}

}
