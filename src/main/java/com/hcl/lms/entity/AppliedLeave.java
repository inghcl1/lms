package com.hcl.lms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppliedLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appliedLeaveId;
	private LocalDate appliedLeaveDate;
	private Integer leaveTypeId;
	private String description;
	private Integer userId;
	private String status;

	public Integer getAppliedLeaveId() {
		return appliedLeaveId;
	}

	public void setAppliedLeaveId(Integer appliedLeaveId) {
		this.appliedLeaveId = appliedLeaveId;
	}

	public LocalDate getAppliedLeaveDate() {
		return appliedLeaveDate;
	}

	public void setAppliedLeaveDate(LocalDate appliedLeaveDate) {
		this.appliedLeaveDate = appliedLeaveDate;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
