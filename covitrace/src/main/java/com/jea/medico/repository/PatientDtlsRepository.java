package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.medico.model.UserChildModel;
import com.jea.medico.model.UserMasterModel;

public interface PatientDtlsRepository extends JpaRepository<UserChildModel, Integer> {
	/**
	* @author Sibin 
	* @since 15 sep 2020 10.12 AM
	* @implSpec retrives the list<UserChildModel> from userId
	* @param Integer userId
	*/
	
	
	List<UserChildModel> findByUserId(int userId);
}
