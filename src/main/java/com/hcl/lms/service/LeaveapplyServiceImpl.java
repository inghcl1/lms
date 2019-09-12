package com.hcl.lms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LeaveReqDto;
import com.hcl.lms.dto.LeaveResDto;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.Leave;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveRepository;
import com.hcl.lms.util.LmsConstants;

/**
 *  implementation of applyLeave 
 * @author Pradeep AJ
 * @param LeaveReqDto
 * @return LeaveResDto
 * 
 */


@Service
public class LeaveapplyServiceImpl implements LeaveapplyService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LeaveapplyServiceImpl.class);
	
	@Autowired
	private AppliedLeaveRepository appliedLeaveRepository;
	
	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public LeaveResDto applyLeave(LeaveReqDto leaveReq) {
		Optional<Leave> leave=leaveRepository.findByUserIdAndLeaveTypeId(leaveReq.getUserId(), leaveReq.getLeaveTypeId());
		logger.info("Enter into LeaveapplyServiceImpl applyLeave()");
		if(leave.isPresent()) { 
			Optional<AppliedLeave> cheackLeave=appliedLeaveRepository.findByUserIdAndAppliedLeaveDate(leaveReq.getUserId(),leaveReq.getAppliedLeaveDate());
			if(!cheackLeave.isPresent()) {
			Leave leave1=leave.get();
			if(leave1.getAvailableLeaves()!=0) {
				logger.info("Available leave {}",leave1.getAvailableLeaves());
				AppliedLeave applyLeave=new AppliedLeave();
				BeanUtils.copyProperties(leaveReq, applyLeave);
				leave1.setAvailableLeaves(leave1.getAvailableLeaves()-LmsConstants.LEAVE_COUNT_VALUE);
				appliedLeaveRepository.save(applyLeave);
				leaveRepository.save(leave1);
				LeaveResDto response=new LeaveResDto();
				response.setStatusCode(LmsConstants.CREATED);
				response.setMessage(LmsConstants.APPLY_LEAVE_RESPONSE_MES);
				return response;
				
				
			}
			else
			{
				throw new LmsException(LmsConstants.LMS_EXCEPTION_AVAILABLE_LEAVE_MESSAGE);
			}
			}
			else {
				throw new LmsException(LmsConstants.LMS_EXCEPTION_CHECK_DATE_MESSAGE);
			}
		}
		else 
		{
			throw new LmsException(LmsConstants.LMS_EXCEPTION_NOT_ELIGIBLE_MESSAGE);
		}
		
		
	}

}
