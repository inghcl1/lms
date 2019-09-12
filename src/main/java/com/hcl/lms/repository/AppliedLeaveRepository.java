package com.hcl.lms.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.lms.entity.AppliedLeave;
@Repository
public interface AppliedLeaveRepository extends JpaRepository<AppliedLeave, Integer> {

	Optional<AppliedLeave> findByUserIdAndAppliedLeaveDate(Integer userId, LocalDate appliedLeaveDate);

}
