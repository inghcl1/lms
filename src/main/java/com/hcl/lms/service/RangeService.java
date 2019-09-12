package com.hcl.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;


@Service
public interface RangeService {

	 List<LeaveHistoryWithinDateOutput> getRange (Integer userId,Integer range);

}
