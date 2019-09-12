package com.hcl.lms.service;

import com.hcl.lms.dto.LeaveReqDto;
import com.hcl.lms.dto.LeaveResDto;

public interface LeaveapplyService {

	LeaveResDto applyLeave(LeaveReqDto leaveReq);

}
