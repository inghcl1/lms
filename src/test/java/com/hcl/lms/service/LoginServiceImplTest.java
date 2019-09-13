package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.LoginDTO;
import com.hcl.lms.dto.LoginResponseDTO;
import com.hcl.lms.entity.User;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	@Test
	public void testGetUserDetails() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserName("raja@gmail.com");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);
		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(user));

		LoginResponseDTO actualValue = loginServiceImpl.getUserDetails(loginDTO);

		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getStatusCode());

	}

	@Test(expected = LmsException.class)
	public void testGetUserDetailsFailure() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserName("rani@gmail.com");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);

		loginServiceImpl.getUserDetails(loginDTO);

	}
	
	@Test(expected = LmsException.class)
	public void testEmptyCredentials() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserName("");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);

		loginServiceImpl.getUserDetails(loginDTO);

	}

}
