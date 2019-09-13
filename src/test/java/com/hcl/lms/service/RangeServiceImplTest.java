package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;

import com.hcl.lms.exception.LmsException;


@RunWith(MockitoJUnitRunner.Silent.class)
public class RangeServiceImplTest {
	@InjectMocks
	RangeServiceImpl rangeService;
	@Mock
	HistoryServiceImpl historyService;
	
	@Test
	public void testRange() {

		
		int userId=1;
		int range=1;
		LocalDate date = LocalDate.now();
		LocalDate dateRange = date.minus(range, ChronoUnit.MONTHS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String toDate = date.format(formatter);
		String fromDate = dateRange.format(formatter);
		LeaveHistoryWithinDateOutput leave=new LeaveHistoryWithinDateOutput();
		leave.setDescription("sickleave");
		leave.setAppliedLeaveDate(LocalDate.now());
		List<LeaveHistoryWithinDateOutput> leaveHistorywithinDateOutput=new ArrayList<>();
		leaveHistorywithinDateOutput.add(leave);
		Mockito.when(historyService.leaveHistoryWithinDates(fromDate,toDate,userId)).thenReturn(leaveHistorywithinDateOutput);
		List<LeaveHistoryWithinDateOutput> lev=rangeService.getRange(userId,range);
		assertEquals(1,lev.size());
		
	}
	@Test(expected = LmsException.class)
	public void testNoLeaveHistory() {
		String fromDate="";
		String toDate="";
		Integer userId=0;
		Integer range=0;
		LeaveHistoryWithinDateOutput leave=new LeaveHistoryWithinDateOutput();
		leave.setDescription("sickleave");
		leave.setAppliedLeaveDate(LocalDate.now());
		List<LeaveHistoryWithinDateOutput> leaveHistorywithinDateOutput=new ArrayList<>();
		leaveHistorywithinDateOutput.add(leave);
		Mockito.when(historyService.leaveHistoryWithinDates(fromDate,toDate,userId)).thenReturn(leaveHistorywithinDateOutput);
	
	List<LeaveHistoryWithinDateOutput> lev=rangeService.getRange(userId,range);
	
	}
}
