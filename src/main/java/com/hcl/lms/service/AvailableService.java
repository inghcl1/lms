package com.hcl.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.lms.dto.AvailableDto;

@Service
public interface AvailableService {

	List<AvailableDto> availableLeaves(Integer userId);

}
