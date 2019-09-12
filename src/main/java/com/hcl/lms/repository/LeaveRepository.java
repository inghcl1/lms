package com.hcl.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.lms.entity.Leave;
@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	Optional<Leave> findByUserIdAndLeaveTypeId(Integer userId, Integer leaveTypeId);

}
