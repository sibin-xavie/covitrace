package com.jea.medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jea.medico.model.UserChildModel;

public interface PatientDtlsRepository extends JpaRepository<UserChildModel, Integer> {

}
