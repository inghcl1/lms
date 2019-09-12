package com.hcl.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.lms.dto.RangeDto;

@Service
public interface RangeService {

	 List<RangeDto> getRange (Integer userId,String range);

}
