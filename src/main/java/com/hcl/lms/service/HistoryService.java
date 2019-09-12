package com.hcl.lms.service;

import java.util.List;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;

public interface HistoryService {
	
	public List<LeaveHistoryWithinDateOutput> leaveHistoryWithinDates(String fromdate, String todate,Integer userId);

}
