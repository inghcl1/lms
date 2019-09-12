package com.hcl.lms.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveReqDto {
	
	private Integer userId;
	private Integer leaveTypeId;
	private LocalDate appliedLeaveDate;
	private String description;

}
