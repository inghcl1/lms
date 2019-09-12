package com.hcl.lms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LoginDTO;
import com.hcl.lms.dto.LoginResponseDTO;
import com.hcl.lms.entity.User;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.UserRepository;
import com.hcl.lms.util.LmsConstants;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger lOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO) {
		
		lOGGER.info("Inside LoginServiceImpl");

		String userName = loginDTO.getUserName();
		String password = loginDTO.getPassword();

		LoginResponseDTO loginResponseDTO = null;

		if (userName.equals("") || password.equals("")) {

			throw new LmsException(LmsConstants.CREDENTIALS_EMPTY);

		}

		else {
			Optional<User> userList = userRepository.findByUserNameAndPassword(userName, password);

			if (!(userList.isPresent())) {
				throw new LmsException(LmsConstants.LOGIN_FAILURE);

			}

			else {

				loginResponseDTO = new LoginResponseDTO();
				User user = userList.get();
				loginResponseDTO.setUserName(user.getUserName());
				loginResponseDTO.setUserId(user.getUserId());
				loginResponseDTO.setMessage(LmsConstants.LOGIN_SUCCESS);
				loginResponseDTO.setStatusCode(LmsConstants.LOGIN_SUCCESS_CODE);

			}

		}

		return loginResponseDTO;
	}

}
