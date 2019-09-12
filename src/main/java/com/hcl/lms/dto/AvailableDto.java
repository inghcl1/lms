package com.hcl.lms.dto;

public class AvailableDto {

	private String leaveType;
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public Integer getAvailableLeaves() {
		return availableLeaves;
	}
	public void setAvailableLeaves(Integer availableLeaves) {
		this.availableLeaves = availableLeaves;
	}
	private Integer leaveTypeId;
	private Integer availableLeaves;
}
