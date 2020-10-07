package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.PatientMedictnModel;

@Repository
public interface PatientMedictnRepo extends JpaRepository<PatientMedictnModel, Integer> {

}
