package com.hcl.lms.dto;

public class AvailableDto {

	private String leaveType;
	private Integer availed;
	public Integer getAvailed() {
		return availed;
	}
	public void setAvailed(Integer availed) {
		this.availed = availed;
	}
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
