package com.hcl.lms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.lms.entity.AppliedLeave;


@Repository
public interface RangeRepository extends JpaRepository<AppliedLeave,Integer>{

	
@Query("select c from AppliedLeave c where c.appliedLeaveDate>=:lastThreeMonths and c.appliedLeaveDate<=:date and  c.userId=:userId")
List<AppliedLeave> findAll(Integer userId,LocalDate date, LocalDate lastThreeMonths);
@Query("select c from AppliedLeave c where c.userId=:userId")
List<AppliedLeave> findByuserId(Integer userId);

}
