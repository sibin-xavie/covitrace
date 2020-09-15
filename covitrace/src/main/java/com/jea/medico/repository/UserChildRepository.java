package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jea.medico.model.UserChildModel;

public interface UserChildRepository extends JpaRepository<UserChildModel, Integer>{
	
@Modifying
@Query("update UserChildModel u set u.isolated_in = ?1 where u.userChildId = ?2")
int updatePatientDetails(boolean isolated_in, int userChildId);
	
}
