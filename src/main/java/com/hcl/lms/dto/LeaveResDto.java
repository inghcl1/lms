package com.hcl.lms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveResDto {

	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	private Integer statusCode;

}
