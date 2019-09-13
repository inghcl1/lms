package com.hcl.lms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;
import com.hcl.lms.service.HistoryService;

@RunWith(SpringJUnit4ClassRunner.class)
public class HistoryServiceControllerTest {
	
	@Mock
	HistoryService historyService;
	
	@InjectMocks
	HistoryServiceController historyServiceController;
	LeaveHistoryWithinDateOutput  leaveHistoryWithinDateOutput;
	List<LeaveHistoryWithinDateOutput>  leaveHistoryWithinDateOutputList;

	@Before
	public void setup() {
		
		leaveHistoryWithinDateOutput=new LeaveHistoryWithinDateOutput();
		leaveHistoryWithinDateOutput.setAppliedLeaveDate(LocalDate.parse("2019-08-11"));
		leaveHistoryWithinDateOutput.setDescription("going home");
		leaveHistoryWithinDateOutput.setLeaveType("RH");
		leaveHistoryWithinDateOutputList=new ArrayList<>();
		leaveHistoryWithinDateOutputList.add(leaveHistoryWithinDateOutput);
	}

	@Test
	public void testLeaveHistoryWithinDates() {
		Mockito.when(historyService.leaveHistoryWithinDates("11-08-2019", "13-08-2019", 1)).thenReturn(leaveHistoryWithinDateOutputList);
	
	Assert.assertEquals(200, historyServiceController.leaveHistoryWithinDates("11-08-2019", "13-08-2019", 1).getStatusCodeValue());
	}

}
