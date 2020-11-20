package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.RandomQstAnswerModel;
import com.jea.medico.model.UserMasterModel;


	@Repository
	public interface RandomQstAnswerRepo extends JpaRepository<RandomQstAnswerModel, Integer> {
	
		
	}

