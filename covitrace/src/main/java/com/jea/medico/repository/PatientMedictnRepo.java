package com.jea.medico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.PatientMedictnModel;
import com.jea.medico.model.UserMasterModel;

@Repository
public interface PatientMedictnRepo extends JpaRepository<PatientMedictnModel, Integer> {
	@Query("select m from PatientMedictnModel m where m.userId =?1")
	List<PatientMedictnModel> listMedicineUserDtls(UserMasterModel userId);
}
