package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.UserMasterModel;
@Repository
public interface MedicalDtlsRepository extends JpaRepository<MedicalDtlsModel, Integer>{
	@Query("select u from MedicalDtlsModel u where u.userId = ?1 ")
	MedicalDtlsModel findByMedicalDtlsIdAndUserId(UserMasterModel userId);

}
