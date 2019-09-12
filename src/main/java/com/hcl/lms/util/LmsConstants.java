package com.hcl.lms.util;

import org.springframework.http.HttpStatus;

public class LmsConstants {

	public static final int CREATED = HttpStatus.CREATED.value();
	public static final String APPLY_LEAVE_RESPONSE_MES = "YOUR LEAVE APPLIED SUCCESSFULLY";
	public static final String LMS_EXCEPTION_AVAILABLE_LEAVE_MESSAGE = "YOU DON'T HAVE LEAVE'S TO APPLY";
	public static final String LMS_EXCEPTION_NOT_ELIGIBLE_MESSAGE = "RIGHT NOW YOUR NOT ELIGIBLE TO APPLY LEAVE";
	public static final String LMS_EXCEPTION_CHECK_DATE_MESSAGE = "YOU HAVE ALREADY APLLIED LEAVE FOR THIS DAY";
	public static final int LEAVE_COUNT_VALUE = 1;

	public static final String NOAPPLIEDLEAVES = " no leave history";

	public static final int MONTH_VALUE = 3;
	public static final int FIRST_DAY_VALUE = 1;
	public static final int Last_DAY_VALUE = 30;
	public static final String LAST_THREE_MONTHS = "LastThreeMonths";
	public static final String Current_MONTH = "CurrentMonth";
	public static final String LEAVE_TYPE_NOT_EXIST = "CurrentMonth";



}
