package com.hcl.lms.dto;

import java.time.LocalDate;

public class RangeDto {
	
	private String leaveType;
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public LocalDate getAppliedLeaveDate() {
		return appliedLeaveDate;
	}
	public void setAppliedLeaveDate(LocalDate appliedLeaveDate) {
		this.appliedLeaveDate = appliedLeaveDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private LocalDate appliedLeaveDate;
	private String description;

}
