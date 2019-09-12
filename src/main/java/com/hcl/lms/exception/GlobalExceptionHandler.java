package com.hcl.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.lms.dto.ResponseDto;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(LmsException.class)
	public ResponseEntity<ResponseDto> ecomorseExceptionHandler(LmsException ex, WebRequest request) {

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage(ex.getMessage());
		responseDto.setStatusCode(401);

		return new ResponseEntity<>(responseDto, HttpStatus.UNAUTHORIZED);

	}


}