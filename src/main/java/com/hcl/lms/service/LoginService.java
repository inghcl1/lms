package com.hcl.lms.service;

import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LoginDTO;
import com.hcl.lms.dto.LoginResponseDTO;

@Service
public interface LoginService {
	
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO);

}
