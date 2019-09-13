package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.lms.dto.LeaveReqDto;
import com.hcl.lms.dto.LeaveResDto;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveRepository;
import com.hcl.lms.util.LmsConstants;

@RunWith(SpringJUnit4ClassRunner.class)
public class LeaveapplyServiceImplTest {

	@Mock
	private AppliedLeaveRepository appliedLeaveRepository;

	@Mock
	private LeaveRepository leaveRepository;

	@InjectMocks
	private LeaveapplyServiceImpl leaveapplyServiceImpl;

	@Test
	public void applyLeaveTest() {
		LeaveReqDto req = new LeaveReqDto();
		req.setFromDate(LocalDate.now());
		req.setToDate(LocalDate.now());
		req.setDescription("RH");
		req.setUserId(1);
		req.setLeaveTypeId(1);
		LeaveResDto res = new LeaveResDto();
		res.setMessage(LmsConstants.APPLY_LEAVE_RESPONSE_MES);
		res.setStatusCode(LmsConstants.CREATED);
		Leave leave = new Leave();
		leave.setUserId(1);
		leave.setLeaveTypeId(1);
		leave.setLeaveId(1);
		leave.setAvailableLeaves(3);
		AppliedLeave applyleave = new AppliedLeave();
		BeanUtils.copyProperties(req, applyleave);
		leave.setAvailableLeaves(leave.getAvailableLeaves() - LmsConstants.LEAVE_COUNT_VALUE);

		Mockito.when(leaveRepository.findByUserIdAndLeaveTypeId(req.getUserId(), req.getLeaveTypeId()))
				.thenReturn(Optional.of(leave));
		Mockito.when(appliedLeaveRepository.save(applyleave)).thenReturn(applyleave);
		Mockito.when(leaveRepository.save(leave)).thenReturn(leave);
		LeaveResDto actResult = leaveapplyServiceImpl.applyLeave(req);
		assertEquals(res.getStatusCode(), actResult.getStatusCode());

	}
	
	@Test(expected = LmsException.class)
	public void lmsExceptionTest() {
		LeaveReqDto req = new LeaveReqDto();
	//	req.setAppliedLeaveDate(LocalDate.now());
		req.setDescription("RH");
		req.setUserId(0);
		req.setLeaveTypeId(1);
		LeaveResDto actResult = leaveapplyServiceImpl.applyLeave(req);
	}

}
