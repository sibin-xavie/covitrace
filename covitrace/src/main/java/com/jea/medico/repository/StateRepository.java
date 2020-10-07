package com.jea.medico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jea.medico.model.MedicalDtlsModel;
import com.jea.medico.model.StateModel;
@Repository
public interface StateRepository extends JpaRepository<StateModel, Integer>{

	
	
	@Query("select u from StateModel u where u.stateId = ?1 ")
	List<StateModel> findByStateId(int stateId);
	
	@Modifying
	@Query("delete from StateModel s where s.stateId=?1")
	int deleteBystateId(int stateId);
}
