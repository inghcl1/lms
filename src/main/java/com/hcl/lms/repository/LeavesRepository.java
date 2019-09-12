package com.hcl.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.lms.entity.Leave;

@Repository
public interface LeavesRepository extends JpaRepository<Leave,Integer> {

	List<Leave> findByuserId(Integer userId);
	@Query("select c from AppliedLeave c")
	List<Leave> findAll();


}
