package com.hcl.lms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.entity.LeaveType;
import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveTypeRepository;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceImplTest {

	@Mock
	AppliedLeaveRepository appliedLeaveRepository;

	@Mock
	LeaveTypeRepository leaveTypeRepository;

	@InjectMocks
	HistoryServiceImpl historyServiceImpl;

	AppliedLeave appliedLeave;
	List<AppliedLeave> appliedLeaveList;
	Leave leave;

	List<Leave> leaveList;
	LeaveType leaveType;

	

	@Before
	public void setup() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		appliedLeave = new AppliedLeave();
		appliedLeave.setAppliedLeaveDate(LocalDate.parse("12-08-2019",formatter));
		appliedLeave.setAppliedLeaveId(1);
		appliedLeave.setDescription("discription");
		appliedLeave.setLeaveTypeId(1);
		appliedLeave.setStatus("ACCEPTED");
		appliedLeave.setUserId(1);

		appliedLeaveList = new ArrayList<>();
		appliedLeaveList.add(appliedLeave);

		leave = new Leave();
		leave.setAvailableLeaves(10);
		leave.setLeaveId(1);
		leave.setLeaveTypeId(1);
		leave.setUserId(1);

		leaveList = new ArrayList<>();

		leaveList.add(leave);
		leaveType = new LeaveType();
		leaveType.setLeaveType("RH");
		leaveType.setLeaveTypeId(1);

		
	}

	@Test
	public void testLeaveHistoryWithinDates() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		Mockito.when(appliedLeaveRepository.findByAppliedLeaveDateBetween(LocalDate.parse("11-08-2019",formatter), LocalDate.parse("13-08-2019",formatter)))
				.thenReturn(Optional.of(appliedLeaveList));
		Mockito.when(leaveTypeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(leaveType));
		List<LeaveHistoryWithinDateOutput> actual = historyServiceImpl.leaveHistoryWithinDates("11-08-2019", "13-08-2019", 1);
		
//		Assert.assertEquals("RH", actual.get(0).getLeaveType());
	
	}

}
