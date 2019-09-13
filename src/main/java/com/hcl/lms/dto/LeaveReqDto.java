package com.hcl.lms.dto;

import java.time.LocalDate;


public class LeaveReqDto {
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
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
	private Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
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
	private Integer leaveTypeId;
	private LocalDate appliedLeaveDate;
	private String description;
	
	}
	
	


