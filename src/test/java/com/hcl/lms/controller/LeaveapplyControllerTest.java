package com.hcl.lms.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.lms.dto.LeaveReqDto;
import com.hcl.lms.dto.LeaveResDto;
import com.hcl.lms.service.LeaveapplyService;
import com.hcl.lms.util.LmsConstants;
@RunWith(SpringJUnit4ClassRunner.class)
public class LeaveapplyControllerTest {
	
	@Mock
	private LeaveapplyService leaveApplyService;
	
	@InjectMocks
	private LeaveapplyController leaveapplyController;

	@Test
	public void applyLeaveTest() {
		LeaveReqDto req=new LeaveReqDto();
		req.setFromDate(LocalDate.now());
		req.setToDate(LocalDate.now());
		req.setDescription("RH");
		req.setUserId(1);
		req.setLeaveTypeId(1);
		LeaveResDto res=new LeaveResDto(); 
		res.setMessage(LmsConstants.APPLY_LEAVE_RESPONSE_MES);
		res.setStatusCode(LmsConstants.CREATED);
		ResponseEntity<LeaveResDto> expResult=new ResponseEntity<>(res,HttpStatus.CREATED);
		Mockito.when(leaveApplyService.applyLeave(req)).thenReturn(res);
		ResponseEntity<LeaveResDto> actResult=leaveapplyController.applyLeave(req);
		assertEquals(expResult, actResult);
	}

}
