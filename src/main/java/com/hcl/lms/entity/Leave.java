package com.hcl.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer leaveId;
	private Integer userId;
	private Integer availableLeaves;
	private Integer leaveTypeId;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAvailableLeaves() {
		return availableLeaves;
	}

	public void setAvailableLeaves(Integer availableLeaves) {
		this.availableLeaves = availableLeaves;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

}
