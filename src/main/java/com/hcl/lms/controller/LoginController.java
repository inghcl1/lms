package com.hcl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.lms.dto.LoginDTO;
import com.hcl.lms.dto.LoginResponseDTO;
import com.hcl.lms.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> getUser(@RequestBody LoginDTO loginDTO) {

		return new ResponseEntity<>(loginService.getUserDetails(loginDTO), HttpStatus.OK);

	}

}
