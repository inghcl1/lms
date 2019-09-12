package com.hcl.lms.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.LoginDTO;
import com.hcl.lms.dto.LoginResponseDTO;
import com.hcl.lms.service.LoginServiceImpl;
import com.hcl.lms.util.LmsConstants;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;

	@Test
	public void testGetUser() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserName("raja@gmail.com");
		loginDTO.setPassword("raja@123");
		
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		loginResponseDTO.setUserId(1);
		loginResponseDTO.setUserName("raja@gmail.com");
		loginResponseDTO.setMessage(LmsConstants.LOGIN_SUCCESS);
		loginResponseDTO.setStatusCode(LmsConstants.LOGIN_SUCCESS_CODE);
		
		Mockito.when(loginServiceImpl.getUserDetails(loginDTO)).thenReturn(loginResponseDTO);
		LoginResponseDTO actualValue=loginServiceImpl.getUserDetails(loginDTO);
		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getStatusCode());
		
	}

}
