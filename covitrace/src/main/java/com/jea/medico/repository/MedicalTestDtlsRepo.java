package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jea.medico.model.MedicalTestModel;

public interface MedicalTestDtlsRepo  extends JpaRepository<MedicalTestModel, Integer>{

	List<MedicalTestModel> findByUserId(Integer userId);
	
	@Modifying
	@Query("delete from MedicalTestModel b where b.medTestId=?1")
	int deleteBymedTestId(Integer medTestId);
	
}
