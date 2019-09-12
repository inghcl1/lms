package com.hcl.lms.util;

import org.springframework.http.HttpStatus;

public class LmsConstants {
	
	public static final int CREATED =HttpStatus.CREATED.value();
	public static final String APPLY_LEAVE_RESPONSE_MES="YOUR LEAVE APPLIED SUCCESSFULLY";
	public static final String LMS_EXCEPTION_AVAILABLE_LEAVE_MESSAGE="YOU DON'T HAVE LEAVE'S TO APPLY";
	public static final String LMS_EXCEPTION_NOT_ELIGIBLE_MESSAGE="RIGHT NOW YOUR NOT ELIGIBLE TO APPLY LEAVE";
	public static final String LMS_EXCEPTION_CHECK_DATE_MESSAGE="YOU HAVE ALREADY APLLIED LEAVE FOR THIS DAY";
	public static final int LEAVE_COUNT_VALUE=1;
	
}
