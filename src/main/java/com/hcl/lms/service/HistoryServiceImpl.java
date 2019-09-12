package com.hcl.lms.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.lms.dto.LeaveHistoryWithinDateOutput;
import com.hcl.lms.entity.AppliedLeave;
import com.hcl.lms.entity.LeaveType;
import com.hcl.lms.exception.LmsException;
import com.hcl.lms.repository.AppliedLeaveRepository;
import com.hcl.lms.repository.LeaveTypeRepository;
import com.hcl.lms.util.LmsConstants;

/**
 * 
 * @author sairam this class will get the leave history of a user with two dates
 * 
 **/
@Service
public class HistoryServiceImpl implements HistoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HistoryServiceImpl.class);

	@Autowired
	AppliedLeaveRepository appliedLeaveRepository;

	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	/**
	 * @apiNote this method will return the list of leaves history of a perticular
	 *          user
	 * @param fromdate from date of the leaves list
	 * @param todate   to date of the leaves list
	 * @param userId   user id of the logined user
	 **/

	@Override
	public List<LeaveHistoryWithinDateOutput> leaveHistoryWithinDates(String fromdate, String todate, Integer userId) {

		LOGGER.info("HistoryServiceImpl--> leaveHistoryWithinDates fromdate:{}, todate:{}, userId:{}", fromdate, todate,
				userId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		Optional<List<AppliedLeave>> appliedLeaves = appliedLeaveRepository.findByAppliedLeaveDateBetween(
				LocalDate.parse(fromdate, formatter), LocalDate.parse(todate, formatter));

		if ((!appliedLeaves.isPresent()))
			throw new LmsException(LmsConstants.NOAPPLIEDLEAVES);

		if ((appliedLeaves.get().isEmpty()))
			throw new LmsException(LmsConstants.NOAPPLIEDLEAVES);

		Stream<AppliedLeave> appliedLeavesList = appliedLeaves.get().stream().filter(p -> p.getUserId().equals(userId));

		List<LeaveHistoryWithinDateOutput> leaveHistoryWithinDateOutputList = new ArrayList<>();

		appliedLeavesList.forEach(appliedLeave -> {

			Optional<LeaveType> leaveType = leaveTypeRepository.findById(appliedLeave.getLeaveTypeId());
			if (!leaveType.isPresent())
				throw new LmsException(LmsConstants.NOAPPLIEDLEAVES);

			LeaveHistoryWithinDateOutput leaveHistoryWithinDateOutput = new LeaveHistoryWithinDateOutput();
			leaveHistoryWithinDateOutput.setAppliedLeaveDate(appliedLeave.getAppliedLeaveDate());
			leaveHistoryWithinDateOutput.setDescription(appliedLeave.getDescription());
			leaveHistoryWithinDateOutput.setLeaveType(leaveType.get().getLeaveType());
			leaveHistoryWithinDateOutputList.add(leaveHistoryWithinDateOutput);

		});

		LOGGER.info("HistoryServiceImpl--> leaveHistoryWithinDates completd");
		return leaveHistoryWithinDateOutputList;

	}

}
