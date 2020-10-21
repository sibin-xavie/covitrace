package com.jea.medico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.StateModel;
@Repository
public interface StateRepository extends JpaRepository<StateModel, Integer>{

}
