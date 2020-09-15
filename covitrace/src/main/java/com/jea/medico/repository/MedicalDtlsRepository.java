package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jea.medico.model.MedicalDtlsModel;

public interface MedicalDtlsRepository extends JpaRepository<MedicalDtlsModel, Integer>{
	@Query("select u from MedicalDtlsModel where u.medicalDtlsId = ?1 ")
	MedicalDtlsModel findByMedicalDtlsIdAndUserId(int medicalDtlsId);

}
