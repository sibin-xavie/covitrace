package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jea.medico.model.PatientMedicationInfoModel;
import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.UserMasterModel;

public interface PatientMedicationInfoRepo extends JpaRepository<PatientMedicationInfoModel, Integer> {
	@Query("select m from PatientMedicationInfoModel m where m.userId =?1")
	List<PatientMedicationInfoModel> listPatMediTstUserDtls(UserMasterModel userId);
}
